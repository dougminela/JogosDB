import DAO.DesenvolvedoresDAO;
import DAO.JogosDAO;
import tabelas.Desenvolvedores;
import tabelas.Jogos;
import java.util.Scanner;

public class InserirDados {
    public static void criar() {
        Scanner sc = new Scanner(System.in);

        Jogos j = new Jogos();
        try {
            System.out.println("Digite o nome do jogo:");
            j.setNome(sc.next());

            System.out.println("Digite o ano que o jogo foi lançado:");
            j.setAno(sc.nextInt());

            System.out.println("Digite as plataformas do jogo (separado pro viruglas): ");
            j.setPlataformas(sc.next());

            new JogosDAO().cadastrarJogos(j);
            System.out.println("Jogo cadastrado com sucesso!");

            Desenvolvedores d = new Desenvolvedores();
            System.out.println("Digite o nome da desenvolvedora:");
            d.setNome(sc.next());

            System.out.println("Digite a cidade de origem:");
            d.setCidadeOrigem(sc.next());

            DesenvolvedoresDAO.criarDesenvolvedor(d);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
