package ds.example.trie;

public class Trie {

    private TrieNode root;

    public Trie(){
        root = new TrieNode();
        System.out.println("New Trie Node has been created");
    }

    public void insert(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node ==null){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Success fully inserted"+ word+" in Trie");
    }

    public boolean search(String word){
        TrieNode current = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node ==null){
                System.out.println("Search word: "+word+" does not exist in Trie");
                return false;
            }
            current = node;
        }
        if(current!=null && current.endOfString){
            System.out.println("Search word: "+word+" does not exist in Trie or is a Prefix of another string");
        }else{
            System.out.println("Search word: "+word+" does exist in Trie");
        }
        return current.endOfString;
    }

    public void delete(String word){
        if(search(word)){
            delete(root,word,0);
        }
    }
    public boolean delete (TrieNode parentNode, String word, int index){
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted = false;

        if(currentNode.children.size() > 1){
            delete(currentNode,word,index+1);
            return false;
        }
        if(index == word.length()-1){
            if(currentNode.children.size() >= 1){
                currentNode.endOfString = false;
                return false;
            }else{
                parentNode.children.remove(ch);
                return true;
            }
        }
        if(currentNode.endOfString == true){
            delete(currentNode,word,index+1);
            return false;
        }
        canThisNodeBeDeleted = delete(currentNode,word,index+1);
        if(canThisNodeBeDeleted){
            parentNode.children.remove(ch);
            return true;
        }else{
            return false;
        }
    }
}
