/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio;

import br.com.beans.Cidades;
import br.com.persistencia.CidadesDao;
import br.com.persistencia.ProdutoDao;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author HJ-Sistemas
 */
@ManagedBean(name = "cidadeBeans")
public class CidadesCtrl {
   private Cidades cid = new Cidades();
   private String filtro = null;

   public List<Cidades> getListagem() {
		if(filtro == null){
			cid = new Cidades();
			return CidadesDao.listagem(null);
		}else
		return CidadesDao.listagem(filtro);
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
    
}
