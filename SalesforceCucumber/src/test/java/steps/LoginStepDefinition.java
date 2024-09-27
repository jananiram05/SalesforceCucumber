package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import hooks.Hooks;
import pages.LoginPage;
import utils.Datautils;

public class LoginStepDefinition {
	private WebDriver driver;
	private LoginPage loginPage;

	@Before
	public void setup() {
		System.out.println("setting up ...");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
	}

	@After
	public void teardown(Scenario scenario) {
		System.out.println("tear down...");

		/*
		 * if (driver != null) { driver.quit(); }
		 */
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		//driver = null;
		driver.close();
	}

	/*
	 * public LoginStepDefinition(Hooks hooks) { this.driver = hooks.getDriver();
	 * this.loginPage = new LoginPage(driver); }
	 */

	@Given("User is on {string}")
	public void userIsOn(String pageName) throws IOException {
		if (pageName.equals("LoginPage")) {
			driver.get(Datautils.readLoginTestData("login.url")); // Assuming you have this URL in your properties file
		}
	}

	@When("Enter into textbox username as {string}")
	public void enterIntoTextboxUsernameAs(String username) {
		loginPage.enterUsername(username);
	}

	@When("Enter into password as {string}")
	public void enterIntoPasswordAs(String password) {
		loginPage.enterPassword(password);
	}

	@When("click on Button {string}")
	public void clickOnButton(String button) {
		if (button.equals("Login")) {
			loginPage.clickLogin();
		}
	}

	@Then("user should be seeing home page")
	public void user_should_be_seeing_home_page() {
		// You can add assertions here to verify the user is on the home page.
	}

	@When("User enters valid username")
	public void user_enters_valid_username() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername(Datautils.readLoginTestData("valid.username"));
	}

	@When("User enters valid password")
	public void user_enters_valid_password() throws IOException {
		// Write code here that turns the phrase above into concrete actions
		loginPage.enterPassword(Datautils.readLoginTestData("valid.password"));
	}

	@When("click on login Button")
	public void click_on_login_button() {
		// Write code here that turns the phrase above into concrete actions
		loginPage.clickLogin();
	}

}
