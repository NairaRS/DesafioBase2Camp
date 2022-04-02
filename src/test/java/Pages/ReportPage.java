package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ReportPage {
    private WebDriver driver;
    private By projeto = By.xpath("//*[@class='row-1']//option[@value='24']");
    private By botaoSelecionar = By.xpath("//input[@value='Select Project']");
    private By categoria = By.xpath("//*[@class='row-1']//option[@value='33']");
    private By reprodutibilidade = By.xpath("//*[@class='row-2']//option[@value='50']");
    private By sumario = By.xpath("//input[@name='summary']");
    private By descricao = By.xpath("//textarea[@name='description']");
    private By botaoSubmeter = By.xpath("//input[@value='Submit Report']");
    private By issueReportado = By.xpath("//body/div[@align='center']");

    public ReportPage(WebDriver driver){
        this.driver = driver;
    }

    public void escolherProjeto(){
        driver.findElement(projeto).click();
    }

    public void selecionarProjeto(){
        driver.findElement(botaoSelecionar).click();
    }

    public void selecionarCategoria() {
        driver.findElement(categoria).click();
    }

    public void selecionarReprodutibilidade(){
        driver.findElement(reprodutibilidade).click();
    }

    public void preencherSumario(String texto){
        driver.findElement(sumario).sendKeys(texto);
    }

    public void preencherDescricao(String texto){
        driver.findElement(descricao).sendKeys(texto);
    }

    public HomePage clicarBotaoSubmeter(){
        driver.findElement(botaoSubmeter).click();
        return new HomePage(driver);
    }

    public String issueReportadoComSucesso(){
        return driver.findElement(issueReportado).getText();
    }

}
