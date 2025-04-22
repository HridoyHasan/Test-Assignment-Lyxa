# Test-Assignment-Lyxa

This repository contains Selenium, Appium, JMeter, and Postman API test automation scripts, manual test cases, summary report, and setup instructions.

# Project Structure Overview

- Selenium – Web automation tests using Java and Maven in Eclipse
- Appium – Mobile app automation using Node.js and VS Code
- JMeter – Performance testing using .jmx files
- Postman – API testing using Postman and Newman CLI

# Selenium Setup (Java + Maven in Eclipse)

## Step 1: Install Required Software

Java JDK
- Download: https://www.oracle.com/java/technologies/downloads/
- Set JAVA_HOME environment variable
- Add %JAVA_HOME%\bin to PATH
- Verify installation:
    java -version

Eclipse IDE
- Download: https://www.eclipse.org/downloads/
- Select: Eclipse IDE for Java Developers

Maven
- Maven comes bundled with Eclipse via m2e plugin

## Step 2: Create Maven Project

- In Eclipse: File > New > Project > Maven > Maven Project
- Use the following project info:
    Group Id: com.testing
    Artifact Id: selenium-tests
    Version: 0.0.1-SNAPSHOT
    Packaging: jar

## Step 3: Add Dependencies

- Open pom.xml
- Click on "pom.xml" tab at bottom
- Add the following under <dependencies>:

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

- Save the file (Ctrl+S)

## Step 4: Create Package and Class

- Create package:
    Right-click src/main/java > New > Package
    Name: Test

- Create Java class:
    Right-click Test package > New > Class
    Name: Test

## Step 5: Write and Run Test

- Write test code in Test.java
- To run:
    Right-click Test.java > Run As > Java Application

- Screenshots (if implemented) will be saved in screenshots folder

# Appium Test Execution (Android)

## Prerequisites

- Install Node.js and Appium:
    npm install -g appium

- Android Studio with configured emulator (AVD)
- Java JDK installed and JAVA_HOME configured
- Appium Inspector or GUI (optional)

## Steps

1. Launch Android emulator:
    emulator -avd <emulator_name>

2. Start Appium server:
    appium

3. Open test project in VS Code

4. Run test file:
    node <your_test_script>.js

5. Or use Mocha:
    npx mocha <your_test_script>.js

# JMeter Performance Tests

## Prerequisites

- Apache JMeter installed and path set
- .jmx test plan file prepared

## GUI Mode

1. Open JMeter:
    jmeter

2. File > Open > Select .jmx file

3. Click Start button to run the test

4. Use listeners to view results

## Command Line Mode

Run the test:
    jmeter -n -t path/to/testplan.jmx -l path/to/result.jtl -e -o path/to/html-report

Flags:
- -n: Run in non-GUI mode
- -t: Path to JMX test file
- -l: Log file (JTL)
- -e: Generate HTML report
- -o: Output directory

Open index.html from output directory in browser to view results

# Postman API Tests

## Using Postman App

1. Open Postman
2. Import collection (.json) and environment (.json) files
3. Select environment
4. Use Collection Runner to execute

## Using Newman CLI

1. Install Newman:
    npm install -g newman

2. Run the collection:
    newman run path/to/collection.json -e path/to/environment.json -r cli,html --reporter-html-export path/to/report.html

Flags:
- -r: Reporter output (CLI and HTML)
- --reporter-html-export: Save HTML report to file
