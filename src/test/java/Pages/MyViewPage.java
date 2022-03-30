package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MyViewPage {
    private WebDriver driver;
    private By pesquisar = By.xpath("//input[@name='bug_id']");
    private By jump = By.xpath("//input[@value='Jump']");
    private By project = By.xpath("//table/tbody/tr[3]/td[2]");
    private By category = By.xpath("//table/tbody/tr[3]/td[3]");
    private By nome = By.xpath("//table/tbody/tr[11]/td[2]");

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

    public String Summary_Sucesso(){
        return driver.findElement(nome).getText();
    }

    public String Category_Sucesso(){
        return driver.findElement(category).getText();
    }

    public String Project_Sucesso(){
        return driver.findElement(project).getText();
    }
}
