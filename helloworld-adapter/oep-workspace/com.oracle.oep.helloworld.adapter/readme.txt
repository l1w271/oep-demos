Use File, Export, Oracle CEP applications to export the packaged bundle to:

<INSTALL_DIR>\ocep_11.1\modules

In your application project, in the MANIFEST.MF editor, on the "Dependencies" tab in the required plug-in section:
choose the "Add" button to add "com.oracle.cep.adapter.test"

Make sure that you deploy the adapter bundle to the server first!
It should always be the first entry in your deployments.xml

It's a good idea to un-deploy other applications relying on your adapter bundles 
before deploying changes to the adapter bundle.

