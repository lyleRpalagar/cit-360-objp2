package hibernate;

import org.hibernate.*;
import org.hibernate.cfg.*;
 
public class ClientForSave { 
 
	public static void main(String[] args)
	{
 
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml"); 
 
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Product p=new Product();
 
		p.setProductId(101);
		p.setProName("iPhone");
		p.setPrice(25000);
 
		Transaction tx = session.beginTransaction();
		session.save(p);
		System.out.println("Object saved successfully.....!!");
		tx.commit();
		session.close();
		factory.close();
	}
 
	
	/*Couple of things you need to change for this to work 
	 * hibernate.cfg.xml > change the username and password and your database connection
	 * Build your database 
	 * In the Databasea please use this SQL QUERY 
	 * : select * from products;  
	 * 
	 * mine populated as so:
	 *   pid     pname    price
	 *   101     iphone   25000
	 *   102     ipod     22000
	 *   ..                     */
	
	
	
}