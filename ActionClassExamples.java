package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionClassExamples {
	
	
	
	
	
	
	public void dragAndDrop() throws InterruptedException {
		
		// TODO Auto-ge''nerated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/drop.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement dragMe = driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement dropHere = driver.findElement(By.xpath("//p[text()='Drop here']"));
		
		Actions builder = new Actions(driver);
		Thread.sleep(10000);
		builder.dragAndDrop(dragMe, dropHere).perform();
		Thread.sleep(3000);
		builder.dragAndDropBy(dragMe, 150, 150).perform();//Move the element based on position
		Thread.sleep(3000);
		driver.quit();
	}
	
	public void selectable() throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement firstItem = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement lastItem = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		Actions builder = new Actions(driver);
		builder.clickAndHold(firstItem).moveToElement(lastItem).release().perform();
		
		
		Thread.sleep(2000);
		builder.keyDown(Keys.CONTROL).click(firstItem).click(lastItem).keyUp(Keys.CONTROL).perform();
		Thread.sleep(3000);
		
		
		
		Thread.sleep(3000);
		//driver.quit();

	}
	
	public void sortable() {
		// This method is used to shuffle the web elements from one index to other index using locations
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.switchTo().frame(0);
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));
		
		Actions builder = new Actions(driver);
		
		int x = item5.getLocation().getX();
		int y = item5.getLocation().getY();
		
		builder.dragAndDropBy(item1, x, y).perform();
		
		

	}
	
	public void actionsMethods() throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable Notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//MouseHover on Men web element
		WebElement menElement = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
		Actions webActions = new Actions(driver);
		webActions.moveToElement(menElement).perform();
		Thread.sleep(3000);
		
		//DoubleClick on Myntra Web Element to refresh the page
		WebElement myntraElement = driver.findElement(By.xpath("(//a[@class='myntraweb-sprite desktop-logo sprites-headerLogo'])[1]"));
		webActions.doubleClick(myntraElement).perform();
		Thread.sleep(2000);
		
		//RightCLick on the web page
		webActions.contextClick().perform();
		Thread.sleep(3000);
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ActionClassExamples obj = new ActionClassExamples();
		//obj.actionsMethods();
		
		
		//obj.dragAndDrop();
		
		//obj.selectable();
		
		obj.sortable();
		
		
		
		
		
		
		
		
	}

}
