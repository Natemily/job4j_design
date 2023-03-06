package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    private int indexFound(K key) {
        int index;
        if (key == null) {
            index = 0;
        } else {
            index = indexFor(hash(key.hashCode()));
        }
        return index;
    }

    @Override
    public boolean put(K key, V value) {
        boolean result = false;
        int i = indexFound(key);
        if (table[i] == null) {
            table[i] = new MapEntry<>(key, value);
            result = true;
            count++;
            modCount++;
        }
        if (capacity * LOAD_FACTOR <= count) {
            expand();
        }
        return result;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] doubleTable = new MapEntry[capacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                if (table[i].key == null) {
                    doubleTable[0] = table[i];
                } else {
                    int j = indexFor(hash(table[i].key.hashCode()));
                    doubleTable[j] = table[i];
                }
            }
        }
        table = doubleTable;
    }

    @Override
    public V get(K key) {
        V result = null;
        int i = indexFound(key);
        if (key == null) {
            if (table[0] != null && table[0].key == null) {
                result = table[0].value;
            }
        } else {
            if (checkNull(i, key)) {
                result = table[i].value;
            }
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        boolean result = false;
        int i = indexFound(key);
        if (key == null) {
            if (table[0] != null && table[0].key == null) {
                table[0] = null;
                result = true;
                count--;
                modCount++;
            }
        } else {
            if (checkNull(i, key)) {
                table[i] = null;
                result = true;
                count--;
                modCount++;
            }
        }
        return result;
    }

    private boolean checkNull(int i, K key) {
        return table[i] != null
                && table[i].key != null
                && key.hashCode() == table[i].key.hashCode()
                && key.equals(table[i].key);
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private final int expectedModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < capacity && table[index] == null) {
                    index++;
                }
                return index < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}