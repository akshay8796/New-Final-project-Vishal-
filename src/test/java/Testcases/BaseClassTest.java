package Testcases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClassTest {
	public static WebDriver driver; // import to use static 
	Properties p;
	@Parameters("browser")
	@BeforeClass(groups = "Regression")
	public void Setup(String br) throws IOException
	{
		FileReader file=new FileReader("./src/test/resources/Config.properties");
		p=new Properties();
		p.load(file);
		
		switch (br) {
		case "Chrome": 
			
	    driver = new ChromeDriver();
	    break;
		case "Firefox": driver=new FirefoxDriver(); break;
		case "InternetExp": driver=new InternetExplorerDriver(); break;
		default:System.out.println("Invalid Browser"); return;
			
		
	             }
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL3"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups = "Regression")
	public void tearDown()
	{
		driver.quit();
	}
	
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new java.util.Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp +".png";
		File targetFile=new File(targetFilePath);
		//sourceFile.renameTo(targetFile);
		org.apache.commons.io.FileUtils.copyFile (sourceFile, targetFile);
		return targetFilePath;
	}

}
