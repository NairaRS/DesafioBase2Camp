package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyViewPage {
    private WebDriver driver;
    private By pesquisar = By.xpath("//input[@name='bug_id']");
    private By jump = By.xpath("//input[@value='Jump']");
    private By id = By.xpath("//table/tbody/tr[3]/td[1]");
    private By project = By.xpath("//table/tbody/tr[3]/td[2]");
    private By category = By.xpath("//table/tbody/tr[3]/td[3]");
    private By nome = By.xpath("//table/tbody/tr[11]/td[2]");
    //private By reported = By.xpath("//*[contains(text(), 'Reported by Me')]");
    private By botaoViewIssue = By.xpath("//a[contains(@href, '/view_all')]");

    public MyViewPage(WebDriver driver){
        this.driver = driver;
        /*FluentWait wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(pesquisar));*/
    }

    public void pesquisarIssue(String texto){
        driver.findElement(pesquisar).sendKeys(texto);
    }

    public void clicarPesquisar(){
        driver.findElement(jump).click();
    }

    public String id_Sucesso(){
        return driver.findElement(id).getText();
    }

    public String summary_Sucesso(){
        return driver.findElement(nome).getText();
    }

    public String category_Sucesso(){
        return driver.findElement(category).getText();
    }

    public String project_Sucesso(){
        return driver.findElement(project).getText();
    }

    public ViewIssues clicarViewIssues(){
        driver.findElement(botaoViewIssue).click();
        return new ViewIssues(driver);
    }
}
