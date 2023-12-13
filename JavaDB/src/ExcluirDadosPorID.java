import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Conexao.Conexao;

public class ExcluirDadosPorID {
    public static void ExcluirDadosPorid1() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do jogo a ser excluído: ");
        int idJogo = sc.nextInt();
        sc.nextLine(); // Limpar o buffer após ler o inteiro

        excluirJogo(idJogo);

        sc.close();
    }

    public static void excluirJogo(int idJogo) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConexao();
            String sql = "DELETE FROM jogos WHERE idJogo = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idJogo);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Jogo excluído com sucesso!");
            } else {
                System.out.println("Nenhum jogo foi encontrado com esse ID");
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
