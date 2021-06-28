#Dummy API Tests

Libraries:
 1. Rest Assured
 2. JSON Schema Validator
 3. TestNG
 4. Language Java
 

Structure:
1. packages inside (src/main/java):
  	- com.dummyapi.base: contains base page for configuration and properties file set up
 	- com.dummyapi.comment: contains methods to fetch comments
 	- com.dummyapi.common: contains methods for response validation and response display
 	- com.dummyapi.post: contains methods to fetch posts
 	- com.dummyapi.tag: contains methods to fetch tags
 	- com.dummyapi.user: contains methods to fetch users
 	
2. packages inside (src/test/java):
 	- com.dummyapi.tests.comment: contains tests related to get post comments list
 	- com.dummyapi.tests.post: contains tests related to get post
 	- com.dummyapi.test.tag: contains tests related to get tag
 	- com.dummyapi.test.user: contains tests related to get user
 	
3. files inside (src/test/resources):
 	- property file
 	- jsonSchemaOfEachEntity in json files
 	
Test Execution:
- git clone 
- Replace xxxxxxxxxxxxxxxxxxxxxxxx with valid api-id in src/test/resources/config.properties file
- move the directory where pom.xml and testng.xml are present and run below command
- mvn clean test -DsuiteXmlFile=testng.xml
- refer com.dummyapi.test-output.emailable-report.html for the test output (few tests might be failing due to json schema validation)