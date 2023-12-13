import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class ListarDados {
    public static void main(String[] args) {
        listarJogos();
    }

    public static void listarJogos() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConexao();
            String sql = "SELECT * FROM jogos";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("---Lista de Jogos---");
            while (rs.next()) {
                int idJogo = rs.getInt("idJogo");
                String nome = rs.getString("Nome");
                int ano = rs.getInt("Ano");
                String plataformas = rs.getString("Plataformas");
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
