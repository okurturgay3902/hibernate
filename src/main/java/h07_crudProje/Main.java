package h07_crudProje;

public class Main {

	public static void main(String[] args) {
		
	CrudMetodlar metod =new CrudMetodlar();
	
	metod.sessionFactoryOlustur();
	
	//veri tabanina personel ekle 
	
	/*
	metod.personelEkle("omer", "tufan", 7700);
	metod.personelEkle("suleyman", "matkuliev", 8800);
	metod.personelEkle("kursat", "turgut", 9900);
	*/
	
	// metod.idIlePersonelSil(1);	
	
	// metod.idIleMaasGuncelle(2, 10000);
	
	metod.tumPersoneliListele();
	
	metod.sil();
		
	metod.tumPersoneliListele();	
		
		

	}

}
