package nyp_odev1;

public class Krediler {
	private int krediID;
	private double krediMiktari;
	private double taksitMiktar;
	
	public Krediler(int krediID,double krediMiktari, double taksitMiktar) {
		this.krediID = krediID;
		this.krediMiktari = krediMiktari;
		this.taksitMiktar = taksitMiktar;	
	}

	public void kampanya(KrediKarti limit) {
		
	}

	@Override
	public String toString() {
		return "Krediler [krediID=" + krediID + ", krediMiktari=" + krediMiktari + ", taksitMiktar=" + taksitMiktar+ "]";
	}

	public int getKrediID() {
		return krediID;
	}

	public void setKrediID(int krediID) {
		this.krediID = krediID;
	}

	public double getKrediMiktari() {
		return krediMiktari;
	}

	public void setKrediMiktari(double krediMiktari) {
		this.krediMiktari = krediMiktari;
	}

	public double getTaksitMiktar() {
		return taksitMiktar;
	}

	public void setTaksitMiktar(double taksitMiktar) {
		this.taksitMiktar = taksitMiktar;
	}
	
	


}
