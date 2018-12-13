public class PersistentMap<KEY extends Comparable<KEY>, VALUE> implements IPersistentMap<KEY, VALUE> {

    private MyAvlTree<KEY, VALUE> tree;

    public PersistentMap() {
        this.tree = new MyAvlTree<>(null, 0);

    }

    private PersistentMap(MyAvlTree<KEY, VALUE> newTree) {
        this.tree = newTree;
    }

    @Override
    public VALUE get(KEY key) {
        return tree.getByKey(key);
    }

    @Override
    public PersistentMap insert(KEY key, VALUE v) {
        return new PersistentMap(this.tree.insert(key, v));
    }

    @Override
    public PersistentMap erase(KEY key) {
        return new PersistentMap(this.tree.remove(key));
    }

    @Override
    public boolean contains(KEY key) {
        return tree.contains(key);
    }

    @Override
    public int size() {
        return this.tree.getSize();
    }

    @Override
    public Boolean empty() {
        return this.tree.getSize() == 0 ? true : false;
    }
}
