About the project

This project was created as part of the final stage of the software testing course and is educational. We, 
the team, conducted a comprehensive testing of the PetSitters platform, developed by students as an educational web application.
PetSitters is a service for searching and booking pet care services. The platform allows users to register, find verified performers, manage orders, leave reviews and use a rating system. 
The project includes various modules, such as a personal account, authorization system, service booking and profile management.
The main goal of our work is to test this project from different aspects, using various testing methodologies, modern tools and working through the entire testing cycle from requirements analysis to reporting.

Repository with tests and documentation
Public repository:
https://github.com/RomNox/finalProject

We used a structured and systematic approach based on best testing practices:

Requirements analysis – we studied the specifications and analyzed the system using the FURPS (Functionality, Usability, Reliability, Performance, Supportability) model.
Creating test documentation – developed a test plan, test cases, and checklists to check key functional and non-functional requirements.
Functional testing – tested the main user scenarios: registration, authorization, booking, working with a profile, and payments.
API testing – used Postman and Newman to test API endpoints for correctness, security, and error handling.
UI/UX testing – checked the usability of the interface, compliance with layouts, and responsiveness of the site on different devices.
Load testing – using Artillery, we tested the system under high load to determine its performance.
Automated testing – developed tests for Selenium WebDriver + JUnit, implemented CI/CD with Jenkins.
Reporting – We used Allure and also documented the bugs we found in Jira.

Used tools and technologies

Test automation - Java, Selenium WebDriver, JUnit, Gradle
CI/CD and reporting - Jenkins, Allure
API testing - Postman, Newman
Load testing - Artillery
Logging and debugging - Logback
Test management - Jira, TestLink

Test results
General statistics:

200 test cases

136 positive scenarios (successful checks)
64 negative scenarios (error handling)

Functional tests:

Registration and authorization – passed
Booking services – 2 errors with cancellation processing
Search for performers – passed
Profile management – passed
Review system – 1 bug (rating is not updated after deleting a review)

API testing:

100 API requests via Postman – 97% successful
3% of errors: incorrect processing of invalid data

Load testing (Artillery):

Requests Average response time Successes Bugs
100 requests 38 ms 100% 0%
1000 requests 39 ms 99.5% 0.5%
5000 requests 41 ms 97% 3%

Automated testing:

50 Selenium tests – 95% successful, 5% unstable due to UI delays
Bugs registered in Jira:

Total: 37 bugs
Fixed: 30
Remaining relevant: 7
Key issues that require fixing:

Incorrect handling of booking cancellations.
Error updating rating after deleting a review.
The API does not always correctly handle incorrect data.

Team contribution
This project was developed by a team of students as part of the final test assignment.

Team members:
Vladimir Romaikin (Project manager)
Denys Parkhomenko
Dana Streltsova
Kseniia Ivanova
