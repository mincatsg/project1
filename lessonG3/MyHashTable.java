package lessonG3;

import java.util.HashMap;

public class MyHashTable<K, V> extends HashMap<K, V> {
    @Override
    public synchronized V get(Object key) {
        return super.get(key);
    }

    @Override
    public synchronized V put(K key, V value) {
        return super.put(key, value);
    }

    @Override
    public synchronized V remove(Object key) {
        return super.remove(key);
    }
}
