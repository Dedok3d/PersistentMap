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
}