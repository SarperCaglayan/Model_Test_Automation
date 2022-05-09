package skenarios.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import skenarios.pages.LoginPage;
import skenarios.utilities.BrowserUtils;
import skenarios.utilities.ConfigurationReader;
import skenarios.utilities.Driver;

public class loginStepDefs{

    LoginPage loginPage = new LoginPage();
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        BrowserUtils.waitFor(2);
        String url = ConfigurationReader.get("url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);
    }
    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {

        BrowserUtils.waitFor(2);
        loginPage.languageButton.click();
        loginPage.login(username, password);
    }

    @Then("User is on the main page")
    public void UserIsOnTheMainPage() {
        //BrowserUtils.waitFor(6);
        //String actualTitle = Driver.get().getTitle();
        //String expectedTitle = "Skenarios";
        //Assert.assertTrue(actualTitle.contains(expectedTitle));

        String loginUrl= "https://test-skenarios.herokuapp.com/ui/login/";
        String currentUrl = Driver.get().getCurrentUrl();
        Assert.assertFalse(currentUrl.contains(loginUrl));
    }
    @Given("User is on the staging login page")
    public void user_is_on_the_staging_login_page() {
        BrowserUtils.waitFor(3);
        String url = ConfigurationReader.get("staging_url");
        //WebDriver driver = Driver.get();
        Driver.get().get(url);
        BrowserUtils.waitFor(3);
    }
    @When("the user logs in using {string} and {string} at staging")
    public void the_user_logs_in_using_and_at_staging(String username, String password) {
        System.out.println("This test is for the username of ===>" + username);
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }
    @Then("User is on the staging main page")
    public void user_is_on_the_staging_main_page() {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        String expectedTitle = "Portfolio";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        String expectedUrl= "https://staging-skenarios.herokuapp.com/ui";
        String currentUrl = Driver.get().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedUrl));

        BrowserUtils.waitFor(2);
        String orgNameText = new LoginPage().OrgName.getText();
        System.out.println("Organization is = " + orgNameText);
    }

}

