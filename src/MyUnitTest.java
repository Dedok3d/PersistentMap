import org.junit.jupiter.api.Test;

public class MyUnitTest {

    @Test
    public void testMap() {
        PersistentMap<Integer, Integer> emptyMap = new PersistentMap<>();
        PersistentMap<Integer, Integer> map_1_10 = emptyMap.insert(1, 10);
        PersistentMap<Integer, Integer> map_1_10_2_20 = map_1_10.insert(2, 20);
        PersistentMap<Integer, Integer> map_1_10_2_30 = map_1_10.insert(2, 30);
        PersistentMap<Integer, Integer> map_2_20 = map_1_10_2_20.erase(1);

        assert (emptyMap.empty());
        assert (!emptyMap.contains(1));
        assert (!emptyMap.contains(2));
        assert (!map_1_10.empty());
        assert (map_1_10.contains(1));
        assert (!map_1_10.contains(2));
        assert (!map_2_20.contains(1));
        assert (map_2_20.contains(2));
        assert (map_1_10_2_20.size() == 2);
        assert (map_1_10_2_30.size() == 2);
        assert (map_1_10_2_20.get(2) == 20);
        assert (map_1_10_2_30.get(2) == 30);

    }

    @Test
    public void test100list() {

        PersistentMap<Integer, Integer> Map = new PersistentMap<>();
        for(int i=0; i<100; i++){
            Map = Map.insert(i, 10);
        }
        assert (Map.size() == 100);
    }

    @Test
    public void test1000list() {

        PersistentMap<Integer, Integer> Map = new PersistentMap<>();
        for(int i=0; i<1000; i++){
            Map = Map.insert(i, 10);
        }
        assert (Map.size() == 1000);
    }

    @Test
    public void test10000list() {

        PersistentMap<Integer, Integer> Map = new PersistentMap<>();
        for(int i=0; i<10000; i++){
            Map = Map.insert(i, 10);
        }
        assert (Map.size() == 10000);
    }

    @Test
    public void test100000list() {

        PersistentMap<Integer, Integer> Map = new PersistentMap<>();
        for(int i=0; i<100000; i++){
            Map = Map.insert(i, 10);
        }
        assert (Map.size() == 100000);
    }

    @Test
    public void test1000000list() {

        PersistentMap<Integer, Integer> Map = new PersistentMap<>();
        for(int i=0; i<1000000; i++){
            Map = Map.insert(i, 10);
        }
        assert (Map.size() == 1000000);
    }


}