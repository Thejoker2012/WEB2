package br.com.unisys.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import br.com.unisys.model.HibernateUtil;
import br.com.unisys.model.Perfil;
import br.com.unisys.model.PerfilDAO;

public class PerfilAction extends ActionSupport {
	
	private static final long serialVersionUID = 716155646905825865L;
	
	public Perfil perfil = new Perfil();
	
	public Perfil getPerfil(){ 
		return this.perfil;	
	}
	
	public void setPerfil(Perfil perfil){
		this.perfil = perfil;
	}
	
	@Action(value="adicionaPerfil",
	        results={@Result(name="ok", location="/msg_gravacao_ok.jsp"),
 					 @Result(name="erro", location="/msg_gravacao_erro.jsp")})
	public String adicionaPerfil(){
		
		String retorno = "";

		try{
			Session session = new HibernateUtil().getSession();
			session.beginTransaction();
		
			PerfilDAO dao = new PerfilDAO(session);
			dao.adiciona(perfil);
		
			session.getTransaction().commit();
			session.close();
			
			retorno = "ok";
			
            }catch(HibernateException ex){
			
			ex.printStackTrace();
			retorno = "erro";
		}
		
		return retorno;
	}

	@Action(value="atualizaPerfil",
	        results={@Result(name="ok", location="/msg_gravacao_ok.jsp"),
 					 @Result(name="erro", location="/msg_gravacao_erro.jsp")})
	public String atualizaPerfil(){
		
		String retorno = "";

		try{
			Session session = new HibernateUtil().getSession();
			session.beginTransaction();
		
			PerfilDAO dao = new PerfilDAO(session);
			dao.atualiza(perfil);
		
			session.getTransaction().commit();
			session.close();
			
			retorno = "ok";
			
            }catch(HibernateException ex){
			
			ex.printStackTrace();
			retorno = "erro";
		}
		
		return retorno;
	}

	@Action(value="deletaPerfil",
	        results={@Result(name="ok", location="/msg_gravacao_ok.jsp"),
 					 @Result(name="erro", location="/msg_gravacao_erro.jsp")})
	public String deletaPerfil(){
		
		String retorno = "";

		try{
			Session session = new HibernateUtil().getSession();
			session.beginTransaction();
		
			PerfilDAO dao = new PerfilDAO(session);
			dao.deleta(perfil);
		
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