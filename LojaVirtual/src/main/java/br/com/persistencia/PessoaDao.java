/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.persistencia;


import br.com.beans.Pessoa;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author HJ-Sistemas
 */
public class PessoaDao implements Serializable{
    private static final long serialVersionUID = 1L;

	public static void salvar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pessoa);
		t.commit();

	}

	public static void alterar(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(pessoa);
		t.commit();
		sessao.close();
	}

	public static void excluir(Pessoa pessoa) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(pessoa);
		t.commit();
		sessao.close();
	}

	public static List<Pessoa> listagem(String pessoa_nome) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Pessoa");
		if (pessoa_nome == null) {
			consulta = sessao.createQuery("from Pessoa order by pes_nome");
		} else {
			consulta = sessao.createQuery("from Pessoa where pes_nome like:parametro order by pes_nome");
			consulta.setString("parametro", "%" + pessoa_nome + "%");
		}
		List lspessoa = consulta.list();
		sessao.close();
		return lspessoa;
	}
	public static Pessoa pesqId(int valor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Produto where prod_id = :parametro");
		consulta.setInteger("parametro", valor);
		sessao.close();
		return (Pessoa) consulta.uniqueResult();
	}
}
