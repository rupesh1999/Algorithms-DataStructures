package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    int size;
    int numberOfElements;
    LinkedList<hashNode>[] bucketarrray;

    Main(int size){
        this.size = size;
        this.numberOfElements = 0;
        this.bucketarrray = new LinkedList[size];
        for(int i=0; i<size; i++){
            bucketarrray[i] = new LinkedList<hashNode>();
        }
    }

    void addValue(String key , int value){
        int position = myHash(key , size);
        hashNode newNode = new hashNode(key , value);
        bucketarrray[position].add(newNode);
        numberOfElements++;
    }

    int myHash(String key , int size){
        int hashvalue = key.hashCode();
        hashvalue = hashvalue%size;
        if(hashvalue < 0){
            hashvalue += size;
        }
        return hashvalue;
    }

    int search(String key){
        int position = myHash(key , size);
        Iterator<hashNode> i =  bucketarrray[position].listIterator();
        while(i.hasNext()){
            hashNode n = i.next();
            if(n.key == key){
                System.out.println("item found and the value is\t" + n.value);
                return n.value;
            }
        }
        System.out.println("item not found in the hashtable\n");
        return -1;
    }

    void remove(String key){
        int position  = myHash(key , size);
        Iterator<hashNode> i = bucketarrray[position].listIterator();
        while(i.hasNext()){
            hashNode n = i.next();
            if(n.key == key){
                i.remove();
            }
        }
    }


    public static void main(String[] args) {
	// write your code here
        Main hashtable = new Main(100);
        hashtable.addValue("red" , 5);
        hashtable.addValue("green" , 10);
        hashtable.addValue("blue" , 5);
        hashtable.addValue("yellow" , 5);
        hashtable.addValue("magenta" , 5);
        hashtable.addValue("cool" , 5);
        hashtable.addValue("hehe" , 5);
        hashtable.addValue("lolo" , 5);
        hashtable.addValue("hujame" , 5);
        hashtable.remove("green");
        hashtable.search("green");
        hashtable.remove("red");
        hashtable.search("red");
        System.out.println(hashtable.numberOfElements);
    }
}
