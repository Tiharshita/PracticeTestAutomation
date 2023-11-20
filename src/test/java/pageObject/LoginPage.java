package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	//constructor
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	//elements
	@FindBy(id="username")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement passwd;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement submitBtn;
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logoutBtn;
	
	@FindBy(xpath="//div[text()='Your username is invalid!']")
	WebElement errormessage;
	
	
	//Action Methods
	public void setUserName(String username) {
		userName.sendKeys(username);
	
	}
	
	public void setPassword(String password) {
		passwd.sendKeys(password);
	
	}

	public void clickSubmit(){
		submitBtn.click();
	}
	
	public void clickLogout() {
		logoutBtn.click();
	}
	
	public Object getPageTitle() {
		return driver.getTitle();

	}
	
	public String getError() {
		return errormessage.getText();
	}
}


