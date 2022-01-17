package h06_ManyToMany;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class H4_Fetch {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(H1_Ogrenci.class).addAnnotatedClass(H2_Kitap.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
	// 1) id si 1111 olan ogrenciyi getir
		System.out.println("1111 nolu ogrenci: "+session.get(H1_Ogrenci.class, 1111));
		
	
	// 2) 	id si 101 olan kitabi getir
		
		System.out.println("101 nolu kitap : "+session.get(H2_Kitap.class, 101));
		
		
	// 3- adi math book olan kitabi getir
		
		String hqlQuery1= "FROM H2_Kitap k where k.book='math book'";
		
		System.out.println("mat book bilgiler : "+session.createQuery(hqlQuery1).getSingleResult()); // getSingleResult: tek setir dondurecekse tercih edilir
		
	//4)Adı "Ali Can" olan öğrenciyi getirin. Kitapları da görmek istiyorum.HQL yazıyoruz, from classismi yazılır.
				//herşey isteniyorsa select* gerek yok	
		
		String hqlQuery2="from H1_Ogrenci o where o.name='Ali Can'";
	Object sorgu2= session.createQuery(hqlQuery2).getSingleResult();
	System.out.println("Ali can kimki : "+sorgu2);	
	
	// 5- sadece student isimlerini getir
	
	String hqlQuery3= "SELECT o.name From H1_Ogrenci o";
	
	List<Object> sorgu3= session.createQuery(hqlQuery3).getResultList();
		// Object degilde H1_Ogreci de yazabiliriz sadece ogrenci bilgisi istedigi icin
	System.out.println("Ogrenci listesi : "+sorgu3);
	
	// 6- kitap isimlerini getir
	
	String hqlQuery4= "SELECT k.book From H2_Kitap k";
	
	List<Object> sorgu4= session.createQuery(hqlQuery4).getResultList();
		// Object degilde H2_Kitap de yazabiliriz sadece kitap bilgisi istedigi icin
	System.out.println("Kitap listesi : "+sorgu4);
	
	
	
	
	
	
	
	
		
tx.commit();
	}

}
