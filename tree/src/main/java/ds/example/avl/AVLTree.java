package ds.example.avl;

import javax.swing.plaf.metal.MetalTheme;
import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    AVLNode root;
    AVLTree(){
        root = null;
    }

    public void preOrder(AVLNode node){
        if(node == null){
            return;
        }
        System.out.println(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(AVLNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.value+" ");
        inOrder(node.right);
    }

    public void postOrder(AVLNode node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value+" ");
    }

    public void levelOrder(AVLNode node){
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            AVLNode prsNode = queue.remove();
            System.out.println(prsNode.value+" ");
            if(prsNode.left!=null){
                queue.add(prsNode.left);
            }if(prsNode.right!=null){
                queue.add(prsNode.right);
            }
        }
    }

    AVLNode search(AVLNode node, int value){
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

    public int getHeight(AVLNode node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    private AVLNode rotateRight(AVLNode dBNode) {
        AVLNode newRoot = dBNode.left;
        dBNode.left = dBNode.left.right;
        newRoot.right = dBNode;
        dBNode.height = 1 + Math.max(getHeight(dBNode.left), getHeight(dBNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    private AVLNode rotateLeft(AVLNode dbNode) {
        AVLNode newRoot = dbNode.right;
        dbNode.right = dbNode.right.left;
        newRoot.left = dbNode;
        dbNode.height = 1 + Math.max(getHeight(dbNode.left), getHeight(dbNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    int getBalanced(AVLNode node){
        if(node == null){
            return 0;
        }else{
            return getHeight(node.left) - getHeight(node.right);
        }
    }

    public void insert(int value){
        root = insertNode(root,value);
    }

     private AVLNode insertNode(AVLNode node, int value){
        if (node == null){
            AVLNode newNode = new AVLNode();
            newNode.value = value;
            newNode.height = 1; // to make calculations easy and avoid additional checks the default height is set to 1
            return newNode;
        }else if(value < node.value){
            node.left = insertNode(node.left,value);
        }else if (value > node.value){
            node.right = insertNode(node.right,value);
         }
        node.height = 1+ Math.max(getHeight(node.left),getHeight(node.right));
        int balance = getBalanced(node);

        if(balance > 1 && value < node.left.value){
            // LL condition
            return rotateRight(node);
        }
         if(balance > 1 && value > node.left.value){
             // LR condition
             node.left = rotateLeft(node.left);
             return rotateRight(node);
         }

         if(balance < -1 && value > node.right.value){
             // RR condition
             return rotateLeft(node);
         }
         if(balance <-1 && value < node.right.value){
             // RL condition
             node.right = rotateRight(node.right);
             return rotateLeft(node);
         }
         return node;
     }

     public static AVLNode minimumNode(AVLNode node){
        if (node.left == null){
            return node;
        }
        return minimumNode(node.left);
     }

     public void  deleteNode(int value){
        deleteNode(root, value);
     }

     public AVLNode deleteNode(AVLNode node, int value){
        if(node == null){
            System.out.println("Value not founf in Tree");
            return node;
        }
        if(value < node.value){
            node.left = deleteNode(node.left, value);
        }else if (value > node.value){
            node.right = deleteNode(node.right, value);
        }else{
            if(node.left !=null && node.right !=null){
                AVLNode temp = node;
                AVLNode minimumNode = minimumNode(temp.right);
                node.value = minimumNode.value; // assign the node with min Node value
                /**
                 * delete the min Node => the child of min Node will be assigned to the parent of Min Node because
                 * when a recursive call is made it will it will satisfy the condition of Node with single child.
                 */
                node.right = deleteNode(node.right,minimumNode.value);
            }else if (node.left!=null){
                node = node.left;
            }else if (node.right != null){
                node = node.right;
            }else {
                /**
                 * leaf node
                 */
                node =null;
            }
        }
         int balance = getBalanced(node);
         /**
          * Below is Balanced factor based Rotation decision which is more preferred thatn the
          * way logic is written in insertNode method. insert node method uses value to determine
          * the rotation logic which might lead to incorrect results in some cases.
          */
         if(balance > 1 && getBalanced(node.left) >=0){
             //LL
             return rotateRight(node);
         }
         if(balance > 1 && getBalanced(node.left) < 0){
             //LR
             node.left = rotateLeft(node.left);
             return rotateRight(node);
         }
         if(balance < -1 && getBalanced(node.right) <= 0){
             //RR
             return rotateLeft(node);
         }
         if(balance < -1 && getBalanced(node.right) > 0){
             //RL
             node.right = rotateRight(node.right);
             return rotateLeft(node);
         }
         return node;
     }

     public void deleteAVLTree(){
        root = null;
         System.out.println("AVL tree has been deleted");
     }
}
