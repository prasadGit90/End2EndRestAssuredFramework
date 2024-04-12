RestAssured End2End Framework
=============================
This repository contains a comprehensive End-to-End (E2E) testing framework built using Java, Rest Assured, and TestNG. The framework is designed to streamline API testing processes with features including logging, Extent reporting, API chaining, and a modular framework structure.

**Prerequisites:**
==================
-	IDE: Eclipse
-	Programming Language: Java
-	Dependencies: Rest Assured, TestNG, log4j, extentreports
  
**Features:**
=============
- Logging: Implementing log4j for comprehensive logging.
-  Extent Report: Utilizing Extent Reports for detailed test reporting.
-  API Chaining: Ability to chain multiple API requests for end-to-end testing      
-  E2E Execution: Execution of tests using Maven (pom.xml) and TestNG (testng.xml).
-  Modular Framework Structure: Organized into distinct packages and classes for better maintainability and scalability.
  
**Usage:**
==========
Steps:
1. Create Maven Project: Initialize a Maven project structure.
2. Update pom.xml: Add required dependencies for Rest Assured, TestNG, log4j, and          extent reports.
3. Create Folder Structure: Organize project into logical folders.
4. Create Packages:
  i) - api.endpoints: Contains classes for defining API endpoints.
    	 - Routes.java: Contains URLs.
     	 - UserEndpoints.java: Implemented CRUD operations for user module.
       - PetEndpoints.java: Similar implementation pet module.
    	 - StoreEndpoints.java: Similar implementation store module.
  ii)  - api.payload: Stores input data for POST requests.
  iii) - api.test: Implements tests and assertions.
  iv) - api.utilities:
       - DataProviders: Implements data-driven testing.
       - ExtentReportManager: Manages ExtentReports.
       - XLUtilities: Handles Excel data.
5. Generate Extent Reports: Implement utilities for generating ExtentReports and configure testng.xml for report generation.
6. Add Logging: Integrate logging functionality for comprehensive test logs.

**Running Tests:**
==================
To execute tests, use the following command:
mvn clean test

