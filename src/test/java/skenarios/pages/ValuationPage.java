package skenarios.pages;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import skenarios.utilities.Driver;

import java.io.File;
import java.io.IOException;

public class ValuationPage {
    public ValuationPage() throws IOException {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//a[@id=\"nav-link-valuation\"]")
    public WebElement valuationPropertyPage;

    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement valuationSearch;

    @FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Valuate residential property here')]")
    public WebElement validateResidentialButton;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@name='postalCode']")
    public WebElement postalCodeInput;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@id='buildYear']")
    public WebElement buildYearInput;

    @FindBy(xpath = "//input[@id='noOfFloors']")
    public WebElement floors;

    @FindBy(xpath = "//select[@id=\"buildingType\"]")
    public WebElement buildingTypeOptions;

    @FindBy(xpath = "//input[@id= 'floorArea']")
    public WebElement FloorAreaInput;

    @FindBy(xpath = "//input[@id= 'LOT_OWNED']")
    public WebElement ownLot;

    @FindBy(xpath = "//input[@id= 'NUMBER_OF_ROOMS']")
    public WebElement noOfRoomsInput;

    @FindBy(xpath = "//select[@id=\"CONDITION\"]")
    public WebElement conditionOptions;

    @FindBy(xpath = "//select[@id=\"BALCONY_TYPE\"]")
    public WebElement balconyOptions;

    @FindBy(xpath = "//select[@id=\"SAUNA\"]")
    public WebElement saunaOptions;

    @FindBy(xpath = "//select[@id=\"KITCHEN_TYPE\"]")
    public WebElement kitchenOptions;

    @FindBy(xpath = "//input[@id='floor']")
    public WebElement unitFloor;

    @FindBy(xpath = "//input[@id='maintenanceFee']")
    public WebElement maintenanceFee;

    @FindBy(xpath = "(//button[@class='btn btn-success'])[1]")
    public WebElement AddUnitButton;

    @FindBy(xpath = "//*[text()='Valuate unit']")
    public WebElement ValuateUnitButton;

    @FindBy(xpath = "(//td[contains(@test-id,'valuation_value')])[1]")
    public WebElement marketValue;

    @FindBy(xpath = "(//td[contains(@colspan,'3')])[4]")
    public WebElement marketValueM2;

    @FindBy(xpath = "//td[@test-id='estimated_value']")
    public WebElement estimatedMarketValue;

    @FindBy(xpath = "(//i[contains(@class,'fas fa-lg fa-star')])[1]")
    public WebElement rentAccuracy;

    @FindBy(xpath = "//button[contains(.,'Back to search')]")
    public WebElement backToSearchButton;

    @FindBy(xpath = "(//i[@class='fas fa-chevron-circle-right cursorPointer'])")
    public WebElement valueCursorPointer;

    @FindBy(xpath = "(//td[@class='text-left'])[2]")
    public WebElement buildingName;

    @FindBy(xpath = "(//td[contains(@class,'text-right')])[1]")
    public WebElement roomsValue;

    @FindBy(xpath = "(//td[contains(@class,'text-right')])[3]")
    public WebElement floorValue;

    @FindBy(xpath = "//input[@id='place']")
    public WebElement coordinateLink;

    @FindBy(xpath = "//button[@id='btnfind']")
    public WebElement findButton;

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    public WebElement acceptButton;
    @FindBy(xpath = "//input[@id='lat']")
    public WebElement latInput;

    @FindBy(xpath = "//input[@id='lng']")
    public WebElement lonInput;

    @FindBy(xpath = "//input[@id='address']")
    public WebElement coordinateAddress;

    @FindBy(xpath = "(//button[@class='btn btn-primary'])[1]")
    public WebElement findGPS_Button;

    @FindBy(xpath = "//input[@id=\"latitude\"]")
    public WebElement getLatitude;

    @FindBy(xpath = "//input[@id=\"longitude\"]")
    public WebElement getLongitude;
}