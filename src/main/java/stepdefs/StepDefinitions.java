package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.MortgagePageSteps;
import steps.MortgageReadyHousePageSteps;
import steps.StartPageSteps;

public class StepDefinitions {

    private StartPageSteps startPageSteps = new StartPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();
    private MortgageReadyHousePageSteps mortgageReadyHousePageSteps = new MortgageReadyHousePageSteps();

    @When("курсор наведен на элемент меню: Ипотека")
    public void moveToMortgage() {
        startPageSteps.moveToMortgage();
    }

    @Then("нажимаем на элемент меню: ипотека на готовое жилье и переходим на вкладку ипотечных условий")
    public void chooseMortgageOnReadyHouse() {
        mortgagePageSteps.chooseMortgageOnReadyHouse();
    }

    @When("заполняются поля:")
    public void fillFields(DataTable fields) {
        mortgageReadyHousePageSteps.fillFields(
                fields.asMap(String.class, String.class)
        );
    }

    @And("нажаты чекбоксы Молодая семья и страхование жизни")
    public void clickCheckBox() {
        mortgageReadyHousePageSteps.clickCheckBoxLifeInsurance();
        mortgageReadyHousePageSteps.clickCheckBoxyYoungFamily();
    }

    @And("выполнена проверка результатов:")
    public void checkResults(DataTable results) {
        mortgageReadyHousePageSteps.checkResults(
                results.asMap(String.class, String.class)
        );
    }







}
