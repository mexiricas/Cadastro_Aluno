package br.com.negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.beans.Pessoa;
import br.com.persistencia.PessoaDao;

@ManagedBean(name= "pessoaBeans")
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 7329427687235074332L;
	private Pessoa pessoa = new Pessoa();
	private String filtro;
	
	public List<Pessoa> getListagem() {
		if(filtro == null){
			pessoa = new Pessoa();
			return PessoaDao.listagem(null);
		}else
		return PessoaDao.listagem(filtro);
	}
	public String actionGravar() {
		if (pessoa.getPes_id() == 0) {
			PessoaDao.salvar(pessoa);
			return "lista_cliente";
		} else {
			PessoaDao.alterar(pessoa);
			return "pessoa_cad";
		}
	}
	
	public String actionVoltar() {
		pessoa = new Pessoa();
		return "index";

	}
	
	public String actionExcluir() {
		PessoaDao.excluir(pessoa);
		return "lista_cliente";

	}
	
	public String actionAlterar(Pessoa p) {
		pessoa = p;
		return "pessoa_cad";

	}
	
	
	
	
	
	//getters e setters
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
}
