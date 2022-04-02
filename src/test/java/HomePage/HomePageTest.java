package HomePage;

import Base.BaseTests;
import Pages.HomePage;
import Pages.ReportPage;
import Pages.ViewIssues;
import Util.Funcoes;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class HomePageTest extends BaseTests{

    HomePage homePage;
    ReportPage reportPage;
    String id_IssueCriado;
    String categoria = "[All Projects] Teste";
    String sumario = "Teste_naira.souza";
    String descricao = "Teste rapido software";
    String submissao = "Report_Issue_Sucesso";
    String nome_projeto = "Desafio jMeter Project 1";
    ViewIssues viewIssues;

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
        homePage = loginPage.clicarBotaoLogin();
        //Conferir se usuario está logado
        assertEquals(homePage.estaLogado(), "naira.souza");
        String user = homePage.estaLogado();
        capturarTelaSimples(user);}

    @Test
    public void testeCriarIssue_IssueCriadoComSucess(){
        testeLoginComSucesso_EstaLogado();
        reportPage = homePage.reportarIssue();
        //Escolher projeto
        reportPage.escolherProjeto();
        //Selecionar projeto
        reportPage.selecionarProjeto();
        //Selecionar categoria
        reportPage.selecionarCategoria();
        //Selecionar reprodutibilidade
        reportPage.selecionarReprodutibilidade();
        //Preencher sumario
        reportPage.preencherSumario(sumario);
        //Preencher descricao
        reportPage.preencherDescricao(descricao);
        //Submeter
        reportPage.clicarBotaoSubmeter();
        String mensagem = "Operation successful.";
        id_IssueCriado = Funcoes.remove_texto(reportPage.issueReportadoComSucesso());
        System.out.print("O ID do issue criado é " + id_IssueCriado);
        String criacao = "Issue Criado";
        capturarTela(id_IssueCriado, criacao);
        Assert.assertTrue(reportPage.issueReportadoComSucesso().contains(mensagem));
    }


    @Test
    public void testePesquisarIssue_IssueEncotrado(){
        testeLoginComSucesso_EstaLogado();
        //Pesquisar issue por ID
        String id = "9375";
        homePage.pesquisarIssue(id);
        viewIssues = homePage.clicarBotaoJump();
        //Verificar ID
        Pattern p = Pattern.compile("0"+id+"$");
        Matcher m = p.matcher(viewIssues.id_Sucesso());
        Assert.assertTrue("Tem meu dígito!", m.find());
        //Verificar categoria, sumário e proejto
        String categoriaIssueEditado = "[All Projects] Desafio";
        String sumarioIssueEditado = "Teste Pesquisar e Editar Issue";
        assertEquals(viewIssues.category_Sucesso(), categoriaIssueEditado);
        Assert.assertTrue(viewIssues.summary_Sucesso().contains(sumarioIssueEditado));
        assertEquals(viewIssues.project_Sucesso(), nome_projeto);
        //Pesquisar por nome do issue
        carregarPaginaInicial();
        viewIssues = homePage.clicarViewIssues();
        viewIssues.selecionarProjetoCorreto();
        viewIssues.procurarIssue(sumarioIssueEditado);
        viewIssues.filtrarIssue();
        //Verificar nome
        assertEquals(viewIssues.localizarIssue(), sumarioIssueEditado);}

    @Test
    public void testeEditarIssue_IssueEditado(){
        testeLoginComSucesso_EstaLogado();
        //Pesquisar por id
        String id = "9375";
        homePage.pesquisarIssue(id);
        viewIssues = homePage.clicarBotaoJump();
        //Editar issue
        viewIssues.editarIssue();
        viewIssues.editarStatus();
        String status = "resolved";
        String addInfo = "Edição com sucesso.";
        String addNote = "Issue resolvido.";
        viewIssues.editarAdditionalInformation(addInfo);
        viewIssues.editarAddNote(addNote);
        viewIssues.clicarBotaoUpdateInformation();
        //Verificar edição
        String issue = "Issue resolvido";
        capturarTela(id,issue);
        assertEquals(viewIssues.obterStatusEditado(), status);
        assertEquals(viewIssues.obterAdditionalInformationEditado(), addInfo);
        assertEquals(viewIssues.obterAddNoteEditado(), addNote);}

    @Test
    public void testeExcluirIssue_IssueNaoEncontrado(){
        testeLoginComSucesso_EstaLogado();
        //Deletar um issue apenas
        //Pesquisar por id
        String id = "9374";
        homePage.pesquisarIssue(id);
        viewIssues = homePage.clicarBotaoJump();
        //Deletar issue
        viewIssues.clicarBotaoDeletarIssue();
        viewIssues.deletarIssues();
        //Pesquisar issue deletado
        homePage.pesquisarIssue(id);
        homePage.clicarBotaoJump();
        //Verificar
        String erro = "Issue deletado";
        capturarTela(id,erro);
        String issueDeletado = "not found";
        Assert.assertTrue(viewIssues.obterMensagemConfirmaçãoDelete().contains(id));
        Assert.assertTrue(viewIssues.obterMensagemConfirmaçãoDelete().contains(issueDeletado));
        //Deletar todos os issues
        /*carregarPaginaInicial();
        homePage.clicarIssuesReportados();
        viewIssues.clicarSelecionarTodos();
        viewIssues.clicarDeletarTodos();
        viewIssues.clicarBotaoOK();
        viewIssues.deletarTodosOsIssues();
        //String zeroIssues = "(0-0/0)";
        //Assert.assertTrue(mvPage.conferirIssuesDeletados().contains(zeroIssues))*/;
    }

}
