**DEPENDENCIES**

Required for building, running and testing:
* [Apache Maven 3.6.3](https://maven.apache.org/download.cgi) 
* [Mockito Framework](https://search.maven.org/search?q=g:org.mockito%20AND%20a:mockito-core&core=gav)
* [Java 13.0.2](https://www.java.com/en/download/)


**BUILD AND RUN**

To build and run BATTLEFIELD:
* mvn clean compile
* mvn exec:java -Dexec.mainClass="playgame.Main"


**TESTING**

To run the testing suite:
* mvn clean compile
* mvn test


**ARTIFACTS**

To build and run the JAR executable:
* mvn clean package
* java -jar target/BATTLEFIELD-1.0.jar

To generate the Javadocs:
* mvn javadoc:javadoc


**GAMEPLAY**

Play as the hero and collect keys to unlock the exit and escape the pursuing enemies!
* Control your hero with the arrow keys to move across the map. Press 'p' to pause the game.
* Collect all the keys to unlock the endpoint to beat the game
* Avoid pursuing enemies which deplete your health bar
* Avoid red and black bombs which reduce your health and total score respectively
* Collect bonus rewards to increase your score and help you along the way:
	* Hearts will restore your health bar
	* Ice will freeze enemies in place for a short duration

Have fun!!!

[GAMEPLAY TRAILER](https://vimeo.com/408712691?fbclid=IwAR3qDD7wGLnzpigiy82DPTWqjJMJoqnjkij8jbERg4gvE46f9FBhPyB6-ug)

