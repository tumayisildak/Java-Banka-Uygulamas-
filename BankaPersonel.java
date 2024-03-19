package nyp_odev1;

import java.util.ArrayList;

//BankaPersonel s�n�f� kisi s�n�f�ndan miras ald�g� icin extend ettim
public class BankaPersonel extends Kisi {
	private int PersonelID;
	//musteriler arraylisti olusturdum.
	ArrayList<Musteri> musteriler = new ArrayList<>();
	
	//Bankapersoneli yap�c� metodunu olusturdum.
	public BankaPersonel(long tcKimlikNo, String ad, String soyad, String email, long telefonNumarasi) {
		super(tcKimlikNo,ad, soyad, email, telefonNumarasi);
		//ata s�n�ftan ald�g� deg�skenler� super() ile ald�m.
	}

	//S�n�f i�indeki de�i�kenlerin ve m��teri arraylistinin getter-setter metotlar�n� olu�turdum.
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
