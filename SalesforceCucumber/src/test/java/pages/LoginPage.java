package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	@FindBy(id="username")
	private WebElement usernametextbox;
	
	@FindBy(id="password")
	private WebElement passwordtextbox;
	
	@FindBy(id="Login")
	private WebElement loginButton;
	
	
	public void enterUsername(String username) {
		usernametextbox.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordtextbox.sendKeys(password);
	}
	public void clickLogin() {
		loginButton.click();
	}
	

	public void loginToSFDC(String userEmail, String passWord) {
		//logger.info("Siging in to application");
		this.usernametextbox.sendKeys(userEmail);
		this.passwordtextbox.sendKeys(passWord);
		this.loginButton.click();
		//logger.info("Should be signed in to application");
	}



}
