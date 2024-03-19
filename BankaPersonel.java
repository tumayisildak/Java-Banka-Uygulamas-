package nyp_odev1;

import java.util.ArrayList;

//BankaPersonel sýnýfý kisi sýnýfýndan miras aldýgý icin extend ettim
public class BankaPersonel extends Kisi {
	private int PersonelID;
	//musteriler arraylisti olusturdum.
	ArrayList<Musteri> musteriler = new ArrayList<>();
	
	//Bankapersoneli yapýcý metodunu olusturdum.
	public BankaPersonel(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi) {
		super(tcKimlikNo,ad, soyad, email, telefonNumarasi);
		//ata sýnýftan aldýgý degýskenlerý super() ile aldým.
	}

	//Sýnýf içindeki deðiþkenlerin ve müþteri arraylistinin getter-setter metotlarýný oluþturdum.
	public int getPersonelID() {
		return PersonelID;
	}

	public void setPersonelID(int personelID) {
		PersonelID = personelID;
	}

	public ArrayList<Musteri> getMusteriler() {
		return musteriler;
	}

	public void setMusteri(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi, int musteriNumarasi) {
		musteriler.add(new Musteri(tcKimlikNo, ad, soyad, email, telefonNumarasi, musteriNumarasi));
	}
	@Override
	public String toString() {
		return "BankaPersonel [PersonelID=" + PersonelID + ", musteriler=" + musteriler + "]";
	}

}
