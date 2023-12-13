import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class ListarDadosComInnerJoin {


    public static void listarJogosComDesenvolvedoras() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConexao();
            String sql = "SELECT jogos.idJogo AS idJogo, jogos.nome AS nomeJogo, jogos.ano AS anoJogo, desenvolvedores.nome AS nomeDesenvolvedor " +
                        "FROM jogos INNER JOIN desenvolvedores ON jogos.idDesenvolvedor = desenvolvedores.idDesenvolvedor";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("---Lista de Jogos com seus Desenvolvedores---");
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
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
