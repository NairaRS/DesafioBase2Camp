package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By usuarioLogado = By.xpath("//*[@class='login-info-left']//span[@class='italic']");
    private By botaoReport = By.xpath("//a[contains(@href, '/bug')]");
    private By pesquisar = By.xpath("//input[@name='bug_id']");
    private By jump = By.xpath("//input[@value='Jump']");
    private By botaoViewIssue = By.xpath("//a[contains(@href, '/view_all')]");
    private By reportedIssues = By.xpath("//*[contains(text(), 'Reported by Me')]");

    public HomePage (WebDriver driver){
        this.driver = driver;
    }

    public String estaLogado(){
        return driver.findElement(usuarioLogado).getText();
    }

    public void pesquisarIssue(String texto){
        driver.findElement(pesquisar).sendKeys(texto);
    }

    /*public void clicarIssuesReportados(){
        driver.findElement(reportedIssues).click();
    }*/

    public ReportPage reportarIssue(){
        driver.findElement(botaoReport).click();
        return new ReportPage(driver);
    }

    public ViewIssues clicarBotaoJump(){
        driver.findElement(jump).click();
        return new ViewIssues(driver);
    }

    public ViewIssues clicarViewIssues(){
        driver.findElement(botaoViewIssue).click();
        return new ViewIssues(driver);
    }

    }
