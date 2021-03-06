package br.com.persistencia;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	private static final SessionFactory sesssionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			registradorServico.applySettings(cfg.getProperties());
			StandardServiceRegistry servico = registradorServico.build();
			return cfg.buildSessionFactory(servico);

		} catch (Throwable e) {
			// TODO: handle exception
			System.out
					.println("Criação inicial do Session Falhou. Erro !!" + e);
			throw new ExceptionInInitializerError(e);
		}

	}
	
	public static SessionFactory getSessionFactory(){
		return sesssionFactory;
	}
}
