import managers.ManagerPages;
import org.junit.After;
import org.junit.Before;

import pages.MortgagePage;
import pages.MortgageReadyHousePage;
import steps.BaseSteps;
import steps.MortgagePageSteps;
import steps.MortgageReadyHousePageSteps;
import steps.StartPageSteps;

import java.util.HashMap;


public class AllureTest {
    protected ManagerPages app = ManagerPages.getManagerPages();
    private StartPageSteps startPageSteps = new StartPageSteps();
    private MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();
    private MortgageReadyHousePageSteps mortgageReadyHousePageSteps = new MortgageReadyHousePageSteps();
    @Before
    public void setUp() {
        BaseSteps.setUp();
    }

    @org.junit.Test
    public void testMortgage() {
        startPageSteps.moveToMortgage();

        mortgagePageSteps.chooseMortgageOnReadyHouse();

        mortgageReadyHousePageSteps.fillFields(
                new HashMap<String, String>() {{
                    put("Стоимость недвижимости", "5180000");
                    put("Первоначальный взнос", "3058000");
                    put("Срок кредита", "30");
                }}
        ).clickCheckBoxLifeInsurance().clickCheckBoxyYoungFamily()
                .checkResults(
                new HashMap<String, String>() {{
                    put("Ежемесячный платеж", "16922");
                    put("Необходимый доход", "21784");
                    put("Сумма кредита", "2122000");
                    put("Процентная ставка", "11");
                }}
        );



           }

    @After
    public void tearDown() {
        BaseSteps.tearDown();
    }
}
