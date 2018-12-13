public interface IPersistentMap<KEY extends Comparable<KEY>, VALUE> {

    public VALUE get(KEY key);

    public IPersistentMap<KEY, VALUE> insert(final KEY key, final VALUE value);

    public IPersistentMap<KEY, VALUE> erase(final KEY key);

    public boolean contains(KEY key);

    public int size();

    public Boolean empty();
}
