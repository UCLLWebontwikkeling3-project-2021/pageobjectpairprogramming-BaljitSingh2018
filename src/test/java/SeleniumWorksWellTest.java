import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWorksWellTest {

	private String url = "http://localhost:8080";
	private WebDriver driver;

		@Before
		public void setUp() throws Exception {
			// pas aan indien nodig
			//System.setProperty("webdriver.chrome.driver", "/Users/grjon/Desktop/web3/chromedriver");
			// windows: gebruik dubbele \\ om pad aan te geven
			// hint: zoek een werkende test op van web 2 maar houd er rekening mee dat Chrome wellicht een upgrade kreeg
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Balji_000\\Documents\\2020-2021\\Web3\\Lib\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://nl.wikipedia.org/wiki/Hoofdpagina");
		}



		@Test 
		public void browserVindtWikipedia() {
			assertEquals("Wikipedia, de vrije encyclopedie", driver.getTitle());
		}

		@Test
		public void wikipediaVindtSelenium() {
			WebElement field = driver.findElement(By.id("searchInput"));
			field.clear();
			field.sendKeys("selenium");
			WebElement link = driver.findElement(By.id("searchButton"));
			link.click();
			assertEquals("Selenium - Wikipedia", driver.getTitle());
			assertEquals("Selenium", driver.findElement(By.tagName("h1")).getText());
	}

	@Test
	public void test_Gaat_Naar_Form_Page_Als_WelcomeFile(){
		driver.get(url);
		assertEquals("Home", driver.getTitle());
	}

	@After
	public void clean(){
		driver.quit();
	}


}
