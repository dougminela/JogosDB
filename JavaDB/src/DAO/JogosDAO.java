package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexao.Conexao;
import tabelas.Jogos;

public class JogosDAO {

    public void cadastrarJogos(Jogos jogos) {
        String sql = "INSERT INTO jogos (nome, ano, plataformas) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, jogos.getNome());
            ps.setInt(2, jogos.getAno());
            ps.setString(3, jogos.getPlataformas());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    System.out.println("O ID gerado para o jogo é: " + idGerado);
                    jogos.setId(idGerado);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
