# Ourvirtualmarket Project - BDD Framework With Cucumber


  ### Codes And Test Prepared By :
Bug Busters


  ### Getting Started
To get start with this framework, you will need to have following software on your system

• Java 8 or later \
• Maven 4.7 v. or later \
• Chrome, Edge, Safari, IE or Firefox Web Browser

1. Open Terminal or command prompt and navigate to the root directory of the project.
2. Run the following command to download the required dependencies:

   ```bash
    mvn clean
    ```

3. Run the following command to run the test

   ```bash
    mvn verify
    ```

  ### Run With CukesRunner
4. Open the project with IntelliJ IDEA
    - Go to CukesRunner Class inside the project
    - Add a tag name
    - Click the " Run " button
  
### Our Framework is Cucumber (BDD)

* We built our framework using the Java Programming Language.
* We used Maven as a build management tool.
* We used cucumber-Junit and Cucumber Runner to orchestrate tests.
* Inside the Cucumber Runner, we used glues to connect feature files to step definitions.
* We added the report plugin to Cucumber Cukes Runner to generate JSON and HTML reports.
* We have a utilities package, which contains utility classes such as Configuration Reader, Browser Utils, and Driver.
* We are using Page Object Modelling to enhance test maintenance and reduce code duplication.
* We use Page Object Classes to store and identify the elements that we work on.
* We use the Page Factory class and initElements() method to initialize them.
* We are using Cucumber and Gherkin language for non-technical people to understand what is going on in testing.
* To interact with browsers, we are utilizing Selenium WebDriver.
* We used the Singleton pattern by declaring the constructor of the class as private so that no one instantiates the class outside of it. And declared a static method with return type as an object of the class which should check if the class is already instantiated once.
* We have created our test cases in the feature files as-is.
* In the Feature folder, we store our feature files separately, and it helps in the usability of the codes.
* We use hook class as pre-and post-test implementations.
* The step Definitions folder is the place where our actual test scripts are.
* We added a screenshot interface; when the scenario fails, it takes a screenshot.
* For assertions/verifications, to compare expected and actual results we utilize Junit assertions.
* We also use tags for tests that we want to run in bulk.
* Our framework is easy to maintain since we have elements stored in one centralized place. If any changes happen in the application about the elements, we know where to go and how to fix it to run test scripts correctly. 

## 2024 March ;

### END


