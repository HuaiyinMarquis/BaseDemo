package com.lintCodeTest;

/**
 * 452. 删除链表中的元素
 * Created by ChenMP on 2018/4/10.
 */
public class RemoveElements {
    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode solution(ListNode head, int val) {
        if(head == null) return null;
        while(head != null) {
            if(head.val == val) {
                head = head.next;
            } else
                break;
        }
        ListNode father = head;
        if(head != null && null != father.next) {
            ListNode son = father.next;
            while(son != null) {
                if(son.val == val) {
                    father.next = son.next;
                } else {
                    father = father.next;
                }
                son = father.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node7 = new ListNode(3);
        ListNode node6 = new ListNode(5);
        ListNode node5 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println(node1);
        System.out.println(solution(node1,3));
    }
}
