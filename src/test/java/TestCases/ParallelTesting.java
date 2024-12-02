package TestCases;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ParallelTesting {
	
	public static void main(String[] args) {
        // Generate a unique email ID
        String uniqueEmail = "user_" + UUID.randomUUID() + "@example.com";

        // Run browsers simultaneously using threads
        Thread chromeThread = new Thread(() -> runTestInChrome(uniqueEmail));
        Thread firefoxThread = new Thread(() -> runTestInFirefox(uniqueEmail));

        chromeThread.start();
        firefoxThread.start();

        try {
            chromeThread.join();
            firefoxThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runTestInChrome(String email) {
        // Set Chrome driver properties
        System.setProperty("webdriver.chrome.driver", "https://naveenautomationlabs.com/opencart/");

        WebDriver driver = new ChromeDriver();
        try {
            // Perform your test with the unique email
            driver.get("https://example.com");
            System.out.println("Running on Chrome with email: " + email);

            // Add your test steps here...
        } finally {
            driver.quit();
        }
    }

    public static void runTestInFirefox(String email) {
        // Set Firefox driver properties
        System.setProperty("webdriver.gecko.driver", "https://naveenautomationlabs.com/opencart/");

        WebDriver driver = new FirefoxDriver();
        try {
            // Perform your test with the unique email
            driver.get("https://example.com");
            System.out.println("Running on Firefox with email: " + email);

            // Add your test steps here...
        } finally {
            driver.quit();
        }
    }

}
