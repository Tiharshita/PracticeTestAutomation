package pageObject;

import java.util.ResourceBundle;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
    
	   public BasePage(WebDriver driver)
	     {
		     this.driver=driver;
		     PageFactory.initElements(driver,this);
	     }
	}	
	
//	@BeforeClass
//	@Parameters("browser")
//	public void setup(String br) {
//		
//		rb=ResourceBundle.getBundle("config");
//		
//		if(br.equals("chrome"))
//		{
//			driver=new ChromeDriver();
//		}
//		else if (br.equals("firefox")) {
//			driver=new FirefoxDriver();
//		}
//		else {
//			driver=new EdgeDriver();
//		}
//	}
//
//	@AfterClass
//	public void teardown() {
//		
//		driver.quit();
//	}

