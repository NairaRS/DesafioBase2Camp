package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.xpath("//input[@name='username']");
    private By password = By.xpath("//input[@name='password']");
    private By lembrarLogin = By.xpath("//input[@name='perm_login']");
    private By botaoLogin = By.className("button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void preencherUsuario(String texto){
        driver.findElement(username).sendKeys(texto);
    }

    public void preencherSenha(String texto){
        driver.findElement(password).sendKeys(texto);
    }

    public void clicarLembrarLogin(){
        driver.findElement(lembrarLogin).click();
    }

    public HomePage clicarBotaoLogin(){
        driver.findElement(botaoLogin).click();
        return new HomePage(driver);
    }
}
