package steps;

import io.qameta.allure.Step;
import pages.BasePage;
import pages.MortgageReadyHousePage;
import utils.Utils;

import java.util.Map;

import static org.junit.Assert.assertTrue;

public class MortgageReadyHousePageSteps extends BaseSteps {

    @Step("поле {fieldName} заполняется значением {value}")
    private void fillField(String fieldName, String value) {
        app.getMortgageReadyHousePage().fillField(fieldName, value);
    }

    @Step("Вводим стоимость недвижимости")
    public void inputPriceRealty(String priceRealty) {
        app.getMortgageReadyHousePage().inputPriceRealty(priceRealty);
    }

    @Step("Вводим первоначальный взнос")
    public void inputInitialPayment(String initialPayment) {
        app.getMortgageReadyHousePage().inputInitialPayment(initialPayment);
    }

    @Step("Вводим срок кредита")
    public void inputLoanPeriod(String loanPeriod) {
        app.getMortgageReadyHousePage().inputLoanPeriod(loanPeriod);
    }

    @Step("заполняются поля:")
    public MortgageReadyHousePageSteps fillFields(Map<String, String> fields) {
        app.getMortgageReadyHousePage().selectFrame();
        fields.forEach(this::fillField);
        return this;
    }

    @Step("Нажимаем на чекбокс: Страхование жизни")
    public MortgageReadyHousePageSteps clickCheckBoxLifeInsurance() {
        app.getMortgageReadyHousePage().clickCheckboxLifeInsurance();
        return this;
    }

    @Step("Нажимаем на чекбокс: Молодая семья")
    public MortgageReadyHousePageSteps clickCheckBoxyYoungFamily() {
        app.getMortgageReadyHousePage().clickCheckBoxyYoungFamily();
        return this;
    }

    @Step("Проверяем поля: ежемесяный платеж, сумма кредита, ежемесячный доход, процентная ставка")
    public void assertFields(String monthlyPaymentValue, String sumCreditValue, String requiredRevenueValue) {
        app.getMortgageReadyHousePage().assertFields(monthlyPaymentValue, sumCreditValue, requiredRevenueValue);
    }





    @Step("выполнена проверка заполнения полей:")
    public MortgageReadyHousePageSteps checkFillFields(Map<String, String> fields){
        fields.forEach(this::checkFillField);
        return this;
    }

    @Step("поле {fieldName} заполнено значением {value}")
    private void checkFillField(String fieldName, String value) {
        String actual = app.getMortgageReadyHousePage().getFillField(fieldName);
        assertTrue(
                String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", fieldName, actual, value),
                actual.equals(value)
        );
    }

    @Step("выполнена проверка результатов:")
    public MortgageReadyHousePageSteps checkResults(Map<String, String> results) {
        results.forEach(this::checkResult);
        return this;
    }

    @Step("результат {resultName} заполнен значением {value}")
    private void checkResult(String resultName, String value) {
        app.getMortgageReadyHousePage().assertFields("16 922 ₽", "2 122 000 ₽", "21 784 ₽");
        String actual = app.getMortgageReadyHousePage().getResult(resultName);
        assertTrue(
                String.format("Значение результата [%s] равно [%s]. Ожидалось - [%s]", resultName, actual, value.replaceAll("[₽ ]", "").trim()),
                actual.equals(value)
        );
        Utils.addScreenshot();
    }

}
