package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

import java.util.Set;
import java.util.Iterator;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class searchProduct {
	public WebDriver driver;
	String homepage_result;
	String offerpage_result;

	@Given("user is on freencard landing page")
	public void user_is_on_freencard_landing_page() {
		System.setProperty("webdriver.chrome.driver","D:\\Users\\Harika.Sankula\\Documents\\selenium\\new version\\chromedriver-win64\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	  
	}
	@When("user search with shortname {string} and extracted product")
	public void user_search_with_shortname_and_extracted_product(String product) {
		driver.findElement(By.xpath("//input[@class='search-keyword']")).sendKeys((product));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='product-name']")));
		
	    homepage_result=driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
	    System.out.println(homepage_result);
	}
	/*@Then("user search for {string} shortname in offer page to check product")
	public void user_search_for_shortname_in_offer_page_to_check_product(String sameproduct) {
		driver.findElement(By.linkText("Top Deals")).click();
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		String parentwindow=i1.next();
		String childwindow=i1.next();
		driver.switchTo().window(childwindow);
		driver.findElement(By.id("search-field")).sendKeys(sameproduct);
		offerpage_result =driver.findElement(By.xpath("//*[text()='Tomato']")).getText();
		System.out.println(offerpage_result);
		Assert.assertEquals(offerpage_result,homepage_result);
		driver.switchTo().window(parentwindow);
		
		
		
		
	   
	}*/

}
