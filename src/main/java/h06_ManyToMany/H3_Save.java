package h06_ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H3_Save {

	public static void main(String[] args) {
		
		
		
		H2_Kitap art =new H2_Kitap(101, "art book");
		H2_Kitap math = new H2_Kitap(102,"math book");
		H2_Kitap science = new H2_Kitap(103,"science book");
		H1_Ogrenci student1=new H1_Ogrenci(1111, "Beyhan Can", 70);		
		H1_Ogrenci student2 = new H1_Ogrenci(2222, "Ali Can",10);
		H1_Ogrenci student3 = new H1_Ogrenci(3333,"Ayse Tan",12);
		
	
	student1.getBooks().add(art);	
	student1.getBooks().add(math);	
	student1.getBooks().add(science);	
		
	student2.getBooks().add(art);
	
	student3.getBooks().add(art);
	student3.getBooks().add(math);
	
	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(H1_Ogrenci.class).addAnnotatedClass(H2_Kitap.class);
	SessionFactory sf = con.buildSessionFactory();
	Session session = sf.openSession();
	
	Transaction tx = session.beginTransaction();
	
	
	System.out.println(session.save(student1)); 
	session.save(student2);
	session.save(student3);
	session.save(art);
	session.save(math);
	session.save(science);
	
	
	
	// alt kisma gerek yok tersden dusunulurse
//	art.getStudents().add(student1);
//	art.getStudents().add(student2);	
//	art.getStudents().add(student3);
//	math.getStudents().add(student1);
//	math.getStudents().add(student3);	
//	science.getStudents().add(student1);
	
	
	
	/*
	 * *****coklu baglama*******
	
	@Entity
	@Table(name = "users")
	public class Users {
	            
	    @Id
	    @Column(name = "idusers")
	    private int idusers;
	       
	    @OneToMany(mappedBy="idusers")
	    private Set<Accounts> accounts;
	    ...
	}
	*********************
	@Entity
	@Table(name = "accounts")
	public class Accounts {
	    
	    @Id
	   
	    @Column(name = "idaccounts")
	    private int idaccounts;
	   
	    @ManyToOne
	    @JoinColumn(name="idusers")
	    private Users idusers;

	    @OneToMany(mappedBy="idaccounts")
	    private Set<Transacs> transacs;
	    ...
	}
	*************
	@Entity
	@Table(name = "transacs")
	public class Transacs {
	    
	    @Id
	    
	    @Column(name = "idtransacs")
	    private int idtransacs;

	    @ManyToOne
	    @JoinColumn(name="idaccounts")
	    private Accounts idaccounts;
	    ....
	}
	
	*/
	
	tx.commit();
	}

}
