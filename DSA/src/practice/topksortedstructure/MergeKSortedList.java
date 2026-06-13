package practice.topksortedstructure;

import common.ListNode;
import common.PrintUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
K Smallest Pair Sum → Min Heap + Frontier Expansion
K Largest Pair Sum → Max Heap + Frontier Expansion + Visited Set

 */
public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length ==0) return null;
        ListNode head = lists[0];//,newHead = head;

        for(int i=1;i<lists.length;i++){
            head = mergeTwoList(head,lists[i]);
        }

        return head;
    }

    public ListNode mergeTwoList(ListNode head,ListNode head1){
        ListNode temp =head,temp1=head1;
        ListNode newHead = new ListNode(-1),cur = newHead;
        while(temp != null && temp1 != null){
            if(temp.val <= temp1.val){
                cur.next = temp;
                temp = temp.next;
            }else{
                cur.next = temp1;
                temp1 = temp1.next;
            }
            cur = cur.next;
        }

        if(temp != null){
            cur.next = temp;
        }
        else if(temp1 != null){
            cur.next = temp1;
        }
        return newHead.next;
    }

    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2) -> n1.val - n2.val);
        for(ListNode list:lists){
            while(list != null){
                pq.add(list);
                list = list.next;
            }
        }

        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        while(!pq.isEmpty()){
            temp.next = pq.poll();
            temp = temp.next;
        }
        temp.next = null;
        return newHead.next;
    }

//    public record Tuple(ListNode node,int index,int listIndex){}
    public static ListNode mergeKListPqOpt(List<ListNode> lst){
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>((t1,t2) -> t1.val-t2.val);
        for(int i=0;i<lst.size();i++){
            ListNode node = lst.get(i);
            if(node != null) {
                pq.add(lst.get(i));
            }
        }

        if(pq.isEmpty()){
            return null;
        }

        ListNode newHead=dummy;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            newHead.next = new ListNode(node.val);
            newHead = newHead.next;
            if(node.next!=null) {
                pq.add(node.next);
                node.next=null;
            }
        }

        return dummy.next;
    }

    public static void print(ListNode node){
        System.out.println();
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next = new ListNode(3);

        ListNode head1 = new ListNode(4);
        head1.next= new ListNode(5);
        head1.next.next = new ListNode(6);

        ListNode head3 = new ListNode(2);
        head3.next= new ListNode(4);
        head3.next.next = new ListNode(6);


        ListNode newHead = mergeKListPqOpt(Arrays.asList(head,head1,head3));
        print(newHead);

    }

}
