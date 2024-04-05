<!doctype html>
<%@page import="com.notetaker.entities.Note"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.notetaker.helper.FactoryProvider"%>
<%@page import="org.hibernate.Session"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Edit Note</title>
	
	<!-- Adding all_js_css_files.jsp -->
	<%@include file="required/all_js_css_files.jsp" %>


  </head>
  <body>
    
    <!-- Adding navbar.jsp -->
    <%@include file="navbar.jsp" %>
    
    <br>
    
    <!-- Getting respective note using noteId from request -->
    <%
    	int noteId = Integer.parseInt(request.getParameter("noteId").trim());
    	
    	Session s = FactoryProvider.getFactory().openSession();
    
		Transaction tx = s.beginTransaction();
		
		Note note = (Note)s.get(Note.class, noteId);
    	
		
    %>
    
    
    <!-- Add note form -->
    <form action="EditNoteServlet" method="post">

		<div class="container">
			
			<!-- noteId -->
			<input type="hidden" name="noteId" value=<%= note.getNoteId() %>>
			
			<!-- add title -->
			<div class="mb-3">
			    <label for="noteTitle" class="form-label">Title</label>
			    <input 	type="text" 
			    		class="form-control" 
			    		id="noteTitle"
			    		name="noteTitle" 
			    		value="<%=note.getNoteTitle() %>"
			    		required />
			</div>
			<!-- add content -->
			<div class="mb-3">
			    <label for="noteContent" class="form-label">Content</label>
			    <textarea 	id="noteContent"	
			    			class="form-control"
			    			name="noteContent"	
			    			style="height:300px;" required ><%= note.getNoteContent() %>
			    </textarea>
			</div>
			
			<!-- centering Add button -->
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Save Changes</button>
			</div>
		
		</div>
		
	</form>
    
    


  </body>
</html>