package jul22.week4.day16.WindowHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindowHandlesWithSeparateMethod {
	
	//Global variable driver
	public static ChromeDriver driver;
	public void windowHandles(int index) {
		Set<String> setWindowHandles = driver.getWindowHandles();
		List<String> listWindowHandles = new ArrayList<String>(setWindowHandles);
		String windows = listWindowHandles.get(index);
		driver.switchTo().window(windows);

	}

		public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			new ChromeDriver();
			driver.get("https://demo.guru99.com/popup.php");
			driver.findElement(By.linkText("Click Here")).click();
			
			LearnWindowHandlesWithSeparateMethod lwhs= new LearnWindowHandlesWithSeparateMethod();
			lwhs.windowHandles(1);			
			driver.findElement(By.name("emailid")).sendKeys("sudhakar.karuppannan@gmail.com");
			lwhs.windowHandles(0);
			String headerText = driver.findElement(By.xpath("//h2[text()='Guru99 Bank']")).getText();
			System.out.println(headerText);
			lwhs.windowHandles(1);
				
		}

	
}
