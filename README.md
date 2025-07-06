# TransMediaAssignment

A test automation framework designed to verify the functionality of web applications. This project follows the **Page Object Model (POM)** design pattern and includes both **UI and API test automation** components.

## Prerequisites

- Java 11 or Higher  
- API Server: `http://localhost:3000`

## Structure

### Base Layer

- `BaseAPITest.java`: Foundation for API test execution  
- `BaseUITest.java`: Foundation for UI test execution  
- `JsonFileRead.java`: Read Json files

### Page Object Model (POM) Layer

- `BoardsHomePage.java`: Handles elements and business logic in the Boards related page  
- `ListPage.java`: Handles elements and business logic for List related page

### API Test Layer

Contains API test implementations:

- `ListCreateTest.java`: Tests adding a new list  
- `ListDeleteTest.java`: Tests deleting newly created list

### UI Test Layer

Contains UI test implementations:

- `BoardCreationTest.java`: Tests inputting a Board name, press enter. Verify Board created successfully  
- `ListCreationTest.java`: Tests adding two lists and verifies two lists created successfully  
- `ListDeletionTest.java`: Tests deleting a list

### Resources

- `listId.txt`: Util file for writing  
- `list_payload.json`: Contains JSON payload for list creation

### Constants

- `Constants.java`: Contains the test data

### Reporting
- `ExtentReportManager.java`: Contains common report configuration
- `Report path`: test-output/ExtentReport.html
- ![image](https://github.com/user-attachments/assets/236e7308-4462-4ce2-9212-24279d07650c)

