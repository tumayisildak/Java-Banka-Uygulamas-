package nyp_odev1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		//M�sterileri tutmak i�in bir adet Banka personeli olusturdum.
		BankaPersonel personel1 = new BankaPersonel(30473295474L, "Tumay", "Is�ldak", "tumayisildak@gmail.com",5316643775L);
		//Manuel 2 tane musteri olusturdum.
		personel1.setMusteri(207065654474L, "Murat", "Karaca", "karacamurat@gmail.com",5544564454L, 10);
		personel1.setMusteri(207065654474L, "Gizem", "Ya�c�", "gizemya�c�@gmail.com",5248869571L, 11);

		Scanner input = new Scanner(System.in);
		//��lemler i�in while dongusu
		while (true) {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("M��teri olu�turmak i�in 1'i tu�lay�n�z.");
			System.out.println("M��teri bilgilerini g�r�nt�lemek i�in 2'yi tu�lay�n�z.");
			System.out.println("Normal Hesap eklemek i�in 3'� tu�lay�n�z.");
			System.out.println("Maa� Hesab� eklemek i�in 4'� tu�lay�n�z.");
			System.out.println("Hesap silmek i�in 5'i tu�lay�n�z.");
			System.out.println("Hesab�n�za para eklemek i�in 6'y� tu�lay�n�z.");
			System.out.println("Hesab�n�zdan para cekmek i�in 7'yi tu�lay�n�z.");
			System.out.println("Para transfer etmek i�in 8'i tu�lay�n�z.");
			
			int x = input.nextInt();
			switch (x) {
				// kullan�c� bilgilerini ister ve m��teri olu�turur.
				case 1:
					System.out.println("TC No giriniz:");
					long tc = input.nextLong();
					System.out.println("Ad giriniz:");
					String ad = input.next();
					System.out.println("Soyad giriniz:");
					String soyad = input.next();
					System.out.println("email giriniz:");
					String mail = input.next();
					System.out.println("telefon no giriniz:");
					long tel = input.nextLong();
					int musterino = (int) (Math.random() * 10000 + 1);
					Musteri musteri = new Musteri(tc, ad, soyad, mail, tel, musterino);
					personel1.setMusteri(tc, ad, soyad, mail, tel, musterino);
					System.out.println("Hesab�n�z ba�ar�yla olu�turulmu�tur. M��teri numaran�z:" + musterino);
					break;
				//M��teri numaras� girilen ki�inin bilgilerini, hesab�ndaki bakiyelerini ve IBAN bilgilerini g�sterir.
				case 2:
					System.out.println("L�tfen m��teri numaran�z� giriniz: ");
					int musno = input.nextInt();
					boolean varMi=false;
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						if (personel1.getMusteriler().get(i).getMusteriNumarasi() == musno) {
							System.out.println("Ad: " + personel1.getMusteriler().get(i).getAd());
							System.out.println("Soyad: " + personel1.getMusteriler().get(i).getSoyad());
							System.out.println("TC No: " + personel1.getMusteriler().get(i).getTcKimlikNo());
							System.out.println("E-mail: " + personel1.getMusteriler().get(i).getEmail());
							System.out.println("Telefon Numaras�: " + personel1.getMusteriler().get(i).getTelefonNumarasi());
							System.out.println("Vadesiz Hesap Bakiyesi: " + personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye() + " IBAN: "+ personel1.getMusteriler().get(i).vadesizhesap.getIban());
							if(personel1.musteriler.get(i).vadelihesap!=null)
								System.out.println("Vadeli Hesap Bakiyesi: " + personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye()+ " IBAN: "+ personel1.getMusteriler().get(i).vadelihesap.getIban());
							if(personel1.musteriler.get(i).yatirimhesap!=null)
								System.out.println("Yat�r�m Hesap Bakiyesi: " + personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye()+ " IBAN: "+ personel1.getMusteriler().get(i).yatirimhesap.getIban());
							varMi=true;
							break;
						} 
					}
						if(varMi==false)
							System.out.println("Ge�ersiz m��teri numaras�!");
					break;
				//Hesap bilgisi Normal olan hesap ekler ve M��teri s�n�f�ndaki hesapEkle metotunu kullan�r.
				case 3:
					System.out.println("L�tfen Normal hesap eklemek i�in m��teri numaran�z� giriniz: ");
					int musno2 = input.nextInt();
					boolean varMi2=false;
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						if (personel1.getMusteriler().get(i).getMusteriNumarasi() == musno2) {
							long iban = (long) (Math.random() * 10000000 + 350011000000L);
							double toplamBakiye = 0;
							personel1.getMusteriler().get(i).hesapEkle(personel1.getMusteriler().get(i).getTcKimlikNo(),
									personel1.getMusteriler().get(i).getMusteriNumarasi(),
									personel1.getMusteriler().get(i).getAd(), personel1.getMusteriler().get(i).getSoyad(),
									iban, toplamBakiye, "Normal Hesap");
							varMi2=true;
							break;
						}	
					}if(varMi2==false)
							System.out.println("Ge�ersiz m��teri numaras�!");
					break;
				//Hesap bilgisi Maa� hesab� olan hesap ekler ve M��teri s�n�f�ndaki hesapEkle2 metotunu kullan�r.
				case 4:
					System.out.println("L�tfen Maa� hesab� eklemek i�in m��teri numaran�z� giriniz: ");
					int musno3 = input.nextInt();
					boolean varMi3=false;
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						if (personel1.getMusteriler().get(i).getMusteriNumarasi() == musno3) {
							long iban = (long) (Math.random() * 10000000 + 350011000000L);
							double toplamBakiye = 0;
							personel1.getMusteriler().get(i).hesapEkle2(personel1.getMusteriler().get(i).getTcKimlikNo(),
									personel1.getMusteriler().get(i).getMusteriNumarasi(),
									personel1.getMusteriler().get(i).getAd(), personel1.getMusteriler().get(i).getSoyad(),
									iban, toplamBakiye, "Maa� Hesab�");
							varMi3=true;
							break;
						} 
					}if(varMi3==false)
							System.out.println("Ge�ersiz m��teri numaras�!");
					break;
				//Girilen m��teri s�n�f�n� hesapSil metotuna uygunsa siler.
				case 5:
					System.out.println("L�tfen hesap silmek i�in m��teri numaran�z� giriniz: ");
					int musno4 = input.nextInt();
					boolean varMi4=false;
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						if (personel1.getMusteriler().get(i).getMusteriNumarasi() == musno4) {
							personel1.getMusteriler().get(i).hesapSil(personel1.getMusteriler().get(i).getTcKimlikNo(),
									personel1.getMusteriler().get(i).getMusteriNumarasi(),
									personel1.getMusteriler().get(i).getAd(), personel1.getMusteriler().get(i).getSoyad());
							varMi4=true;
							break;
						} 
					}if(varMi4==false)
							System.out.println("Ge�ersiz m��teri numaras�!");
					break;
				//Girilen m��teri numaras�n�n hesaplar�ndan se�ilen hesab�na para ekler.
				case 6:
					System.out.println("L�tfen m��teri numaran�z� giriniz: ");
					int musno5 = input.nextInt();
					System.out.println("Para eklemek istedi�iniz hesab� se�iniz:\n1)Vadesiz Hesap\n2)Vadeli Hesap\n3)Yat�r�m Hesab�");
					int y = input.nextInt();	
					switch (y) {
						//vadesiz hesaba para eklemek i�in.
						case 1:
							boolean varMi5=false;
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5) {
									System.out.println("Yat�rmak istedi�iniz miktar� giriniz:");
									double islembakiye = input.nextDouble();
									personel1.getMusteriler().get(i).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(i).paraYatir(personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye(),islembakiye));
									System.out.println("Yeni vadesiz hesap bakiyeniz:"+personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye());
									varMi5=true;
									break;
								}
							}if(varMi5==false) 
									System.out.println("Ge�ersiz m��teri numaras�!");
							break;
						//vadeli hesaba para eklemek i�in.
						case 2:
							boolean varMi6=false;
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5 && personel1.getMusteriler().get(i).vadelihesap==null) {
									System.out.println("Vadeli hesab�n�z bulunmamaktad�r!");
									varMi6=true;
									break;
								}
								else if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5 && personel1.getMusteriler().get(i).vadelihesap!=null ) {
									System.out.println("Yat�rmak istedi�iniz miktar� giriniz:");
									double islembakiye = input.nextDouble();
									personel1.getMusteriler().get(i).vadelihesap.setVadeliBakiye(personel1.getMusteriler().get(i).paraYatir(personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye(),islembakiye));
									System.out.println("Yeni vadeli hesap bakiyeniz:"+personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye());
									varMi6=true;
									break;
								}
	
							}
							if(varMi6==false)
								System.out.println("Ge�ersiz m��teri numaras�!");
							break;
						//Yat�r�m hesaba para eklemek i�in.
						case 3:
							boolean varMi7=false;
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5 && personel1.getMusteriler().get(i).yatirimhesap==null) {
									System.out.println("Yat�r�m hesab�n�z bulunmamaktad�r!");
									varMi7=true;
									break;
								}

								else if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5) {
									System.out.println("D�viz t�r� se�iniz\n1)Dolar\n2)Euro\n3)Alt�n");
									int dovizsecim=input.nextInt();
									double dolar=19.48;
									double euro=21.46;
									double altin=1287.14;
									varMi7=true;
									//d�viz t�r�ne g�re kur hesab� yap�p para ekler.
									switch(dovizsecim) {
										case 1:
											System.out.println("Yat�rmak istedi�iniz dolar miktar�n� giriniz:");
											double islembakiye = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizYatir(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye,dolar));
											System.out.println("Yeni yat�r�m hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										case 2:
											System.out.println("Yat�rmak istedi�iniz euro miktar�n� giriniz:");
											double islembakiye2 = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizYatir(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye2,euro));
											System.out.println("Yeni yat�r�m hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										case 3:
											System.out.println("Yat�rmak istedi�iniz alt�n gram�n� giriniz:");
											double islembakiye3 = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizYatir(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye3,altin));
											System.out.println("Yeni yat�r�m hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										default:
											System.out.println("Gecersiz i�lem!");
										break;
									}
									break;
								}
	
							}if(varMi7==false)
									System.out.println("Ge�ersiz m��teri numaras�!");
							default:
								System.out.println("Ge�ersiz i�lem!");
							break;
					}
					break;
				case 7:
					//Girilen m��teri numaras�n�n hesaplar�ndan se�ilen hesab�ndan para �eker.
					System.out.println("L�tfen m��teri numaran�z� giriniz: ");
					int musno6 = input.nextInt();
					System.out.println("Para cekmek istedi�iniz hesab� se�iniz:\n1)Vadesiz Hesap\n2)Vadeli Hesap\n3)Yat�r�m Hesab�");
					int z = input.nextInt();	
					switch (z) {
						//vadesiz hesaptan para �ekmek i�in.
						case 1:
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6) {
									System.out.println("Cekmek istedi�iniz miktar� giriniz:");
									double islembakiye = input.nextDouble();
									personel1.getMusteriler().get(i).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(i).paraCek(personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye(),islembakiye));
									System.out.println("Yeni vadesiz hesap bakiyeniz:"+personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye());
									break;
								}
								else 
									System.out.println("Ge�ersiz m��teri numaras�!");
									break;
								
							}
							break;
						//vadeli hesaptan para �ekmek i�in.
						case 2:
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6 && personel1.getMusteriler().get(i).vadelihesap==null) {
									System.out.println("Vadeli hesab�n�z bulunmamaktad�r!");
									break;
								}
								else if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6 && personel1.getMusteriler().get(i).vadelihesap!=null ) {
									System.out.println("Cekmek istedi�iniz miktar� giriniz:");
									double islembakiye = input.nextDouble();
									personel1.getMusteriler().get(i).vadelihesap.setVadeliBakiye(personel1.getMusteriler().get(i).paraCek(personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye(),islembakiye));
									System.out.println("Yeni vadeli hesap bakiyeniz:"+personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye());
									break;
								}
								
								else 
									System.out.println("Ge�ersiz m��teri numaras�!");
									break;
								
							}
							break;
						//Yat�r�m hesab�ndan para �ekmek i�in.
						case 3:
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6 && personel1.getMusteriler().get(i).yatirimhesap==null) {
									System.out.println("Yat�r�m hesab�n�z bulunmamaktad�r!");
									break;
								}

								else if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6 && personel1.getMusteriler().get(i).yatirimhesap!=null) {
									System.out.println("D�viz t�r� se�iniz\n1)Dolar\n2)Euro\n3)Alt�n");
									int dovizsecim=input.nextInt();
									double dolar=19.48;
									double euro=21.46;
									double altin=1287.14;
									//d�viz t�r�ne g�re kur hesab� yap�p para eksiltir.
									switch(dovizsecim) {
										case 1:
											System.out.println("Bozdurmak istedi�iniz dolar miktar�n� giriniz:");
											double islembakiye = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizBoz(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye,dolar));
											System.out.println("Yeni yat�r�m hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										case 2:
											System.out.println("Bozdurmak istedi�iniz euro miktar�n� giriniz:");
											double islembakiye2 = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizBoz(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye2,euro));
											System.out.println("Yeni yat�r�m hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										case 3:
											System.out.println("Bozdurmak istedi�iniz alt�n gram�n� giriniz:");
											double islembakiye3 = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizBoz(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye3,altin));
											System.out.println("Yeni yat�r�m hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
									}
									break;
								}
								else 
									System.out.println("Ge�ersiz m��teri numaras�!");
									break;
								
							}
							break;
						default:
							System.out.println("Ge�ersiz i�lem");
							break;
					}
					break;
				//Ibanlar� kullan�cdan al�nan hesaplar aras� para transferi.
				case 8:
					//MEVCUT hesaplar�n Ibanlar�n� yazd�r�r.
					System.out.println("Mevcut IBAN listesi");	
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						if(personel1.musteriler.get(i).vadesizhesap!=null)
							System.out.println("M��teri Ad� Soyad�: "+ personel1.musteriler.get(i).getAd()+" "+personel1.musteriler.get(i).getSoyad()+ " / Hesap t�r�: Vadesiz Hesap / IBAN: " + personel1.musteriler.get(i).vadesizhesap.getIban());
							if(personel1.musteriler.get(i).vadelihesap!=null)
								System.out.println("M��teri Ad� Soyad�: "+ personel1.musteriler.get(i).getAd()+" "+personel1.musteriler.get(i).getSoyad()+ " / Hesap t�r�: Vadeli Hesap / IBAN: " + personel1.musteriler.get(i).vadelihesap.getIban());
							if(personel1.musteriler.get(i).yatirimhesap!=null)
								System.out.println("M��teri Ad� Soyad�: "+ personel1.musteriler.get(i).getAd()+" "+personel1.musteriler.get(i).getSoyad()+ " / Hesap t�r�: Yat�r�m Hesap / IBAN: " + personel1.musteriler.get(i).yatirimhesap.getIban());}
					System.out.println("G�nderici IBAN bilgisini giriniz:");
					int iban1 = input.nextInt();
					System.out.println("Al�c� IBAN bilgisini giriniz:");
					int iban2 = input.nextInt();
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						for(int j=0;j<personel1.musteriler.size(); j++) {
							if(personel1.musteriler.get(i).vadesizhesap.getIban()==iban1 && personel1.musteriler.get(j).vadesizhesap.getIban()==iban2) {			
									System.out.println("Transfer etmek istedi�iniz miktar� giriniz: ");
									double transfer = input.nextDouble();
									personel1.getMusteriler().get(i).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(i).paraCek(personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye(),transfer));
									personel1.getMusteriler().get(j).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(j).paraYatir(personel1.getMusteriler().get(j).vadesizhesap.getVadesizBakiye(),transfer));
									System.out.println("Transfer ba�ar�l�...Para ��k��� sonras� yeni bakiyeniz:"+personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye());
	
						}
							/*else if(personel1.getMusteriler().get(i).vadesizhesap.getIban()==iban1 && personel1.getMusteriler().get(j).vadelihesap.getIban()==iban2) {			
								System.out.println("Transfer etmek istedi�iniz miktar� giriniz: ");
								double transfer = input.nextDouble();
								personel1.getMusteriler().get(i).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(i).paraCek(personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye(),transfer));
								personel1.getMusteriler().get(j).vadelihesap.setVadeliBakiye(personel1.getMusteriler().get(j).paraYatir(personel1.getMusteriler().get(j).vadelihesap.getVadeliBakiye(),transfer));
								System.out.println("Transfer ba�ar�l�...Para ��k��� sonras� yeni bakiyeniz:"+personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye());

					}*/
							}
	
			}
				default:
					//System.out.println("Ge�ersiz ��lem!");
					break;
		}
	}
}}
