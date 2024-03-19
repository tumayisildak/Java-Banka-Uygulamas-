package nyp_odev1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) { 
		//Müsterileri tutmak için bir adet Banka personeli olusturdum.
		BankaPersonel personel1 = new BankaPersonel(30473295474L, "Tumay", "Isýldak", "tumayisildak@gmail.com",5316643775L);
		//Manuel 2 tane musteri olusturdum.
		personel1.setMusteri(207065654474L, "Murat", "Karaca", "karacamurat@gmail.com",5544564454L, 10);
		personel1.setMusteri(207065654474L, "Gizem", "Yaðcý", "gizemyaðcý@gmail.com",5248869571L, 11);

		Scanner input = new Scanner(System.in);
		//Ýþlemler için while dongusu
		while (true) {
			System.out.println("--------------------------------------------------------------------------------------------");
			System.out.println("Müþteri oluþturmak için 1'i tuþlayýnýz.");
			System.out.println("Müþteri bilgilerini görüntülemek için 2'yi tuþlayýnýz.");
			System.out.println("Normal Hesap eklemek için 3'ü tuþlayýnýz.");
			System.out.println("Maaþ Hesabý eklemek için 4'ü tuþlayýnýz.");
			System.out.println("Hesap silmek için 5'i tuþlayýnýz.");
			System.out.println("Hesabýnýza para eklemek için 6'yý tuþlayýnýz.");
			System.out.println("Hesabýnýzdan para cekmek için 7'yi tuþlayýnýz.");
			System.out.println("Para transfer etmek için 8'i tuþlayýnýz.");
			
			int x = input.nextInt();
			switch (x) {
				// kullanýcý bilgilerini ister ve müþteri oluþturur.
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
					System.out.println("Hesabýnýz baþarýyla oluþturulmuþtur. Müþteri numaranýz:" + musterino);
					break;
				//Müþteri numarasý girilen kiþinin bilgilerini, hesabýndaki bakiyelerini ve IBAN bilgilerini gösterir.
				case 2:
					System.out.println("Lütfen müþteri numaranýzý giriniz: ");
					int musno = input.nextInt();
					boolean varMi=false;
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						if (personel1.getMusteriler().get(i).getMusteriNumarasi() == musno) {
							System.out.println("Ad: " + personel1.getMusteriler().get(i).getAd());
							System.out.println("Soyad: " + personel1.getMusteriler().get(i).getSoyad());
							System.out.println("TC No: " + personel1.getMusteriler().get(i).getTcKimlikNo());
							System.out.println("E-mail: " + personel1.getMusteriler().get(i).getEmail());
							System.out.println("Telefon Numarasý: " + personel1.getMusteriler().get(i).getTelefonNumarasi());
							System.out.println("Vadesiz Hesap Bakiyesi: " + personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye() + " IBAN: "+ personel1.getMusteriler().get(i).vadesizhesap.getIban());
							if(personel1.musteriler.get(i).vadelihesap!=null)
								System.out.println("Vadeli Hesap Bakiyesi: " + personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye()+ " IBAN: "+ personel1.getMusteriler().get(i).vadelihesap.getIban());
							if(personel1.musteriler.get(i).yatirimhesap!=null)
								System.out.println("Yatýrým Hesap Bakiyesi: " + personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye()+ " IBAN: "+ personel1.getMusteriler().get(i).yatirimhesap.getIban());
							varMi=true;
							break;
						} 
					}
						if(varMi==false)
							System.out.println("Geçersiz müþteri numarasý!");
					break;
				//Hesap bilgisi Normal olan hesap ekler ve Müþteri sýnýfýndaki hesapEkle metotunu kullanýr.
				case 3:
					System.out.println("Lütfen Normal hesap eklemek için müþteri numaranýzý giriniz: ");
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
							System.out.println("Geçersiz müþteri numarasý!");
					break;
				//Hesap bilgisi Maaþ hesabý olan hesap ekler ve Müþteri sýnýfýndaki hesapEkle2 metotunu kullanýr.
				case 4:
					System.out.println("Lütfen Maaþ hesabý eklemek için müþteri numaranýzý giriniz: ");
					int musno3 = input.nextInt();
					boolean varMi3=false;
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						if (personel1.getMusteriler().get(i).getMusteriNumarasi() == musno3) {
							long iban = (long) (Math.random() * 10000000 + 350011000000L);
							double toplamBakiye = 0;
							personel1.getMusteriler().get(i).hesapEkle2(personel1.getMusteriler().get(i).getTcKimlikNo(),
									personel1.getMusteriler().get(i).getMusteriNumarasi(),
									personel1.getMusteriler().get(i).getAd(), personel1.getMusteriler().get(i).getSoyad(),
									iban, toplamBakiye, "Maaþ Hesabý");
							varMi3=true;
							break;
						} 
					}if(varMi3==false)
							System.out.println("Geçersiz müþteri numarasý!");
					break;
				//Girilen müþteri sýnýfýný hesapSil metotuna uygunsa siler.
				case 5:
					System.out.println("Lütfen hesap silmek için müþteri numaranýzý giriniz: ");
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
							System.out.println("Geçersiz müþteri numarasý!");
					break;
				//Girilen müþteri numarasýnýn hesaplarýndan seçilen hesabýna para ekler.
				case 6:
					System.out.println("Lütfen müþteri numaranýzý giriniz: ");
					int musno5 = input.nextInt();
					System.out.println("Para eklemek istediðiniz hesabý seçiniz:\n1)Vadesiz Hesap\n2)Vadeli Hesap\n3)Yatýrým Hesabý");
					int y = input.nextInt();	
					switch (y) {
						//vadesiz hesaba para eklemek için.
						case 1:
							boolean varMi5=false;
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5) {
									System.out.println("Yatýrmak istediðiniz miktarý giriniz:");
									double islembakiye = input.nextDouble();
									personel1.getMusteriler().get(i).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(i).paraYatir(personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye(),islembakiye));
									System.out.println("Yeni vadesiz hesap bakiyeniz:"+personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye());
									varMi5=true;
									break;
								}
							}if(varMi5==false) 
									System.out.println("Geçersiz müþteri numarasý!");
							break;
						//vadeli hesaba para eklemek için.
						case 2:
							boolean varMi6=false;
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5 && personel1.getMusteriler().get(i).vadelihesap==null) {
									System.out.println("Vadeli hesabýnýz bulunmamaktadýr!");
									varMi6=true;
									break;
								}
								else if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5 && personel1.getMusteriler().get(i).vadelihesap!=null ) {
									System.out.println("Yatýrmak istediðiniz miktarý giriniz:");
									double islembakiye = input.nextDouble();
									personel1.getMusteriler().get(i).vadelihesap.setVadeliBakiye(personel1.getMusteriler().get(i).paraYatir(personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye(),islembakiye));
									System.out.println("Yeni vadeli hesap bakiyeniz:"+personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye());
									varMi6=true;
									break;
								}
	
							}
							if(varMi6==false)
								System.out.println("Geçersiz müþteri numarasý!");
							break;
						//Yatýrým hesaba para eklemek için.
						case 3:
							boolean varMi7=false;
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5 && personel1.getMusteriler().get(i).yatirimhesap==null) {
									System.out.println("Yatýrým hesabýnýz bulunmamaktadýr!");
									varMi7=true;
									break;
								}

								else if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno5) {
									System.out.println("Döviz türü seçiniz\n1)Dolar\n2)Euro\n3)Altýn");
									int dovizsecim=input.nextInt();
									double dolar=19.48;
									double euro=21.46;
									double altin=1287.14;
									varMi7=true;
									//döviz türüne göre kur hesabý yapýp para ekler.
									switch(dovizsecim) {
										case 1:
											System.out.println("Yatýrmak istediðiniz dolar miktarýný giriniz:");
											double islembakiye = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizYatir(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye,dolar));
											System.out.println("Yeni yatýrým hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										case 2:
											System.out.println("Yatýrmak istediðiniz euro miktarýný giriniz:");
											double islembakiye2 = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizYatir(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye2,euro));
											System.out.println("Yeni yatýrým hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										case 3:
											System.out.println("Yatýrmak istediðiniz altýn gramýný giriniz:");
											double islembakiye3 = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizYatir(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye3,altin));
											System.out.println("Yeni yatýrým hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										default:
											System.out.println("Gecersiz iþlem!");
										break;
									}
									break;
								}
	
							}if(varMi7==false)
									System.out.println("Geçersiz müþteri numarasý!");
							default:
								System.out.println("Geçersiz iþlem!");
							break;
					}
					break;
				case 7:
					//Girilen müþteri numarasýnýn hesaplarýndan seçilen hesabýndan para çeker.
					System.out.println("Lütfen müþteri numaranýzý giriniz: ");
					int musno6 = input.nextInt();
					System.out.println("Para cekmek istediðiniz hesabý seçiniz:\n1)Vadesiz Hesap\n2)Vadeli Hesap\n3)Yatýrým Hesabý");
					int z = input.nextInt();	
					switch (z) {
						//vadesiz hesaptan para çekmek için.
						case 1:
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6) {
									System.out.println("Cekmek istediðiniz miktarý giriniz:");
									double islembakiye = input.nextDouble();
									personel1.getMusteriler().get(i).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(i).paraCek(personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye(),islembakiye));
									System.out.println("Yeni vadesiz hesap bakiyeniz:"+personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye());
									break;
								}
								else 
									System.out.println("Geçersiz müþteri numarasý!");
									break;
								
							}
							break;
						//vadeli hesaptan para çekmek için.
						case 2:
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6 && personel1.getMusteriler().get(i).vadelihesap==null) {
									System.out.println("Vadeli hesabýnýz bulunmamaktadýr!");
									break;
								}
								else if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6 && personel1.getMusteriler().get(i).vadelihesap!=null ) {
									System.out.println("Cekmek istediðiniz miktarý giriniz:");
									double islembakiye = input.nextDouble();
									personel1.getMusteriler().get(i).vadelihesap.setVadeliBakiye(personel1.getMusteriler().get(i).paraCek(personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye(),islembakiye));
									System.out.println("Yeni vadeli hesap bakiyeniz:"+personel1.getMusteriler().get(i).vadelihesap.getVadeliBakiye());
									break;
								}
								
								else 
									System.out.println("Geçersiz müþteri numarasý!");
									break;
								
							}
							break;
						//Yatýrým hesabýndan para çekmek için.
						case 3:
							for (int i = 0; i < personel1.musteriler.size(); i++) {
								if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6 && personel1.getMusteriler().get(i).yatirimhesap==null) {
									System.out.println("Yatýrým hesabýnýz bulunmamaktadýr!");
									break;
								}

								else if(personel1.getMusteriler().get(i).getMusteriNumarasi() == musno6 && personel1.getMusteriler().get(i).yatirimhesap!=null) {
									System.out.println("Döviz türü seçiniz\n1)Dolar\n2)Euro\n3)Altýn");
									int dovizsecim=input.nextInt();
									double dolar=19.48;
									double euro=21.46;
									double altin=1287.14;
									//döviz türüne göre kur hesabý yapýp para eksiltir.
									switch(dovizsecim) {
										case 1:
											System.out.println("Bozdurmak istediðiniz dolar miktarýný giriniz:");
											double islembakiye = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizBoz(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye,dolar));
											System.out.println("Yeni yatýrým hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										case 2:
											System.out.println("Bozdurmak istediðiniz euro miktarýný giriniz:");
											double islembakiye2 = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizBoz(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye2,euro));
											System.out.println("Yeni yatýrým hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
										case 3:
											System.out.println("Bozdurmak istediðiniz altýn gramýný giriniz:");
											double islembakiye3 = input.nextDouble();
											personel1.getMusteriler().get(i).yatirimhesap.setYatirimBakiye(personel1.getMusteriler().get(i).dovizBoz(personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye(),islembakiye3,altin));
											System.out.println("Yeni yatýrým hesap bakiyeniz:"+personel1.getMusteriler().get(i).yatirimhesap.getYatirimBakiye());
											break;
									}
									break;
								}
								else 
									System.out.println("Geçersiz müþteri numarasý!");
									break;
								
							}
							break;
						default:
							System.out.println("Geçersiz iþlem");
							break;
					}
					break;
				//Ibanlarý kullanýcdan alýnan hesaplar arasý para transferi.
				case 8:
					//MEVCUT hesaplarýn Ibanlarýný yazdýrýr.
					System.out.println("Mevcut IBAN listesi");	
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						if(personel1.musteriler.get(i).vadesizhesap!=null)
							System.out.println("Müþteri Adý Soyadý: "+ personel1.musteriler.get(i).getAd()+" "+personel1.musteriler.get(i).getSoyad()+ " / Hesap türü: Vadesiz Hesap / IBAN: " + personel1.musteriler.get(i).vadesizhesap.getIban());
							if(personel1.musteriler.get(i).vadelihesap!=null)
								System.out.println("Müþteri Adý Soyadý: "+ personel1.musteriler.get(i).getAd()+" "+personel1.musteriler.get(i).getSoyad()+ " / Hesap türü: Vadeli Hesap / IBAN: " + personel1.musteriler.get(i).vadelihesap.getIban());
							if(personel1.musteriler.get(i).yatirimhesap!=null)
								System.out.println("Müþteri Adý Soyadý: "+ personel1.musteriler.get(i).getAd()+" "+personel1.musteriler.get(i).getSoyad()+ " / Hesap türü: Yatýrým Hesap / IBAN: " + personel1.musteriler.get(i).yatirimhesap.getIban());}
					System.out.println("Gönderici IBAN bilgisini giriniz:");
					int iban1 = input.nextInt();
					System.out.println("Alýcý IBAN bilgisini giriniz:");
					int iban2 = input.nextInt();
					for (int i = 0; i < personel1.musteriler.size(); i++) {
						for(int j=0;j<personel1.musteriler.size(); j++) {
							if(personel1.musteriler.get(i).vadesizhesap.getIban()==iban1 && personel1.musteriler.get(j).vadesizhesap.getIban()==iban2) {			
									System.out.println("Transfer etmek istediðiniz miktarý giriniz: ");
									double transfer = input.nextDouble();
									personel1.getMusteriler().get(i).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(i).paraCek(personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye(),transfer));
									personel1.getMusteriler().get(j).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(j).paraYatir(personel1.getMusteriler().get(j).vadesizhesap.getVadesizBakiye(),transfer));
									System.out.println("Transfer baþarýlý...Para çýkýþý sonrasý yeni bakiyeniz:"+personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye());
	
						}
							/*else if(personel1.getMusteriler().get(i).vadesizhesap.getIban()==iban1 && personel1.getMusteriler().get(j).vadelihesap.getIban()==iban2) {			
								System.out.println("Transfer etmek istediðiniz miktarý giriniz: ");
								double transfer = input.nextDouble();
								personel1.getMusteriler().get(i).vadesizhesap.setVadesizBakiye(personel1.getMusteriler().get(i).paraCek(personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye(),transfer));
								personel1.getMusteriler().get(j).vadelihesap.setVadeliBakiye(personel1.getMusteriler().get(j).paraYatir(personel1.getMusteriler().get(j).vadelihesap.getVadeliBakiye(),transfer));
								System.out.println("Transfer baþarýlý...Para çýkýþý sonrasý yeni bakiyeniz:"+personel1.getMusteriler().get(i).vadesizhesap.getVadesizBakiye());

					}*/
							}
	
			}
				default:
					//System.out.println("Geçersiz Ýþlem!");
					break;
		}
	}
}}
