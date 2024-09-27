
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableScraper {
	public static void main(String[] args) {
		// Set up ChromeDriver path
		//in latest 4.0 it doesnt require
		System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();

		// Navigate to the webpage with the table
		driver.get("https://example.com/table");

		// Locate the table by its ID or class (you can modify this according to your
		// HTML structure)
		WebElement table = driver.findElement(By.id("table-id")); // or By.className("table-class")

		// Find all the rows in the table body
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Loop through each row
		for (WebElement row : rows) {
			// Get all the columns (cells) in the current row
			List<WebElement> columns = row.findElements(By.tagName("td"));

			// Loop through each cell and print the text
			for (WebElement column : columns) {
				System.out.print(column.getText() + "\t"); // Tab space between each column
			}
			System.out.println(); // Newline after each row
		}

		// Close the browser
		driver.quit();
	}
}
