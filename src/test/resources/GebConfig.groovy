import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions


driver = {
    WebDriverManager.chromedriver().setup()
    ChromeOptions chromeOptions = new ChromeOptions()
    chromeOptions.addArguments("--disable-notifications")
    chromeOptions.addArguments("--start-maximized")
    new ChromeDriver(chromeOptions)
}

reportsDir = "build/reports"
