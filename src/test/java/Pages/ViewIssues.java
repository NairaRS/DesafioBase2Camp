package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewIssues {
    private WebDriver driver;
    private By pesquisa = By.cssSelector("#filter_open input[name='search']");
    private By filtro = By.cssSelector("#filter_open .button-small[value='Apply Filter']");
    private By localiza = By.xpath("//*[contains(text(), 'Teste_NRS')]");

    public ViewIssues(WebDriver driver){
        this.driver = driver;
    }

    public void procurarIssue(String texto){
        driver.findElement(pesquisa).sendKeys(texto);
    }

    public void filtrarIssue(){
        driver.findElement(filtro).click();
    }

    public String localizarIssue(){
        return driver.findElement(localiza).getText();
    }

}
