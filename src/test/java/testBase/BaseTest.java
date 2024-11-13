package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
	
	public static WebDriver driver;
	public Properties prop;
	
	@BeforeClass (groups= {"Sanity","Regression","Master","DataDriven"})
 	@Parameters ({"os","browser"})
	public void setup(String os, String br) throws IOException	
	{
		FileReader file=new FileReader("./src//test//resources//config.properties");
		prop=new Properties();
		prop.load(file);
				
		switch(br.toLowerCase()){
		
		case "chrome": driver=new ChromeDriver(); break;
		case "edge": driver=new EdgeDriver(); break;
		case "firefox": driver=new FirefoxDriver(); break;
		default: System.out.println("Invalid Browser"); return;
			
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("appUrl"));
			
	}
	
	@AfterClass (groups= {"Sanity","Regression","Master","DataDriven"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String getRandomAlphabetic()
	{
		String alpha=RandomStringUtils.randomAlphabetic(5);
		return alpha;
	}   
	
	public String getRandomNumeric()
	{
		String numeric=RandomStringUtils.randomNumeric(5);
		return numeric;
	}
	
	public String getalphanumberic()
	{
		String alphanumer=RandomStringUtils.randomAlphanumeric(6);
		return alphanumer;
	}
	
	public String CaptureScreen(String tname) {
		
		String timestamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot) driver; 
		File Sourcefile=ts.getScreenshotAs(OutputType.FILE);
		String targetfilepath=System.getProperty("user.dir")+"\\screenshot\\"+tname+"_"+timestamp+".png";
		File targetfile=new File (targetfilepath);
		
		Sourcefile.renameTo(targetfile);
		
		return targetfilepath;
	}
	
	
	

}
