# Selenium Explicit Wait Example

This Java program, 'ExplicitWait.java', demonstrates the use of Selenium WebDriver's explicit wait functionality.

## Project Description

The program automates a simple search on Google.  It performs the following actions:

1.  Opens the Google homepage in a Chrome browser.
2.  Locates the search bar.
3.  Enters "java" into the search bar.
4.  Submits the search query.
5.  Uses an explicit wait to wait for the search results page to load.
6.  Prints the number of search results links on the page.
7.  Closes the browser.

The key aspect of this program is the use of 'WebDriverWait' to handle asynchronous behavior in web applications.  Instead of using a fixed delay (which can lead to unnecessary waiting or errors if the page loads slowly), explicit wait ensures that the program waits only until a specific condition is met (in this case, the visibility of the search results).

## Features

* Demonstrates how to set up and use Selenium WebDriver with ChromeDriver.
* Shows how to interact with web page elements (search bar, search results).
* Implements explicit wait using 'WebDriverWait' and 'ExpectedConditions'.
* Handles potential exceptions during the test execution.
* Properly closes the browser and quits the WebDriver instance.

## How to Use

1.  **Prerequisites:**
    * Java Development Kit (JDK) installed.
    * Selenium WebDriver Java library added to the project.
    * ChromeDriver installed and the system property 'webdriver.chrome.driver' set to the correct path.  See the [Selenium Setup Guide](./docs/selenium_setup.pdf) for detailed instructions.

2.  **Compile the Java code:**

    '''bash
    javac ExplicitWait.java
    '''

3.  **Run the compiled code:**

    '''bash
    java ExplicitWait
    '''

    The program will open a Chrome browser, perform the search, and print the number of search results.

## Code Explanation

\* 'System.setProperty("webdriver.chrome.driver", "/*Local URL of the Web Driver*/");':  Configures the system property to specify the location of the ChromeDriver executable.  **Note:** You must replace '"/*Local URL of the Web Driver*/"' with the actual path to your ChromeDriver.
\* 'ChromeOptions options = new ChromeOptions();':  Creates an instance of 'ChromeOptions' to configure the Chrome browser.  This example includes a commented-out line for running Chrome in headless mode.
\* 'WebDriver driver = new ChromeDriver(options);':  Initializes a new ChromeDriver instance with the specified options.
\* 'driver.get("https://www.google.com");':  Opens the Google homepage.
\* 'driver.findElement(By.name("q"));':  Locates the search bar element using its name attribute.
\* 'searchBar.sendKeys("java");':  Enters "java" into the search bar.
\* 'searchBar.submit();':  Submits the search query.
\* 'WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));':  Creates a 'WebDriverWait' instance with a timeout of 3 seconds.
\* 'wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));':  Waits until the element with the ID "search" is visible.  This is the explicit wait, ensuring that the program waits for the search results to load.
\* 'searchResults.findElements(By.tagName("a")).size();':  Finds all the anchor tags within the search results and prints the count.
\* 'Thread.sleep(200);':  Pauses execution for 200 milliseconds.  \*Note: Explicit waits are generally preferred over Thread.sleep, as Thread.sleep is an unconditional wait.\*
\* 'driver.quit();':  Closes the browser and terminates the WebDriver session in the 'finally' block.

## Selenium Setup Guide

For a detailed guide on setting up Selenium WebDriver with Java, please refer to the [Selenium Setup Guide](./docs/selenium_setup.pdf).
