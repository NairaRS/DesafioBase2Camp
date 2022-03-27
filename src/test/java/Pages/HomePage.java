package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By usuarioLogado = By.cssSelector(".login-info-left span.italic");
    private By botaoReport = By.cssSelector(".menu a[href^='/']:nth-child(3)");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public String estaLogado(){
        return driver.findElement(usuarioLogado).getText();
    }

    public ReportPage reportarIssue(){
        driver.findElement(botaoReport).click();
        return new ReportPage(driver);
    }

}
