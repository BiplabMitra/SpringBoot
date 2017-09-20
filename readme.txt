@Author : Biplab

##Creating new application
Step 1. Create a new Spring boot application using maven command 
mvn archetype:generate -DgroupId=com.changehealthcare -DartifactId=<name of the project> -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

Step 2. Download the dependencies
		mvn clean
		
Step 3. change the setting to import in eclipse
		mvn eclipse:eclipse
		
Step 4. import in eclipse.

Step 5. Add any dependencies required for the API in pom.xml

Step 6. change application.yml file
		1. Server port 
		2. management port <while depploying the war in tomcat comment this segment>
		
Step 7. create any properties file required in resource folder.

Step 8 : Build the application
		 mvn clean install
		 

##Running application without tomcat:
java -jar -Dspring.profiles.active=mysql <full path for the war file>
Example
java -jar -Dspring.profiles.active=mysql D:/playroom-workspace/sbpapigateway/target/sbpapigateway-1.0.war

## Running application in tomcat : no changes deploy the war in webapp folder

## Running actuator (as per the API 1 project , for other change the port number as in .yml file)
	1.http://localhost:8091/env
	2.http://localhost:8091/health
	3.http://localhost:8091/info
	4.http://localhost:8091/metrics
	
## Swagger UI when running application without tomcat
	http://localhost:8090/swagger-ui.html


## Swagger UI when running application in  tomcat
	http://localhost:8080/sbpapigateway-1.0/swagger-ui.html