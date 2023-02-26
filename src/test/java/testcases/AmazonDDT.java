package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AmazonWebElements;
import Utilities.BaseClass;
import Utilities.XLUtils;

public class AmazonDDT extends BaseClass {

	@Test(priority=1)
	public void sign() throws IOException {
		AmazonWebElements amazon = new AmazonWebElements(driver);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOf(amazon.SignIn)).click();
		takescreenshot("Completed");
		wait.until(ExpectedConditions.visibilityOf(amazon.CreateAccount)).click();
		takescreenshot("Completed2");
	}

	@Test(dataProvider = "test", priority=2)
	public void Regform(String name, String email, String password) {
		AmazonWebElements amazon = new AmazonWebElements(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.visibilityOf(amazon.FN)).sendKeys(name);
		System.out.println("name");
		wait.until(ExpectedConditions.visibilityOf(amazon.FN)).clear();
		System.out.println("name");
		wait.until(ExpectedConditions.visibilityOf(amazon.email)).sendKeys(email);
		System.out.println("name");
		wait.until(ExpectedConditions.visibilityOf(amazon.email)).clear();
		wait.until(ExpectedConditions.visibilityOf(amazon.Password)).sendKeys(password);
		wait.until(ExpectedConditions.visibilityOf(amazon.Password)).clear();
		System.out.println("name");
		wait.until(ExpectedConditions.visibilityOf(amazon.ReenterPassword)).sendKeys("test123");
		wait.until(ExpectedConditions.visibilityOf(amazon.ReenterPassword)).clear();
		System.out.println("name");

	}

	@DataProvider(name = "test")
	public String[][] Customer_Details() throws IOException {
		String path = System.getProperty("user.dir") + "\\src\\test\\java\\TestData\\TestData.xls";
		XLUtils xlpath = new XLUtils(path);

		int totalrows = xlpath.getRowCount("TestData");
		System.out.println("Number of rows" + totalrows);
		int totalcols = xlpath.getCellCount("TestData", 1);
		System.out.println("Number of cols" + totalcols);

		String Details[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) {
			for (int j = 0; j < totalcols; j++) {
				Details[i - 1][j] = xlpath.getCellData("TestData", i, j);
				System.out.println(Details[i - 1][j]);
			}
		}

		return Details;
	}

}
