package HomePage;

import Base.BaseTests;
import Pages.HomePage;
import Pages.MyViewPage;
import Pages.ReportPage;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HomePageTest extends BaseTests {

    @Test
    public void testeLoginComSucesso_EstaLogado(){
        inicializar();
        carregarPaginaInicial();
        //Preencher usuario
        loginPage.preencherUsuario("naira.souza");
        //Preencher senha
        loginPage.preencherSenha("curran22");
        //Clicar lembrar login
        loginPage.clicarLembrarLogin();
        //Clicar botão login
        HomePage homePage = loginPage.clicarBotaoLogin();
        //Conferir se usuario está logado
        //carregarPaginaInicial();
        assertEquals(homePage.estaLogado(), "naira.souza");
        String user = homePage.estaLogado();
        capturarTela(user);

        //2º TESTE @TEST 2

        ReportPage reportPage = homePage.reportarIssue();
        //Escolher projeto
        String nome_projeto = "Desafio jMeter Project 1";
        reportPage.escolherProjeto();
        //Selecionar projeto
        reportPage.selecionarProjeto();
        //Selecionar categoria
        String categoria = "[All Projects] Teste";
        reportPage.selecionarCategoria();
        //Selecionar reprodutibilidade
        reportPage.selecionarReprodutibilidade();
        //Preencher sumario
        String sumario = "Teste_NRS2";
        reportPage.preencherSumario(sumario);
        //Preencher descricao
        String descricao = "Teste rapido software";
        reportPage.preencherDescricao(descricao);
        //Submeter
        MyViewPage mvPage = reportPage.clicarBotaoSubmeter();
        String submissao = "Report_Issue_Sucesso";
        capturarTela(submissao);
        espera();
        String mensagem = "Operation successful.";
        Assert.assertTrue(reportPage.issueReportadoComSucesso().contains(mensagem));

        //3º TESTE @TEST 3

        //Pesquisar issue

        String id = "9036";
        mvPage.pesquisarIssue(id);
        mvPage.clicarPesquisar();
        //Verificar
        assertEquals(mvPage.Category_Sucesso(), categoria);
        assertEquals(mvPage.Summary_Sucesso(), sumario);
        assertEquals(mvPage.Project_Sucesso(), nome_projeto);
    }
}
