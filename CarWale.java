package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarWale {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		// Mouse hover on Used Cars Element
		WebElement usedCarElement = driver.findElement(By.xpath("(//li[@class='o-pAUxC _2TEfMi']/div)[1]"));
		Actions builder = new Actions(driver);
		
		builder.moveToElement(usedCarElement).perform();
		
		//Click 'Find Used Cars' Element
		driver.findElement(By.xpath("//div[contains(text(),'Find Used cars')]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//span[@id='closeLocIcon']")).click();
		
		//Select City as 'Chennai'
		Select city = new Select(driver.findElement(By.xpath("//select[@id='drpCity']")));
		List<WebElement> cityList = city.getOptions();
		for (WebElement list : cityList) {
			if (list.getText().contains("Chennai")) {
				System.out.println("City Chennai Exists in the list");
				driver.findElement(By.xpath("//select[@id='drpCity']")).sendKeys("Chennai",Keys.ENTER);
				break;
			}
			
			
		}
		
		//Choose Budget from 8L to 12L
		driver.findElement(By.xpath("(//span[@id='upDownArrow'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='minInput']")).sendKeys("8");
		driver.findElement(By.xpath("//input[@id='maxInput']")).sendKeys("12");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='btnSetBudget']")).click();
		Thread.sleep(3000);
	
		//Select cars with photos
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//WebElement hyundaiCheckBox = driver.findElement(By.xpath("//li[@data-manufacture-en='Hyundai']//span"));
		WebElement carsWithPhoto = driver.findElement(By.xpath("//li[@name='CarsWithPhotos']"));
		wait.until(ExpectedConditions.elementToBeClickable(carsWithPhoto));
		
		//WebElement carsWithPhoto = driver.findElement(By.xpath("((//div[@class='filter-set content-inner-block-10 position-rel'])[2]//li)[2]"));
		//hyundaiCheckBox.click();
		//WebElement carsWithPhoto = driver.findElement(By.xpath("(//li[@name='CarsWithPhotos'])"));
		//carsWithPhoto.click();
		builder.moveToElement(carsWithPhoto).click().perform();
		boolean enabled = carsWithPhoto.isEnabled();
		boolean selected = carsWithPhoto.isSelected();
		System.out.println("Checkbox is '"+enabled+"'");
		System.out.println("Checkbox is '"+selected+"'");
		
		
		Thread.sleep(3000);
		
	
	}

}
