loadProperties('ServerEnv.properties')
connect(_connectUser,_connectPassword,_connectUrl)
edit()
servermb=getMBean("Servers/"+_serverName)
if servermb is None:
	print '@@@ No server MBean found'
else:
	print "@@@ Starting Script..."
	startEdit()
	print "@@@ Creating JMS Server..."
	jmsServer = create('HealthcareJMSServer','JMSServer')
	jmsServer.addTarget(servermb)
	jmsMySystemResource = create("HealthcareJMSModule","JMSSystemResource")
	jmsMySystemResource.addTarget(servermb)
	subDeployment = jmsMySystemResource.createSubDeployment('HealthcareSubdeployment')
	subDeployment.addTarget(jmsServer)    
	theJMSResource = jmsMySystemResource.getJMSResource()

	print "@@@ Creating Connection Factory.."
	connfact1 = theJMSResource.createConnectionFactory('HealthcareConnectionFactory')
	connfact1.setJNDIName('jms/HealthcareConnectionFactory')
	connfact1.setSubDeploymentName('HealthcareSubdeployment')

	print "@@@ Creating Queue..."
	jmsqueue1 = theJMSResource.createQueue('InboundEvents')
	jmsqueue1.setJNDIName('jms/InboundEvents')
	jmsqueue1.setSubDeploymentName('HealthcareSubdeployment')

	print "@@@ Creating Queue..."
	jmsqueue2 = theJMSResource.createQueue('OutboundAlerts')
	jmsqueue2.setJNDIName('jms/OutboundAlerts')
	jmsqueue2.setSubDeploymentName('HealthcareSubdeployment')

	
	print '@@@ Resources created.  Saving changes ...'
	save()
	activate(block="true")
	print '@@@ Changes activated.'
disconnect()
