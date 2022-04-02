package Steps;

import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UsarMantisStep {
    private static WebDriver driver;
    private HomePage homePage = new HomePage(driver);

    @Before
    public static void inicializar() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\naira\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //ESPERA IMPL�CITA
    }

    @BeforeEach
    public void carregarPaginaInicialStep(){
        driver.get("https://mantis-prova.base2.com.br");
        LoginPage loginPage = new LoginPage(driver);
        String user = "naira.souza";
        String password = "curran22";
        loginPage.preencherUsuario(user);
        loginPage.preencherSenha(password);
        loginPage.clicarLembrarLogin();
        loginPage.clicarBotaoLogin();
    }

}
