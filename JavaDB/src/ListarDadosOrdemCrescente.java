import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class ListarDadosOrdemCrescente {
    public static void listarJogosEmOrdemCrescente() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConexao();
            String sql = "SELECT * FROM jogos ORDER BY ano ASC";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("---Lista de Jogos em Ordem Crescente por ano---");
            while (rs.next()) {
                int idJogo = rs.getInt("idJogo");
                String nome = rs.getString("nome");
                int ano = rs.getInt("ano");
                String plataformas = rs.getString("plataformas");

                System.out.println("ID: " + idJogo + ", Nome: " + nome + ", Ano: " + ano + ", Plataformas: " + plataformas);
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
    }
}
