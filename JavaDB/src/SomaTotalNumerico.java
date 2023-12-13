import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class SomaTotalNumerico {
    public static void main(String[] args) {
        String nomeTabela = "jogos";
        String nomeColuna = "idJogos";

        double soma = calcularSomaTotal(nomeTabela, nomeColuna);
        System.out.println("Soma total de " + nomeColuna + ": " + soma);
    }

    public static double calcularSomaTotal(String nomeTabela, String nomeColuna) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        double soma = 0;

        try {
            conn = Conexao.getConexao();
            String sql = "SELECT SUM(" + nomeColuna + ") AS soma FROM " + nomeTabela;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                soma = rs.getDouble("soma");
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
        return soma;
    }
}
