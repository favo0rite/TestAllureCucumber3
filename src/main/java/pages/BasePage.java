package pages;

import managers.ManagerPages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static steps.BaseSteps.getDriver;

public class BasePage {
    protected ManagerPages app = ManagerPages.getManagerPages();

    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();

    protected Actions action = new Actions(getDriver());

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);

    protected Actions actions = new Actions(getDriver());

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    protected void scrollToElementJs(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void moveToElement(WebElement element) {
        action.moveToElement(element).build().perform();
    }

    protected WebElement elementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void fillInputField(WebElement field, String value) {
        scrollToElementJs(field);
        elementToBeClickable(field).click();
        field.sendKeys(value);
    }

    public void clickElementJs(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

    public void inputField(WebElement element, String value){
        element.click();
        element.sendKeys(Keys.CONTROL, "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(value);
    }

    public void elementTextToBePresent(WebElement element, String value) {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
    }




}
