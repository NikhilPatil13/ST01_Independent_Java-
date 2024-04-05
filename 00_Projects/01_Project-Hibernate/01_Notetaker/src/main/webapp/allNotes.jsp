<%@page import="com.notetaker.entities.Note"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="com.notetaker.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>All Notes</title>
		
		<!-- Adding all_js_css_files.jsp -->
		<%@include file="required/all_js_css_files.jsp" %>
			
		
	</head>
		<body>
		
			<!-- Adding navbar.jsp -->
			<%@include file="navbar.jsp" %>
			
			<h2 style="text-align:center"><u>Available Notes :</u></h2>
			<br>
			
			
			<div class="container">
			
				<div class="row">
				
					<div class="col-12">
					
						<%
							Session s = FactoryProvider.getFactory().openSession();
							
							Query query = s.createQuery("from Note");
						
							List<Note> listOfNotes = query.list();
						
							for(Note note : listOfNotes)
							{
						%>
								<!-- Adding card -->
								<div class="card mt-3">
								  <div class="card-body">
								    <h5 class="card-title"><%= note.getNoteTitle() %></h5>
								    <p class="card-text"><%= note.getNoteContent() %></p>
								    
								    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
								    	<a href="editNote.jsp?noteId=<%= note.getNoteId() %>" class="btn btn-primary me-md-2 btn-sm">
								    		<i class="bi bi-pencil-square"></i>
								    	</a>
								    	<a href="DeleteNoteServlet?noteId=<%=note.getNoteId() %>" class="btn btn-danger btn-sm">
											<i class="bi bi-trash"></i>
										</a>
								    </div>
								    
								  </div>
								</div>
						<% 	
							}
							
							s.close(); 
						%>
					
					</div>
				
				</div>
			
			</div>
	
	
	</body>
</html>