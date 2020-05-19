package com.congzer.linkdlist;

/**
 * @Description
 * @Author zhangzhucong
 * @Date 2020/4/22
 **/
public class LeeCode203 {

    //Definition for singly-linked list.
    static class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] arr) {

            if (arr == null || arr.length == 0) {

                throw new IllegalArgumentException("arr can not be empty");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {

                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {

            StringBuilder res = new StringBuilder();
            ListNode cur = this;
            while (cur != null) {

                res.append(cur.val);
                res.append("->");
                cur = cur.next;
            }
            res.append("NULL");
            return res.toString();
        }
    }

    public static ListNode removeElements(ListNode head, int val) {

        //第一个元素为val
        while (head != null && head.val == val) {

            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        //全部元素为val
        if (head == null) return null;

        //其他元素为val
        ListNode prev = head;
        while (prev.next != null) {

            if (prev.next.val == val) {

                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {

                prev = prev.next;
            }
        }
        return head;
    }

    public static ListNode removeElements2(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;

        if (head == null) return null;

        ListNode prev = head;
        while (prev.next != null) {

            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return head;
    }

    public static ListNode removeElementsWithDummyHead(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {

            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
        return dummyHead.next;
    }

    //将链表分解为一个一个的子节点，在此例中该子节点为头节点，然后再对头节点进行操作
    public static ListNode removeElementsWithRecursion(ListNode head, int val) {

        if (head == null) {

            return null;
        }
        ListNode res = removeElementsWithRecursion(head.next, val);
        if (head.val == val) {

            return res;
        } else {

            head.next = res;
            return head;
        }
    }

    public static ListNode removeElementsWithRecursion2(ListNode head, int val) {

        if (head == null) return null;
        head.next = removeElementsWithRecursion(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

        int[] arr = {6, 6, 1, 2, 6, 4, 5, 6, 6, 6, 7};
        //int[] arr = {1, 2, 6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

        System.out.println(removeElementsWithRecursion2(listNode, 6));
    }
}