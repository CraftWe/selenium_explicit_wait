// Package declaration: Organizes the class into a named package.
package com;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// Class declaration: Defines the main class of our program.
public class ExplicitWait {
    // The main method, where the program execution starts.
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Configuring Selenium to use ChromeDriver and setting its executable path.
        System.setProperty("webdriver.chrome.driver", "/*Local URL of the Web Driver*/");

        // Creating an instance of ChromeOptions.
        ChromeOptions options = new ChromeOptions();
        // The next line is where we would customize our Chrome browser
        // For example, running it without showing the window (headless)
        // options.addArguments("--headless"); 
        // Initializing a new instance of ChromeDriver with the specified options.
        WebDriver driver = new ChromeDriver(options);

        try {
            // Opening the Google homepage.
            driver.get("https://www.google.com");

            // Finding the search bar using its name attribute and typing "java" into it.
            WebElement searchBar = driver.findElement(By.name("q"));
            searchBar.sendKeys("java");
            // Submitting the search form.
            searchBar.submit();

            // Implementing an explicit wait of 3 seconds to ensure the visibility of the search results.
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            // Waiting until the element with id "search" is visible on the page.
            WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));

            // Finding all <a> elements within searchResults and printing the total count.
            System.out.println("Number of searches: " + searchResults.findElements(By.tagName("a")).size());

            // Pausing the execution for 200 milliseconds.
            Thread.sleep(200);
        } catch (Exception e) {
            // Printing the stack trace if an exception occurs.
            e.printStackTrace();
        } finally {
            // Closing the browser and quitting the WebDriver.
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
