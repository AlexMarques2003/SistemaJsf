package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Clientes;
import br.com.farmacia.factory.ConexaoFactory;

public class ClientesDAO {

	public void salvar(Clientes c) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO clientes ");
		sql.append("(nome, logradouro,numero,cpf,cep,rg) ");
		sql.append("VALUES (?,?,?,?,?,?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, c.getNome());
		comando.setString(2, c.getLogradouro());
		comando.setString(3, c.getNumero());
		comando.setString(4, c.getCpf());		
		comando.setString(5, c.getCep());
		comando.setString(6, c.getRg());		
				
		comando.executeUpdate();

	}

	public void excluir (Clientes c) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM clientes ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getCodigo());
		comando.executeUpdate();
	}

	public void editar (Clientes c) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE clientes ");
		sql.append("SET nome = ?, logradouro = ?,numero = ?,cep = ?,cpf = ?,rg = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, c.getNome());
		comando.setString(2, c.getLogradouro());
		comando.setString(3, c.getNumero());
		comando.setString(4, c.getCep());
		comando.setString(5, c.getCpf());
		comando.setString(6, c.getRg());		
		
		comando.setLong(7, c.getCodigo());
		
		comando.executeUpdate();

	}

	public Clientes buscaPorCodigo(Clientes c)throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome, logradouro, numero, cep, cpf, rg ");
		sql.append("FROM clientes ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, c.getCodigo());

		ResultSet resultado = comando.executeQuery();
		Clientes retorno = null;

		if(resultado.next()){
			retorno = new Clientes();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setLogradouro(resultado.getString("logradouro"));
			retorno.setNumero(resultado.getString("numero"));
			retorno.setCep(resultado.getString("cep"));
			retorno.setCpf(resultado.getString("cpf"));
			retorno.setRg(resultado.getString("rg"));
		}

		return retorno;
	}


	public ArrayList<Clientes>buscarPorNome(Clientes c)throws SQLException{

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome, numero,logradouro,cep,cpf,rg ");
		sql.append("FROM clientes ");
		sql.append("WHERE nome LIKE ? ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, "%" + c.getNome() + "%");
		
		ResultSet resultado = comando.executeQuery();

		ArrayList<Clientes>lista = new ArrayList<Clientes>();

		while(resultado.next()){
			Clientes item = new Clientes();
			item.setCodigo(resultado.getLong("codigo"));
			item.setNome(resultado.getString("nome"));
			item.setNumero(resultado.getString("numero"));
			item.setLogradouro(resultado.getString("logradouro"));
			item.setCep(resultado.getString("cep"));
			item.setCpf(resultado.getString("cpf"));
			item.setRg(resultado.getString("rg"));

			lista.add(item);
		}

		return lista;
	}

	public ArrayList<Clientes> listar()throws SQLException{

		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, nome, logradouro, numero, cep, cpf, rg ");
		sql.append("FROM clientes ");
		sql.append("ORDER BY nome ASC ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Clientes>lista = new ArrayList<Clientes>();

		while(resultado.next()){
			Clientes c = new Clientes();
			c.setCodigo(resultado.getLong("codigo"));
			c.setNome(resultado.getString("nome"));
			c.setLogradouro(resultado.getString("logradouro"));
			c.setNumero(resultado.getString("numero"));
			c.setCep(resultado.getString("cep"));
			c.setCpf(resultado.getString("cpf"));
			c.setRg(resultado.getString("rg"));
			

			lista.add(c);
		}

		return lista;
	}
}

