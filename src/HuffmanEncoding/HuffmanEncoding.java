package HuffmanEncoding;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

//https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
//https://www.tutorialspoint.com/java/character_isletter.htm
public class HuffmanEncoding {

    static class HuffmanNode {

        int data;
        char ch;
        HuffmanNode left;
        HuffmanNode right;
    }

    static class HuffmanComparator implements Comparator<HuffmanNode> {

        @Override
        public int compare(HuffmanNode l, HuffmanNode r) {
            return l.data - r.data;
        }
    }

    /**
     *
     * @param root
     * @param s
     */
    public static void printTreeTraversal(HuffmanNode root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.ch)) {
            System.out.println(root.ch + ":" + s);
            return;
        }
        printTreeTraversal(root.left, s + "0");
        printTreeTraversal(root.right, s + "1");
    }

    public static void main(String[] args) {

        int i;
        char t;

        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Enter the String");
        str = sc.nextLine();
        String toLowerCase = str.toLowerCase();

        HashMap<Character, Integer> map = new HashMap<>();
        for (i = 0; i < toLowerCase.length(); i++) {
            t = toLowerCase.charAt(i);
            if (map.containsKey(t)) {
                int val = map.get(t);
                val = val + 1;
                map.put(t, val);
            } else {
                map.put(t, 1);
            }
        }

        System.out.println(map);
        Collection<Integer> values = map.values();
        Character[] keyArray = map.keySet().toArray(new Character[map.size()]);
        Integer[] freqArray = values.toArray(new Integer[map.size()]);
        System.out.println(keyArray.length);
        int n = keyArray.length;

        PriorityQueue<HuffmanNode> pQueue = new PriorityQueue<>(n, new HuffmanComparator());

        HuffmanNode huffmanNode;
        huffmanNode = new HuffmanNode();

        for (i = 0; i < n; i++) {

            huffmanNode.ch = keyArray[i];
            huffmanNode.data = freqArray[i];

            huffmanNode.left = null;
            huffmanNode.right = null;

            pQueue.add(huffmanNode);
        }

        HuffmanNode root = null;
        while (pQueue.size() > 1) {

            HuffmanNode l = pQueue.peek();
            pQueue.poll();

            HuffmanNode r = pQueue.peek();
            pQueue.poll();

            HuffmanNode newNode = new HuffmanNode();
            newNode.data = l.data + r.data;
            newNode.ch = '-';

            newNode.left = l;
            newNode.right = r;
            root = newNode;
            pQueue.add(newNode);
        }
        printTreeTraversal(root, "");
    }

}
