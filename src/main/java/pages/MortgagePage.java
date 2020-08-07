package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MortgagePage extends BasePage {
    private @FindBy(xpath = "//div[@class='kit-col kit-col_lg_5 lg-menu__col']//a[text()='Ипотека на готовое жильё']")
    WebElement mortgageOnReadyHouse;

    public MortgageReadyHousePage chooseMortgageOnReadyHouse() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='kit-col kit-col_lg_5 lg-menu__col']//a[text()='Ипотека на готовое жильё']")));
        moveToElement(mortgageOnReadyHouse);
        mortgageOnReadyHouse.click();
        return app.getMortgageReadyHousePage();
    }
}
