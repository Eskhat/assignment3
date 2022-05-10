package com.company;



public class BST {
     Node root;
    private class Node{
        private int key;

        private Node left,right;
        public Node(int key){

            this.key=key;
        }
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void put(int key){
     root=put(key,root);
    }

    private Node put(int key,Node node){
        if(node==null){
            return new Node(key);
        }
        if(key<node.key){
            node.left=put(key,node.left);
        }else if(key> node.key){
            node.right=put(key,node.right);
        }



        return node;
    }

    public void get(int key){
        if(key== root.key){
            System.out.println(key);
        }else
            System.out.println("No contains");
    }

    public void delete(int key){
        root=delete(key,root);
    }
    private Node delete(int key,Node node){
        if(node==null){
            return node;
        }
        if(key<node.key){
            node.left=delete(key,node.left);
        }else if(key> node.key){
            node.right=delete(key,node.right);
        }
        return node;
    }


    public void show() { show(root); }


    private void show(Node root){
        if (root != null) {
            show(root.left);
            System.out.println(root.key);
            show(root.right);
        }
    }
}
