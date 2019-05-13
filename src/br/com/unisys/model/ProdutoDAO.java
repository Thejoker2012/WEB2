package br.com.unisys.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ProdutoDAO {
	
private Session session;
	
	public ProdutoDAO(Session session){
		this.session = session;
	}
	
	public void adiciona(Produto produto){
		
		this.session.save(produto);
	}
	
	public void deleta(Produto produto){
		this.session.delete(produto);
	}
	
	public void atualiza(Produto produto){
		this.session.update(produto);
	}
	
	public Produto retorna(long idProduto){
		return (Produto) this.session.load(Usuario.class, idProduto);
	}
	
	@SuppressWarnings("unchecked")
	public List <Produto> listaProduto() {
		return this.session.createQuery("FROM Produto").list();
	}
	
	@SuppressWarnings("unchecked")
	public List <Usuario> validaLogin(String nomeUsuario, String senha) {
		Criteria crit = session.createCriteria(Usuario.class); 
		crit.add(Restrictions.eq("nomeUsuario",nomeUsuario));
		crit.add(Restrictions.eq("senha",senha));
		List<Usuario> results = crit.list(); 
		return results;
	}

}


