# TransMediaAssignment
## Overview
A test automation framework designed to verify the functionality of web applications. This project follows the Page Object Model (POM) design pattern and includes both UI and API test automation components.
##Prerequisites
-Java 11 or Higher
-API Server http://localhost:3000
##Structure
1. Base Layer
BaseAPITest.java: Foundation for API test execution.
BaseUITest.java: Foundation for UI test execution.
UtilHelper.java: Common utility functions.

2. Page Object Model (POM) Layer
BoardsHomePage.java: Handles elements and business Logic in the Boards related page.
ListPage.java: Handles elements and business Logic for List related page.

3. API Test Layer
Contains API test implementations:

ListCreateTest.java: Tests adding a new list
ListDeleteTest.java: Tests deleting newly created list

4. UI Test Layer
Contains UI test implementations:

BoardCreationTest.java: Tests inputting a Board name, press enter. Verify Board created successfully.
ListCreationTest.java: Tests Adding two lists and verify two lists created successfully
ListDeletionTest.java: Tests deleting a list

5. Resources
listId.txt: Util file for writing
list_payload.json: Contains JSON payload for List creation

6. Constants
Constants.java: Contains the test data
