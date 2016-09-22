package br.com.persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.beans.Produto;

public class ProdutoDao implements Serializable {

	private static final long serialVersionUID = 1L;

	public static void inserir(Produto prod) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(prod);
		t.commit();
		

	}

	public static void alterar(Produto prod) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(prod);
		t.commit();
		sessao.close();
	}

	public static void excluir(Produto prod) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(prod);
		t.commit();
		sessao.close();
	}

	public static List<Produto> listagem(String prod_nome) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Produto");
		if (prod_nome == null) {
			consulta = sessao.createQuery("from Produto order by nome");
		} else {
			consulta = sessao.createQuery("from Produto where pro_nome like:parametro order by pro_nome");
			consulta.setString("parametro", "%" + prod_nome + "%");
		}
		List lsproduto = consulta.list();
		sessao.close();
		
		return lsproduto;
	}
	public static Produto pesqId(int valor) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Produto where prod_id = :parametro");
		consulta.setInteger("parametro", valor);
		sessao.close();
		return (Produto) consulta.uniqueResult();
	}
}
