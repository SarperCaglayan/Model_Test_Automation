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


    //select[@id="CONDITION"]
}