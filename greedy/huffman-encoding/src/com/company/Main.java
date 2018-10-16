package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void printCode(huffmanNode root , String s){

        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {

            // c is the character in the node
            System.out.println(root.ch + ":" + s);

            return;
        }

        printCode(root.left , s + "0");
        printCode(root.right , s + "1");
    }


    public static void main(String[] args) {
	// write your code here
        Scanner s = new Scanner(System.in);
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<huffmanNode> q = new PriorityQueue<>(n ,new mycomparator());
        for(int i = 0 ; i < n ; i++){
            huffmanNode hn = new huffmanNode();

            hn.ch = charArray[i];
            hn.data = charfreq[i];

            hn.left = null;
            hn.right = null;

            q.add(hn);
        }

        huffmanNode root = null;

        while(q.size() > 1){
            huffmanNode x = q.peek();
            q.poll();
            huffmanNode y = q.peek();
            q.poll();

            huffmanNode f = new huffmanNode();

            f.data = x.data + y.data;
            f.ch = '-';

            f.left = x;
            f.right = y;

            root = f;

            q.add(f);

        }

        printCode(root , "");
    }
}
