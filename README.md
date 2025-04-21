# Test-Assignment-Lyxa


# Setting Up Selenium Project in Eclipse

# STEP 1
Install Required Software

Java JDK
Download: https://www.oracle.com/java/technologies/downloads/
Add JAVA_HOME to environment variables
Add %JAVA_HOME%\bin to PATH
Verify: java -version

Eclipse IDE
Download: https://www.eclipse.org/downloads/
Select "Eclipse IDE for Java Developers"

Maven
Eclipse includes Maven integration (m2e plugin)
No separate installation needed

# STEP 2
Create Maven Project in Eclipse

Create new Maven project
File > New > Project > Maven > Maven Project

Group Id: com.testing
Artifact Id: selenium-tests
Version: 0.0.1-SNAPSHOT
Packaging: jar
Click next-next-finish


# Step 3: Required dependencies

-Update pom.xml with dependencies
-Double-click pom.xml
-Click on "pom.xml" tab at bottom
-Add dependencies between <dependencies> tags

  <dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.31.0</version>
    </dependency>
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.3.2</version>
    </dependency>
      <dependency>
        <groupId>commons-io</groupId>
        <artifactId>commons-io</artifactId>
        <version>2.14.0</version>
    </dependency>
  </dependencies>


-Save pom.xml
-Save file (Ctrl+S)


# Step 4: Create Test Class

Create package
Right-click src/main/java > New > Package
Name: Test

Create Java class
Right-click Test package > New > Class
Name: Test

# Step 5: Write code into Test.java file

# Step 6: Run Test
Right-click Test.java > Run As > Java Application

# Step 7: Check screenshots
Screenshots saved in project's screenshots folder
