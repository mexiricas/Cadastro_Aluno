package br.com.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "estados")
public class Estados {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int est_id;
	@Column(name = "nome", length = 120, nullable = true)
	private String est_nome;
	@Column(name = "sigla", length = 120, nullable = true)
	private String est_sigla;
	
	
	
	public String getEst_nome() {
		return est_nome;
	}
	public void setEst_nome(String est_nome) {
		this.est_nome = est_nome;
	}
	public int getEst_id() {
		return est_id;
	}
	public void setEst_id(int est_id) {
		this.est_id = est_id;
	}
	
	public String getEst_sigla() {
		return est_sigla;
	}
	public void setEst_sigla(String est_sigla) {
		this.est_sigla = est_sigla;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  this.est_sigla + this.est_nome;
	}

	
}
