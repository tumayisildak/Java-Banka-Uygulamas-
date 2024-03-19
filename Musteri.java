package nyp_odev1;

import java.util.ArrayList;

import java.util.Scanner;
//Musteri sýnýfý kisi sýnýfýndan miras aldýgý icin extend ettim.
public class Musteri extends Kisi{
	
	private int musteriNumarasi;
	//hesaplar ve kredi kartlari arraylisti olusturdum.
	static ArrayList<BankaHesap> hesaplar = new ArrayList<>();
	ArrayList<KrediKarti> krediKartlari = new ArrayList<>();
	
	//her bir hesap türü için nesne olusturdum.
	VadesizHesap vadesizhesap;
	VadeliHesap vadelihesap;
	YatirimHesap yatirimhesap;
	
	//Musteri yapýcý metotunu olusturdum
	public Musteri(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi, int musteriNumarasi) {
		super(tcKimlikNo, ad, soyad, email, telefonNumarasi);
		this.musteriNumarasi = musteriNumarasi;
		//ibaný random atadým.
		long iban = (long)(Math.random()*10000000+35001100L);
		//müsteri olustururken vadesiz hesabý otomatýk olusturdum.
		vadesizhesap = new VadesizHesap("Vadesiz Hesap",1000,iban,0,"Normal Hesap");
		hesaplar.add(vadesizhesap);
	}
	
	//normal hesap ekle metotu
	public void hesapEkle(long tcKimlikNo, int musteriNumarasi, String ad, String soyad, long iban, double toplamBakiye, String hesapBilgisi) {
		System.out.println("Eklemek istediginiz hesap turunu seciniz\n1)Vadeli Hesap\n2)Yatýrým Hesabý");
		//hesap türü bilgisini kullanýcýdan aldým.
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		//ibaný random atadým.
		long iban2 = (long)(Math.random()*10000000+35001100L);
		switch(x) {
			case 1:
				//yeni vadeli normal hesap
				vadelihesap = new VadeliHesap("Vadeli Hesap",0,10,iban2,0,"Normal Hesap");
				hesaplar.add(vadelihesap);
				System.out.println("Vadeli Normal Hesap baþarýyla eklendi.\n");
				break;
			case 2: 
				//yeni normal yatirim hesap
				yatirimhesap = new YatirimHesap("Yatirim Hesap",0,"doviz",19.48F,iban2,0,"Normal Hesap");
				hesaplar.add(yatirimhesap);
				System.out.println("Yatýrým Normal Hesap baþarýyla eklendi.\n");
				break;
			default : 
		        System.out.println("Geçersiz islem!");
		        break;
		}
		
	}
	//maaþ hesabý ekle metotu
	public void hesapEkle2(long tcKimlikNo, int musteriNumarasi, String ad, String soyad, long iban, double toplamBakiye, String hesapBilgisi) {
		System.out.println("Eklemek istediginiz hesap turunu seciniz\n1)Vadeli Hesap\n2)Yatýrým Hesabý");
		//hesap türü bilgisini kullanýcýdan aldým.
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		//ibaný random atadým.
		long iban3 = (long)(Math.random()*10000000+35001100L);
		switch(x) {
			case 1:
				//yeni vadeli maaþ hesabý
				vadelihesap = new VadeliHesap("Vadeli Hesap",0,20,iban3,0,"Maaþ Hesabý");
				hesaplar.add(vadelihesap);
				System.out.println("Vadeli Maaþ Hesabý baþarýyla eklendi.\n");
				break;
			case 2: 
				//yeni Yatirim maaþ hesabý
				yatirimhesap = new YatirimHesap("Yatirim Hesap",0,"doviz",19.48F,iban3,0,"Maaþ Hesabý");
				hesaplar.add(yatirimhesap);
				System.out.println("Yatýrým Maaþ Hesabi baþarýyla eklendi.\n");
				break;
			default : 
		        System.out.println("Geçersiz islem!");
		        break;
		}
		
	}
	
	//hesap sil metotu
	public void hesapSil(long tcKimlikNo, int musteriNumarasi, String ad, String soyad) {
		//hesap turu secimi
	        System.out.println("Silmek istediginiz hesap turunu seciniz\n1)Vadeli Hesap\n2)Yatýrým Hesabý");
			Scanner input = new Scanner(System.in);
			int x = input.nextInt();
			if(x==1) {
				for(int i=0;i<hesaplar.size();i++) {
					//vadeli hesap var mý? kontrolü
					if(vadelihesap==null) {
						System.out.println("Vadeli hesabýnýz bulunmamaktadýr!\n");
						break;
					}
					//vadeli hesabýn bakiyesi kontrolü
					else if(vadelihesap.hesapTuru.equals("Vadeli Hesap")){
						if(vadelihesap.getVadeliBakiye()==0) {
						// vadeli hesap bakiyesi 0 ise hesabý siler
						hesaplar.remove(i);
						System.out.println("Vadeli Hesap baþarýyla silindi.\n");
					}
						else {
							// vadeli hesap bakiyesi 0 deðil ise uyarý verir.
							System.out.println("Lütfen bakiyenizi baþka bir hesaba aktarýnýz!");
					}}
					}
				}
			else if(x==2) {
				for(int i=0;i<hesaplar.size();i++) {
					//Yatirim hesabý var mý? kontrolü
					if(yatirimhesap==null) {
						System.out.println("Yatirim hesabýnýz bulunmamaktadýr!");
						break;
					}
					//Yatirim hesabýnýn bakiyesi kontrolü
					else if(yatirimhesap.hesapTuru.equals("Yatirim Hesap")){
						if(yatirimhesap.getYatirimBakiye()==0) {
						hesaplar.remove(i);
						System.out.println("Yatirim Hesabi baþarýyla silindi.\n");
					}
						// Yatirim hesap bakiyesi 0 deðil ise uyarý verir.
						else {System.out.println("Lütfen bakiyenizi baþka bir hesaba aktarýnýz!");
						}}
					}
		    } 
			// Kullanýcý yanlýþ tuþa bastýysa uyarý verir.
			else {
		        System.out.println("Geçersiz islem!");
		    }        
	}

	@Override
	public String toString() {
		return "Musteri [musteriNumarasi=" + musteriNumarasi + ", hesaplar=" + hesaplar + ", krediKartlari="+ krediKartlari + "]";
	}

	//private deðiþkenlerin ve arraylistlerin getter-setter metotlarý.
	public int getMusteriNumarasi() {
		return musteriNumarasi;
	}

	public void setMusteriNumarasi(int musteriNumarasi) {
		this.musteriNumarasi = musteriNumarasi;
	}

	public ArrayList<BankaHesap> getHesaplar() {
		return hesaplar;
	}

	public void setHesaplar(long iban, double toplamBakiye, String hesapBilgisi) {
		hesaplar.add(new BankaHesap(iban, toplamBakiye, hesapBilgisi));
	}

	public ArrayList<KrediKarti> getKrediKartlari() {
		return krediKartlari;
	}

	public void setKrediKartlari(int kartNumarasi, double limit, double guncelBorc, double kullanilabilirLimit) {
		krediKartlari.add(new KrediKarti(kartNumarasi, limit, guncelBorc, kullanilabilirLimit));
	}
	// para yatýrma ve çekme iþlemleri için metotlar
	public double paraYatir(double Bakiye, double islemMiktar) {
		return (Bakiye+islemMiktar);
	}
	public double dovizYatir(double yatirimBakiye, double islemMiktar,double kur) {
		return (yatirimBakiye+islemMiktar*kur);
	}

	public double paraCek(double Bakiye, double islemMiktar) {
		return (Bakiye-islemMiktar);
	}
	public double dovizBoz(double yatirimBakiye, double islemMiktar,double kur) {
		return (yatirimBakiye-islemMiktar*kur);
	}
	
		

}
