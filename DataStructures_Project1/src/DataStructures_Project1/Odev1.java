/**
* @file Odev1
* @description Yazilan bu program bir dosya icerisindeki karakterleri LinkedList icerisinde
* saklamaktadir. Ayrica bu karakterlerden sonra hangi karakterlerin gectigi ve adet 
* bilgisi de bir baglantili liste yapisinda tutulmaktadir
* @assignment Odev1
* @date 16.04.2020
* @author Abdussamet KACI
*/
package DataStructures_Project1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//test sinifidir
public class Odev1 {
    
    public static void main(String[] args) {

        // text dosyasinin okunacagi yol
        // java ayni dizindeki dosyayi okumakta zorlandigi icin tam yol vermek zorunda kaldim
        String path = "C:\\Users\\asus\\Documents\\NetBeansProjects\\Abdussamet_KACI_1721221007_Odev1\\src\\Abdussamet_KACI_1721221007_Odev1\\";

        System.out.println("please write your file (please don't forget the file extension): ");
        Scanner scanner = new Scanner(System.in); // kullanicidan okunacak dosya beklenir
        path += scanner.nextLine(); // dosya yola eklenir

        FileReader fr = null;
        try {
            fr = new FileReader(path);

            SLinkedList<Character> linkedList = new SLinkedList<>();

            int fileReaded; // dosyadan okunan deger
            char charFile; // dosyadan okunan degerin karaktere cast edilmis hali
            while ((fileReaded = fr.read()) != -1) { // dosyanin sonuna kadar okur ve karakterleri ana noda ekler
                charFile = (char) fileReaded; // okunan dger cast edilir
                charFile = Character.toLowerCase(charFile); // okunan deger kucuk harfe donusturulur

                //eger okunan deger alfabetikse ve baglantili listede yoksa
                if (Character.isAlphabetic(charFile) && !linkedList.hasItem(charFile)) {
                    linkedList.addLast(charFile); // baglantili listenin sonuna ekler
                }

            }

            char characterMain; // baglantili listeden okunan ana karakter
            for (int i = 0; i < linkedList.size(); i++) { // baglantili listenin boyutu kadar doner
                characterMain = linkedList.getData(i); // baglantili listenin i'ninci indeksindeki datayi getirir

                fr = new FileReader(path);
                while ((fileReaded = fr.read()) != -1) {
                    charFile = (char) fileReaded;
                    charFile = Character.toLowerCase(charFile);

                    if (charFile == characterMain) { // dosyadan okunan karakter listedeki karakter ise

                        // dosyadan bir daha deger okuruz amam bu okunan deger bir yandaki degerdir
                        // dosya okundukca pointer surekli ilerler
                        char characterList = (char) fr.read(); // okunan deger ana node'a eklenecek olan liste karakteri

                        // eger bu karakter alfabetikse ve  ana karakter de liste karakterini icermiyorsa
                        if (Character.isAlphabetic(characterList) && !linkedList.hasItem(characterMain, characterList)) {
                            linkedList.addLast(characterMain, characterList); // ana karaktere liste karakterinin sonuna ekle

                        //eger ki alfabetikse ve ana karakterde liste karakteri geciyorsa
                        } else if (Character.isAlphabetic(characterList) && linkedList.hasItem(characterMain, characterList)) {
                            linkedList.addCount(characterMain, characterList); // liste karakterinin sayisini 1 artır
                        }
                    }

                }

            }
            
            // methodlar test edilir
            linkedList.print();
            
            linkedList.ardisikKarakterler('v');
        
            linkedList.ardisikKarakterler('z');
       
            linkedList.enCokArdisik();
            linkedList.enCokArdisik('a');
            linkedList.enCokArdisik('v');
            linkedList.enAzArdisik();
            linkedList.enAzArdisik('v');

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Odev1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Odev1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Odev1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
