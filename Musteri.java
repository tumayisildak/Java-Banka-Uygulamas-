package nyp_odev1;

import java.util.ArrayList;

import java.util.Scanner;
//Musteri s�n�f� kisi s�n�f�ndan miras ald�g� icin extend ettim.
public class Musteri extends Kisi{
	
	private int musteriNumarasi;
	//hesaplar ve kredi kartlari arraylisti olusturdum.
	static ArrayList<BankaHesap> hesaplar = new ArrayList<>();
	ArrayList<KrediKarti> krediKartlari = new ArrayList<>();
	
	//her bir hesap t�r� i�in nesne olusturdum.
	VadesizHesap vadesizhesap;
	VadeliHesap vadelihesap;
	YatirimHesap yatirimhesap;
	
	//Musteri yap�c� metotunu olusturdum
	public Musteri(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi, int musteriNumarasi) {
		super(tcKimlikNo, ad, soyad, email, telefonNumarasi);
		this.musteriNumarasi = musteriNumarasi;
		//iban� random atad�m.
		long iban = (long)(Math.random()*10000000+35001100L);
		//m�steri olustururken vadesiz hesab� otomat�k olusturdum.
		vadesizhesap = new VadesizHesap("Vadesiz Hesap",1000,iban,0,"Normal Hesap");
		hesaplar.add(vadesizhesap);
	}
	
	//normal hesap ekle metotu
	public void hesapEkle(long tcKimlikNo, int musteriNumarasi, String ad, String soyad, long iban, double toplamBakiye, String hesapBilgisi) {
		System.out.println("Eklemek istediginiz hesap turunu seciniz\n1)Vadeli Hesap\n2)Yat�r�m Hesab�");
		//hesap t�r� bilgisini kullan�c�dan ald�m.
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		//iban� random atad�m.
		long iban2 = (long)(Math.random()*10000000+35001100L);
		switch(x) {
			case 1:
				//yeni vadeli normal hesap
				vadelihesap = new VadeliHesap("Vadeli Hesap",0,10,iban2,0,"Normal Hesap");
				hesaplar.add(vadelihesap);
				System.out.println("Vadeli Normal Hesap ba�ar�yla eklendi.\n");
				break;
			case 2: 
				//yeni normal yatirim hesap
				yatirimhesap = new YatirimHesap("Yatirim Hesap",0,"doviz",19.48F,iban2,0,"Normal Hesap");
				hesaplar.add(yatirimhesap);
				System.out.println("Yat�r�m Normal Hesap ba�ar�yla eklendi.\n");
				break;
			default : 
		        System.out.println("Ge�ersiz islem!");
		        break;
		}
		
	}
	//maa� hesab� ekle metotu
	public void hesapEkle2(long tcKimlikNo, int musteriNumarasi, String ad, String soyad, long iban, double toplamBakiye, String hesapBilgisi) {
		System.out.println("Eklemek istediginiz hesap turunu seciniz\n1)Vadeli Hesap\n2)Yat�r�m Hesab�");
		//hesap t�r� bilgisini kullan�c�dan ald�m.
		Scanner input = new Scanner(System.in);
		int x = input.nextInt();
		//iban� random atad�m.
		long iban3 = (long)(Math.random()*10000000+35001100L);
		switch(x) {
			case 1:
				//yeni vadeli maa� hesab�
				vadelihesap = new VadeliHesap("Vadeli Hesap",0,20,iban3,0,"Maa� Hesab�");
				hesaplar.add(vadelihesap);
				System.out.println("Vadeli Maa� Hesab� ba�ar�yla eklendi.\n");
				break;
			case 2: 
				//yeni Yatirim maa� hesab�
				yatirimhesap = new YatirimHesap("Yatirim Hesap",0,"doviz",19.48F,iban3,0,"Maa� Hesab�");
				hesaplar.add(yatirimhesap);
				System.out.println("Yat�r�m Maa� Hesabi ba�ar�yla eklendi.\n");
				break;
			default : 
		        System.out.println("Ge�ersiz islem!");
		        break;
		}
		
	}
	
	//hesap sil metotu
	public void hesapSil(long tcKimlikNo, int musteriNumarasi, String ad, String soyad) {
		//hesap turu secimi
	        System.out.println("Silmek istediginiz hesap turunu seciniz\n1)Vadeli Hesap\n2)Yat�r�m Hesab�");
			Scanner input = new Scanner(System.in);
			int x = input.nextInt();
			if(x==1) {
				for(int i=0;i<hesaplar.size();i++) {
					//vadeli hesap var m�? kontrol�
					if(vadelihesap==null) {
						System.out.println("Vadeli hesab�n�z bulunmamaktad�r!\n");
						break;
					}
					//vadeli hesab�n bakiyesi kontrol�
					else if(vadelihesap.hesapTuru.equals("Vadeli Hesap")){
						if(vadelihesap.getVadeliBakiye()==0) {
						// vadeli hesap bakiyesi 0 ise hesab� siler
						hesaplar.remove(i);
						System.out.println("Vadeli Hesap ba�ar�yla silindi.\n");
					}
						else {
							// vadeli hesap bakiyesi 0 de�il ise uyar� verir.
							System.out.println("L�tfen bakiyenizi ba�ka bir hesaba aktar�n�z!");
					}}
					}
				}
			else if(x==2) {
				for(int i=0;i<hesaplar.size();i++) {
					//Yatirim hesab� var m�? kontrol�
					if(yatirimhesap==null) {
						System.out.println("Yatirim hesab�n�z bulunmamaktad�r!");
						break;
					}
					//Yatirim hesab�n�n bakiyesi kontrol�
					else if(yatirimhesap.hesapTuru.equals("Yatirim Hesap")){
						if(yatirimhesap.getYatirimBakiye()==0) {
						hesaplar.remove(i);
						System.out.println("Yatirim Hesabi ba�ar�yla silindi.\n");
					}
						// Yatirim hesap bakiyesi 0 de�il ise uyar� verir.
						else {System.out.println("L�tfen bakiyenizi ba�ka bir hesaba aktar�n�z!");
						}}
					}
		    } 
			// Kullan�c� yanl�� tu�a bast�ysa uyar� verir.
			else {
		        System.out.println("Ge�ersiz islem!");
		    }        
	}

	@Override
	public String toString() {
		return "Musteri [musteriNumarasi=" + musteriNumarasi + ", hesaplar=" + hesaplar + ", krediKartlari="+ krediKartlari + "]";
	}

	//private de�i�kenlerin ve arraylistlerin getter-setter metotlar�.
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
	// para yat�rma ve �ekme i�lemleri i�in metotlar
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
