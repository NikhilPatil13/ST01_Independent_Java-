package com.notetaker.servlets;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.notetaker.entities.Note;
import com.notetaker.helper.FactoryProvider;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteNoteServlet
 */
@WebServlet("/DeleteNoteServlet")
public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteNoteServlet() {
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try 
		{
			// getting value of noteId coming in request as parameter
			int noteId  = Integer.parseInt(request.getParameter("noteId").trim());
			
			// getting note object matching with noteId
			Session session = FactoryProvider.getFactory().openSession();
	
			Note note = (Note)session.get(Note.class, noteId);
		
			// Want to delete this note
			// need to beginTransaction to do permanent changes is database 
			Transaction transaction = session.beginTransaction();
		
			// delete note object 
			session.delete(note);
			
			// do permanent changes in db
			transaction.commit();
			
			// close session
			session.close();

			// redirect to allNotes.jsp
			response.sendRedirect("allNotes.jsp");
			
			
		}
		catch(Exception e) 
		{
			System.out.println("Exception Occured is DeleteNoteServlet - "+e.getMessage());
		}
	
	}

}
