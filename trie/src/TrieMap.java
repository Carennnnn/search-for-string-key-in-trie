//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class TrieMap implements TrieMapInterface{
    TrieMapNode root;

    public TrieMap(){
        root = new TrieMapNode();
    }

    //Indirectly recursive method to meet definition of interface
    public void put(String key, String value){
        if(key.length() == 0){
            return;
        }

        put(key, value, root);
        return;
    }

//Recursive method
// Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution

    public void put(String newKey, String value, TrieMapNode newNode){
        Character character = newKey.charAt(0);
        if(newNode.getChildren().containsKey(character)){
            newKey = newKey.substring(1);
            if(newKey.length() == 0 && newNode.getChildren().get(character).getValue() == null){
                newNode.getChildren().get(character).setValue(value);
                return;
            }
        }else{
            TrieMapNode aNewNode = new TrieMapNode();
            newNode.getChildren().put(character, aNewNode);
            newKey = newKey.substring(1);
            if(newKey.length() == 0){
                newNode.getChildren().get(character).setValue(value);
                return;
            }
        }

        put(newKey, value, newNode.getChildren().get(character));

    }


    //Indirectly recursive method to meet definition of interface
    public String get(String key){
        if(key.length() == 0){
            return null;
        }
        return get(root, key);
    }

    //Recursive method
    //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
    public String get(TrieMapNode current, String curKey){
        Character c = curKey.charAt(0);

        if(current.getChildren().containsKey(c)){
            curKey = curKey.substring(1);
            if(curKey.length() == 0){
                TrieMapNode nextNode = current.getChildren().get(c);
                if(nextNode.getValue() != null){
                    return nextNode.getValue(); }
            }
            else{
                return get(current.getChildren().get(c), curKey);
            }
        }

        return null;

    }

    //Indirectly recursive method to meet definition of interface
    public boolean containsKey(String key){
        if(key.length() == 0){
            return false;
        }
        return containsKey(root, key);
    }

    //Recursive method
    //Note: arguments are only a suggestion, you may use your own if you devise a different recursive solution
    public boolean containsKey(TrieMapNode current, String curKey){
        Character c = curKey.charAt(0);
        boolean contain = false;
        if(current.getChildren().containsKey(c)){
            curKey = curKey.substring(1);
            if(curKey.length() == 0){
                TrieMapNode nextNode = current.getChildren().get(c);
                if(nextNode.getValue() != null){
                    contain = true;
                }
            }
            else{
                return containsKey(current.getChildren().get(c), curKey);
            }
        }return contain;
    }

    //Indirectly recursive method to meet definition of interface
    public ArrayList<String> getKeysForPrefix(String prefix){
        return new ArrayList<String>();
    }

    //Recursive helper function to find node that matches a prefix
    //Note: only a suggestion, you may solve the problem is any recursive manner
    public TrieMapNode findNode(TrieMapNode current, String curKey){
        return null;
    }

    //Recursive helper function to get all keys in a node's subtree
    //Note: only a suggestion, you may solve the problem is any recursive manner
    public ArrayList<String> getSubtreeKeys(TrieMapNode current){
        return new ArrayList<String>();
    }

    //Indirectly recursive method to meet definition of interface
    public void print(){
        print(root);
    }


    //Recursive method to print values in tree
    public void print(TrieMapNode current) {

        if (current.getChildren().isEmpty()) {
            return;
        }
        if (current.getValue() != null) {
            System.out.println(current.getValue());
        }

            ArrayList<TrieMapNode> allNodes = new ArrayList<>();
            for (TrieMapNode n : current.getChildren().values()) {
                allNodes.add(n);
            }
            for (int i = 0; i < allNodes.size(); i++) {
                print(allNodes.get(i));
            }
        }




    public static void main(String[] args){
        //You can add some code in here to test out your TrieMap initially
        //The TrieMapTester includes a more detailed test

    }
}