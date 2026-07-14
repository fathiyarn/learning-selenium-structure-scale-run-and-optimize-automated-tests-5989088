import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {
	private WebDriver driver;

	public ContactPage(WebDriver driver) { this.driver = driver; }

	By firstNameLoc = By.id("first_name");
	By lastNameLoc = By.id("last_name");
	By emailLoc = By.id("email");
	By subjectLoc = By.id("subject");
	By messageLoc = By.id("message");
	By btnSubmitLoc = By.className("btnSubmit");

	By alertLoc = By.className("alert");

	public void fillForm() {
	
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameLoc))
	            .sendKeys("John");
	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameLoc))
	            .sendKeys("Smith");
	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(emailLoc))
	            .sendKeys("john.smith@example.com");
	
	    Select subjectSelect = new Select(
	            wait.until(ExpectedConditions.elementToBeClickable(subjectLoc))
	    );
	
	    subjectSelect.selectByValue("webmaster");
	
	    wait.until(ExpectedConditions.visibilityOfElementLocated(messageLoc))
	            .sendKeys("Hello My name is John Smith, Please make sure we have got 50 characters in this message.");
	}

	public void submitForm() {
		driver.findElement(btnSubmitLoc).click();
	}
}
