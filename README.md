## AIRE LOGIC Automation Test

### Implemented below scenarios
- UI Scenarios -- Opens a chrome browser and run the below 9 automated scenarios and the other 3 scenarios are the defects I found and need more information to automate

### Scenarios

1. Clicking on Sell Cookies/ Buy Factories without any cookies shouldn’t be able to buy Sell cookies/Buy Factories
2. Entering your name and click on Start should redirect to new page and it should have the entered name, Cookies, factories and Money with default values
3. Clicking on Cookie clicker should redirect to the home page and should have all the names with score
4. Click some cookies and verify the score updated in the home page
5. Clicking on Click Cookie should just increase 1 cookie every time and it should not increase Factories/Money
6. When you have 10 cookies and try 9 sell cookies and should be able to sell and get money with .25 dollar each cookie
7. Selling all cookies what I have left should work  —  Not working as expected
8. Clicking on Sell cookies/Buy Factories without entering anything in the text box shouldn’t do any thing
9. Clicking on Buy factories/Sell Cookies should not increase the cookies count — Not working while clicking Buy factories and it is increasing cookies count more
10. We should just be able to sell cookies with the amount of cookies we have — Not working. We are able to see the cookies more than we have after clicking Buy factories
11. Once we click on buy factories then Click cookie is not increasing the cookies count by 1 per every click. Instead it is increasing random numbers —  Not working as expected
12. We shouldn’t be able to create a new game with the same name. But If we are creating then we shouldn’t override the score. — Not working as expected

### Technology Stack

- Java 8
- Cucumber
- Selenium Webdriver
- Pico Container
- Maven
- AssertJ


### IDE
 
- IntelliJ IDEA


### Browser Support

- Google Chrome


### Run Tests

- `mvn clean test`


### Reports
- Generated reports are under target/cucumber-reports/cucumber.html/index.html

