package br.com.unisys.model;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Produto")
@SequenceGenerator(name="seq_Produto", sequenceName="seq_Produto", allocationSize=1)
public class Produto {
	
	//@Entity Anota��o usada para criar (Entidade) no BD
	//@Table Anota��o usada para criar Tabela no BD
	//@Sequence generator Anota��o usada para criar a sequence no BD Oracle
	//@Id
	//@Column
	//@JoinColumn
	//@Many to One Anota��o usada para criar o relacionamento de um para muitos BD Oracle
	
	//Campos
	@Id
	@GeneratedValue(generator="seq_Produto", strategy=GenerationType.SEQUENCE)
	public long idProduto;
	@Column(length=50)
	public String nomeProduto;
	@Column
	public Double preco;
	
	
	//Relacionamento com Categoria
	@ManyToOne
	@JoinColumn(name="idCategoria", referencedColumnName="idCategoria")
	public Categoria Categoria = new Categoria();
	@Column
	public int estoque;
	
	@Column(length=1)
	public String bloqueado;
	
	//Construtor
	public Produto(){
		
	}

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categoria categoria) {
		Categoria = categoria;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public String getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(String bloqueado) {
		this.bloqueado = bloqueado;
	}	
}
