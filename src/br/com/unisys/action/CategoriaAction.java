package br.com.unisys.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import br.com.unisys.model.Categoria;
import br.com.unisys.model.CategoriaDAO;
import br.com.unisys.model.HibernateUtil;

public class CategoriaAction extends ActionSupport {
	
	private static final long serialVersionUID = 716155646905825865L;
	
	public Categoria categoria = new Categoria();
	
	public Categoria getCategoria(){ 
		return this.categoria;	
	}
	
	public void setCategoria(Categoria categoria){
		this.categoria = categoria;
	}
	
	@Action(value="adicionaCategoria",
	        results={@Result(name="ok", location="/msg_gravacao_ok.jsp"),
 					 @Result(name="erro", location="/msg_gravacao_erro.jsp")})
	public String adicionaCategoria(){
		
		String retorno = "";

		try{
			Session session = new HibernateUtil().getSession();
			session.beginTransaction();
		
			CategoriaDAO dao = new CategoriaDAO(session);
			dao.adiciona(categoria);
		
			session.getTransaction().commit();
			session.close();
			
			retorno = "ok";
			
            }catch(HibernateException ex){
			
			ex.printStackTrace();
			retorno = "erro";
		}
		
		return retorno;
	}

	@Action(value="atualizaCategoria",
	        results={@Result(name="ok", location="/msg_gravacao_ok.jsp"),
 					 @Result(name="erro", location="/msg_gravacao_erro.jsp")})
	public String atualizaCategoria(){
		
		String retorno = "";

		try{
			Session session = new HibernateUtil().getSession();
			session.beginTransaction();
		
			CategoriaDAO dao = new CategoriaDAO(session);
			dao.atualiza(categoria);
		
			session.getTransaction().commit();
			session.close();
			
			retorno = "ok";
			
            }catch(HibernateException ex){
			
			ex.printStackTrace();
			retorno = "erro";
		}
		
		return retorno;
	}

	@Action(value="deletaCategoria",
	        results={@Result(name="ok", location="/msg_gravacao_ok.jsp"),
 					 @Result(name="erro", location="/msg_gravacao_erro.jsp")})
	public String deletaCategoria(){
		
		String retorno = "";

		try{
			Session session = new HibernateUtil().getSession();
			session.beginTransaction();
		
			CategoriaDAO dao = new CategoriaDAO(session);
			dao.deleta(categoria);
		
			session.getTransaction().commit();
			session.close();
			
			retorno = "ok";
			
            }catch(HibernateException ex){
			
			ex.printStackTrace();
			retorno = "erro";
		}
		
		return retorno;
	}
	
}