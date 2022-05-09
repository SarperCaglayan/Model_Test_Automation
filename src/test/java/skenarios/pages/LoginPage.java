package skenarios.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import skenarios.utilities.ConfigurationReader;
import skenarios.utilities.Driver;

import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[starts-with(@id,'nav-link')]")
    public List<WebElement> menuOptions;

    @FindBy(id = "username")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(xpath= "//input[@name='login']")
    public WebElement loginBtn;

    @FindBy(xpath= "//input[@name='login-button']")
    public WebElement loginBtnStg;

    @FindBy(xpath = "//div[@class='text_content']")
    public WebElement portfolioButton;

    @FindBy(xpath = "//a[@id='edit-form-tab-2']")
    public WebElement selectPortfolio;

    @FindBy(xpath = "//a[@id='portfolio_list2741']")
    public WebElement UtestPortfolio;

    @FindBy(xpath = "//a[@id='portfolio_list5317']")
    public WebElement AutomationPortfolio;

    @FindBy(xpath = "//a[@id='portfolio_list5247']")
    public WebElement ModelAutoPortfolio;

    @FindBy(xpath = "//a[@id='nav-link-organization-dropdown']")
    public WebElement OrgName;

    @FindBy(xpath = "//img[@src='/ui/assets/media/gb.516897fd.svg']")
    public WebElement languageButton;

    @FindBy(xpath = "//a[@id=\"nav-link-valuation\"]")
    public WebElement valuationPropertyPage;


    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    public void loginAsTester(){

        String username = ConfigurationReader.get("test_engineer_username");
        String password = ConfigurationReader.get("test_engineer_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
    public void loginAtProd(){

        String username = ConfigurationReader.get("prod_engineer_username");
        String password = ConfigurationReader.get("prod_engineer_password");

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtnStg.click();
    }

}