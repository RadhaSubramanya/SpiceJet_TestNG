package SpiceJet.SpiceJet_TestNG.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	public WebDriver driver = null;
	public Properties prop = null;

	public WebDriver launchBrowser(Properties prop){
		switch (prop.getProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			break;
		case "ie":
			break;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageloadtimeout")),
				TimeUnit.SECONDS);
		return driver;
	}

	public Properties initializeProperties() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\NEW Drive E Data\\New Radha Workspace Dec 2019"
				+ "\\Project\\SpiceJet_TestNG\\src\\main\\java\\SpiceJet\\SpiceJet_TestNG"
				+ "\\config\\Config.properties");
		prop.load(fis);
		return prop;
	}

	public String getScreenshot() {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshots" + System.currentTimeMillis() + ".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			System.out.println("capture failed" + e.getMessage());
		}
		return path;
	}

}
