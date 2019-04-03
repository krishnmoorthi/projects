import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SitePingCheck {
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
        //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe")
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kthangav\\Selenium\\chrome_driver_version_73\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();

        String baseUrl = "http://https://www.google.com/";
        String expectedTitle = "Google Search";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }

        //close Fire fox
        driver.close();

    }
}
