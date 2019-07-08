package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SignupForm;

public class SignupFormSteps {
    private ChromeDriver driver;
    private SignupForm signupForm;

    @Given("user navigates to the app url")
    public void userNavigatesToTheAppUrl() {
        System.setProperty("webdriver.chrome.driver", "/Users/gago/Downloads/selenium/chromedriver");
        driver = new ChromeDriver();
        driver.get("http://katalon-test.s3.amazonaws.com/demo-aut/dist/html/form.html");
        signupForm = new SignupForm(driver);
    }

    @When("user fills first name {string}")
    public void userFillsFirstName(String firstName) {
        signupForm.typeFirstName(firstName);
    }

    @And("user fills last name {string}")
    public void userFillsLastName(String lastName) {
        signupForm.typeLastName(lastName);
    }

    @And("user fills gender")
    public void userFillsGender() {
        signupForm.chooseGender(0);
    }

    @And("user fills date of birth {string}")
    public void userFillsDateOfBirth(String dateOfBirth) {
        signupForm.typeBirthday(dateOfBirth);
    }

    @And("user fills address")
    public void userFillsAddress() {
        signupForm.typeAddress("1234 N Main Street");
    }

    @And("user fills email")
    public void userFillsEmail() {
        signupForm.typeEmail("a@a.com");
    }

    @And("user fills password")
    public void userFillsPassword() {
        signupForm.typePassword("12345Password");
    }

    @And("user fills company")
    public void userFillsCompany() {
        signupForm.typeCompany("Best Company");
    }

    @And("user role QA")
    public void userRoleQA() {
        signupForm.chooseRole("QA");
    }

    @And("user select job expectations")
    public void userSelectJobExpectations() {
        signupForm.setExpectation("Good teamwork");
        signupForm.setExpectation("High salary");
        signupForm.setExpectation("Challenging");
    }

    @And("user select ways of development")
    public void userSelectWaysOfDevelopment() {
        signupForm.selectRandomDevelopmentWays();
    }

    @And("user fill comment")
    public void userFillComment() {
        signupForm.typeComment("I Love Cucumber!!!");
    }

    @And("user click submit button")
    public void userClickSubmitButton() {
        signupForm.submitForm();
    }

    @Then("form is submitted")
    public void formIsSubmitted() {
        String signupMessageResult = signupForm.getSubmitMessage();
        Assert.assertEquals(signupMessageResult, "Successfully submitted!");
    }

    @After
    public void shutdown() {
        driver.quit();
    }
}
