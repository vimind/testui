# testui
# Dependencies
1. Java
2. Selenium
3. TestNG
4. Allure
5. Maven
# Setup
git clone https://github.com/vimind/testui.git
Import/Open project in IDE(Intellij/Eclipse)
# Description of the Framework
This is a Page object Model framework. Each page has PageClass.java and PageTest.java classes.
Used Allure as reporting tool. Can be used to run tests in parallel.


# Application used to test
https://openweathermap.org/

# Test Execution
mvn clean test

# Report Generation
Prerequisite: Install allure using following command
brew install allure

allure generate allure-results --clean -o test-report
