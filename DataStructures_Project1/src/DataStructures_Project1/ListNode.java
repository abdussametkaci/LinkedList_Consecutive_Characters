/**
* @file ListNode
* @description Yazilan bu program bir dosya icerisindeki karakterleri LinkedList icerisinde
* saklamaktadır. Ayrica bu karakterlerden sonra hangi karakterlerin gectigi ve adet 
* bilgisi de bir baglantili liste yapisinda tutulmaktadir
* @assignment Odev1
* @date 16.04.2020
* @author Abdussamet KACI
*/
package DataStructures_Project1;

// liste karakterlerini tutacak olan liste node
// liste node'u bir baglantili listedeki ana karakterlerden sonra gelen karakterleri tutar
// ve bunlarin kac defa gectigini de
public class ListNode<T> {
    
    T data;
    int count;
    ListNode<T> nextListNode;
    
    public ListNode(T data){
        this.data = data;
        count = 0;
    }
}
