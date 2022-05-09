package skenarios.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import skenarios.pages.LoginPage;
import skenarios.pages.ValuationPage;
import skenarios.utilities.BrowserUtils;
import skenarios.utilities.ConfigurationReader;
import skenarios.utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;

public class ValuationPageSteps {

    ValuationPage valuationPage = new ValuationPage();
    String path = "C:\\Users\\u_arg\\Downloads\\Comparable_import_2.xlsx";
    Workbook workbook = WorkbookFactory.create(new File(path));
    Sheet sheet = workbook.getSheet("Buildings");
    Sheet sheet2 = workbook.getSheet("Units");

    Faker faker= new Faker();
    Integer nextInt = faker.random().nextInt(1, 251);

    //Building parameters
    Row row0 = sheet.getRow(1);
    Cell country = row0.getCell(0);
    Cell cityCell = row0.getCell(1);
    String cityStringCellValue = cityCell.getStringCellValue();
    Cell addressCellValue = row0.getCell(2);
    String stringCellAddress = addressCellValue.getStringCellValue();
    Cell postCodeXlsx = row0.getCell(3);
    String stringCellPostCode = postCodeXlsx.getStringCellValue();
    int postalCodeXlsx = Integer.parseInt(stringCellPostCode);
    Cell buildYearXlsx = row0.getCell(4);
    int buildYearXlsxNumericCellValue = (int) buildYearXlsx.getNumericCellValue();

    Cell buildingTypeXlsx = row0.getCell(5);
    String buildingTypeXlsxStringCellValue = buildingTypeXlsx.getStringCellValue();
    String buildingTypewithLowerCase = buildingTypeXlsxStringCellValue.toLowerCase();
    Cell buildingIdXlsx = row0.getCell(6);
    Cell groupIdXlsx = row0.getCell(7);
    Cell floorsXlsx = row0.getCell(8);
    Cell ownLotXlsx = row0.getCell(9);
    String stringCellValue = ownLotXlsx.getStringCellValue();
    boolean ownLot = Boolean.parseBoolean(stringCellValue);

    //Unit parameters
    Row row2 = sheet2.getRow(1);
    Cell unitIdXlsx = row2.getCell(1);
    Cell floorAreaXlsx = row2.getCell(2);
    double floorAreaXlsxNumericCellValue = floorAreaXlsx.getNumericCellValue();
    Cell roomsXlsx = row2.getCell(3);
    int numericRoomsValue = (int) roomsXlsx.getNumericCellValue();
    Cell unitFloorXlsx = row2.getCell(4);
    int numericFloorValue = (int) unitFloorXlsx.getNumericCellValue();

    Cell conditionXlsx = row2.getCell(5);
    String conditionX = conditionXlsx.getStringCellValue();
    Cell balconyXlsx = row2.getCell(6);
    String stringBalconyValue = balconyXlsx.getStringCellValue();
    Cell kitchenXlsx = row2.getCell(7);
    String kitchenXlsxStringCellValue = kitchenXlsx.getStringCellValue();
    Cell saunaXlsx = row2.getCell(8);
    Cell maintenanceXlsx = row2.getCell(9);
    double maintenanceXlsxNumericCellValue = maintenanceXlsx.getNumericCellValue();


    String address = "";
    String postalcode= "01390";
    String city= "Vantaa";
    String buildYear= "2022";
    String floorArea= "63";
    String noOfRooms= "3";
    String noOfFloors= "1";
    Boolean lotOwned = false;
    String condition= "New";

    public ValuationPageSteps() throws IOException {
    }


    public void Setup() throws IOException {


     LinkedHashMap<String, Object> data =new LinkedHashMap<String,Object>();
        data.put("lat", 64.11);
        data.put("lon", 23.55);
        data.put("balcony_type", stringBalconyValue);
        data.put("floor_num", numericFloorValue);
        data.put("condition", conditionX);
        data.put("number_of_rooms", numericRoomsValue);
        data.put("municipality", cityStringCellValue);
        data.put("postcode", postalCodeXlsx);
        data.put("property_type", buildingTypewithLowerCase);
        data.put("floor_area", floorAreaXlsxNumericCellValue);
        data.put("build_year", buildYearXlsxNumericCellValue);
        data.put("lift", true);
        data.put("maintainance_fee_sqm", maintenanceXlsxNumericCellValue);
        data.put("netInternalArea", 78.0);
        data.put("kitchen_type", kitchenXlsxStringCellValue);
        data.put("lot_owned", ownLot);
    }



    @Given("User is on the portfolio page")
    public void user_is_on_the_portfolio_page() {
        BrowserUtils.waitFor(3);
        String url = ConfigurationReader.get("url");
        Driver.get().get(url);

        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitFor(5);
        loginPage.login(ConfigurationReader.get("prod_engineer_username"),ConfigurationReader.get("prod_engineer_password"));

        System.out.println("User logged in as tester");
        BrowserUtils.waitFor(5);

        loginPage.portfolioButton.click();
        System.out.println("User selects the portfolio");

        BrowserUtils.waitFor(2);
        loginPage.selectPortfolio.click();
        BrowserUtils.waitFor(2);
        loginPage.ModelAutoPortfolio.click();

    }

    @When("the User navigates to the Property Valuation page")
    public void the_user_navigates_to_the_property_valuation_page() {
        BrowserUtils.waitFor(3);
        String valuation = ConfigurationReader.get("valuationUrl");
        Driver.get().get(valuation);
        BrowserUtils.waitFor(3);
    }

    @When("Set the details of property and valuate unit")
    public void set_the_details_of_property_and_valuate_unit() {
        System.out.println("stringCellAddress = " + stringCellAddress);
        valuationPage.valuationSearch.sendKeys(stringCellAddress);
        BrowserUtils.waitFor(6);
        //valuationPage.AddUnitButton.click();
        valuationPage.validateResidentialButton.click();
        BrowserUtils.waitFor(4);
        valuationPage.addressInput.sendKeys(stringCellAddress);
        System.out.println("stringCellPostCode = " + stringCellPostCode);
        valuationPage.postalCodeInput.sendKeys(stringCellPostCode);
        System.out.println("cityStringCellValue = " + cityStringCellValue);
        valuationPage.cityInput.sendKeys(cityStringCellValue);
        System.out.println("buildingTypeXlsxStringCellValue = " + buildingTypeXlsxStringCellValue);
        Select select = new Select(valuationPage.buildingTypeOptions);
        select.selectByVisibleText(buildingTypeXlsxStringCellValue);
        String buildYearStr = Integer.toString(buildYearXlsxNumericCellValue);
        System.out.println("buildYearStr = " + buildYearStr);
        valuationPage.buildYearInput.sendKeys(buildYearStr);
        BrowserUtils.waitFor(2);
        double floorAreaXlsxNumericCellValue = floorAreaXlsx.getNumericCellValue();
        int floorAreaXlsxNumericCellValue1 = (int) floorAreaXlsxNumericCellValue;
        String floorAreaString = Integer.toString(floorAreaXlsxNumericCellValue1);
        System.out.println("floorAreaString = " + floorAreaString);
        valuationPage.FloorAreaInput.sendKeys(floorAreaString);
        int numericRoomsValue = (int) roomsXlsx.getNumericCellValue();
        String roomsValueString = Integer.toString(numericRoomsValue);
        //String roomsString = roomsXlsx.getStringCellValue();
        BrowserUtils.waitFor(2);
        System.out.println("roomsValueString = " + roomsValueString);
        valuationPage.noOfRoomsInput.sendKeys(roomsValueString);
        BrowserUtils.waitFor(2);
        Select select1 = new Select(valuationPage.conditionOptions);
        System.out.println("conditionX = " + conditionX);
        select.selectByVisibleText(conditionX);
        String floorsString = Integer.toString(numericFloorValue);
        System.out.println("floorAreaString = " + floorAreaString);
        valuationPage.floors.sendKeys(floorsString);

        String stringCellValue = ownLotXlsx.getStringCellValue();
        boolean ownLot = Boolean.parseBoolean(stringCellValue);
        System.out.println("ownLot = " + ownLot);
        if (ownLot){
            valuationPage.ownLot.click();
        }

        BrowserUtils.waitFor(2);
        valuationPage.ValuateUnitButton.click();
        BrowserUtils.waitForVisibility(valuationPage.marketValue, 30);
    }

    @Then("User should be able to see valuation results")
    public void user_should_be_able_to_see_valuation_results() {
        String marketValueText = valuationPage.marketValue.getText();
        System.out.println("Market value = " + marketValueText);

        String valueM2Text = valuationPage.marketValueM2.getText();
        System.out.println("Market value (m2) = " + valueM2Text);
        //String accuracyText = valuationPage.valueAccuracy.getText();
        //System.out.println("accuracyText = " + accuracyText);

        System.out.println("User is able to see the valuation results for a residential property");

    }

    @And("User should be able to see the saved results")
    public void userShouldBeAbleToSeeTheSavedResults() {
        BrowserUtils.waitFor(3);
        //String valuation = ConfigurationReader.get("propertyValuationPage");
        //Driver.get().get(valuation);
        valuationPage.backToSearchButton.click();
        BrowserUtils.waitFor(3);

        valuationPage.valueCursorPointer.click();
        BrowserUtils.waitFor(2);
        String buildingNameText = valuationPage.buildingName.getText();
        System.out.println("building name = " + buildingNameText);
        String roomsValueText = valuationPage.roomsValue.getText();
        System.out.println("number of rooms = " + roomsValueText);
        String floorValueText = valuationPage.floorValue.getText();
        System.out.println("number of floors= " + floorValueText);

        String marketValueText = valuationPage.estimatedMarketValue.getText();
        System.out.println("marketValue = " + marketValueText);
        //Assert.assertEquals(marketValueText, "82000");

        Assert.assertEquals("Number of rooms doesn't match!", roomsValueText, noOfRooms );
        Assert.assertEquals("verify that floor area matches!", floorValueText, floorArea);

        System.out.println("User is able to see that the valuation results for a residential property has saved");
    }
}
