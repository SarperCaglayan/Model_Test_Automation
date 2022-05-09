package skenarios.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import skenarios.utilities.BrowserUtils;
import skenarios.utilities.Driver;

public class PropertiesPage {

    public PropertiesPage() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "a[id='nav-link-properties']")
    public WebElement propertiesPage;

    @FindBy(xpath = "(//a[@href=\"/ui/group/163138\"])[1]")
    public WebElement selectGroup;

    @FindBy(id = "pills-unit-tab")
    public WebElement selectUnit;

    @FindBy(css = "i[type='button']")
    public WebElement openAddUnitButton;

    @FindBy(id = "key")
    public WebElement UnitIdInput;

    @FindBy(xpath = "(//input[@id='name'])[2]")
    public WebElement UnitNameInput;

    @FindBy(id="floorArea")
    public WebElement floorAreaInput;

    @FindBy(xpath = "//select[@id='usageType']")
    public WebElement usageTypeOptions;

    @FindBy(xpath = "//select[@id='propertyBuildingId']")
    public WebElement buildingOptions;

    @FindBy(xpath = "//select[@id='INTENDED_USAGE_L3']")
    public WebElement buildingUsageType;

    @FindBy(xpath = "//button[@class='btn btn-primary' and text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[@class='btn btn-primary'][contains(.,'Confirm')]")
    public WebElement confirmButton;

    @FindBy(xpath = "//span[@test-id='close-unit-modal']")
    public WebElement exitUnitButton;

    @FindBy(xpath = "//div[contains(text(),'Unit added')]")
    public WebElement unitAddedMessage;

    //After adding a unit to check if it has been created open the created unit
    @FindBy(xpath = "//*[text()='AutomatedUnit123345']")
    public WebElement OpenUnit;

    @FindBy(xpath = "//span[contains(text(),'AutomatedUnit123345')]")
    public WebElement unitId;

    @FindBy(xpath = "//span[contains(text(),'110')]")
    public WebElement unitFloorArea;

    @FindBy(xpath = "//i[@test-id='delete_unit']")
    public WebElement deleteUnitButton;

    @FindBy(xpath = "(//button[@class=\"btn btn-danger\"])[3]")
    public WebElement removeUnitButton;

    @FindBy(xpath = "//div[contains(text(),'This property group has no attached property units')]")
    public WebElement hasNoUnitMessage;


    public void moveToProperties() {
        // Driver.get().navigate().to("https://app.skenarios.com/ui/properties/");
        BrowserUtils.waitFor(5);
        WebDriver driver= new EdgeDriver();
        Actions actions= new Actions(driver);
        propertiesPage.click();
    }
}

