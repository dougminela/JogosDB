import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class MediaDadosNumericos {
    public static void main(String[] args) {
        String nomeTabela = "jogos";
        String nomeColuna = "ano";

        double media = calcularMedia(nomeTabela, nomeColuna);
        System.out.println("Média de " + nomeColuna + ": " + media);
    }

    public static double calcularMedia(String nomeTabela, String nomeColuna) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        double media = 0;

        try {
            conn = Conexao.getConexao();
            String sql = "SELECT AVG(" + nomeColuna + ") AS media FROM " + nomeTabela;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                media = rs.getDouble("media");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return media;
    }
}
