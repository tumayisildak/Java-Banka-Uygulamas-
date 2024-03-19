package nyp_odev1;

public class KrediKarti {
	
	private long KartNumarasi;
	private double limit;
	private double guncelBorc;
	private double kullanilabilirLimit;
	KrediKarti kredikarti;
	
	public KrediKarti(long kartNumarasi, double limit, double guncelBorc, double kullanilabilirLimit) {
		KartNumarasi = kartNumarasi;
		this.limit = limit;
		this.guncelBorc = guncelBorc;
		this.kullanilabilirLimit=kullanilabilirLimit;
	}

	public void krediKartiEkle(long kartNumarasi, double limit) {
		this.KartNumarasi = kartNumarasi;
		this.limit = limit;
		kartNumarasi = (long)(Math.random()*10000000+55880040000L);
		kredikarti = new KrediKarti(kartNumarasi,limit,guncelBorc,kullanilabilirLimit);
		//krediKartlari.add(kredikarti);
		System.out.println("Vadeli Hesap baþarýyla eklendi.\n");
	}
	
	public void krediKartiSil(long kartNumarasi, double limit, double guncelBorc) {
		this.KartNumarasi = kartNumarasi;
		this.limit = limit;
		this.guncelBorc = guncelBorc;
	}
	
	public double kullanilabilirLimit(long kartNumarasi, double limit, double guncelBorc) {
		this.KartNumarasi = kartNumarasi;
		this.limit = limit;
		this.guncelBorc = guncelBorc;
		return (limit-guncelBorc);
	}

	@Override
	public String toString() {
		return "KrediKarti [KartNumarasi=" + KartNumarasi + ", limit=" + limit + ", guncelBorc=" + guncelBorc + "]";
	}

	public long getKartNumarasi() {
		return KartNumarasi;
	}

	public void setKartNumarasi(int kartNumarasi) {
		KartNumarasi = kartNumarasi;
	}

	public double getLimit() {
		return limit;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public double getGuncelBorc() {
		return guncelBorc;
	}

	public void setGuncelBorc(double guncelBorc) {
		this.guncelBorc = guncelBorc;
	}

	public double getKullanilabilirLimit() {
		return kullanilabilirLimit;
	}

	public void setKullanilabilirLimit(double kullanilabilirLimit) {
		this.kullanilabilirLimit = kullanilabilirLimit;
	}
	
	
}
