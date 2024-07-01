package ds.example.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLL {

    BinaryNode root;

    public BinaryTreeLL(){
        this.root = null;
    }

    void preOrder(BinaryNode bNode){
        if(bNode == null){
            return;
        }
        System.out.println(bNode.data+" ");
        preOrder(bNode.left);
        preOrder(bNode.right);
    }

    void inOrder(BinaryNode bNode){
        if (bNode == null){
            return ;
        }
        inOrder(bNode.left);
        System.out.println(bNode.data);
        inOrder(bNode.right);
    }

    void postOrder(BinaryNode bNode){
        if (bNode == null){
            return ;
        }
        postOrder(bNode.left);
        postOrder(bNode.right);
        System.out.println(bNode.data);

    }

    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode pNode = queue.remove();
            System.out.print(pNode.data+" ");
            if(pNode.left !=null){
                queue.add(pNode.left);
            }
            if(pNode.right !=null){
                queue.add(pNode.right);
            }
        }
    }

    /**
     *     Search for an element
     *     Searching is done using Level order as it uses queue.
     *     pre,post and in order uses stack which is expensive
     */

    public void search(String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode pNode = queue.remove();
            if(pNode.data == value){
                System.out.println("Value -"+value+" found in tree");
                return;
            }else{
                if(pNode.left !=null){
                    queue.add(pNode.left);
                }
                if(pNode.right !=null){
                    queue.add(pNode.right);
                }
            }
        }
        System.out.println("Value -"+ value+" NOT found in tree");
    }

    public void insert(String value){
        BinaryNode bNode = new BinaryNode();
        bNode.data = value;
        if (root == null){
            root = bNode;
            System.out.println("Value inserted");
        }else{
            Queue<BinaryNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                BinaryNode pNode = queue.remove();
                if(pNode.left == null){
                    pNode.left = bNode;
                    System.out.println("Value Inserted");
                    break;
                }else if(pNode.right == null){
                    pNode.right = bNode;
                    System.out.println("Value Inserted");
                    break;
                }else{
                    queue.add(pNode.left);
                    queue.add(pNode.right);
                }

            }
        }
    }

    public BinaryNode getDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode pNode = null;
        while(!queue.isEmpty()){
            pNode = queue.remove();
            if(pNode.left !=null){
                queue.add(pNode.left);
            }
            if(pNode.right !=null){
                queue.add(pNode.right);
            }
        }
        return pNode;
    }

    public void deleteDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode prvNode= null;
        BinaryNode prsNode= null;
        while(!queue.isEmpty()){
            prvNode = prsNode;
            prsNode = queue.remove();
            if(prsNode.left ==null){
                prvNode.right = null;
                return;
            }else if(prsNode.right ==null){
                prsNode.left = null;
                return;
            }else{
                queue.add(prsNode.left);
                queue.add(prsNode.right);
            }
        }
    }

    public void deleteGivenNode(String value){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode pNode = queue.remove();
            if(pNode.data == value){
                pNode.data = getDeepestNode().data;
                deleteDeepestNode();
                System.out.println("Element is deleted");
                return;
            }else{
                if(pNode.left !=null){
                    queue.add(pNode.left);
                }
                if(pNode.right !=null){
                    queue.add(pNode.right);
                }
            }
        }
        System.out.println("Element not found in Tree");
    }

    public void deleteTree(){
        root = null;
        System.out.println("Tree is deleted");
    }
}
