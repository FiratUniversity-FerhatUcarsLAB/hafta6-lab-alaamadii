/**
 * Ad Soyad: [Alaa Madi]
 * Öğrenci No: [240541609]
 * Proje: [university system grade calculator]
 * Tarih: [22/11/2025]
 */


import java.util.Scanner;

public class SinemaBileti {
    /*
     * check if the day is weekend 
     * the days are represented as numbers  1 to 7
     * 1: pazartesi
     */
    public boolean isWeekend(int gun){
        return (gun == 6 || gun ==7);

    }

     //matine show is before 12 pm
    public boolean isMatinee(int saat){
        return saat < 12;

    }


    public double calculateBasePrice(int gun, int saat){
        if (isMatinee(saat))
            return 45;
        else
            return 65;

    }



    /*
     * the discount is devided at this way 
     * if your age >= 65 it will be 30% , your age < 12 its 25%
     * for the student from day 1 to 4 (monday to thursday) you have 20% and betwen(friday to saturday) you have 15%
     * for ogretmen if day is wednesday (3) will be 35%
     */
    public double calculateDiscount(int yas, int meslek, int gun){

        // see the presentge of the discount according the age
        double discount = 0 ;
        if(yas >= 65)
            discount = 0.30;
        else if (yas < 12)
            discount =0.25;


        // see the discount presentge according the meslek
        switch (meslek) {
            //student case
            case 1:
                if (gun >= 1 && gun <= 4)
                    discount = Math.max(discount, 0.20);
                else
                    discount = Math.max(discount, 0.15);
                
                break;
        // for ogretmen case 
            case 2:
                if(gun == 3)
                    discount = Math.max(discount, 0.35);
                break;
        }
        return discount;

    } 

    /*
     * the plus price accordin to the film turu
     * 3: 3D  price+ 25,  3: IMAX price+ 35, 4: 4DX price+ 50.
     */
    public double getFormatExtra(int filmTuru){
        switch (filmTuru) {
            case 2:
                return 25;
            case 3:
                return 35;
            case 4:
                return 50;
            default:
                return 0;
        }       

    }
    
    //final result 
    public double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru){

        double base = calculateBasePrice(gun, saat);
        double discountRate = calculateDiscount(yas, meslek, gun);
        double formatExtra = getFormatExtra(filmTuru);

        double priceAfterDiscount = base - (base * discountRate);
        return priceAfterDiscount + formatExtra;

    }



    public void generateTicketInfo(int yas, int meslek, int filmTuru, int saat,int gun, double finalPrice){
        String[] gunler = {"Pazartesi", "Salı", "Çarşamba", "Perşembe", "Cuma", "Cumartesi", "Pazar"};
        String meslekStr = (meslek == 1) ? "Öğrenci" : (meslek == 2) ? "Öğretmen" : "Diğer";
        String formatStr = (filmTuru == 1) ? "2D" : (filmTuru == 2) ? "3D" : (filmTuru == 3) ? "IMAX" : "4DX";

        System.out.println("\n --- Bilet Bilgisi ---");
        System.out.println("Gün              : " + gunler[gun - 1]);
        System.out.println("Saat             : " + saat + ":00");
        System.out.println("Yaş              : " + yas);
        System.out.println("Meslek           : " + meslekStr);
        System.out.println("Film Formatı     : " + formatStr);
        System.out.println("-------------------------------");
        System.out.println(" Ödenecek Tutar: " + finalPrice + " TL");
    }








    // main method
    public static void main(String[] args){
        //create scanner object 
        Scanner input = new Scanner(System.in);
        //create an object of the class
        SinemaBileti tickBileti = new SinemaBileti();

        /*
         * taking inputs form the user 
         * the days as numbers 1 to 7 
         * the meslek as numbers 1: ogrenci 2: ogretmin 3: diger
         * the film turu is 1:2D 2:3D 3:IMAX
         */
        System.out.println("choose a gun bettwen 1 to 7 (1 is pazartesi)");
        int gun = input.nextInt();

        System.out.println("Enter the number of your meslek (1: ogrenci, 2: ogretmen, 3: diger)");
        int meslek = input.nextInt();

        System.out.println("Entr the Film type number you want (1: 2D , 2: 3D,  3: IMAX, 4: 4DX)");
        int filmTuru = input.nextInt();

        System.out.println("Enter you age: ");
        int yas = input.nextInt();

        System.out.println("Enter the hour you want the ticket on: ");
        int saat = input.nextInt();


        double finalPrice = tickBileti.calculateFinalPrice(gun, saat, yas, meslek, filmTuru);
        tickBileti.generateTicketInfo(yas, meslek, filmTuru, saat, gun, finalPrice);
    }
}
