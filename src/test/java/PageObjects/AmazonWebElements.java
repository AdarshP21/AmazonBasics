package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonWebElements {
	
	 WebDriver driver;
	
	
	public AmazonWebElements(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	public WebElement SignIn;
	
	@FindBy(xpath = "//*[@id='ap_email']")
	@CacheLookup
	public WebElement Email;
	
	@FindBy(xpath = "//*[@id=\"continue\"]")
	@CacheLookup
	public WebElement Continue;

	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	@CacheLookup
	public WebElement Password;
	
	@FindBy(xpath = "//*[@id=\"createAccountSubmit\"]")
	@CacheLookup
	public WebElement CreateAccount;
	
	
	@FindBy(xpath = "//*[@id=\"ap_customer_name\"]")
	@CacheLookup
	public WebElement FN;
	
	@FindBy(xpath = "//*[@id=\"ap_email\"]")
	@CacheLookup
	public WebElement email;
	
	@FindBy(xpath = "//*[@id=\"ap_password_check\"]")
	@CacheLookup
	public WebElement ReenterPassword;
	
	

}
