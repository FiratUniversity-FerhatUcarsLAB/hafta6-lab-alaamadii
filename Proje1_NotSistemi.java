/**
 * Ad Soyad: [Alaa Madi]
 * Öğrenci No: [240541609]
 * Proje: [university system grade calculator]
 * Tarih: [21/11/2025]
 */

import java.util.Scanner;
// calculate average score according to exam and assignments
public class NotSystem{
    public double calculateAverage(double vize, double finalExam, double odev){
        /*
         *  the numbers in the line is the system of counting the average 
         * vise: 30%
         * final: 40%
         * odev: 30%
         */
        double ortalama = (vize * 0.3) + (finalExam * 0.4) + (odev * 0.3);
        return  ortalama; 
    }
    // return true if passed and false if failed
    public boolean isPassedGrade(double ortalama){
        return (ortalama >= 50);

    }
    // return A if passed and F if failed
    public char getLetterGrade(double ortalama){
            if (ortalama >= 90) 
               return 'A';
            else if (ortalama >= 80)
                return 'B';
            else if (ortalama >= 70)
                return 'C';
            else if (ortalama >= 60) 
                return 'D';
            else if (ortalama >= 50) 
                return 'E';
            else return 'F';
    }

    // check if the student on the honer list
    public boolean isHonorList(double ortalama){
        return (ortalama >= 85);
    }
     
    // check if the student has retake right
    public boolean hasRetakeRight(double ortalama){
        return (ortalama >= 45 && ortalama < 50);

    }
    



    //main method
    public static void main(String[] args){

        // create scanner object
        Scanner input = new Scanner(System.in);

        // create an object of the class
        NotSystem ogrenci = new NotSystem();


        //input the vize sinav score
        System.out.println("Enter your vize sinav score: ");
        double vize = input.nextDouble();

        // input the final exam score
        System.out.println("Enter your final Sinav score: ");
        double finalExam = input.nextDouble();

        // input the assigment score
        System.out.println("Enter your odev score: ");
        double odev = input.nextDouble();


      
        double toplam = ogrenci.calculateAverage(vize, finalExam, odev);
        // calling the methods
        System.out.println("your average score is: " + toplam);
        System.out.println("did you pass the course: " + ogrenci.isPassedGrade(toplam));
        System.out.println("your letter grade is: " + ogrenci.getLetterGrade(toplam));
        System.out.println("are you on the honor list: " + ogrenci.isHonorList(toplam));
        System.out.println("do you have retake right: " + ogrenci.hasRetakeRight(toplam));


    }

}
