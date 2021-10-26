package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Finding the web table using xPath
		WebElement webTable = driver.findElement(By.id("table_id"));

		// Accessing the rows of the table using table object
		List<WebElement> tableRows = webTable.findElements(By.tagName("tr"));
		System.out.println("No of rows " + tableRows.size());
		// Prints all the content from the table
		System.out.println("The table content as follows ");
		for (WebElement webElement : tableRows) {
			System.out.println(webElement.getText());

		}

		WebElement firstRow = tableRows.get(1);
		List<WebElement> tableCol = firstRow.findElements(By.tagName("td"));
		String text = tableCol.get(1).getText();
		System.out.println("First Column Values " + text);

		System.out.println("No of columns " + tableCol.size());

		System.out.println("First Column value ");

		// Print the contents from 2nd column alone

		List<WebElement> cols = tableRows.get(1).findElements(By.tagName("td"));
		// List<WebElement> cols = row.findElements(By.tagName("td"));

		System.out.println(cols.get(5).getText());

	}

}
