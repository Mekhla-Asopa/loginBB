package org.bb.testPom;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.bb.pom.Invoice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestInvoice {
	
	public WebDriver driver;
	
	@BeforeTest
	public void lBrowser() {
	System.setProperty("webdriver.chrome.driver", ".\\Softwares\\chromedriver.exe");
	driver = new ChromeDriver();
	Reporter.log("Launching browser", true);
	driver.manage().window().maximize();    
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://qa.aceinvoice.com/sign_up");
	}
	
	@Test
	public void run() throws InterruptedException{
	Invoice in = new Invoice(driver);
	Random r = new Random();
	int num = r.nextInt(1000);
	String utext = ("un" + num + "@gmail.com");
	String ptext = "Qwerty123";
	Reporter.log(utext, true);
	in.emailText(utext);
	in.getsclick();
	Thread.sleep(2000);
	in.pwdText(ptext);
	Thread.sleep(4000);
	in.pwdCText(ptext);
	Thread.sleep(4000);
	in.contClick();
	Thread.sleep(4000);
	in.firstNameText("Mekhla");
	Thread.sleep(2000);
	in.lastNameText("Dutta");
	Thread.sleep(2000);
	in.timeField();
	Thread.sleep(2000);
	in.checkBoxClick();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)");
	Thread.sleep(6000);
	in.commitClick();
	Thread.sleep(7000);
	in.orgNameText("Qspider");
	Thread.sleep(4000);
	in.orgCommitClick();
	Thread.sleep(4000);
	in.skipClick();
	Thread.sleep(4000);
	in.gToAppClick();
	
	}
	
	@AfterTest
	public void cBrowser(){
		driver.close();
		}
	
}
