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
    private By reportedIssues = By.xpath("//*[contains(text(), 'Reported by Me')]");
    private By botaoViewIssue = By.xpath("//a[contains(@href, '/view_all')]");
    private By editar = By.xpath("//input[@value='Edit']");
    private By status = By.cssSelector(".row-1 select[tabindex='7'] option[value='80']");
    private By addInfo = By.xpath("//textarea[@name='additional_information']");
    private By addNote = By.xpath("//textarea[@name='bugnote_text']");
    private By botaoUpdateInformation = By.cssSelector(".button[value='Update Information']");
    private By addInfoEditada = By.xpath("//table/tbody/tr[13]/td[2]");
    private By addNoteEditada = By.xpath("//*[@class='bugnote-note-public']");
    private By statusEditado = By.cssSelector(".row-1 td[bgcolor]");
    private By botaoDeletar = By.xpath("//input[@value='Delete']");
    private By botaoDeletarIssues = By.xpath("//input[@value='Delete Issues']");
    private By erro = By.cssSelector(".center[style='color:red']");
    private By allIssues = By.xpath("//input[@name='all_bugs']");
    private By deleteAllIssue = By.cssSelector(".left select option[value='DELETE']");
    private By botaoOK = By.xpath("//button[@value='OK']");
    private By zeroIssuesReportados = By.xpath("//*[contains(text(), '(0 - 0 / 0)')]");

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

    public void editarIssue(){
        driver.findElement(editar).click();
    }

    public void editarStatus(){
        driver.findElement(status).click();
    }

    public void editarAdditionalInformation(String texto){
        driver.findElement(addInfo).sendKeys(texto);
    }

    public void editarAddNote(String texto){
        driver.findElement(addNote).sendKeys(texto);
    }

    public void clicarBotaoUpdateInformation(){
        driver.findElement(botaoUpdateInformation).click();
    }

    public String obterStatusEditado(){
        return driver.findElement(statusEditado).getText();
    }

    public String obterAdditionalInformationEditado(){
        return driver.findElement(addInfoEditada).getText();
    }

    public String obterAddNoteEditado(){
        return driver.findElement(addNoteEditada).getText();
    }

    public void clicarBotaoDeletarIssue(){
        driver.findElement(botaoDeletar).click();
    }

    public void deletarIssues(){
        driver.findElement(botaoDeletarIssues).click();
    }

    public String obterMensagemConfirmaçãoDelete(){
        return driver.findElement(erro).getText();
    }

    public void clicarIssuesReportados(){
        driver.findElement(reportedIssues).click();
    }

    public void clicarSelecionarTodos(){
        driver.findElement(allIssues).click();
    }

    public void clicarDeletarTodos(){
        driver.findElement(deleteAllIssue).click();
    }

    public void clicarBotaoOK(){
        driver.findElement(botaoOK).click();
    }

    public String conferirIssuesDeletados(){
        return driver.findElement(zeroIssuesReportados).getText();
    }


}
