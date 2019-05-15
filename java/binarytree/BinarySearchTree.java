package binarytree;

public class BinarySearchTree {

    private Node root;

    public Node find(int val) {
        Node node = root;
        while (node != null) {
            if (node.val < val) {
                node = node.right;
            } else if (node.val > val) {
                node = node.left;
            } else {
                return node;
            }
        }
        return node;
    }

    public void insert(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }
        Node node = root;
        while (node != null) {
            if (node.val > val) {
                if (node.right == null) {
                    node.right = new Node(val);
                    return;
                }
                node = node.right;
            } else {
                if (node.left == null) {
                    node.left = new Node(val);
                    return;
                }
                node = node.left;
            }
        }
    }

    public void delete(int val) {
        Node tbd = root;
        Node p = null;
        while (tbd != null && tbd.val != val) {
            p = tbd;
            if (tbd.val < val) {
                tbd = tbd.right;
            } else if (tbd.val > val) {
                tbd = tbd.left;
            }
        }

        if (tbd == null) {
            return;
        }

        if (tbd.left != null && tbd.right != null) {
            Node rightMin = tbd.right;
            Node minP = tbd;
            while (rightMin.left != null) {
                minP = rightMin;
                rightMin = rightMin.left;
            }
            tbd.val = rightMin.val;
            tbd = rightMin;
            p = minP;
        }

        Node child = tbd.left == null ? tbd.right : tbd.left;
        if (p == null) {
            p = child;
        } else if (p.left == tbd) {
            p.left = child;
        } else {
            p.right = child;
        }
    }

    public void delete2(int val) {
        delete(root, val);
    }

    private Node delete(Node node, int val) {
        if (node == null) {
            return null;
        }

        if (node.val > val) {
            node.left = delete(node.left, val);
        } else if (node.val < val) {
            node.right = delete(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                return node.left == null ? node.right : node.left;
            } else {
                Node rightMin = findMin(node.right);
                node.val = rightMin.val;
                node.right = delete(node.right, rightMin.val);
            }
        }
        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    class Node {

        private int val;

        private Node left;

        private Node right;

        Node(int val) {
            this.val = val;
        }
    }
}
