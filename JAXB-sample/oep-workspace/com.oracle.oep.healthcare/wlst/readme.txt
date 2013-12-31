
There are 2 queues and a connection factory that get created:

JMS SERVER
==========
AuctionJMSServer

JMS MODULE
===========
AuctionJMSModule

CONNECTION FACTORY
==================
jms/AuctionConnectionFactory

QUEUES
======
jms/AuctionQueue


The configJms.cmd script can be run to create JMS queues.  
The WLS server must be running. 
The admin username/password/url and server name can be configured via the ServerEnv.properties file.