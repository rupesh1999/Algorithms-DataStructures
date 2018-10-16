package com.company;

import java.util.Comparator;

public class mycomparator implements Comparator<huffmanNode> {
    public int compare(huffmanNode x , huffmanNode y){
        return x.data - y.data;
    }
}