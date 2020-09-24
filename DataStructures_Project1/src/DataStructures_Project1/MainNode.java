/**
* @file MainNode
* @description Yazilan bu program bir dosya icerisindeki karakterleri LinkedList icerisinde
* saklamaktadır. Ayrica bu karakterlerden sonra hangi karakterlerin gectigi ve adet 
* bilgisi de bir baglantili liste yapisinda tutulmaktadir
* @assignment Odev1
* @date 16.04.2020
* @author Abdussamet KACI abdussamet.kaci@stu.fsm.edu.tr
*/
package DataStructures_Project1;

// ana karakterleri tutacak olan ana node 
public class MainNode<T> {

    T data;
    MainNode<T> nextMainNode;
    ListNode<T> listNode;

    public MainNode(T data) {
        this.data = data;
    }
    

}
