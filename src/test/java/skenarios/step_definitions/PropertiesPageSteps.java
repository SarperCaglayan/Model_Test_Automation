package skenarios.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import skenarios.pages.LoginPage;
import skenarios.pages.PropertiesPage;
import skenarios.utilities.BrowserUtils;
import skenarios.utilities.ConfigurationReader;
import skenarios.utilities.Driver;

public class PropertiesPageSteps {
    PropertiesPage propertiesPage= new PropertiesPage();

    @When("User navigates to the {string} page")
    public void user_navigates_to_the_page(String string) {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitFor(2);
        loginPage.languageButton.click();
        //BrowserUtils.waitFor(2);
        loginPage.loginAsTester();
        System.out.println("User logged in as tester");
        BrowserUtils.waitForVisibility(loginPage.portfolioButton,3);


        loginPage.portfolioButton.click();
        System.out.println("User selects the portfolio");

        BrowserUtils.waitFor(1);
        loginPage.selectPortfolio.click();
        BrowserUtils.waitFor(1);
        loginPage.AutomationPortfolio.click();

        Driver.get().navigate().to(ConfigurationReader.get("testPropertiesUrl"));
        BrowserUtils.waitFor(2);



    }
    @When("Selects a group from the group list")
    public void selects_a_group_from_the_group_list() {
        PropertiesPage propertiesPage= new PropertiesPage();
        BrowserUtils.waitFor(3);
        propertiesPage.selectGroup.click();

        //String groupTitle = Driver.get().getTitle();
        //Assert.assertTrue(groupTitle.contains("Group"));
    }
    @When("Open adding unit popup and set the details")
    public void open_adding_unit_popup_and_set_the_details() {
        PropertiesPage propertiesPage= new PropertiesPage();
        BrowserUtils.waitForVisibility(propertiesPage.selectUnit,3);

        propertiesPage.selectUnit.click();
        propertiesPage.openAddUnitButton.click();

        BrowserUtils.waitForVisibility(propertiesPage.UnitIdInput,2);
        propertiesPage.UnitIdInput.sendKeys("AutomatedUnit123345");
        //BrowserUtils.waitFor(1);
        propertiesPage.UnitNameInput.sendKeys("Eteläkatu 1 A 111 Test Unit");
        //BrowserUtils.waitFor(1);
        propertiesPage.floorAreaInput.sendKeys("110");

        Select select = new Select(propertiesPage.usageTypeOptions);
        BrowserUtils.waitFor(1);
        //select.selectByVisibleText("Residential");
        select.selectByIndex(1);

        Select select2 = new Select(propertiesPage.buildingOptions);
        //BrowserUtils.waitFor(2);
        select2.selectByIndex(1);

        Select select3 = new Select(propertiesPage.buildingUsageType);
        select3.selectByIndex(5);
        BrowserUtils.waitFor(2);
        propertiesPage.saveButton.click();

        BrowserUtils.waitFor(2);
     /*   propertiesPage.confirmButton.click();
        BrowserUtils.waitForVisibility(propertiesPage.unitAddedMessage,3);
    */

    }
    @Then("User is able to add a new unit")
    public void user_is_able_to_add_a_new_unit() {

        WebElement unitAddedMessage = propertiesPage.unitAddedMessage;
        Assert.assertTrue(unitAddedMessage.isDisplayed());

        propertiesPage.exitUnitButton.click();
        BrowserUtils.waitFor(2);
        propertiesPage.OpenUnit.click();
        BrowserUtils.waitForVisibility(propertiesPage.unitId,3);

        String unitId = propertiesPage.unitId.getText();
        String unitFloorArea = propertiesPage.unitFloorArea.getText();
        Assert.assertEquals("Unit name is not as expected!", "AutomatedUnit123345", unitId);
        Assert.assertEquals("Unit floor area is not true! ","110",unitFloorArea);

        System.out.println("User successfully adds a new unit");
        System.out.println("**********************************");
    }
    @When("Select a unit from the list and delete")
    public void select_a_unit_from_the_list_and_delete() {
        PropertiesPage propertiesPage= new PropertiesPage();
        BrowserUtils.waitFor(3);
        propertiesPage.selectUnit.click();

        System.out.println("User selects a unit and clicks delete and remote buttons");
    }
    @Then("User is able to delete a unit")
    public void user_is_able_to_delete_a_unit() {
        BrowserUtils.waitForVisibility(propertiesPage.deleteUnitButton,2);
        PropertiesPage propertiesPage= new PropertiesPage();
        propertiesPage.deleteUnitButton.click();
        BrowserUtils.waitFor(2);
        propertiesPage.removeUnitButton.click();

        BrowserUtils.waitFor(2);
        Assert.assertTrue(propertiesPage.hasNoUnitMessage.isDisplayed());

        System.out.println("User is successfully able to delete the unit");
        System.out.println("Test is PASSED!!!");
    }
}
