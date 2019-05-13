<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	<script type="text/javascript">
       function ConfirmaExclusao() {
           return confirm("Registro selecionado na grid será excluido!");
       }    
   	</script>
</head>
<body >		
	  <h3><font color="blue">Consulta Usuário</font></h3><hr>
	  
      <div class="col-md-12 column">
          <table class="table table-condensed table-bordered">
            <thead>
              <tr>
              	<th>#</th>
                <th>Nome do Usuário</th>
                <th>Perfil</th>
				<th>Bloqueado</th>
			  </tr>
            </thead>        
			<tbody>
				<%
					Session sessionH = new HibernateUtil().getSession();
					sessionH.beginTransaction();
					UsuarioDAO dao = new UsuarioDAO(sessionH);
					
				    List <Usuario> listaUsuarios = dao.listaUsuario();

				    for (Iterator <Usuario> itUsuarios = listaUsuarios.iterator(); itUsuarios.hasNext();){
				    	Usuario usuario = (Usuario) itUsuarios.next();
				    %>
						<tr>
							<td><%=usuario.getIdUsuario()%></td> 
							<td><%=usuario.getNomeUsuario()%></td>
							<td><%=usuario.perfil.getDescricao()%></td>
							<td><%=usuario.getBloqueado()%></td>
							<td><a href="usuario_atualiza.jsp?idUsuario=<%=usuario.getIdUsuario()%>">Editar</a>
								<a href="usuario_deleta.jsp?idUsuario=<%=usuario.getIdUsuario()%>" onclick="return ConfirmaExclusao();">Remover</a>
							</td>
						</tr>
				    <%
			         }
					%>
			</tbody>
		  </table>
      </div>
</body>
</html>