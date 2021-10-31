package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tableExercise {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Locating the web table
		WebElement seleniumTable = driver.findElement(By.id("table_id"));
		// Finding the rows of the table
		List<WebElement> rows = seleniumTable.findElements(By.xpath("//table[@id='table_id']//tr"));
		// Printing the header columns of the table or first row of the table
		System.out.println("The Header of the table as follows ");
		System.out.println(rows.get(0).getText());
		System.out.println(rows.get(1).getText());

		// Printing the column values of the table
		List<WebElement> cols = seleniumTable.findElements(By.xpath("//table[@id='table_id']//td"));
		System.out.println(cols.get(4).getText());
		System.out.println("Entire Data of the table as follows");

		for (int i = 1; i < rows.size(); i++) {
			if (i == 2) {
				System.out.println("Print 2nd Row");
				System.out.println(rows.get(i).getText());

			}
		}
		// Printing the Mentor Name from 3rd row of the table
		System.out.println("The Mentor Name of 3rd Row from the table ");
		List<WebElement> Col = rows.get(3).findElements(By.tagName("td"));
		System.out.println(Col.get(4).getText());
		// Printing Only Selenium Learning details from the table
		System.out.println("Priting Selenium Learning Columns Details alone");
		for (int i = 0; i < rows.size(); i++) {
			List<WebElement> allCols = rows.get(i).findElements(By.tagName("td"));

			for (int j = 0; j < allCols.size(); j++) {
				if (j == 0) {

					System.out.println(allCols.get(0).getText());
					break;
				}

			}
		}

	}

}
