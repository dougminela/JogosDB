package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;
import tabelas.Desenvolvedores;

public class DesenvolvedoresDAO {
    public static void criarDesenvolvedor(Desenvolvedores d) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Conexao.getConexao();
            String sql = "INSERT INTO desenvolvedores (nome, cidade origem) VALUES (?, ?)";
            ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, d.getNome());
            ps.setString(2, d.getCidadeOrigem());

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("O ID gerado para o jogo é: " + idGerado);
                    d.setIdDesenvolvedor(idGerado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
