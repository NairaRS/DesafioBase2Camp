package Base;

import Pages.LoginPage;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


public class BaseTests{
    private static WebDriver driver;
    protected static LoginPage loginPage;

    @BeforeClass
    public static void inicializar(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/target/drivers/chromedriver.exe");;
        driver = new ChromeDriver();
    }

    @Before
    public void carregarPaginaInicial(){
        driver.get("https://mantis-prova.base2.com.br");
        loginPage = new LoginPage(driver);
    }

    public void capturarTelaSimples(String nomeTeste) {
        File capturaDeTelaSimples = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.move(capturaDeTelaSimples, new File(System.getProperty("user.dir") + "/target/screenshots/" + nomeTeste + ".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void capturarTela(String nomeTeste, String texto) {
        File capturaDeTela = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.move(capturaDeTela, new File(System.getProperty("user.dir") + "/target/screenshots/" + nomeTeste + "_" + texto + ".png"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void stepLogin(){
            String user = "naira.souza";
            String password = "curran22";
            loginPage.preencherUsuario(user);
            loginPage.preencherSenha(password);
            loginPage.clicarLembrarLogin();
    }

    @AfterClass
    public static void finalizar(){
        driver.quit();
    }
}
