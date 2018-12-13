public class node<K, V> {
    K key;
    int height;
    V value;
    node<K, V> left;
    node<K, V> right;

    node(K k, V v) {
        key = k;
        left = right = null;
        height = 1;
        value = v;
    }

    node(K k, V v, node left, node right) {
        key = k;
        this.left = left;
        this.right = right;
        height = 1;
        value = v;
    }

    node<K, V> copy() {
        node left = null;
        node right = null;
        if (this.left != null) {
            left = this.left.copy();
        }
        if (this.right != null) {
            right = this.right.copy();
        }
        return new node(key, value, left, right);
    }


}
