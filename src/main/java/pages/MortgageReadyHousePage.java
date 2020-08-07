package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static steps.BaseSteps.getDriver;
import static utils.Utils.addScreenshot;

public class MortgageReadyHousePage extends BasePage {
    private @FindBy(xpath = "//div[@data-label='Стоимость недвижимости']/input[@class='dc-input__input-4-6-1']")
    WebElement priceRealtyInput;

    private @FindBy(xpath = "//iframe[@title='Основной контент']")
    WebElement frameInputs;

    private @FindBy(xpath = "//div[@data-label='Первоначальный взнос']/input")
    WebElement initialPaymentInput;

    private @FindBy(xpath = "//div[@data-label='Срок кредита']/input")
    WebElement loanPeriodInput;

    private @FindBy(xpath = "//input[@aria-checked='true' and @data-e2e-id='mland-calculator/discount-item-2-switcher']")
    WebElement lifeInsuranceCheckBox;

    private @FindBy(xpath = "//span[text()='Молодая семья']/parent::div//following-sibling::span//input")
    WebElement youngFamilyCheckBox;

    private @FindBy(xpath = "//div[contains(@class, 'resultSection')]//span[@data-e2e-id='mland-calculator/main-result-monthly-payment']//span")
    WebElement monthlyPayment;

    private @FindBy(xpath = "//div[contains(@class, 'resultSection')]//span[@data-e2e-id='mland-calculator/main-result-credit-sum']//span")
    WebElement sumCredit;

    private @FindBy(xpath = "//div[contains(@class, 'resultSection')]//span[@data-e2e-id='mland-calculator/main-result-required-income']//span")
    WebElement requiredRevenue;

    private @FindBy(xpath = "//div[contains(@class, 'resultSection')]//span[@data-e2e-id='mland-calculator/main-result-credit-rate']//span")
    WebElement interestRate;


    public void selectFrame() {
        String xpathFrame = "//iframe[@title='Основной контент']";
        WebElement frame = getDriver().findElement(By.xpath(xpathFrame));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", frame);
        getDriver().switchTo().frame(frame);
    }


    public MortgageReadyHousePage inputPriceRealty(String value) {
        scrollToElementJs(frameInputs);
        selectFrame();
        inputField(priceRealtyInput, value);
        return this;
    }

    public MortgageReadyHousePage inputInitialPayment(String value) {
        int length = initialPaymentInput.getAttribute("value").length();
        initialPaymentInput.click();
        for (int i = 0; i < length; i++){
            initialPaymentInput.sendKeys(Keys.BACK_SPACE);
        }
        initialPaymentInput.sendKeys(value);
        return this;
    }

    public MortgageReadyHousePage inputLoanPeriod(String value) {
        inputField(loanPeriodInput, value);
        return this;
    }

    public MortgageReadyHousePage clickCheckboxLifeInsurance() {
        scrollToElementJs(lifeInsuranceCheckBox);
        clickElementJs(lifeInsuranceCheckBox);
        return this;
    }

    public MortgageReadyHousePage clickCheckBoxyYoungFamily() {
        clickElementJs(youngFamilyCheckBox);
        return this;
    }

    public void assertFields(String monthlyPaymentValue, String sumCreditValue, String requiredRevenueValue) {
        scrollToElementJs(monthlyPayment);
        elementTextToBePresent(monthlyPayment, monthlyPaymentValue);
        elementTextToBePresent(sumCredit, sumCreditValue);
        elementTextToBePresent(requiredRevenue, requiredRevenueValue);




    }

    public MortgageReadyHousePage assertInterestRate(String interestRateValue){
        String interestRateString = interestRate.getText().replaceAll("%", "");
        assertEquals("Процентная ставка не совпадает", interestRateValue, interestRateString);
        addScreenshot();
        return this;
    }

    public String getResult(String resultName) {
        switch (resultName) {
            case "Ежемесячный платеж":
                return monthlyPayment.getText().replaceAll("[₽ ]", "").trim();
            case "Сумма кредита":
                return sumCredit.getText().replaceAll("[₽ ]", "").trim();
            case "Необходимый доход":
                return requiredRevenue.getText().replaceAll("[₽ ]", "").trim();
            case "Процентная ставка":
                return interestRate.getText().replaceAll("[,]", ".").replaceAll("[%]", "");
            default:
                throw new AssertionError("Результат не объявлен на странице");
        }


    }

    public void fillField(String fieldName, String value) {
        switch (fieldName) {
            case "Стоимость недвижимости":
                inputField(priceRealtyInput, value);
                break;
            case "Первоначальный взнос":
                inputField(initialPaymentInput, value);
                break;
            case "Срок кредита":
                inputField(loanPeriodInput, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public String getFillField(String fieldName) {
        switch (fieldName) {
            case "Стоимость недвижимости":
                return priceRealtyInput.getAttribute("value").replaceAll("[₽ ]", "").trim();
            case "Первоначальный взнос":
                return initialPaymentInput.getAttribute("value").replaceAll("[₽ ]", "").trim();
            case "Срок кредита":
                return loanPeriodInput.getAttribute("value").replaceAll("[₽ ]", "").trim();
            default:
                throw new AssertionError("Поле не объявлено на странице");
        }

    }





}

