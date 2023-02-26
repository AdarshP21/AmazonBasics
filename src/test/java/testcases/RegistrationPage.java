package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.AmazonWebElements;
import Utilities.BaseClass;

public class RegistrationPage extends BaseClass {
	
	@Test
	public void RegistrationPage1() throws IOException {
	AmazonWebElements amazon = new AmazonWebElements(driver);
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(90));
	wait.until(ExpectedConditions.visibilityOf(amazon.SignIn)).click();
	takescreenshot("Completed1");
	wait.until(ExpectedConditions.visibilityOf(amazon.CreateAccount)).click();
	takescreenshot("Completed2");
	
	}

}
