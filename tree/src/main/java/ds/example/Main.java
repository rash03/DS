package ds.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        TreeNode drinks = new TreeNode("Drinks");
        TreeNode hot = new TreeNode("hot");
        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");
        hot.addChild(tea);
        hot.addChild(coffee);
        TreeNode cold = new TreeNode("cold");
        TreeNode wine = new TreeNode("wine");
        TreeNode beer = new TreeNode("beer");
        cold.addChild(wine);
        cold.addChild(beer);
        drinks.addChild(hot);
        drinks.addChild(cold);
        System.out.println(drinks.print(0));
    }

}