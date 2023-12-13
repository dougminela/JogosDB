

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Conexao.Conexao;

public class LoginBD {
    public static void FazerLoginBD() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("---Login---");
            System.out.print("Usuário: ");
            String login = scanner.next();

            System.out.print("Senha: ");
            String senha = scanner.next();

            boolean loginValido = validarLogin(login, senha);

            if (loginValido) {
                System.out.println("Login bem-sucedido! Abrindo menu de opções...");
            } else {
                System.out.println("Usuário ou senha incorretos. Tente novamente.");
                return;
            }
        }
    }


    private static boolean validarLogin(String login, String senha) {
        Connection conexao = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            String sql = "SELECT * FROM usuarios WHERE login = ? AND senha = ?";
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);
            resultSet = ps.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {

            try {
                if (resultSet != null)
                    resultSet.close();
                if (ps != null)
                    ps.close();
                if (conexao != null)
                    conexao.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}

