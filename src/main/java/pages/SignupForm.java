package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class SignupForm {

    private final WebDriver driver;

    @FindBy(id="first-name")
    WebElement firstNameInput;

    @FindBy(id="last-name")
    WebElement lastNameInput;

    @FindBy(name="gender")
    List<WebElement> genders;

    @FindBy(id="dob")
    WebElement dob;

    @FindBy(id="address")
    WebElement address;

    @FindBy(id="email")
    WebElement email;

    @FindBy(id="password")
    WebElement password;

    @FindBy(id="company")
    WebElement company;

    @FindBy(id="role")
    WebElement role;

    @FindBy(id = "expectation")
    WebElement expectation;

    @FindBy(id="comment")
    WebElement comment;

    @FindBy(id="submit")
    WebElement submit;

    @FindBy(id="submit-msg")
    WebElement submitmsg;

    public SignupForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void typeFirstName(String firstName) {
        //firstNameInput.clear(); clear the field
        firstNameInput.sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void chooseGender(int gender) {
        genders.get(gender).click();
    }

    public void typeBirthday(String birthday) {
        dob.sendKeys(birthday);
    }

    public void typeAddress(String address) {
        this.address.sendKeys(address);
    }

    public void typeEmail(String email) {
        this.email.sendKeys(email);
    }


    public void typePassword(String password) {
        this.password.sendKeys(password);
    }

    public void typeCompany(String company) {
        this.company.sendKeys(company);
    }

    public void chooseRole(String role) {
        new Select(this.role).selectByVisibleText(role);
    }

    public void setExpectation(String expectation) {
        new Select(this.expectation).selectByVisibleText(expectation);
    }

    public void selectRandomDevelopmentWays() {
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("div.development-ways > div.checkbox > label > input"));
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int randomNumber = random.nextInt(checkboxes.size());
            WebElement randomCheckbox = checkboxes.get(randomNumber);
            checkboxes.remove(randomNumber);
            randomCheckbox.click();
        }
    }

    public void typeComment(String comment) {
        this.comment.sendKeys(comment);
    }

    public void submitForm() {
        submit.click();
    }

    public String getSubmitMessage() {
        return submitmsg.getText();
    }
}
