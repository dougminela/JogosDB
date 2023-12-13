import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nomeTabela, nomeColuna;
        int opcao = 0;

        /* LoginBD.FazerLoginBD(); */

        while (opcao != 13) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Incluir jogo/desenvolvedor"); // 1.Incluir dado
            System.out.println("2 - Alerar dados por ID do jogo"); // 2.Alterar dados por um campo numérico (chave
                                                                   // primária)
            System.out.println("3 - Alterar dados pelo nome do jogo"); // 3.Alterar dados por um campo string
            System.out.println("4 - Excluir dados pelo ID do jogo"); // 4.Excluir dados por um campo numérico
            System.out.println("5 - Excluir dados pelo nome do jogo"); // 5.Excluir dados por um campo string
            System.out.println("6 - Listar os jogos cadastrados"); // 6.Listar os dados cadastrados
            System.out.println("7 - Listar os jogos em ordem crescente (ano)"); // 7.Listar os dados cadastrados em uma
                                                                                // ordem específica
            System.out.println("8 - Listar jogos por plataforma"); // 8.Listar os dados cadastrados com algum critério a
                                                                   // ser apresentado pelo programador
            System.out.println("9 - Listar dados com INNER JOIN"); // 9.Listar dados com Inner Join
            System.out.println("10 - Mostrar soma total de jogos"); // 10.Mostrar soma total de dados numéricos
            System.out.println("11 - Listar media de ANO dos jogos"); // 11.Apresentar a média de dados numéricos
            System.out.println("12 - Listar jogos com plataformas"); // 12.Listar com agrupamento (conforme trabalho
                                                                     // realizado em grupo)
            System.out.println("13 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    InserirDados.criar();
                    return;
                case 2:
                    AlterarDadosPorId.alterarDadosPorId();
                    return;
                case 3:
                    AlterarDadosPorNome.alterarDadosPorNome();
                    return;
                case 4:
                    ExcluirDadosPorID.ExcluirDadosPorid1();
                    return;
                case 5:
                    ExcluirDadosPorNome.excluirDadosPorNome();
                    return;
                case 6:
                    ListarDados.listarJogos();
                    return;
                case 7:
                    ListarDadosOrdemCrescente.listarJogosEmOrdemCrescente();
                    return;
                case 8:
                    ListagemComAgrupamento.listarJogosPorDesenvolvedor();
                    return;
                case 9:
                    ListarDadosComInnerJoin.listarJogosComDesenvolvedoras();
                    return;
                case 10:
                    System.out.println("Qual tabela que você deseja contar a coluna?: ");
                    nomeTabela = sc.next();
                    System.out.println("Qual coluna");
                    nomeColuna = sc.next();
                    SomaTotalNumerico.calcularSomaTotal(nomeTabela, nomeColuna);
                    return;
                case 11:
                    System.out.println("Qual tabela que você deseja calcular a media da coluna?: ");
                    nomeTabela = sc.next();
                    System.out.println("Qual coluna");
                    nomeColuna = sc.next();
                    MediaDadosNumericos.calcularMedia(nomeTabela, nomeColuna);
                    return;
                case 12:
                    System.out.println("Por qual plataforma deseja filtrar?: ");
                    String plataforma = sc.next();
                    ListarJogosPorPlataforma.listarJogosPorPlataforma(plataforma);
                    return;
                case 13:
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        }
        sc.close();
    }
}
