package br.com.negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.beans.Produto;
import br.com.persistencia.ProdutoDao;

@ManagedBean
@SessionScoped
public class ProdutoCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	private String filtro;

	public List<Produto> getListagem() {
		if (filtro == null) {
			produto = new Produto();
			return ProdutoDao.listagem(null);
		} else
			return ProdutoDao.listagem(filtro);
	}

	public String actionGravar() {

		ProdutoDao produtoDao = new ProdutoDao();
		ProdutoDao.inserir(produto);

		if (produto.getId() == 0) {
			ProdutoDao.inserir(produto);
			return actionInserir();
		} else {
			ProdutoDao.alterar(produto);
			return "lista_produto";
		}
	}

	public String actionInserir() {
		produto = new Produto();
		return "form_produto";

	}

	public String actionVoltar() {
		produto = new Produto();
		return "index";

	}

	public String actionNovaLista() {
		produto = new Produto();
		this.filtro = null;
		getListagem();
		
		return "lista_produto";

	}
	public String actionExcluir() {
		ProdutoDao.excluir(produto);
		return "lista_produto";

	}

	public String actionAlterar(Produto p) {
		produto = p;
		return "form_produto";

	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
