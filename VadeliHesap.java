package nyp_odev1;
//VadeliHesap s�n�f� BankaHesap s�n�f�ndan miras ald�g� icin extend ettim.
public class VadeliHesap extends BankaHesap{
	public String hesapTuru;
	protected double vadeliBakiye;
	public float faizOrani;
	
//VadeliHesap hesap i�in yap�c� metot
	public VadeliHesap(String hesapTuru, double vadeliBakiye, float faizOran�, long iban, double toplamBakiye, String hesapBilgisi) {
		super(iban, toplamBakiye, hesapBilgisi);
		this.hesapTuru=hesapTuru;
		this.vadeliBakiye=vadeliBakiye;
		this.faizOrani=faizOran�;	
	}

	@Override
	public String toString() {
		return "VadeliHesap [hesapTuru=" + hesapTuru + ", vadeliBakiye=" + vadeliBakiye + ", faizOrani=" + faizOrani+ "]";
	}

	//private tan�mlanan degiskenlerin getter-setter mototlar�
	public String getHesapTuru() {
		return hesapTuru;
	}

	public void setHesapTuru(String hesapTuru) {
		this.hesapTuru = hesapTuru;
	}

	protected double getVadeliBakiye() {
		return vadeliBakiye;
	}

	protected void setVadeliBakiye(double vadeliBakiye) {
		this.vadeliBakiye = vadeliBakiye;
	}

	public float getFaizOrani() {
		return faizOrani;
	}

	public void setFaizOrani(float faizOrani) {
		this.faizOrani = faizOrani;
	}
	
}
