import org.junit.jupiter.api.Test;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest extends BaseTest {
	@Test
	public void testContactFormSubmit throws Exception() {
		driver.get("https://practicesoftwaretesting.com/contact");

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
		
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(
		    screenshot.toPath(),
		    Path.of("contact.png"),
		    StandardCopyOption.REPLACE_EXISTING
		);

		ContactPage contactPagePom = new ContactPage(driver);

		//FillForm
		contactPagePom.fillForm();

		// Submit
		contactPagePom.submitForm();

		// Add explicit wait for the success alert to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement alert = wait.until(
			ExpectedConditions.visibilityOfElementLocated(contactPagePom.alertLoc)
		);
		String alertText = alert.getText().trim();

		assertEquals("Thanks for your message! We will contact you shortly.", alertText);
	}
}
