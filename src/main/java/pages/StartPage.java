package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPage extends BasePage {
    public @FindBy(xpath = "//span[@class='lg-menu__text' and text()='Ипотека']")
    WebElement buttonMortgage;



    public MortgagePage moveToButtonMortgage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='lg-menu__text' and text()='Ипотека']")));
        moveToElement(buttonMortgage);
        return app.getMortgagePage();
    }
}
