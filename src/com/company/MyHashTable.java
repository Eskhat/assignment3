package com.company;

import java.util.*;

public class MyHashTable<K,V> {

    private class HashNode<K,V> {
        private K key;
        private V value;

        public HashNode(K key,V value) {
            this.key = key;
            this.value = value;
        }
        private K getKey(){
            return key;
        }
        private V getValue(){
            return value;
        }

        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
    }
    private ArrayList<LinkedList<HashNode<K,V>>> chainArray;
    private static final int M = 16;
    private int size;

    public MyHashTable() {
        this(M);
    }

    public MyHashTable(int M) {
        size = M;
        chainArray=new ArrayList<LinkedList<HashNode<K,V>>>();
        for(int i=0;i<M;i++) {
            chainArray.add(new LinkedList<HashNode<K,V>>());
        }
    }

    private int hash(K key) {
        return key.hashCode();
    }

    public V get(K key) {
        LinkedList<HashNode<K,V>> bucket = chainArray.get(hash(key));
        for (HashNode<K,V> e : bucket) {
            if (e.getKey() == key) {
                return e.getValue();
            }
        }
        return null;
    }

    public void put(K key, V value) {
        LinkedList<HashNode<K,V>> bucket = chainArray.get(hash(key));
        bucket.add(new HashNode<K,V>(key, value));
    }


    public void contains(V value){

            if(chainArray.contains(value)){
                System.out.println("true");
            }else {
                System.out.println("false");
            }

    }






}

