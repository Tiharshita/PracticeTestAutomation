package stepDefinitions;

import java.time.Duration;
import java.util.ResourceBundle;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginPage;

public class steps {
	
	public WebDriver driver;
	public ResourceBundle rb;
	LoginPage loginpage;
	String br;

	@Before
	public void setUp() {
		
		rb=ResourceBundle.getBundle("config");
		br=rb.getString("browser");
		
		
	}
	  @After
	    public void tearDown(Scenario scenario) {
	        System.out.println("Scenario status ======>"+scenario.getStatus());
	        if(scenario.isFailed()) {
	        	
	        	TakesScreenshot ts=(TakesScreenshot) driver;
	        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
	        	scenario.attach(screenshot, "image/png",scenario.getName());
	        	            
	        }
	       driver.quit();
	    }
	
	@Given("user Launch Browser")
	public void user_launch_browser() {
//		 	if(br.equals("chrome"))
//	        {
//	           driver=new ChromeDriver();
//	        }
//	        else if (br.equals("firefox")) {
//	            driver = new FirefoxDriver();
//	        }
//	        else if (br.equals("edge")) {
//	            driver = new EdgeDriver();
//	        }
			driver=new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user Opens URL {string}")
	public void user_opens_url(String url) {
	    
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("user enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUserName(username);
		loginpage.setPassword(password);
	}

	@When("click On Submit")
	public void click_on_submit() {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.clickSubmit();
	}

	@Then("page Title should be {string}")
	public void page_Title_should_be(String title){
		LoginPage loginpage = new LoginPage(driver);
		if(driver.getPageSource().contains("\"Test Login | Practice Test Automation\""))
				//|| driver.getPageSource().contains("Logged In Successfully | Practice Test Automation")) 
			//driver.getPageSource().contains("Logged In unsuccessfully")
				{
			//driver.close();
			Assert.assertTrue(true);
			}
		
		//else {Assert.assertEquals(title, driver.getTitle());
		else {Assert.assertEquals(title, driver.getTitle());

		}
//		try {
//		
//		String ExpectedResult= "Logged In Successfully | Practice Test Automation";
//		String ActualResult= driver.getTitle();
//		
//		
//		Assert.assertEquals(ActualResult, ExpectedResult);
//		}
//		catch(Exception e){
//		Assert.fail("validate Test case failed");
//		}
	}
	@When("user Click on Logout")
	public void user_click_on_logout() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		
		Thread.sleep(3000);
		if(driver.getPageSource().contains("Logged In Successfully | Practice Test Automation")) {
		loginpage.clickLogout();
		} 
		else {
//		driver.close();
		System.out.println("close the browser");
		}
	}
	
//	@Then("error message should be visible on screen {string}")
//	public void error_message_should_be_visible_on_screen(String string) {
//		String actualMsg = driver.findElement(By.xpath("//div[text()='Your username is invalid!']")).getText();
//				String errorMsg= "Your username is invalid!";
//
//				if(actualMsg.equals(errorMsg)) {
//				        System.out.println("Test Case Passed");
//				    }else{
//				        System.out.println("Test Case Failed");
//				    }
//	}
	
	@Then("close Browser")
	public void close_browser() {
		 driver.quit();
	}
}
