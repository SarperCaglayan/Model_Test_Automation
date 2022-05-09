package skenarios.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import skenarios.utilities.Driver;

public class CREValuationPage {
    public CREValuationPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//input[@id='search-input']")
    public WebElement valuationSearch;

    @FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Valuate commercial property here')]")
    public WebElement valuateCommercialButton;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement addressInput;

    @FindBy(xpath = "//input[@name='postalCode']")
    public WebElement postalCodeInput;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityInput;

    @FindBy(xpath = "//input[@id=\"buildYear\"]")
    public WebElement buildYearInput;

    @FindBy(xpath = "//select[@id=\"usageType\"]")
    public WebElement usageTypeOptions;

    @FindBy(xpath = "//input[@id= 'floorArea']")
    public WebElement FloorAreaInput;

    @FindBy(xpath = "(//button[@class='btn btn-primary btn-update'])[1]")
    public WebElement saveButton;
    @FindBy(xpath = "(//td[contains(@test-id,'valuation_value')])[1]")
    public WebElement marketValue;

    @FindBy(xpath = "(//td[@test-id='valuation_per_sqm'])[1]")
    public WebElement marketValueM2;

    @FindBy(xpath = "(//i[@class='fas fa-lg fa-star'])[2]")
    public WebElement valueAccuracy;

    @FindBy(xpath = "(//i[@class='fas fa-lg fa-star'])[6]")
    public WebElement rentAccuracy;

    @FindBy(xpath = "//button[contains(.,'Back to search')]")
    public WebElement backToSearchButton;

    @FindBy(xpath = "(//i[@class='fas fa-chevron-circle-right cursorPointer'])")
    public WebElement valueCursorPointer;

    @FindBy(xpath = "(//td[@class='text-right'])[8]")
    public WebElement estimatedMarketValue;

    @FindBy(xpath = "(//td[@class='text-right'])[9]")
    public WebElement estimatedMarketValueM2;

    @FindBy(xpath = "(//td[contains(@colspan,'3')])[5]")
    public WebElement estOperCosts;

    @FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Value breakdown ↓')]")
    public WebElement valueBreakdownButton;

    @FindBy(xpath = "(//td[contains(.,'34 080')])[1]")
    public WebElement annualOpex;

    @FindBy(xpath = "(//button[@type='button'][contains(.,'Cancel')])[5]")
    public WebElement cancelButton;



}
