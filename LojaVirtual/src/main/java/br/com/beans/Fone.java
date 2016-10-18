package br.com.beans;

import javax.persistence.*;

@Entity
@Table(name = "fone")
public class Fone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fon_id")
	private int id;
	@Column(name = "fon_numero", length = 20, nullable = true)
	private String fon_numero;
	@Column(name = "fon_descricao", length = 30, nullable = true)
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFon_numero() {
		return fon_numero;
	}

	public void setFon_numero(String fon_numero) {
		this.fon_numero = fon_numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
