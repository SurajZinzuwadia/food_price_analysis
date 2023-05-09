package project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class trieST {
    private static final int R = 256;        // extended ASCII


    private Node root;      // root of trie
    private int N;          // number of keys in trie

    private static class Node {
        private HashMap<String, Integer> freq;    // hashmap to store filename and frequency for the word
        private Node[] next = new Node[R];        // child nodes
    }

    public trieST() {
    }

    // method to get the hashmap(occurrence of the key in each filename) from key(word)
    public HashMap<String, Integer> get(String key) {
        Node x = get(root, key, 0);
        // ignore get and return null if unable to find key
        if (x == null) 
        	return null;
        return x.freq;
    }

    // check if key is present in the hashmap(uses the get method)
    public boolean contains(String key) {
        return get(key) != null;
    }

    // recursive get method to parse through nodes of a tree to get the hashmap
    private Node get(Node x, String key, int d) {
    	// base conditions
        if (x == null) 
        	return null;
        // if word is found
        if (d == key.length()) 
        	return x;
        char c = key.charAt(d);
        return get(x.next[c], key, d+1);
    }

    // method to insert the key and auto increment occurrence (takes word(key) and filename as input
    public void put(String key, String map_key) {
    	// ignore if filename is not given
        if (map_key == null) 
        	delete(key);
        else 
        	root = put(root, key, map_key, 0);
    }

    // recursive method to parse through the tree and place the word and occurrence in the trie
    private Node put(Node x, String key, String map_key, int d) {
    	// create character connection if not present
        if (x == null) 
        	x = new Node();
        // if reached to the end of word
        if (d == key.length()) {
        	// if hashmap is not created,  create it and increment the number of keys in the trie
            if(x.freq == null) {
            	N++;
                x.freq = new HashMap<>();
            }
            // if hashmap contains record for the filename, increment it else add the record with the occurence as 1
            if(x.freq.containsKey(map_key))
            	x.freq.put(map_key, x.freq.get(map_key)+1);
            else
            	x.freq.put(map_key, 1);
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, map_key, d+1);
        return x;
    }

    // get size of the trie(number of words present in the trie
    public int size() {
        return N;
    }

    // method to get list of keys from the trie
    public Iterable<String> keys() {
        List<String> results = new ArrayList<String>();
        collect(root, new StringBuilder(""), results);
        return results;
    }

    // helper recursive method to get list of keys
    private void collect(Node x, StringBuilder prefix, List<String> results) {
        if(x == null)
        	return;
        if(x.freq != null)
        	results.add(prefix.toString());
        for(char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    // method to delete a word from the trie
    public void delete(String key) {
        root = delete(root, key, 0);
    }

    // recursive method to parse through the trie to find and delete the word from the trie
    private Node delete(Node x, String key, int d) {
        if (x == null) 
        	return null;
        // if reached the end of word
        if (d == key.length()) {
        	// if word is present remvoe from the list and decrease the size variable
            if (x.freq != null)
            	N--;
            // remove the hashmap
            x.freq = null;
        }
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        // remove subtrie rooted at x if it is completely empty
        if (x.freq != null) 
        	return x;
        for (int c = 0; c < R; c++)
            if (x.next[c] != null)
                return x;
        return null;
    }
}