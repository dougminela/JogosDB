import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class ListarJogosPorPlataforma {

    public static void listarJogosPorPlataforma(String plataforma) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConexao();
            String sql = "SELECT * FROM jogos WHERE plataforma LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, plataforma);

            rs = ps.executeQuery();

            System.out.println("---Lista de Jogos com plataforma que contenha '" + plataforma + "'---");
            while (rs.next()) {
                int idJogo = rs.getInt("idJogo");
                String nome = rs.getString("nome");
                int ano = rs.getInt("ano");
                String plataformas = rs.getString("plataformas");

                System.out.println("ID: " + idJogo + ", Nome: " + nome + ", ano: " + ano + ", plataformas: " + plataformas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
