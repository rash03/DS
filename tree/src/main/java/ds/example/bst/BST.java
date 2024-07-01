package ds.example.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    BSTNode root;

    public BST(){
        this.root = null;
    }

    private BSTNode insert(BSTNode node, int value){

        if(node == null){
            BSTNode bstNode = new BSTNode();
            bstNode.value = value;
            return bstNode;
        }else if(value <= node.value){
            node.left = insert(node.left,value);
            return node;
        }else{
            node.right = insert(node.right,value);
            return node;
        }
    }

    public void insert(int value){
        insert(root, value);
    }

    public void preOrder(BSTNode node){
        if(node == null){
            return;
        }
        System.out.println(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(BSTNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value+" ");
        inOrder(node.right);
    }

    public void postOrder(BSTNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value+" ");
    }

    public void levelOrder(BSTNode node){
        Queue<BSTNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BSTNode prsNode = queue.remove();
            System.out.println(prsNode.value+" ");
            if(prsNode.left!=null){
                queue.add(prsNode.left);
            }if(prsNode.right!=null){
                queue.add(prsNode.right);
            }
        }
    }

    BSTNode search(BSTNode node, int value){
        if(node ==null){
            return null;
        }
        if(node.value == value){
            System.out.println("Value found");
            return node;
        }
        else if(value < node.value){
            return search(node.left, value);
        }else {
            return search(node.right, value);
        }
    }

    BSTNode minimumNode(BSTNode root){
        if(root.left == null){
            return root;
        }else{
            return minimumNode(root.left);
        }

    }
    BSTNode deleteNode(BSTNode root, int value){
        if(root == null){
            System.out.println("Element node found in Tree");
            return null;
        }
        if(value < root.value){
            root.left = deleteNode(root.left,value);
        }else if(value > root.value){
            root.right = deleteNode(root.right,value);
        }else{
            if(root.left!=null && root.right!=null){
                BSTNode minNode = minimumNode(root.right);
                root.value = minNode.value;
                root.right = deleteNode(root.right, minNode.value);
            }else if (root.left !=null){
                root = root.left;
            }else if (root.right !=null){
                root = root.right;
            }else{
                root = null;
            }
        }
        return root;
    }

    public void deleteTree(){
        root = null;
        System.out.println("Tree is deleted");
    }
}
