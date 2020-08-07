import managers.ManagerPages;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;
import pages.MortgagePage;
import pages.MortgageReadyHousePage;
import steps.BaseSteps;
import steps.MortgagePageSteps;
import steps.MortgageReadyHousePageSteps;
import steps.StartPageSteps;

import java.util.HashMap;


public class AllureTest {



    @Before
    public void setUp() {
        BaseSteps.setUp();
    }

    @Test
    public void testMortgage() {
        StartPageSteps startPageSteps = new StartPageSteps();
        MortgagePageSteps mortgagePageSteps = new MortgagePageSteps();
        MortgageReadyHousePageSteps mortgageReadyHousePageSteps = new MortgageReadyHousePageSteps();
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
