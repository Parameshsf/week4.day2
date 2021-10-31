package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launching Chrome Browser and webpage
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Mouse hover to 'Brands' link and search for 'L'Oreal Paris'
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
		driver.findElement(By.xpath("(//div[@class='css-ov2o3v']/a)[1]")).click();
		System.out.println("The title of the page displayed with searched brand: " + driver.getTitle());

		// Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'customer top rated')]/following::div)[1]")).click();
		// driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(3000);
		// Click Category and click Hair --> Hair Care --> Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		WebElement shampoo = driver.findElement(By.xpath("//span[text()='Shampoo']"));
		shampoo.click();

		// Click Concern -- > color protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

		// Check whether the filter is applied with Shampoo
		if (driver.findElement(By.xpath("//span[text()='Shampoo']")).getText().contains("Shampoo")) {
			System.out.println("The Shampoo filter has been applied successfully");

		}

		// Click on L'Oreal Paris Colour Protect Shampoo
		System.out.println(driver.findElement(By.xpath("(//div[@class='css-10zjw4o'])[1]")).getText());
		if (driver.findElement(By.xpath("(//div[@class='css-10zjw4o'])[1]")).getText()
				.contains("L'Oreal Paris Colour Protect Shampoo")) {
			driver.findElement(By.xpath("(//div[@class='css-10zjw4o'])[1]")).click();
		}
		// A tab opened with L'Oreal Paris Colour Protect Shampoo selected. Switching to
		// the new web page displayed
		Set<String> winHand1 = driver.getWindowHandles();
		List<String> winHandList1 = new ArrayList<String>(winHand1);
		driver.switchTo().window(winHandList1.get(1));
		// Selecting the size of the shampoo from the dropdownn
		Select shampooSize = new Select(driver.findElement(By.xpath("//select[contains(@title,'SIZE')]")));
		shampooSize.selectByVisibleText("360ml");
		Thread.sleep(3000);

		// Print the MRP of shampoo
		String mrp = driver.findElement(By.xpath("((//span[contains(text(),'MRP')])[1]/following::span)[1]")).getText();
		String mrpNo = mrp.substring(1, 4);
		int initialPrice = Integer.parseInt(mrpNo);

		System.out.println("The size of MRP variable " + mrp.length());
		System.out.println("Initial price of the product before checkout" + initialPrice);
		// Click Add to Bag button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'ADD TO BAG')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='css-5s18zx eoh7kvv0']")).click();
		Thread.sleep(3000);
		// Grand Total element is inside a frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='css-acpm4k']")));
		String total = driver.findElement(By.xpath("(//div[@class='value'])[4]")).getText();
		String firstTotal = total.substring(1, 4);
		System.out.println("The grand total before checkout: " + firstTotal);
		// Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.switchTo().defaultContent();
		// Click Continue as Guest
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		WebElement grandTotal = driver
				.findElement(By.xpath("//div[@class='payment-details-tbl grand-total-cell prl20']//span"));
		String fprice = grandTotal.getText();
		int finalPrice = Integer.parseInt(fprice);
		
		System.out.println("The Final price is: " + grandTotal.getText());
		if (initialPrice == finalPrice) {
			System.out.println("Initial price and Final price of the product are same");
		} else {
			System.out.println("Initial price and Final price of the product are NOT same");
		}
		
		driver.close();
		driver.switchTo().window(winHandList1.get(0));
		driver.close();
		
		

	}

}
