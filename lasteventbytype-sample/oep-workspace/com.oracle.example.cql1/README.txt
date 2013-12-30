This application shows on the console each Vehicle that arrives on the input channel.

Every 60 seconds, it outputs the vehicle id of the last vehicle of each type seen.
NODE:inputChannel][+]:Vehicle [eventTime=1388442653166446000, vehicleAssetName=Boat, vehicleID=22]
[NODE:inputChannel][+]:Vehicle [eventTime=1388442654165518000, vehicleAssetName=SUV, vehicleID=23]
[NODE:inputChannel][+]:Vehicle [eventTime=1388442655166228000, vehicleAssetName=Car, vehicleID=24]
[NODE:inputChannel][+]:Vehicle [eventTime=1388442656166375000, vehicleAssetName=Car, vehicleID=25]
[NODE:inputChannel][+]:Vehicle [eventTime=1388442657166573000, vehicleAssetName=Truck, vehicleID=26]
[NODE:inputChannel][+]:Vehicle [eventTime=1388442658165524000, vehicleAssetName=Truck, vehicleID=27]
[NODE:inputChannel][+]:Vehicle [eventTime=1388442659165768000, vehicleAssetName=Car, vehicleID=28]
[NODE:**** outputChannel **** ][+]:Vehicle [eventTime=1388442620166245000, vehicleAssetName=Train, vehicleID=51]
[NODE:**** outputChannel **** ][+]:Vehicle [eventTime=1388442659165768000, vehicleAssetName=Car, vehicleID=28]
[NODE:**** outputChannel **** ][+]:Vehicle [eventTime=1388442654165518000, vehicleAssetName=SUV, vehicleID=23]
[NODE:**** outputChannel **** ][+]:Vehicle [eventTime=1388442653166446000, vehicleAssetName=Boat, vehicleID=22]
[NODE:**** outputChannel **** ][+]:Vehicle [eventTime=1388442637166044000, vehicleAssetName=Golf Cart, vehicleID=6]
[NODE:**** outputChannel **** ][+]:Vehicle [eventTime=1388442658165524000, vehicleAssetName=Truck, vehicleID=27]

i.e. the last 'Golf Cart' seen had ID #6.  The last 'Truck' had ID #27.
 
