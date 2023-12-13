import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;

public class ListagemComAgrupamento {
    public static void listarJogosPorDesenvolvedor() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConexao();
            String sql = "SELECT desenvolvedores.nome, COUNT(jogos.idJogo) AS quantidade_jogos\r\n"
            		+ "FROM jogos\r\n"
            		+ "INNER JOIN desenvolvedores ON jogos.idDesenvolvedor = desenvolvedores.idDesenvolvedor\r\n"
            		+ "GROUP BY desenvolvedores.nome;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("---Contagem de Jogos por Desenvolvedor(\"---");
            while (rs.next()) {
                String nomeDesenvolvedor = rs.getString("desenvolvedores.nome");
                int quantidadeJogos = rs.getInt("quantidade_jogos");

                System.out.println("Desenvolvedor: " + nomeDesenvolvedor + " - Quantidade de Usuários: " + quantidadeJogos);
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
