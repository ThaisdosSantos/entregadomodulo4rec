package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.conexao.MySqlConexao;
import pacote.model.Cadastro;

public class CadastroDao implements CRUD{
	
	private static Connection connection  =  MySqlConexao.createConnection();
	private static String sql;
	
	public static void create(Cadastro cadastro) {
		sql = "INSERT INTO cadastro VALUES (NULL, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

             preparedStatement.setString(1,cadastro.getNome());
             preparedStatement.setLong(2, cadastro.getCpf());
             preparedStatement.setLong(3,cadastro.getRg());
             preparedStatement.setString(4,cadastro.getNascimento());
             preparedStatement.setString(5, cadastro.getSexo());
             preparedStatement.setString(6,cadastro.getEmail());
             preparedStatement.setString(7,cadastro.getSenha());

             preparedStatement.executeUpdate();
             System.out.println("dados inserido no banco de dados!" );

        } catch(SQLException e) {
             System.out.println("dados não inserido no banco de dados " + e.getMessage());
        }
    }


    public static void delete(int codCadastro) {
    	
    	sql = "DELETE FROM cadastro WHERE codCliente = ?";
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1,codCadastro); 
			preparedStatement.executeUpdate();
			
			System.out.println("Cadastro deletado.");
			
		}catch(SQLException e) {
			System.out.println("Cadastro não foi deletado. " + e.getMessage());
		}
    	
    }

    public static List<Cadastro> find(String pesquisa) {
    	
    	sql = String.format("SELECT * FROM cadastro WHERE nome like '%s%%' OR cpf like '%s%%' ", pesquisa,pesquisa);
        List<Cadastro> cadastros = new ArrayList<Cadastro>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
            	
                Cadastro cadastro = new Cadastro();
                
                cadastro.setCodCliente(resultSet.getInt("CodCliente"));
                cadastro.setNome(resultSet.getString("nome"));
                cadastro.setCpf(resultSet.getLong("cpf"));
                cadastro.setRg(resultSet.getLong("rg"));
                cadastro.setNascimento(resultSet.getString("nascimento"));
                cadastro.setSexo(resultSet.getString("sexo"));
                cadastro.setEmail(resultSet.getString("email"));
                cadastro.setSenha(resultSet.getString("senha"));

                cadastros.add(cadastro);
                
            }


            System.out.println("Cliente encontrado na lista de cadastro");
            return cadastros;


        }catch(SQLException e) {
            System.out.println("Cliente não encontra na lista de cadastro " + e.getMessage());
            return null;

        }
    }

    public static Cadastro findByPk(int codCadastro) {
       
    	
    	sql = String.format("SELECT * FROM cadastro WHERE codCliente = %d ", codCadastro);
		
		try {
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql); 
			
			Cadastro cadastro = new Cadastro();
			
			while(resultSet.next()) {
				
				cadastro.setCodCliente(resultSet.getInt("CodCliente"));
                cadastro.setNome(resultSet.getString("nome"));
                cadastro.setCpf(resultSet.getLong("cpf"));
                cadastro.setRg(resultSet.getLong("rg"));
                cadastro.setNascimento(resultSet.getString("nascimento"));
                cadastro.setSexo(resultSet.getString("sexo"));
                cadastro.setEmail(resultSet.getString("email"));
                cadastro.setSenha(resultSet.getString("senha"));
				
			}
			
			System.out.println("Cadastro encontrado pelo codCliente");
			return cadastro;
			
		}catch(SQLException e) {
			
			System.out.println("Cadastro não encontrado pelo codCliente"+ e.getMessage());
			return null;
			
		}
    	
    }

    public static void update(Cadastro cadastro) {
    	
    	sql = "UPDATE cadastro SET nome=?, cpf=?, rg=?, nascimento=?, sexo=?, email=?, senha=?  WHERE codCliente=?";
    	
		
		try {
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, cadastro.getNome());
			preparedStatement.setLong(2, cadastro.getCpf());
			preparedStatement.setLong(3, cadastro.getRg());
			preparedStatement.setString(4, cadastro.getNascimento());
			preparedStatement.setString(5, cadastro.getSexo());
			preparedStatement.setString(6, cadastro.getEmail());
			preparedStatement.setString(7, cadastro.getSenha());
			preparedStatement.setInt(8, cadastro.getCodCliente());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Atualizado no banco de dados.");
			
		}catch(SQLException e) {
			System.out.println("Não foi atualizado no banco de dados." + e.getMessage());
		}
    }
    
}
