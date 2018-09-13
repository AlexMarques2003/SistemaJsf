package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.farmacia.DAO.ClientesDAO;
import br.com.farmacia.domain.Clientes;
import br.com.farmacia.util.JSFUtil;

@ManagedBean(name = "MBClientes")
@ViewScoped
public class ClientesBean {

	private Clientes clientes;
	private ArrayList<Clientes>itens;
	private ArrayList<Clientes>itensFiltrados;

	public Clientes getClientes() {
		return clientes;
	}
	public void setClientes(Clientes clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Clientes> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Clientes> itens) {
		this.itens = itens;
	}

	public ArrayList<Clientes> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Clientes> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa(){
		try {
			ClientesDAO cdao = new ClientesDAO();
			itens = cdao.listar();

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}	

	public void prepararNovo(){
		clientes = new Clientes();
	}

	public void novo(){

		try {
			ClientesDAO cdao = new ClientesDAO();
			cdao.salvar(clientes);
			itens = cdao.listar();
			JSFUtil.adicionarMensagemSucesso("Cliente salvo com sucesso!");

		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}
	public void excluir(){
		try {
			ClientesDAO cdao = new ClientesDAO();
			cdao.excluir(clientes);
			itens = cdao.listar();
			JSFUtil.adicionarMensagemSucesso("Cliente excluido com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("Não é possível excluir um fornecedor que tenha um produto associado!");
			e.printStackTrace();
		}
	}

	public void editar(){
		try {
			ClientesDAO cdao = new ClientesDAO();
			cdao.editar(clientes);
			itens = cdao.listar();
			JSFUtil.adicionarMensagemSucesso("Cliente editado com sucesso!");
		} catch (SQLException e) {
			JSFUtil.adicionarMensagemErro("ex.getMessage()");
			e.printStackTrace();
		}
	}	

}
