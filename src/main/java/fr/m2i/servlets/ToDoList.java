package fr.m2i.servlets;

import java.io.IOException;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import fr.m2i.models.Task;

/**
 * Servlet implementation class ToDoList
 */
@WebServlet("/list")
public class ToDoList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE="/WEB-INF/pages/toDoList.jsp";
	Task task = new Task();
  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoList() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersistTask");
		//Attention pas d'autoclosable
		EntityManager em = factory.createEntityManager();

		//em.createNativeQuery("UPDATE task SET nom='" + request.getParameter("nom") + "', description='" + request.getParameter("desc")+ "' where id=" + request.getParameter("id"));
		
	

		@SuppressWarnings("unchecked")
		List<Task> tasks = em.createNativeQuery("SELECT * from task", Task.class).getResultList();
		// bient utiliser les .setParameter(1, "valeur") pour remplacer des ? , secu +++
		
		request.setAttribute("tasks", tasks);
		
		em.close();
		this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requete = request.getParameter("req");
		System.out.println(requete);
		
		if (requete.equalsIgnoreCase("add")) {
			
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersistTask");
			//Attention pas d'autoclosable
			EntityManager em = factory.createEntityManager();
			Task task = new Task();
			task.set_description(request.getParameter("desc"));
			task.set_nom(request.getParameter("nom"));
			//  LE ID s'incremente tout seul (voir task)
			
			em.getTransaction().begin();
			boolean transactionOk = false;
		
			try {em.persist(task);

			transactionOk = true;
			}
			finally {
			    if(transactionOk) {
			        em.getTransaction().commit();
			    }
			    else {
			        em.getTransaction().rollback();
			    }
			}
			em.close();
			
		
		}
		if (requete.equalsIgnoreCase("del")) {
		
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersistTask");
			//Attention pas d'autoclosable
			EntityManager em = factory.createEntityManager();
			
			em.getTransaction().begin();
			boolean transactionOk = false;
			Task task = em.find(Task.class , Integer.parseInt(request.getParameter("id")));
			try {em.remove(task);

			transactionOk = true;
			}
			finally {
			    if(transactionOk) {
			        em.getTransaction().commit();
			    }
			    else {
			        em.getTransaction().rollback();
			    }
			}
			em.close();
			

		}
		if (requete.equalsIgnoreCase("mod")) {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersistTask");
			//Attention pas d'autoclosable
			EntityManager em = factory.createEntityManager();

			Task task = em.find(Task.class , Integer.parseInt(request.getParameter("id")));
			task.set_nom(request.getParameter("nom"));
			task.set_description(request.getParameter("desc"));
			
			em.getTransaction().begin();
			boolean transactionOk = false;

			try {em.persist(task);
			transactionOk = true;
			}
			finally {
			    if(transactionOk) {
			        em.getTransaction().commit();
			    }
			    else {
			        em.getTransaction().rollback();
			    }
			}		
			em.close();
			
		}

		doGet(request,response);
	}

}
