# PersistentMap

Persistent Map by avl-tree

### Prerequisites

Persistent Map under avl-tree, it's my implementation this interface:

```
public interface IPersistentMap<KEY extends Comparable<KEY>,VALUE> {

    public VALUE get(KEY key);

    public IPersistentMap<KEY,VALUE> insert(final KEY key, final VALUE value);

    public IPersistentMap<KEY,VALUE> erase(final KEY key);

    public boolean contains(KEY key);

    public int size() ;

    public Boolean empty();
}
```

## Author

* **Sergey Demidov** - *Initial work* - [Dedok3d](https://github.com/Dedok3d)

You can send feedback [email message](sersh_96@mail.ru) if you want.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to my professor whose take this [task](http://stenenko.com/teach/algo/18225/map.html).
