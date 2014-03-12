package com.db.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.dao.ClientDao;
import com.db.dao.ReservationDao;
import com.db.dao.RestaurantDao;
import com.db.entities.Client;
import com.db.entities.Favourite;
import com.db.entities.Reservation;

/**
 * Servlet implementation class EatItAllServlet
 */
@WebServlet("/EatItAllServlet")
public class EatItAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EatItAllServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
		System.out.println("rrr");
		String page=request.getParameter("hidden");
		String search1= request.getParameter("byplace");
		String search2= request.getParameter("SearchByCuisine");
		 
		HttpSession session = request.getSession();
		
		RequestDispatcher disp;
		ClientDao clientDao =new ClientDao();
		if(page.equals("Login"))
		{   
			String userName=request.getParameter("username");
			String password=request.getParameter("password");
			if (clientDao.validateCredential(userName, password))
			{   
			    session.setAttribute("username", userName);
				disp=request.getRequestDispatcher("/jsp/home.jsp");
		    	disp.forward(request,response);
			}
			else
			{
				disp=request.getRequestDispatcher("/jsp/login.jsp");
		    	disp.forward(request,response);
			}
			}
		
		else if(page.equals("Signup"))
		{   String userName=request.getParameter("username");
		    String password=request.getParameter("password");
		    String name= request.getParameter("name");
		    Client client= new Client();
		    client.setName(name);
		    client.setUsername(userName);
		    client.setPassword(password);
			if(clientDao.validate(client))
				{
				clientDao.save(client);
				disp=request.getRequestDispatcher("/jsp/login.jsp");
				request.setAttribute("errormsg", "Account created");
	    	    disp.forward(request,response);}
			else
			{
				disp=request.getRequestDispatcher("/jsp/newuser.jsp");
				request.setAttribute("errormsg", "user already exists");
	    	    disp.forward(request,response);
			}
			}
			
		else if(request.getParameter("reservation")!= null)
		{   //System.out.println("button pressed");
		    //System.out.println("the value is"+request.getParameter("resturants"));
			String option=request.getParameter("resturants");
			
			RestaurantDao rd= new RestaurantDao();
			Reservation reservation= new Reservation();
			reservation.setRestaurant(rd.loadbyName(option));
			reservation.setRname(rd.loadbyName(option).getName());
			String str=(String) session.getAttribute("username");
			System.out.println(str);
            reservation.setCid(clientDao.loadbyName(str).getId());
           
           System.out.println(reservation.getCid());
           
			
		}
		
		else if(request.getParameter("favourite")!= null)
		{   //System.out.println("button pressed");
		    //System.out.println("the value is"+request.getParameter("resturants"));
			String option=request.getParameter("resturants");
			
			RestaurantDao rd= new RestaurantDao();
			Favourite favourite= new Favourite();
			favourite.setRid(rd.loadbyName(option).getId());
			String str=(String) session.getAttribute("username");
			favourite.setLikedby(clientDao.loadbyName(str).getId());
		
           System.out.println(favourite.getLikedby());
           
			
		}
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
}
}

	
		/*
		else if(page.equals("LogOut"))
		{
			HttpSession session=request.getSession(false);
			session.invalidate();
		
			disp=request.getRequestDispatcher("/jsp/login.jsp");
	    	disp.forward(request,response);
		}
		else
		{
			System.out.println("reached");
			if(request.getParameter("reservation")!= null)
			{
				System.out.println("button pressed");
			}
				
		}
		/*else if(page.equals("SearchByPlace"))
		 { System.out.println("serch by place");}
			
		else if(search2.equals("SearchByCuisine"))
		 { System.out.println("serch by cuisine");}
		}*/
			
	
		
	  
