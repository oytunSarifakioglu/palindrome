/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author OytunS
 */
import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

public class Palindrome {
    
    public static String uzun = "",kisa = "";
            

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here,
        File dosya = new File("words.txt");
        
        if (!dosya.exists()){
            System.out.println("Sistem dosyayı bulamadı.");
            System.exit(0);
        }
        
        Scanner okuyucu = new Scanner(dosya);
        
        System.out.println("Palindrome kelimeler: ");
        
        for (int i=0;(okuyucu.hasNextLine()); i++) {
            
            String kelime = okuyucu.nextLine();
            
            if (kontrol(kelime)==true){
                System.out.println(kelime);
            }         
        }
        
        System.out.println("\nEn uzun palindrome kelime: " + uzun);
        System.out.println("En kisa palindrome kelime: " + kisa);                
    }
    
    public static boolean kontrol (String kelime) {
        int n;
        n = kelime.length();
        for (int i = 0; i < (n/2); i++) {
            if (kelime.charAt(i) != kelime.charAt(n - i -1)){
                return false;
            }
        }
        
        if (n < kisa.length()) kisa = kelime;
        else if (kisa == "")  kisa = kelime;
        
        if (n > uzun.length()) uzun = kelime;
        
        return true;
        
    }   
}