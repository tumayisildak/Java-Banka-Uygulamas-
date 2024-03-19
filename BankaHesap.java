package nyp_odev1;

import java.util.Date;

public class BankaHesap {
	//degiskenleri private tanýmladým
	private long iban;
	private Date hesapAcilisTarih;
	private double toplamBakiye;
	private String hesapBilgisi;
	private double islemMiktar;
	private String hesapTuru;
	
	//BankaHesap için yapýcý metot
	public BankaHesap(long iban, double toplamBakiye, String hesapBilgisi) {
		this.iban=iban;
		this.toplamBakiye=toplamBakiye;
		this.hesapBilgisi=hesapBilgisi;
	}
	
	public void hesapGoruntuleme(int musteriNumarasi, String ad, String soyad,long iban, double toplamBakiye, String hesapBilgisi) {
		this.iban=iban;
		this.toplamBakiye=toplamBakiye;
		this.hesapBilgisi=hesapBilgisi;
	}

	@Override
	public String toString() {
		return "BankaHesap [iban=" + iban + ", hesapAcilisTarih=" + hesapAcilisTarih + ", toplamBakiye=" + toplamBakiye+ ", hesapBilgisi=" + hesapBilgisi + ", islemMiktar=" + islemMiktar + ", hesapTuru=" + hesapTuru + "]";
	}

	//private tanýmlanan degiskenlerin getter-setter mototlarý
	public long getIban() {
		return iban;
	}

	public void setIban(long iban) {
		this.iban = iban;
	}

	public Date getHesapAcilisTarih() {
		return hesapAcilisTarih;
	}

	public void setHesapAcilisTarih(Date hesapAcilisTarih) {
		this.hesapAcilisTarih = hesapAcilisTarih;
	}

	public double getToplamBakiye() {
		return toplamBakiye;
	}

	public void setToplamBakiye(double toplamBakiye) {
		this.toplamBakiye = toplamBakiye;
	}

	public String getHesapBilgisi() {
		return hesapBilgisi;
	}

	public void setHesapBilgisi(String hesapBilgisi) {
		this.hesapBilgisi = hesapBilgisi;
	}

	public double getIslemMiktar() {
		return islemMiktar;
	}

	public void setIslemMiktar(double islemMiktar) {
		this.islemMiktar = islemMiktar;
	}

	public String getHesapTuru() {
		return hesapTuru;
	}

	public void setHesapTuru(String hesapTuru) {
		this.hesapTuru = hesapTuru;
	}
	
	
	}


