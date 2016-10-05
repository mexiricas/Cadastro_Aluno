/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.persistencia;

import br.com.beans.Cidades;
import br.com.beans.Estados;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HJ-Sistemas
 */
public class CidadesDao implements Serializable{
    private static final long serialVersionUID = 1L;

	public static void inserir(Cidades cid) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(cid);
		t.commit();
		

	}

	public static void alterar(Cidades cid) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(cid);
		t.commit();
		sessao.close();
	}

	public static void excluir(Cidades cid) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(cid);
		t.commit();
		sessao.close();
	}

	public static List<Cidades> listagemCidades(String cid_nome) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from cidades");
		if (cid_nome == null) {
			consulta = sessao.createQuery("from cidades order by nome");
		} else {
			consulta = sessao.createQuery("from cidades where nome like:parametro order by id");
			consulta.setString("parametro", "%" + cid_nome + "%");
		}
		List lscid = consulta.list();
		sessao.close();
		
		return lscid;
	}
	public static List<Estados> listagemEstados(String cid_nome) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from estados");
		if (cid_nome == null) {
			consulta = sessao.createQuery("from estados order by nome");
		} else {
			consulta = sessao.createQuery("from estados where nome like:parametro order by id");
			consulta.setString("parametro", "%" + cid_nome + "%");
		}
		List lscid = consulta.list();
		sessao.close();
		
		return lscid;
	}
	
}
