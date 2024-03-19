package nyp_odev1;
//VadesizHesap sýnýfý BankaHesap sýnýfýndan miras aldýgý icin extend ettim.
public class VadesizHesap extends BankaHesap{
	public String hesapTuru;
	private double vadesizBakiye;
	//vadesiz hesap için yapýcý metot
	public VadesizHesap(String hesapTuru, double vadesizBakiye, long iban, double toplamBakiye, String hesapBilgisi){
		//BankaHesap sýnýfýnda tutulan degiskenler icin super() kullandým.
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
	//private tanýmlanan degiskenlerin getter-setter mototlarý
		public double getVadesizBakiye() {
		return vadesizBakiye;
	}

	public void setVadesizBakiye(double vadesizBakiye) {
		this.vadesizBakiye = vadesizBakiye;
	}



}
