public class MyAvlTree<KEY extends Comparable<KEY>, VALUE> {

    private node<KEY, VALUE> root;
    private int size;

    public MyAvlTree(node<KEY, VALUE> root) {
        if (root == null) this.size = 0;
        else this.size = 1;
        this.root = root;

    }

    public MyAvlTree(node<KEY, VALUE> root, int size) {
        this.root = root;
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public node getRoot() {
        return root;
    }

    public void setRoot(node<KEY, VALUE> root) {
        this.root = root;
    }

    private int height(node p) {
        if (p == null) return 0;
        else return p.height;
    }

    private void recalculateHeight(node p) {
        int hl = height(p.left);
        int hr = height(p.right);
        p.height = Math.max(hl, hr) + 1;
    }


    private int getBalance(node p) {
        if (p == null) return 0;
        int balance = 0;
        if (p.left != null) {
            balance += p.left.height;
        }
        if (p.right != null) {
            balance -= p.right.height;
        }

        return balance;
    }

    private node rotateRight(node p) {
        node q = p.left;
        p.left = q.right;
        q.right = p;
        recalculateHeight(p);
        recalculateHeight(q);
        return q;
    }

    private node roteteLeft(node q) {
        node p = q.right;
        q.right = p.left;
        p.left = q;
        recalculateHeight(p);
        recalculateHeight(q);
        return p;
    }

    private node balance(node p) {
        recalculateHeight(p);
        if (getBalance(p) == -2) {
            if (getBalance(p.right) > 0)
                p.right = rotateRight(p.right);
            return roteteLeft(p);
        }
        if (getBalance(p) == 2) {
            if (getBalance(p.left) < 0)
                p.left = roteteLeft(p.left);
            return rotateRight(p);
        }
        return p;
    }

    public boolean contains(KEY key) {
        if (getByKey(key) == null) return false;
        return true;
    }

    public MyAvlTree<KEY, VALUE> insert(KEY k, VALUE v) {
        int contain = 1;
        if (contains(k)) {
            contain = 0;
        }
        node tmp = null;
        if (this.root != null) tmp = this.root.copy();
        tmp = insert(tmp, k, v);
        return new MyAvlTree<>(tmp, this.size + contain);
    }

    private node insert(node<KEY, VALUE> p, KEY k, VALUE v) {
        if (p == null) return new node(k, v);
        if (k.compareTo(p.key) < 0)
            p.left = insert(p.left, k, v);
        else if (k.compareTo(p.key) > 0) {
            p.right = insert(p.right, k, v);
        } else {
            p.value = v;
        }
        return balance(p);
    }

    private node findmax(node p) {
        if (p == null) return p;
        if (p.right != null) {
            return findmax(p.right);
        } else {
            return p;
        }
    }

    private node removemax(node p) {
        if (p.right == null)
            return p.left;
        p.right = removemax(p.right);
        return balance(p);
    }

    public MyAvlTree remove(KEY k) {
        node tmp = this.root.copy();
        if (!contains(k)) {
            return new MyAvlTree<>(tmp, this.size);
        }
        tmp = remove(tmp, k);
        return new MyAvlTree<>(tmp, this.size - 1);
    }

    private node remove(node<KEY, VALUE> p, KEY k) {
        if (p == null) return null;
        if (k.compareTo(p.key) < 0) {
            p.left = remove(p.left, k);
        } else {
            if (k.compareTo(p.key) > 0) {
                p.right = remove(p.right, k);
            } else {
                node l = p.left;
                node r = p.right;

                if (l == null) return r;
                node leftMax = findmax(l.right);

                if (leftMax == null) {
                    leftMax = l;
                    leftMax.right = r;
                } else {
                    l.right = removemax(l.right);
                    leftMax.left = l;
                    leftMax.right = r;
                }


                return balance(leftMax);
            }
        }
        return balance(p);
    }

    public void print() {
        print(this.root, 1);
    }

    private void print(node node, int level) {
        if (node == null) {
            return;
        }

        print(node.left, level + 1);
        for (int i = 0; i < level; ++i) {
            System.out.print('\t');
        }
        System.out.println(node.key + ":" + node.value);
        print(node.right, level + 1);
    }

    public VALUE getByKey(KEY k) {
        return this.getByKey(this.root, k);
    }

    private VALUE getByKey(node<KEY, VALUE> p, KEY k) {
        if (p == null) return null;
        if (p.key == k) return p.value;
        if (k.compareTo(p.key) < 0)
            return getByKey(p.left, k);
        else
            return getByKey(p.right, k);
    }

}
