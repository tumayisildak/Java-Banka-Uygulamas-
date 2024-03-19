package nyp_odev1;
//VadeliHesap sýnýfý BankaHesap sýnýfýndan miras aldýgý icin extend ettim.
public class VadeliHesap extends BankaHesap{
	public String hesapTuru;
	protected double vadeliBakiye;
	public float faizOrani;
	
//VadeliHesap hesap için yapýcý metot
	public VadeliHesap(String hesapTuru, double vadeliBakiye, float faizOraný, long iban, double toplamBakiye, String hesapBilgisi) {
		super(iban, toplamBakiye, hesapBilgisi);
		this.hesapTuru=hesapTuru;
		this.vadeliBakiye=vadeliBakiye;
		this.faizOrani=faizOraný;	
	}

	@Override
	public String toString() {
		return "VadeliHesap [hesapTuru=" + hesapTuru + ", vadeliBakiye=" + vadeliBakiye + ", faizOrani=" + faizOrani+ "]";
	}

	//private tanýmlanan degiskenlerin getter-setter mototlarý
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
