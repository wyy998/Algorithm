import java.util.Vector;

/**
 * Bitree
 */
public class Bitree {
    private Node root = null;

    public Bitree() {
    }

    public Bitree(Node r) {
        root = r;
    }

    private void addNode(Node r, Node p) {
        if (r == null) {
            return;
        }
        if (p.value < r.value) {
            if (r.left == null) {
                r.left = p;
            } else {
                addNode(r.left, p);
            }
        } else if (p.value > r.value) {
            if (r.right == null) {
                r.right = p;
            } else {
                addNode(r.right, p);
            }
        }
    }

    public void add(int v) {
        Node p = new Node(v);
        if (root == null) {
            root = p;
            return;
        }
        addNode(root, p);
    }

    private void mid(Node p, Vector v) {
        if (p != null) {
            mid(p.left, v);
            v.add(p.value);
            mid(p.right, v);
        }
    }

    public Vector midOrder() {
        Vector v = new Vector();
        mid(root, v);
        return v;
    }
}

class Node {
    public int value = 0;
    public Node left = null;
    public Node right = null;

    public Node(int value) {
        this.value = value;
    }
}