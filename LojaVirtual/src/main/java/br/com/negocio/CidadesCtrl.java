/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio;

import br.com.beans.Cidades;
import br.com.beans.Estados;
import br.com.persistencia.CidadesDao;
import br.com.persistencia.ProdutoDao;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

/**
 *
 * @author HJ-Sistemas
 */
@ManagedBean(name = "cidadeBeans")
public class CidadesCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cidades cid = new Cidades();
	private Estados est = new Estados();
	private String filtro = null;

	public List<Cidades> getListagemCidades() {
		if (filtro == null) {
			cid = new Cidades();
			return CidadesDao.listagemCidades(null);
		} else
			return CidadesDao.listagemCidades(filtro);
	}


	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public Cidades getCid() {
		return cid;
	}

	public void setCid(Cidades cid) {
		this.cid = cid;
	}

	public Estados getEst() {
		return est;
	}

	public void setEst(Estados est) {
		this.est = est;
	}

}
