import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Baljit Singh & Mathias Devos
 */

public class HomePage extends Page {

    @FindBy(id="LoginUserid")
    private WebElement useridField;

    @FindBy(id="LoginPassword")
    private WebElement passwordField;

    @FindBy(id="Login")
    private WebElement logInButton;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=Home");
    }

    public void setUseridField(String useridField) {
        this.useridField.clear();
        this.useridField.sendKeys(useridField);
    }

    public void setPasswordField(String passwordField) {
        this.passwordField.clear();
        this.passwordField.sendKeys(passwordField);
    }

    public HomePage submitValid() {
        logInButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void submitInvalid() {
        logInButton.click();
    }
}
