import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Conexao.Conexao;

public class ExcluirDadosPorNome {
    public static void excluirDadosPorNome() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome do jogo a ser excluído: ");
        String nomeJogo = sc.nextLine();
        sc.nextLine(); // Limpar o buffer após ler o inteiro

        excluirJogo(nomeJogo);

        sc.close();
    }

    public static void excluirJogo(String nomeJogo) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConexao();
            String sql = "DELETE FROM jogos WHERE nomeJogo = '?'";
            ps = conn.prepareStatement(sql);
            ps.setString(1, nomeJogo);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Jogo excluído com sucesso!");
            } else {
                System.out.println("Nenhum jogo foi encontrado com esse nome");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
