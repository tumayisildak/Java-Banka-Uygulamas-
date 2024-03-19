package nyp_odev1;
//YatirimHesap s�n�f� BankaHesap s�n�f�ndan miras ald�g� icin extend ettim.
public class YatirimHesap extends BankaHesap{
	public String hesapTuru;
	private double yatirimBakiye;
	private String yatirimTuru;
	public float kur;
	
	//YatirimHesap hesap i�in yap�c� metot
	public YatirimHesap(String hesapTuru, double yatirimBakiye, String yatirimTuru, float kur,long iban, double toplamBakiye, String hesapBilgisi) {
		super(iban, toplamBakiye, hesapBilgisi);
		this.hesapTuru=hesapTuru;
		this.yatirimBakiye=yatirimBakiye;
		this.yatirimTuru=yatirimTuru;
		this.kur=kur;
	}
	//private degiskenler icin getter-setter metot
	public double getYatirimBakiye() {
		return yatirimBakiye;
	}
	public void setYatirimBakiye(double yatirimBakiye) {
		this.yatirimBakiye = yatirimBakiye;
	}
	public String getYatirimTuru() {
		return yatirimTuru;
	}
	public void setYatirimTuru(String yatirimTuru) {
		this.yatirimTuru = yatirimTuru;
	}
	public double paraEkle(int yatirimBakiye, String yatirimTuru, float kur) {
		return (0);
	}
	public double paraBoz(int yatirimBakiye, String yatirimTuru, float kur) {
		return 0;
	}

	@Override
	public String toString() {
		return "YatirimHesap [hesapTuru=" + hesapTuru + ", yatirimBakiye=" + yatirimBakiye + ", yatirimTuru=" + yatirimTuru + ", kur=" + kur + "]";
	}
	
	
}
