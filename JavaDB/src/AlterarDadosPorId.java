import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import Conexao.Conexao;

public class AlterarDadosPorId {
    public static void alterarDadosPorId() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do Jogo a ser alterado: ");
        int idJogo = sc.nextInt();

        System.out.print("Digite o novo nome: ");
        String novoNome = sc.next();

        System.out.print("Digite o novo ano de lançamento: ");
        int novoAno = sc.nextInt();

        System.out.println("Digite as plataformas, separadas pro viruglas: ");
        String novasPlataformas = sc.next();

        alterarJogo(idJogo, novoNome, novoAno, novasPlataformas);
        
        sc.close();
    }

    public static void alterarJogo(int idJogo, String novoNome, int novoAno, String novasPlataformas) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Conexao.getConexao();
            String sql = "UPDATE jogos SET nome = ?, ano = ?, plataformas = ? WHERE idJogo = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, novoNome);
            ps.setInt(2, novoAno);
            ps.setString(3, novasPlataformas);

            int linhasAfetadas = ps.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Dados dos jogos atualizados!");
            } else {
                System.out.println("Não foi possivel encontrar o ID do jogo");
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
