package com.lilili.designpattern.linkedlist;

/**
 * @Author LiYuan
 * @Date 2021/12/20
 **/
public class LinkedList<V extends Comparable<V>> {
    Node<V> head;
    int size;

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }

    private static class Node<V> {
        V val;
        Node next;

        public Node(V val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public int size() {
        return size;
    }

    public void add(V val) {
        Node add = new Node(val, null);
        size++;
        if (head == null) {
            head = add;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = add;
    }

    public boolean remove(V val) {
        if (head != null) {
            Node temp = head;
            Node prev = null;
            while (temp != null) {
                if (temp.val == val) {
                    //当删除的是头结点的时候
                    if (prev == null) {
                        head = temp.next;
                        size--;
                        return true;
                        //非头结点
                    } else {
                        prev.next = temp.next;
                        size--;
                        return true;
                    }
                }
                prev = temp;
                temp = temp.next;
            }
        }
        return false;
    }

    public V get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index + "");
        }
        Node temp = head;
        //从1开始找， 因为这里没有使用空的头结点。
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        return (V) temp.val;

    }

    //-----------------链表题-----------------
    public static Node reverse(Node node) {
        //判空
        if (node == null || node.next == null) {
            return node;
        }
        Node temp = null;
        while (node.next != null) {
            Node tempp = node;
            node = node.next;

            tempp.next = temp;
            temp = tempp;
        }
        node.next = temp;
        return node;
    }

    //---快慢指针找到链表环的入口---
    //具体实现， 快指指针走两步， 慢指针走一步， 第一次相遇， 慢指针归零， 然后快慢指针都走一步， 第二次相遇就是链表的入口。
    public static Node findLoopPort(Node node) {
        Node fast = node, slow = node;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }
        //没有环
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = node;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        //去除环
        slow.next = null;
        //没有环
        return slow;
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //测试增加删除
//        System.out.println(list);
//        list.remove(1);
//        System.out.println("删除头结点后.." + list);
//        list.remove(3);
//        System.out.println("删除任意结点后.." + list);
//        list.add(5);
//        System.out.println(list);
//        list.remove(5);
//        System.out.println("删除尾节点后..." + list);
//        System.out.println(list.get(2));

        //测试反转链表
//        Node node = new Node(1, new Node(2, new Node(3, new Node(4, null))));
//        Node reverse = reverse(node);
//        System.out.println(reverse);

        //测试快慢指针找出链表环
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, null);
        Node n3 = new Node(3, null);
        Node n4 = new Node(4, null);
        Node n5 = new Node(5, null);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        Node loopPort = findLoopPort(n1);
        System.out.println(loopPort);
    }
}


