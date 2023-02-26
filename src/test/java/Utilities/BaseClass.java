package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	@Parameters("browser")
	@BeforeTest
	public void setup(String br) {

		if (br.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			// options.addArguments("--headless");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (br.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			options.addArguments("--incognito");
			options.addArguments("--headless");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
		}

		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.get("https://www.amazon.com/");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(6));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	//screenshot
	public void takescreenshot(String fileName) throws IOException {
		//take screenshot and store it in file format.
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//copy in location
		FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".jpg"));
	}

}
