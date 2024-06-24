package ds.example;

import java.util.ArrayList;

public class TreeNode {

    String data;
    ArrayList<TreeNode> childern;

    public TreeNode(String data){
        this.data = data;
        this.childern = new ArrayList<>();
    }

    public void addChild(TreeNode node){
        this.childern.add(node);
    }

    public String print(int level){
        String ret;
        ret = " ".repeat(level)+data+"\n";
        for(TreeNode node : this.childern){
            ret +=node.print(level+1);
        }
        return ret;
    }

}
