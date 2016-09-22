package br.com.negocio;

import br.com.beans.Pessoa;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.beans.Produto;
import br.com.persistencia.PessoaDao;
import br.com.persistencia.ProdutoDao;

@ManagedBean(name= "pessoaBeans")
@SessionScoped
public class PessoaCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa = null;
	private String filtro;

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

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
			return actionInserir();
		} else {
			PessoaDao.alterar(pessoa);
			return "lista_produto";
		}
	}

	public String actionInserir() {
		pessoa = new Pessoa();
		return "form_produto";
	}

	public String actionVoltar() {
		pessoa = new Pessoa();
		return "index";

	}

	public String actionExcluir() {
		PessoaDao.excluir(pessoa);
		return "lista_produto";

	}

	public String actionAlterar(Pessoa p) {
		pessoa = p;
		return "form_produto";

	}

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
