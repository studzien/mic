#mic

Yet another useless university project

#configuration
1. download apache cxf2, v 2.6.11
2. unpack somewhere
3. add apache cxf in eclipse properties: Window -> Preferences -> Web services -> CXF 2.x -> add installation folder
4. add tomcat 7 server to eclipse: Servers -> add server -> Tomcat 7 -> choose installation directory
5. run project on server: right click on project -> run as -> run on server (choose tomcat)

#creating web services
1. right click on the class (MicService) -> Web Services -> Create Web Service -> Choose Tomcat 7 and Apache CXF2 -> click finish

#running
service list: http://localhost:8080/mic/services/
sample service: http://localhost:8080/mic/services/MicServicePort/takeOwnership
wsdl: http://localhost:8080/mic/services/MicServicePort?wsdl
