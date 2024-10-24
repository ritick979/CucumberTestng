package Steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactusSteps { 
	
	WebDriver driver;
	
	@Given("open the browser, enter the sparsh hospital url")
	public void open_the_browser_enter_the_sparsh_hospital_url() { 
		
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://www.sparshhospital.com/"); 
								
	}

	@Given("clicks the contactus button")
	public void clicks_the_contactus_button() {
		driver.findElement(By.xpath("(//a[@href='https://www.sparshhospital.com/contact-us/'])[1]")).click(); 
	}

	@When("user enters 1stname, lastname, phno, email textbox")
	public void user_enters_1stname_lastname_phno_email_textbox() throws InterruptedException { 
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("contact_first_name")).sendKeys("Raju"); 
		driver.findElement(By.id("contact_last_name")).sendKeys("Kumar");
		driver.findElement(By.id("contact_phone")).sendKeys("8228801164");
		driver.findElement(By.id("contact_email")).sendKeys("Raju56@gmail.com");
	}

	@When("select Yashwantpur hospital from Hospital dropdown")
	public void select_yashwantpur_hospital_from_hospital_dropdown() {
		
		driver.findElement(By.id("contact_hospital")).click();
		 List<WebElement> Options = driver.findElements(By.xpath("//select[@id='contact_hospital']/option")); 
		 
		 for (WebElement option : Options) {
			  if (option.getText().equals("SPARSH Hospital, Yeswanthpur")) {
				  option.click();
				break;
			}
			
		}
		 
		 driver.findElement(By.id("contact_enquiry_type")).click(); 
			List<WebElement> Enquaries = driver.findElements(By.xpath("//select[@id='contact_hospital']/option")); 
			 
			 for (WebElement enquarie : Enquaries) {
				  if (enquarie.getText().equals("General Enquiry")) {
					  
					  enquarie.click();
					break;
				}
			 } 
	}

	@When("write a message and click on send button")
	public void write_a_message_and_click_on_send_button() {
		driver.findElement(By.id("contact_message")).sendKeys("Hello everyone"); 
		 driver.findElement(By.id("contact_submit")).click();
		
	}

	@Then("Thankyou message should be displayed")
	public void thankyou_message_should_be_displayed() {
		 String Text = driver.findElement(By.xpath("//h1[@class='font-700 mb-4']")).getText();
		 String textExpectedString = "Thank you"; 
		 org.junit.Assert.assertEquals(textExpectedString, Text);
	}

	@Then("bank info should be available in the page")
	public void bank_info_should_be_available_in_the_page() {
	    String Actualbankinfo = driver.findElement(By.cssSelector("[class=\"text-blue font-700 border-bottom-blue mb-4 text-center\"]")).getText();
	    String expected = "Make UPI Payment:";
	    org.junit.Assert.assertEquals(expected, Actualbankinfo);
	}

// The following method is for scenario outline. 
	@When("user enters {string} {string} {string} {string} textbox")
	public void user_enters_textbox(String firstname, String lastname, String phno, String email) {
		driver.findElement(By.id("contact_first_name")).sendKeys(firstname); 
		driver.findElement(By.id("contact_last_name")).sendKeys(lastname);
		driver.findElement(By.id("contact_phone")).sendKeys(phno);
		driver.findElement(By.id("contact_email")).sendKeys(email);
	}


}
