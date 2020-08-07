package steps;

import io.qameta.allure.Step;
import pages.MortgageReadyHousePage;

public class MortgagePageSteps extends BasePageSteps {
    @Step("Выбираем в меню: Ипотека на готовое жилье")
    public void chooseMortgageOnReadyHouse() {
        app.getMortgagePage().chooseMortgageOnReadyHouse();
    }

}
