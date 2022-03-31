package HomePage;

import Base.BaseTests;
import Pages.HomePage;
import Pages.MyViewPage;
import Pages.ReportPage;
import Pages.ViewIssues;
import Util.Funcoes;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class HomePageTest extends BaseTests {

    @Test
    public void testeLoginComSucesso_EstaLogado() {
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

        //2º Teste = Criar Issue

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
        String sumario = "Teste_NRS";
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
        String id_IssueCriado = Funcoes.remove_texto(reportPage.issueReportadoComSucesso());
        System.out.print(id_IssueCriado);
        Assert.assertTrue(reportPage.issueReportadoComSucesso().contains(mensagem));

        //3º Teste = Pesquisar Issue

        //Pesquisar issue por ID
        //String id = "9036";
        carregarPaginaInicial();
        mvPage.pesquisarIssue(id_IssueCriado);
        mvPage.clicarPesquisar();
        //Verificar
        Assert.assertTrue(mvPage.id_Sucesso().contains(id_IssueCriado));
        //assertEquals(mvPage.id_Sucesso(), id_IssueCriado);
        assertEquals(mvPage.category_Sucesso(), categoria);
        Assert.assertTrue(mvPage.summary_Sucesso().contains(sumario));
        assertEquals(mvPage.project_Sucesso(), nome_projeto);
        //Pesquisar por outros filtros
        carregarPaginaInicial();
        ViewIssues viewIssues = mvPage.clicarViewIssues();
        viewIssues.procurarIssue("Teste_NRS");
        viewIssues.filtrarIssue();
        assertEquals(viewIssues.localizarIssue(), sumario);
    }

}
