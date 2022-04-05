package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ViewIssues {
    private WebDriver driver;
    private By pesquisa = By.xpath("//*[@id='filter_open']//input[@name='search']");
    private By filtro = By.xpath("//*[@id='filter_open']//input[@name='search']");
    private By localiza = By.xpath("//*[@id='buglist']");
    private By id = By.xpath("//table[3]/tbody/tr[3]/td[1]");
    //private By project = By.xpath("//td[contains(text(), 'Project 1')]");
    //private By category = By.xpath("//td[contains(text(), '[All Projects] Desafio')]");
    //private By nome = By.xpath("//table[3]//td[contains(text(), 'Teste Pesquisar')]");
    private By projetoCorreto = By.xpath("//*[@class='login-info-right']//option[@value='0']");
    private By editar = By.xpath("//input[@value='Edit']");
    private By status = By.xpath("//*[@class='row-1']//select[@tabindex='7']//option[@value='80']");
    private By addInfo = By.xpath("//textarea[@name='additional_information']");
    private By addNote = By.xpath("//textarea[@name='bugnote_text']");
    private By botaoUpdateInformation = By.xpath("//input[@value='Update Information']");
    private By addInfoEditada = By.xpath("//table/tbody/tr[13]/td[2]");
    private By addNoteEditada = By.xpath("//*[@class='bugnote-note-public']");
    private By statusEditado = By.xpath("//*[@class='row-1']/td[@bgcolor='#d2f5b0']");
    private By botaoDeletar = By.xpath("//input[@value='Delete']");
    private By botaoDeletarIssues = By.xpath("//input[@value='Delete Issues']");
    private By erro = By.xpath("//*[@class='center'][@style='color:red']");
    //private By allIssues = By.xpath("//input[@name='all_bugs']");
    //private By deleteAllIssue = By.xpath("//*[@class='left']//option[@value='DELETE']");
    //private By botaoOK = By.xpath("//input[@value='OK']");
    //private By deleteIssues = By.xpath("//input[@value='Delete Issues']");


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

    public String id_Sucesso(){
        return driver.findElement(id).getText();
    }

    /*public String summary_Sucesso(){
        return driver.findElement(nome).getText();
    }

    public String category_Sucesso(){
        return driver.findElement(category).getText();
    }

    public String project_Sucesso(){
        return driver.findElement(project).getText();
    }*/

    public void selecionarProjetoCorreto(){
        driver.findElement(projetoCorreto).click();
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

    /*public void clicarSelecionarTodos(){
        driver.findElement(allIssues).click();
    }

    public void clicarDeletarTodos(){
        driver.findElement(deleteAllIssue).click();
    }

    public void clicarBotaoOK(){
        driver.findElement(botaoOK).click();
    }

    public void deletarTodosOsIssues(){
        driver.findElement(deleteIssues).click();
    }*/

}
