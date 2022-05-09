package skenarios.step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import skenarios.pages.CREValuationPage;
import skenarios.utilities.BrowserUtils;

public class CRE_ValuationPageSteps {

        CREValuationPage CRE_valuationPage = new CREValuationPage();
        String address = "Puustellinrinne 2";
        String postCode = "00410";
        String city = "Helsinki";
        String buildYear = "2006";
        String usableFloor = "1000";

    @When("Set the details of commercial property and valuate unit")
    public void set_the_details_of_commercial_property_and_valuate_unit() {
        CRE_valuationPage.valuationSearch.sendKeys(address);
        BrowserUtils.waitForVisibility(CRE_valuationPage.valuateCommercialButton,4);
        CRE_valuationPage.valuateCommercialButton.click();
        BrowserUtils.waitFor(2);
        CRE_valuationPage.addressInput.sendKeys(address);
        CRE_valuationPage.postalCodeInput.sendKeys(postCode);
        CRE_valuationPage.cityInput.sendKeys(city);
        Select select = new Select(CRE_valuationPage.usageTypeOptions);
        select.selectByVisibleText("Office");
        CRE_valuationPage.buildYearInput.sendKeys(buildYear);
        CRE_valuationPage.FloorAreaInput.sendKeys(usableFloor);
        BrowserUtils.waitFor(2);
        CRE_valuationPage.saveButton.click();
        BrowserUtils.waitForVisibility(CRE_valuationPage.marketValue, 20);

    }

    @Then("User should be able to see CRE valuation results")
    public void user_should_be_able_to_see_cre_valuation_results() {
        String valueM2 = CRE_valuationPage.marketValueM2.getText();
        System.out.println("valueM2Text = " + valueM2);
        Assert.assertEquals(valueM2,"1085");

        String marketValueText = CRE_valuationPage.marketValue.getText();
        System.out.println("marketValue = " + marketValueText);
        Assert.assertEquals(marketValueText, "1085000");

        String estOperCosts = CRE_valuationPage.estOperCosts.getText();
        System.out.println("estimated operating costs = " + estOperCosts);
        //Assert.assertEquals(estOperCosts, 232.5);

        CRE_valuationPage.valueBreakdownButton.click();
        BrowserUtils.waitForVisibility(CRE_valuationPage.annualOpex,3);

        String annualOpexText = CRE_valuationPage.annualOpex.getText();
        System.out.println("annualOpexText = " + annualOpexText);

        CRE_valuationPage.cancelButton.click();
    }

    @Then("User should be able to see the saved CRE results")
    public void user_should_be_able_to_see_the_saved_cre_results() {
        BrowserUtils.waitForVisibility(CRE_valuationPage.backToSearchButton,2);

        CRE_valuationPage.backToSearchButton.click();
        BrowserUtils.waitFor(3);

        CRE_valuationPage.valueCursorPointer.click();
        BrowserUtils.waitFor(2);

        String estimatedMarketValueText = CRE_valuationPage.estimatedMarketValue.getText();
        System.out.println("estimatedMarketValue = " + estimatedMarketValueText);

        String estimatedMarketValueM2Text = CRE_valuationPage.estimatedMarketValueM2.getText();
        System.out.println("estimatedMarketValueM2 = " + estimatedMarketValueM2Text);

    }
}
