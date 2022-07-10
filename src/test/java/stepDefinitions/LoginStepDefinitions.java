package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pageObjects.LoginPage.LoginPage;
import pageObjects.OTPPage.OTPPage;
import pageObjects.homePage.HomePage;
public class LoginStepDefinitions {
    LoginPage loginPage=new LoginPage();
    OTPPage otpPage=new OTPPage();
    HomePage homePage=new HomePage();
    private static final Logger LOG = LoggerFactory.getLogger(LoginStepDefinitions.class);
    @Given("user is on Phoenix Login page and logs in with {string}")
    public void user_is_on_phoenix_login_page_and_logs_in_with(String loginPhoneNumber) {
        loginPage.SVGfontsizeshouldHave("24")
                .verifyPhoenixTxt("Phoenix")
                .verifyLoginTxt("Login to your Account")
                .enterPhNoInLoginBtn(loginPhoneNumber);
    }
    @Then("I click on Login button")
    public void i_click_on_login_button() {
        loginPage.LoginBtnshouldHave("15")
                .clickOnLoginBtnIfEnable();
    }
    @Then("I should see OTP Page and verify the Title as {string}")
    public void iShouldSeeOTPPageAndVerifyTheTitleAs(String Title) {
        otpPage.verifyOTPPageTitle(Title);
    }
    @And("I should verify the text message as An OTP has been sent to {string}. Please enter here.")
    public void iShouldVerifyTheTextMessageAsAnOTPHasBeenSentToPleaseEnterHere(String phNo) {
        otpPage.verifyOTPMsg(phNo);
    }
    @When("I enter OTP as {string}")
    public void i_enter_otp_as(String otp) {
        otpPage.enterOTP(otp);
    }
    @Then("I should see Home Page with {string}")
    public void iShouldSeeHomePageWith(String name) {
        homePage.clickOnAccCircleLnk()
                .validateUserName(name);
    }
    @Then("I click on Logout button")
    public void i_click_on_logout_button() {
        homePage.clickOnLogoutButton();
    }
    @Then("I got log out from the application and land on Login page")
    public void i_got_log_out_from_the_application_and_land_on_login_page() throws InterruptedException {
       loginPage.verifyLoginPageUrl();
    }
    @Given("user is on Phoenix Login page and logs in with different {string}")
    public void userIsOnPhoenixLoginPageAndLogsInWithDifferent(String ph) {
        loginPage.enterPhNoInLoginBtn(ph);
    }
    @Then("I should see error message as {string}")
    public void iShouldSeeErrorMessageAs(String msg) {
        loginPage.verifyPhNoNotRegisteredErrorMsg(msg);
    }

    @Then("I should see  an error message of {string}")
    public void iShouldSeeAnErrorMessageOf(String invalidchar) {
        loginPage.verifyInvalidPhNoMsg(invalidchar);
    }
}
