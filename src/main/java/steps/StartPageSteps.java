package steps;

import io.qameta.allure.Step;
import pages.MortgagePage;

public class StartPageSteps extends BasePageSteps {

    @Step("Выбран элемент меню - Ипотека")
    public void moveToMortgage() {
        app.getStartPage().moveToButtonMortgage();
    }
}
