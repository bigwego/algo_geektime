package stringmatching;

import java.util.LinkedList;

public class ACAutomation {

    private final Node root = new Node();

    public static void main(String[] args) {
        ACAutomation ac = new ACAutomation();
        System.out.println(ac.root);
        String[] strs = new String[]{ "at", "art", "oars", "soar" };
        ac.build(strs);
        ac.match("soarsoars");
    }

    private void build(String[] patterns) {
        for (String p : patterns) {
            Node node = root;
            for (char c : p.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new Node();
                }
                node = node.children[idx];
                node.data = c;
            }
            node.isEnd = true;
            node.len = p.length();
        }
    }

    public void buildFailurePointer() {
        root.fail = root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node child : curr.children) {
                if (child == null) {
                    continue;
                }
                if (curr == root) {
                    child.fail = root;
                } else {
                    Node currF = curr.fail;
                    while (currF != root) {
                        Node currFc = currF.children[child.data - 'a'];
                        if (currFc != null) {
                            child.fail = currFc;
                            break;
                        }
                        currF = currF.fail;
                    }
                    child.fail = root;
                }
                queue.add(child);
            }
        }
    }

    private boolean match(String str) {
        Node curr = root;
        for (int i = 0, len = str.length(); i < len; i++) {
            char c = str.charAt(i);
            while (curr != root && curr.children[c - 'a'] == null) {
                curr = curr.fail;
            }
            curr = curr.children[c - 'a'];
            if (curr == null) {
                curr = root;
            }
            Node tmp = curr;
            while (tmp != root) {
                if (tmp.isEnd) {
                    System.out.println("Matching start from: " + (i - tmp.len + 1));
                    return true;
                }
                tmp = tmp.fail;
            }
        }
        return false;
    }

    private class Node {

        private final Node[] children = new Node[26];

        private char data;

        private int len = -1;

        private boolean isEnd = false;

        private Node fail = null;

    }
}
