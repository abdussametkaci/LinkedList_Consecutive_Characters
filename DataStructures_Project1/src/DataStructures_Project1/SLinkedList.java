/**
* @file SLinkedList
* @description Yazilan bu program bir dosya icerisindeki karakterleri LinkedList icerisinde
* saklamaktadır. Ayrica bu karakterlerden sonra hangi karakterlerin gectigi ve adet 
* bilgisi de bir baglantili liste yapisinda tutulmaktadir
* @assignment Odev1
* @date 16.04.2020
* @author Abdussamet KACI abdussamet.kaci@stu.fsm.edu.tr
*/
package DataStructures_Project1;

public class SLinkedList<T> {

    private MainNode<T> head;

    void addFirst(MainNode<T> newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.nextMainNode = head;
            head = newNode;
        }
    }

    void addFirst(T newData) {
        addFirst(new MainNode<>(newData));
    }

    void addLast(MainNode<T> newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            MainNode<T> temp = head;

            while (temp.nextMainNode != null) {
                temp = temp.nextMainNode;
            }

            temp.nextMainNode = newNode;
        }
    }

    void addLast(T newData) {
        addLast(new MainNode<>(newData));
    }

    boolean addAfter(T search, T newData) {
        if (isEmpty()) {
            System.out.println("Empty list !");
        } else {
            MainNode<T> temp = head;

            while (temp != null && !temp.data.equals(search)) {
                temp = temp.nextMainNode;
            }

            if (temp != null) {
                MainNode<T> newNode = new MainNode<>(newData);
                newNode.nextMainNode = temp.nextMainNode;
                temp.nextMainNode = newNode;
                return true;
            }
        }
        return false;
    }

    MainNode<T> remove(T data) {
        MainNode<T> removedNode = null;

        if (isEmpty()) {
            System.out.println("Empty list !");
        } else {

            if (head.data.equals(data)) {
                removedNode = head;
                head = head.nextMainNode;
            } else {
                MainNode<T> temp = head;

                while (temp.nextMainNode != null && !temp.nextMainNode.data.equals(data)) {
                    temp = temp.nextMainNode;
                }

                if (temp.nextMainNode != null) {
                    removedNode = temp.nextMainNode;
                    temp.nextMainNode = temp.nextMainNode.nextMainNode;
                }
            }
        }

        return removedNode;
    }

    boolean isEmpty() {
        return head == null;
    }

    int size() {
        MainNode<T> temp = head;
        int count = 0;

        while (temp != null) {
            count++;
            temp = temp.nextMainNode;
        }

        return count;
    }

    // bu satirdan sonra benim yazdigim kodlar bulunmaktadir 
    // ana karakterleri alt alta ve liste karakterlerini ise yan yana basar
    void print() {
        MainNode<T> temp = head;

        while (temp != null) { // ana karakterleri doner
            System.out.print(" " + temp.data);

            ListNode<T> tempList = temp.listNode;

            while (tempList != null) { // ana karakterdensonra gelen karakterleri doner yani liste karakterlerini
                System.out.print(" -> " + tempList.data + "," + tempList.count);
                tempList = tempList.nextListNode;
            }

            System.out.print(" -> null");

            System.out.print("\n | ");

            temp = temp.nextMainNode;
            System.out.println("");
        }

        System.out.println("null");
    }

    // baglantili listede bu datanin olup olmadigini kontrol eder
    boolean hasItem(T data) {
        return hasItem(new MainNode<>(data));
    }

    boolean hasItem(MainNode<T> mainNode) {
        // baglantili liste eger bossa yoktur
        if (isEmpty()) {
            return false;
        }

        MainNode<T> temp = head;

        while (temp != null) {
            if (temp.data.equals(mainNode.data)) { // eger data aradigimiz dataya esitse bulunmustur
                return true;
            }
            temp = temp.nextMainNode;
        }

        return false;
    }

    // istenilen indeksteki datayi getirir
    T getData(int index) {
        return getMainNode(index).data;
    }

    MainNode<T> getMainNode(int index) {
        MainNode<T> temp = head;

        if (isEmpty()) { // eger liste bossa yoktur
            return null;
        }

        for (int i = 0; i < index; i++) { // indesk degeri kadar ilerlenir ve degeri bulmus oluruz
            temp = temp.nextMainNode;
        }

        return temp;
    }

    // liste nodunu ana nodun sonuna ekler
    void addLast(MainNode<T> mainNode, ListNode<T> newListNode) {
        if (isEmpty()) { // eger bossa uyari basilir
            System.out.println("empty list");
        } else if (!hasItem(mainNode)) { // eger ana node baglantili listede yoksa
            System.out.println(mainNode.data + " has not founded in this linked list");

        } else {
            MainNode<T> temp = head;

            while (temp != null) { // ana nodelar donulur
                if (temp.data.equals(mainNode.data)) { // eger node bulunduysa

                    newListNode.count++; // liste nodunun degeri 1 artilir

                    if (temp.listNode == null) { // ana nodun liste nodu bossa 
                        temp.listNode = newListNode; // direkt yeni node'u ekler
                    } else { // bos degilse

                        ListNode<T> tempList = temp.listNode;

                        while (tempList.nextListNode != null) { // ana node'un sonuna kadar gidilir
                            tempList = tempList.nextListNode;
                        }

                        tempList.nextListNode = newListNode; // en son eklenir
                    }

                }

                temp = temp.nextMainNode;
            }
        }
    }

    // liste karakterini ana karaktere ekler
    void addLast(T mainData, T newListData) {
        addLast(new MainNode<>(mainData), new ListNode<>(newListData));
    }

    // ana node liste noduna sahip olup olmadigini soyler
    boolean hasItem(MainNode<T> mainNode, ListNode<T> listNode) {
        if (isEmpty()) { // bossa yoktur
            System.out.println("empty list");
            return false;
        }

        if (!hasItem(mainNode)) { // eger ana node baglantili listede yoksa
            // uyariverilir ve false doner
            System.out.println(mainNode.data + " has not founed in this linked list.");
            return false;
        }

        MainNode<T> temp = head;

        while (temp != null) { // ana node'lar gezilir
            if (temp.data == mainNode.data) { // eger ana node bulunduysa
                ListNode<T> tempList = temp.listNode;

                while (tempList != null) { // liste node'lari donulur
                    if (tempList.data.equals(listNode.data)) { // liste nodunun datasi bulunursa
                        return true; // vardir
                    }

                    tempList = tempList.nextListNode;
                }

            }
            temp = temp.nextMainNode;
        }
        // donguye girilmemisse yoktur
        return false;
    }

    boolean hasItem(T mainData, T listData) {
        return hasItem(new MainNode<>(mainData), new ListNode<>(listData));
    }

    // ana node'daki liste nodunun sayisini bir artirir
    void addCount(MainNode<T> mainNode, ListNode<T> listNode) {

        if (isEmpty()) { // bossa liste bos uyarisi veilir
            System.out.println("empty list");
        } else if (!hasItem(mainNode)) { // ana node baglantili listede yoksa
            System.out.println(mainNode.data + " has not founded in this linked list");
        } else if (!hasItem(mainNode, listNode)) { // ana node'da verilen liste nodu yoksa uyari verilir
            System.out.println(mainNode.data + " has no " + listNode.data);
        } else {
            MainNode<T> temp = head;

            while (temp != null) { // ana node'lar gezilir
                if (temp.data.equals(mainNode.data)) { // eger ana node bulunursa
                    ListNode<T> tempList = temp.listNode;

                    while (tempList != null) { // liste node'lari gezilir
                        if (tempList.data.equals(listNode.data)) { // liste node'u bulunursa
                            tempList.count++; // sayi bir artilir
                            break;
                        }
                        tempList = tempList.nextListNode;
                    }
                }

                temp = temp.nextMainNode;
            }
        }

    }

    void addCount(T mainData, T listData) {
        addCount(new MainNode<>(mainData), new ListNode<>(listData));
    }

    // k karakterinden sonra gelen karakterleri yazar
    void ardisikKarakterler(T k) {

        if (isEmpty()) {
            System.out.println("empty list");
        } else if (!hasItem(k)) { // karakter baglantili listede bulunmuyorsa
            System.out.println(k + " is not available in tis linked list");
        } else {

            MainNode<T> temp = head;

            while (temp != null) { // ana node'lar donulur
                if (temp.data.equals(k)) { // ana node bulunursa
                    System.out.print("after datas of " + k);

                    ListNode<T> tempList = temp.listNode;

                    while (tempList != null) { // ana node'un liste karakterleri basılır
                        System.out.print(" -> " + tempList.data + "," + tempList.count);
                        tempList = tempList.nextListNode;
                    }
                    System.out.println("");
                    // basilma islemi gerceklestikten sonra fonksiyondan cikilir
                    return;

                }

                temp = temp.nextMainNode;
            }
        }

    }

    // en cok pes pese gelen karakter ikilisini yazar
    void enCokArdisik() {
        T mainData = null; // ana node'un degeri 
        T listData = null; // liste node'unun degeri
        int maxCount = 0; // en cok gecen karakterin sayisi

        if (isEmpty()) {
            System.out.println("empty list");
            return;
        }

        MainNode<T> temp = head;

        while (temp != null) { // ana node'lari dolasilir

            ListNode<T> tempList = temp.listNode;

            while (tempList != null) { // liste node'lari dolasilir
                if (maxCount < tempList.count) { // eger max sayi liste karakterinin adedinden kucukse
                    maxCount = tempList.count; // max sayi artik liste karakterinin adedi kadardir
                    listData = tempList.data; // yeni liste karakteri degeri
                    mainData = temp.data; // yeni ana karakter degeri
                }

                tempList = tempList.nextListNode;
            }

            temp = temp.nextMainNode;

        }
        // en son bulunan degiskenler basilir
        System.out.println("at most character twin: " + mainData + "" + listData + " is " + maxCount + " times.");

    }

    // k karakterinden sonra en cok gecen karakteri yazar
    void enCokArdisik(T k) {
        T listData = null;
        int maxCount = 0;

        if (isEmpty()) {
            System.out.println("empty list");
            return;
        } else if (!hasItem(k)) {
            System.out.println(k + " is not available in this linked list");
            return;
        }

        MainNode<T> temp = head;

        while (temp != null) { // ana node'lar dolasilir
            if (temp.data.equals(k)) { // verilen karakter bulunursa
                ListNode<T> tempList = temp.listNode;

                while (tempList != null) { // liste node'lari dolasilir
                    if (maxCount < tempList.count) { // max sayi liste karakterinin adedinden kucukse
                        maxCount = tempList.count; // max sayi artik liste karakterinin adedi kadardir
                        listData = tempList.data; // yeni liste karakteri degeri
                    }

                    tempList = tempList.nextListNode;
                }
                // istenilen karakter bulunduktan sonra basilir ve fonksiyondan cikilir
                System.out.println("after " + k + " at most character: " + listData + " is " + maxCount + " times.");
                return;
            }

            temp = temp.nextMainNode;
        }
    }

    // en az pes pese gelen karakter ikilisini basar
    void enAzArdisik() {
        T mainData = null;
        T listData = null;
        int minCount = 0; // en az gecen karakterin sayisi

        if (isEmpty()) {
            System.out.println("empty list");
            return;
        }

        MainNode<T> temp = head;

        while (temp != null) { // ana node'lar dolasilir

            ListNode<T> tempList = temp.listNode;
            
            // sadece ilk degerlerin bir defa eklenmesi icin bu kontrol yapilmaktadir
            if (mainData == null) {
                mainData = temp.data; // ana karakterin degeri atanir
            }

            while (tempList != null) { // liste node'lari dolasilir
                if (listData == null && minCount == 0) {
                    listData = tempList.data; // ana karakterden sonra gelen karakterin degeri atanir (liste karakteri)
                    minCount = tempList.count; // liste karakterinin adedi atanir
                }

                if (minCount > tempList.count) { // eger min sayi liste karakterinin adedinden fazlaysa
                    minCount = tempList.count; // artik minsayi liste karakterinin adedi kadardir
                    listData = tempList.data; // yeni liste akarakteri degeri 
                    mainData = temp.data; // yeni ana karakter degeri
                }

                tempList = tempList.nextListNode;
            }

            temp = temp.nextMainNode;

        }

        System.out.println("at least character twin: " + mainData + "" + listData + " is " + minCount + " times.");
    }

    // k karakterinden sonra gelen en az gecen karakteri basar
    void enAzArdisik(T k) {
        T listData = null;
        int minCount = 0; // en gecen sayi

        if (isEmpty()) {
            System.out.println("empty list");
            return;
        } else if (!hasItem(k)) {
            System.out.println(k + " is not available in this linked list");
            return;
        }

        MainNode<T> temp = head;

        while (temp != null) { // ana node'lar dolasilir
            if (temp.data.equals(k)) { // eger anan node'un degeri esitse
                ListNode<T> tempList = temp.listNode;

                listData = tempList.data;
                minCount = tempList.count;

                while (tempList != null) { // liste node'lari dolasilir
                    if (minCount > tempList.count) { // eger min sayi liste node'unun adedinden fazlaysa
                        minCount = tempList.count; // yeni min sayi liste node'unun adedi kadardir
                        listData = tempList.data; // liste degeri yeni liste degeridir
                    }

                    tempList = tempList.nextListNode;
                }

                System.out.println("after " + k + " at least character: " + listData + " is " + minCount + " times.");
                return; // basilma isleminden sonra fonksiyondan cikilir
            }

            temp = temp.nextMainNode;
        }
    }

}
