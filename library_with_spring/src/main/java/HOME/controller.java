package HOME;
import java.io.Console;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;





@Controller
public class controller 
{
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request)
	{
		if(request.getParameter("clicked").equals("MEMBER"))
		return "member";
		return "login";
	}
	
	@RequestMapping("/login")
	public String members(HttpServletRequest request)
	{
		String password = request.getParameter("password");
		
		return "librarian";
	}
	
	@RequestMapping("/librarian")
	public String librarian ()
	{
		System.out.print("");
		return "librarian";
	}
	
	@RequestMapping("/issue_book")	
	public String Issue(HttpServletRequest request,HttpServletResponse response,Model m) throws IOException 
	{

		 PrintWriter out= response.getWriter();
		   out.println( "Project Started.....!" );
	       
		   String book_id = request.getParameter("book_id");
		   String member_id = request.getParameter("member_id");
		   String book_title = request.getParameter("book_title");
		   
	        Configuration cfg= new  Configuration();
	         cfg.configure("hybernet.cfg.xml"); 
	         
	        System.out.println(book_id+"  "+member_id+" "+book_title);
	        
	         SessionFactory factory= cfg.buildSessionFactory();
	         
	         Session session=factory.openSession();
	         org.hibernate.Transaction tx=  session.beginTransaction();
	         
	      POJO_CLASSES.avl_books books= (POJO_CLASSES.avl_books)session.get(POJO_CLASSES.avl_books.class,book_id);
	         
	      POJO_CLASSES.avl_members members = (POJO_CLASSES.avl_members)session.get(POJO_CLASSES.avl_members.class,member_id);
	         
	         if(members==null||books==null)
	         {
	        	 if(members==null)
	        			System.out.println("Invalid User Id"); 
	        	 else 
	        		 System.out.println("Not Available");
	         }
	         else 
	         {
	        	 
	        	 @SuppressWarnings("unused")
				 POJO_CLASSES.issued_books iBooks = new POJO_CLASSES.issued_books(book_id,book_title,member_id,LocalDate.now());
	        	 out.println("Available..................");
	        	 
	        	 session.save(iBooks);
	        	
	        	 tx.commit();
	        	 
	        	 tx=  session.beginTransaction();
	        	  
	        	 @SuppressWarnings("unchecked")
	Query<POJO_CLASSES.avl_books> query = session.createQuery("delete from avl_books where id=:c");
	 	         
	 	         query.setParameter("c",book_id);
	 	         int n = query.executeUpdate();
	 	        
	 	         System.out.println( "DONE.....--!"+n);
	 	         tx.commit();
	        	 
	         }
	         session.close();
	         String rslt="WANT_MORE";
	 		String link="add_book.jsp";
	 		
	 		m.addAttribute("response",rslt);
	 		m.addAttribute("link",link);
	         return "response";
	}
	
	@RequestMapping("/add_book")
	public String add_book(HttpServletRequest request,Model m)
	{	
		 System.out.println( "Project Started.....!" );
	       
		 String title = request.getParameter("title");
			String id= request.getParameter("id");
				   
	        Configuration cfg= new  Configuration();
	         cfg.configure("hybernet.cfg.xml"); 
	        
	         SessionFactory factory= cfg.buildSessionFactory();
	         
	         Session session=factory.openSession();
	         org.hibernate.Transaction tx=  session.beginTransaction();
	         
	        POJO_CLASSES.avl_books books = new POJO_CLASSES.avl_books(title,id);
	         session.save(books);
	        
	         tx.commit();
	         session.close();
		
		String rslt="ADD MORE";
		String link="add_book.jsp";
		
		m.addAttribute("response",rslt);
		m.addAttribute("link",link);
		
		return "response";
	}
	
	@RequestMapping("/delete_book")
	public String delete_book(HttpServletRequest request,Model m)
	{	
		
		 System.out.println( "delete book Project Started.....!" );
	       
		 String title = request.getParameter("title");
			String id= request.getParameter("id");
			
		   
	         Configuration cfg= new  Configuration();
	         cfg.configure("hybernet.cfg.xml"); 
	        
	         SessionFactory factory= cfg.buildSessionFactory();
	         
	         Session session=factory.openSession();
	         org.hibernate.Transaction tx=  session.beginTransaction();
	         
	         @SuppressWarnings("unchecked")
Query<POJO_CLASSES.avl_books> query = session.createQuery("delete from avl_books where title=:c and id=:d");
	         
             query.setParameter("d",id);
	         query.setParameter("c",title);
	         int n = query.executeUpdate();
	        
	         System.out.println( "DONE.....--!"+n);
	         tx.commit();
	         session.close();
		    
		     
	         String rslt="DELETE MORE BOOKS";
	 		String link="delete_book.jsp";
	 		
	 		m.addAttribute("response",rslt);
	 		m.addAttribute("link",link);
		
		return "response";
		
	}
	
	@RequestMapping("/add_member")
	public String add_member(HttpServletRequest request,Model m)
	{
		
		 System.out.println( "Project Started.....!" );
	       
		 String name = request.getParameter("name");
			String id= request.getParameter("id");
				   
	        Configuration cfg= new  Configuration();
	         cfg.configure("hybernet.cfg.xml"); 
	        
	         SessionFactory factory= cfg.buildSessionFactory();
	         
	         Session session=factory.openSession();
	         org.hibernate.Transaction tx=  session.beginTransaction();
	         
	        POJO_CLASSES.avl_members members = new POJO_CLASSES.avl_members(id,name);
	         session.save(members);
	        
	         tx.commit();
	         session.close();
		
		String rslt="ADD MORE MEMERS";
		String link="add_member.jsp";
		
		m.addAttribute("response",rslt);
		m.addAttribute("link",link);
		
		return "response";
	}
	
	@RequestMapping("/delete_member")
	public String delete_member(HttpServletRequest request,Model m)
	{
		System.out.println( "delete member Project Started.....!" );
	       
		 String name = request.getParameter("name");
			String id= request.getParameter("id");
				   
	        Configuration cfg= new  Configuration();
	         cfg.configure("hybernet.cfg.xml"); 
	        
	         SessionFactory factory= cfg.buildSessionFactory();
	         
	         Session session=factory.openSession();
	         org.hibernate.Transaction tx=  session.beginTransaction();
	         
	         @SuppressWarnings("unchecked")
	         Query<POJO_CLASSES.avl_members> query = session.createQuery("delete from avl_members where name=:c and id=:d");
	         	         
	                      query.setParameter("d",id);
	         	         query.setParameter("c",name);
	         	         int n = query.executeUpdate();
	         	        
	         	         System.out.println( "DONE.....--!"+n);
	         	         tx.commit();
	         	         session.close();
	         		    
		String rslt="DELETE MORE MEMERS";
		String link="delete_member.jsp";
		
		m.addAttribute("response",rslt);
		m.addAttribute("link",link);
		
		return "response";
	}
	
	@RequestMapping("/deposit_book")
	public String deposit_book (HttpServletRequest request,Model m,HttpServletResponse response) throws IOException
	{
		String book_id = request.getParameter("book_id");
		
		String book_title = request.getParameter("book_title");
		
		String member_id = request.getParameter("member_id");
		
		 PrintWriter out= response.getWriter();
		   out.println( "Project Started.....!" );
		   
	        Configuration cfg= new  Configuration();
	         cfg.configure("hybernet.cfg.xml"); 
	        
	         SessionFactory factory= cfg.buildSessionFactory();
	         
	         Session session=factory.openSession();
	         
	       // org.hibernate.Transaction tx=   session.beginTransaction();
     	  
     	  @SuppressWarnings("unchecked")
	Query<POJO_CLASSES.issued_books> query = session.createQuery("from issued_books where book_title=:c and member_id=:d");
	         
	         query.setParameter("c",book_title);
	         query.setParameter("d",member_id);
	         
	         List<POJO_CLASSES.issued_books> list=query.list();
	         
	         
	         int n=0;
	         if(list.size()==0)
	         {
	        	 System.out.println("Invalidate_Data");
	        	   String rslt="INVALID DATA TRY AGAIN";
	   	 		String link="book_deposit.jsp";
	   	 		
	   	 		m.addAttribute("response",rslt);
	   	 		m.addAttribute("link",link);
	         }
	         else 
	         {
	        	 for(POJO_CLASSES.issued_books books:list)
	        		 {
	        		 Period intervalPeriod = Period.between(LocalDate.now(),books.getDate());
	        		   int days=intervalPeriod.getDays();
	        		   float FINE = (float) ((float)(days-15)*0.5);
	        	    	if(FINE<0)
	        			FINE=0;
	        		    System.out.println("FINE: " + FINE);
	        		   n++;
	        		 }
	        	 
	        	 org.hibernate.Transaction tx=  session.beginTransaction();
		         POJO_CLASSES.avl_books members = new POJO_CLASSES.avl_books(book_id,book_title);
		         session.save(members);
		        
		         @SuppressWarnings("unchecked")
Query<POJO_CLASSES.issued_books> queri = session.createQuery("delete from issued_books where book_title=:c and member_id=:d");
		         	         
		                      queri.setParameter("c",book_title);
		         	         queri.setParameter("d",member_id);
		         	         int d = queri.executeUpdate();
		         	        
		         	         System.out.println( "DONE---DELETE .....--!"+d);
		       
		         tx.commit();
		         String rslt="DEOSIT MORE BOOKS";
			 		String link="book_deposit.jsp";
			 		
			 		m.addAttribute("response",rslt);
			 		m.addAttribute("link",link);
		         
	         }     
	         
	         System.out.println( "DONE.....--!"+n);
	         
	         session.close();
	 		
	 		return "response";
	
	}
	
}
