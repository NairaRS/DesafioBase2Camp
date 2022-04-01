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
        String dataHora = homePage.diaEHora();
        System.out.print(dataHora);
        capturarTela(user, dataHora);

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
        String diaHora = reportPage.dataHora();
        capturarTela(submissao, diaHora);
        System.out.print(diaHora);
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
        capturarTelaSimples(id_IssueCriado);
        //Assert.assertTrue(mvPage.id_Sucesso().contains(id_IssueCriado));
        //assertEquals(mvPage.id_Sucesso(), id_IssueCriado);
        Pattern p = Pattern.compile("0"+id_IssueCriado+"$");
        Matcher m = p.matcher(mvPage.id_Sucesso());
        Assert.assertTrue("Tem meu dígito!", m.find());;
        assertEquals(mvPage.category_Sucesso(), categoria);
        Assert.assertTrue(mvPage.summary_Sucesso().contains(sumario));
        assertEquals(mvPage.project_Sucesso(), nome_projeto);
        //Pesquisar por outros filtros
        carregarPaginaInicial();
        ViewIssues viewIssues = mvPage.clicarViewIssues();
        viewIssues.procurarIssue("Teste_NRS");
        viewIssues.filtrarIssue();
        capturarTelaSimples(sumario);
        assertEquals(viewIssues.localizarIssue(), sumario);

        //4º Teste = Editar Issue
        carregarPaginaInicial();
        mvPage.pesquisarIssue(id_IssueCriado);
        mvPage.clicarPesquisar();
        mvPage.editarIssue();
        mvPage.editarStatus();
        String status = "resolved";
        String addInfo = "Edição com sucesso.";
        String addNote = "Issue resolvido.";
        mvPage.editarAdditionalInformation(addInfo);
        mvPage.editarAddNote(addNote);
        mvPage.clicarBotaoUpdateInformation();
        assertEquals(mvPage.obterStatusEditado(), status);
        assertEquals(mvPage.obterAdditionalInformationEditado(), addInfo);
        assertEquals(mvPage.obterAddNoteEditado(), addNote);
        carregarPaginaInicial();
        String issue = "Issue resolvido";
        capturarTelaSimples(issue);

        //5º Teste = Deletar Issue
        //Deletar um issue apenas
        carregarPaginaInicial();
        mvPage.pesquisarIssue(id_IssueCriado);
        mvPage.clicarPesquisar();
        mvPage.clicarBotaoDeletarIssue();
        mvPage.deletarIssues();
        mvPage.pesquisarIssue(id_IssueCriado);
        mvPage.clicarPesquisar();
        String erro = "Issue deletado";
        capturarTelaSimples(erro);
        String issueDeletado = "not found";
        Assert.assertTrue(mvPage.obterMensagemConfirmaçãoDelete().contains(id_IssueCriado));
        Assert.assertTrue(mvPage.obterMensagemConfirmaçãoDelete().contains(issueDeletado));
        //Deletar todos os issues
        carregarPaginaInicial();
        mvPage.clicarIssuesReportados();
        mvPage.clicarSelecionarTodos();
        mvPage.clicarDeletarTodos();
        mvPage.clicarBotaoOK();
        mvPage.deletarIssues();
        carregarPaginaInicial();
        String reportados = "Zero Issues";
        capturarTelaSimples(reportados);
        mvPage.clicarIssuesReportados();
        String zeroIssues = "(0 - 0 / 0)";
        Assert.assertTrue(mvPage.conferirIssuesDeletados().contains(zeroIssues));
    }

}
