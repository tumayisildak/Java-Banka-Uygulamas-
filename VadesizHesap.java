package nyp_odev1;
//VadesizHesap s�n�f� BankaHesap s�n�f�ndan miras ald�g� icin extend ettim.
public class VadesizHesap extends BankaHesap{
	public String hesapTuru;
	private double vadesizBakiye;
	//vadesiz hesap i�in yap�c� metot
	public VadesizHesap(String hesapTuru, double vadesizBakiye, long iban, double toplamBakiye, String hesapBilgisi){
		//BankaHesap s�n�f�nda tutulan degiskenler icin super() kulland�m.
		super(iban, toplamBakiye, hesapBilgisi);
		this.hesapTuru=hesapTuru;
		this.vadesizBakiye=vadesizBakiye;
	}
	
	public double paraYatir(double vadesizBakiye, double islemMiktar) {
		return (vadesizBakiye+islemMiktar);
	}
	public double krediKartiBorcOdeme(double vadesizBakiye, KrediKarti guncelBorc) {
		return 0;
	}
	public double krediOdeme(int krediID, Krediler krediMiktari, Krediler taksitMiktari) {
		return 0;
	}

	@Override
	public String toString() {
		return "VadesizHesap [hesapTuru=" + hesapTuru + ", vadesizBakiye=" + vadesizBakiye + "]";
	}
	//private tan�mlanan degiskenlerin getter-setter mototlar�
		public double getVadesizBakiye() {
		return vadesizBakiye;
	}

	public void setVadesizBakiye(double vadesizBakiye) {
		this.vadesizBakiye = vadesizBakiye;
	}



}
