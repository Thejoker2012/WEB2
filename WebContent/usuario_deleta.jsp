<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    

<%@ page import="br.com.unisys.model.Perfil" %>
<%@ page import="br.com.unisys.model.PerfilDAO" %>

<%@ page import="br.com.unisys.model.Usuario" %>
<%@ page import="br.com.unisys.model.UsuarioDAO" %>

<%@ page import="br.com.unisys.model.HibernateUtil" %>
<%@ page import="org.hibernate.Session" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h3><font color="blue">Deleta Usuário</font></h3><hr>
	<% 
		long _idUsuario = Long.parseLong(request.getParameter("idUsuario"));
	
		Session sessionH = new HibernateUtil().getSession();
		sessionH.beginTransaction();
		
		UsuarioDAO daoUsuario = new UsuarioDAO(sessionH);
		Usuario usuario = new Usuario();
			
		usuario = daoUsuario.retorna(_idUsuario);
			
		String _nomeUsuario = usuario.getNomeUsuario();
		String _senha = usuario.getSenha();
		long _idPerfil = usuario.getIdPerfil();
		String _perfil = usuario.getPerfil().getDescricao();
		String _bloqueado = usuario.getBloqueado();
		String _checkedSim = (_bloqueado.equals("S"))?"checked":"";
		String _checkedNao = (_bloqueado.equals("N"))?"checked":"";
	%>
	
	<form action="deletaUsuario" method="post">
	
		<input type="hidden" name="usuario.idUsuario" value="<%=_idUsuario %>">
		
		<table align="center">
			<tr><td>Nome do usuário:</td><td><input type="text" name="usuario.nomeUsuario" value="<%=_nomeUsuario%>"></td></tr>
			<tr><td>Senha de acesso:</td><td><input type="password" name="usuario.senha" value="<%=_senha%>"></td></tr>
			<tr><td>Perfil:</td>
			    <td><select name="usuario.idPerfil">
						<option selected="selected" value="<%=_idPerfil%>"><%=_perfil%></option>			    			
			    		<%	
			    		
						PerfilDAO daoPerfil = new PerfilDAO(sessionH);
						
					    List <Perfil> listaPerfis = daoPerfil.listaPerfil(); 

					    for (Iterator <Perfil> itPerfil = listaPerfis.iterator(); itPerfil.hasNext();){
				            Perfil perfil = (Perfil) itPerfil.next();
				    	%>
				            <option value=<%=perfil.getIdPerfil()%>><%=perfil.getDescricao()%></option>
				    	<%
				         }
						%>
					</select>
			    </td></tr>
			<tr><td>Acesso bloqueado:</td>
				<td><input type="radio" name="usuario.bloqueado" value="S" <%=_checkedSim %>>Sim &nbsp;&nbsp; 
					<input type="radio" name="usuario.bloqueado" value="N" <%=_checkedNao %>>Não </td></tr>  
  
			<tr><td colspan="2">&nbsp;</td></tr>  
			<tr><td colspan="2" align="right"><input type="submit" value="Confirmar Exclusão"></td></tr>
		</table>
	</form>
</body>
</html>  