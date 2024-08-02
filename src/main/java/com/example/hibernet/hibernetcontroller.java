package com.example.hibernet;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class hibernetcontroller {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata md = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sf = md.getSessionFactoryBuilder().build();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		student h = new student();
		h.setName("Triveni");
		h.setEmail("triv123@gmail.com");
		h.setPassword("triveni12");
        h.setPhonenumber(1234567890);
        s.save(h);
		t.commit();
		System.out.println("Successfully Inserted");
		s.close();
		sf.close();

	}

}