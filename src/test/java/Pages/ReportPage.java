package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ReportPage {
    private WebDriver driver;
    private By projeto = By.cssSelector(".row-1 select option[value='24']");
    private By botaoSelecionar = By.className("button");
    private By categoria = By.cssSelector(".row-1 select option[value='33']");
    private By reprodutibilidade = By.cssSelector(".row-2 select option[value='50']");
    private By sumario = By.xpath("//input[@name='summary']");
    private By descricao = By.xpath("//textarea[@name='description']");
    private By botaoSubmeter = By.className("button");
    private By issueReportado = By.xpath("//body/div[@align='center']");
    private By diaHora = By.cssSelector(".login-info-middle span[class='italic']");

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

    public MyViewPage clicarBotaoSubmeter(){
        driver.findElement(botaoSubmeter).click();
        return new MyViewPage(driver);
    }

    public String issueReportadoComSucesso(){
        return driver.findElement(issueReportado).getText();
    }

    public String dataHora(){ return driver.findElement(diaHora).getText();}

    public void carregarPaginaInicial() {
        driver.get("https://mantis-prova.base2.com.br/my_view_page.php");
    }

}
