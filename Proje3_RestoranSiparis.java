/**
 * Ad Soyad: [Alaa Madi]
 * Öğrenci No: [240541609]
 * Proje: [university system grade calculator]
 * Tarih: [22/11/2025]
 */






import java.util.Scanner;
public class RestoranSiparis {
    /*
     * this is the main menu the prices are in TL
     * izgara tavuk: 85 TL, Adana Kebap 120 TL, levrek 110 TL, Manti 65 TL
     */
    public double getMainDishPrice(int secim){
        switch (secim) {
            case 1:
                return 85;
            case 2:
                return 120;
            case 3:
                return 110;
            case 4:
                return 65;
            default:
                return 0;
        }
    }

    /*
     * this is the Baslangiclar 
     *  1 = Corba:25 TL, 2 = Humus:45 TL, 3 = sigara Boregi 55 TL
     */
    public double getAppetizerPrice(int secim){
        switch (secim) {
            case 1:
                return 25;
            case 2:
                return 45;
            case 3:
                return 55;
        
            default:
                return 0;
        }
    }
     /*
      * the drink prices 
      1= Kola : 15TL, 2= Ayran : 12TL, 3= Meyve Suyu: 35TL, 4= Limonata : 25TL 
      */

    public double getDrinkPrice(int secim){
        switch (secim) {
            case 1:
                return 15;
            case 2:
                return 12;
            case 3:
                return 35;
            case 4:
                return 25;
        
            default:
                return 0;
        }
    }
    /*
     * the dessert prices
     * 1= Kunefe : 65TL, 2= Baklava : 55TL, 3= Sutlac :35TL
     */

    public double getDessertPrice(int secim){
        switch (secim){
            case 1: 
                return 65;
            case 2:
                return 55;
            case 3:
                return 35;
            default:
                return 0;
        }
    }

    // check if the order is combo order
    public boolean isComboOrder(int anaVar, int icecekVar, int tatliVar){
        return (anaVar > 0  && icecekVar > 0 && tatliVar > 0);

    }

    

    // check if this houre is bettwen 14 to 17 so 20% indirim var
    public boolean isHappyHour(int saat){
        return (saat >= 14 && saat < 17);

    }



    /*
     * calculating the discount sum
     * for combo orders 15% 
     * for  above 200 TL orders 10% indirim
     * in the happy hours which is (14:00 to 17:00) iceceklerde 20% 
     * for the students 10% in the weekdays (monday to friday)
     * bahsis is 10%
     */

    public double calculateDiscount(double subTotal, boolean combo, boolean ogrenci, int gun){
            double discountAmount = 0;
            // combo 15% 
            if(combo){
                discountAmount += subTotal * 0.15;
            }
            // for student 10% in weekdays
            if (ogrenci && (gun >= 1 && gun <= 5)){
                discountAmount += subTotal * 0.10;
            }
            // for above 200 TL orders 105
            if (subTotal > 200){
                discountAmount += subTotal * 0.10;
            }

            return discountAmount;


            
    }

    // service tip is 10%(bahsis)
    public double calculateServiceTip(double netTutar){
        return netTutar * 0.10;

    }

    //happy meal icin indirim (privet class)
    private double applyHappyHourToDrink(double drinkPrice, int saat){
        if(isHappyHour(saat)){
            return drinkPrice * (1 - 0.20);
        }else{
            return drinkPrice;
        }
    }




    


    //main method
    public static void main(String[] args){
        //create object for input scanner
        Scanner input = new Scanner(System.in);
        RestoranSiparis sys = new RestoranSiparis();

        System.out.println("=== Akilli Restoran Siparis Sistemi ===");


        System.out.println("Gun sec (1=Pzt . . . 7=Paz)");
        int gun = input.nextInt();

        System.out.println(" saat gir ( 0 - 23)");
        int saat = input.nextInt();
        

        System.out.println("Ana yemek seç: 1=Izgara Tavuk(85), 2=Adana Kebap(120), 3=Levrek(110), 4=Manti(65), 0=Yok");
        int anaVar = input.nextInt();
        double anaFiyat = sys.getMainDishPrice(anaVar);


        System.out.println("Başlangiç seç: 1=Çorba(25), 2=Humus(45), 3=Sigara Böreği(55), 0=Yok");
        int baslangicVar = input.nextInt();
        double basFiyat = sys.getAppetizerPrice(baslangicVar);


        System.out.println("İçecek seç: 1=Kola(15), 2=Ayran(12), 3=Meyve Suyu(35), 4=Limonata(25), 0=Yok");
        int icecekVar = input.nextInt();
        double icecekFiyat = sys.getDrinkPrice(icecekVar);
        // happy hour iceck indirim 
        double icecekAfterHH = sys.applyHappyHourToDrink(icecekFiyat, saat);

         //tatli sec
        System.out.println("Tatli seç: 1=Künefe(65), 2=Baklava(55), 3=Sütlaç(35), 0=Yok");
        int tatli = input.nextInt();
        double tatliFiyat = sys.getDessertPrice(tatli);

        //ogrenci mi
        System.out.println("Ogrenci misin (1: Evet, 0: Hayir)");
        int ogrenciInput = input.nextInt();
        boolean ogrenci = (ogrenciInput == 1);

        //hesaplama
        boolean combo = sys.isComboOrder(anaVar, icecekVar, tatli);
         //sutotal = ana + bas + icecek + tatli
        double subTotal = anaFiyat + basFiyat + icecekAfterHH + tatliFiyat;

        //indirim hesaplama
        double discount = sys.calculateDiscount(subTotal, combo, ogrenci, gun);

        double afterDiscount = subTotal - discount;


                double tip = sys.calculateServiceTip(afterDiscount);

        // toplam ödenecek
        double total = afterDiscount + tip;

        // Çıktı
        System.out.println("\n--- Sipariş Özeti ---");
        System.out.printf("Ana yemek fiyati: %.2f TL\n", anaFiyat);
        System.out.printf("Başlangiç fiyati: %.2f TL\n", basFiyat);
        System.out.printf("İçecek fiyati (HH uygulanmiş): %.2f TL\n", icecekAfterHH);
        System.out.printf("Tatli fiyati: %.2f TL\n", tatliFiyat);
        System.out.printf("Ara toplam (subtotal): %.2f TL\n", subTotal);
        System.out.printf("Toplam indirim: -%.2f TL\n", discount);
        System.out.printf("İndirim sonrasi: %.2f TL\n", afterDiscount);
        System.out.printf("Önerilen servis bahşişi (%%10): %.2f TL\n", tip);
        System.out.printf("Ödenecek toplam: %.2f TL\n", total);

    }




    
}
