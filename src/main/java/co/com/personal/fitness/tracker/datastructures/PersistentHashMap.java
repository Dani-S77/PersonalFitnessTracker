package co.com.personal.fitness.tracker.datastructures;

import co.com.personal.fitness.tracker.persistance.DataPersistence;

import java.util.HashMap;
import java.util.Map;

public class PersistentHashMap<K, V> extends HashMap<K, V> {
    private static final long serialVersionUID = 1L;

    private final transient String filename;
    private final transient DataPersistence dataPersistence;
    private final transient boolean autoSave;

    /**
     * Creates a PersistentHashMap with auto-save enabled
     */
    public PersistentHashMap(String filename, DataPersistence dataPersistence) {
        this(filename, dataPersistence, true);
    }

    /**
     * Creates a PersistentHashMap with optional auto-save
     * @param autoSave if true, saves on every modification; if false, manual save required
     */
    public PersistentHashMap(String filename, DataPersistence dataPersistence, boolean autoSave) {
        super();
        this.filename = filename;
        this.dataPersistence = dataPersistence;
        this.autoSave = autoSave;
        loadFromDisk();
    }

    private void loadFromDisk() {
        Map<K, V> loaded = dataPersistence.loadData(filename);
        if (loaded != null && !loaded.isEmpty()) {
            super.putAll(loaded);
        }
    }

    private void saveToDisk() {
        if (autoSave) {
            dataPersistence.saveData(filename, this);
        }
    }

    // Manual save (useful when autoSave = false)
    public void flush() {
        dataPersistence.saveData(filename, this);
    }

    // Override all modification methods to add auto-save

    @Override
    public V put(K key, V value) {
        V result = super.put(key, value);
        saveToDisk();
        return result;
    }

    @Override
    public V remove(Object key) {
        V result = super.remove(key);
        if (result != null) {
            saveToDisk();
        }
        return result;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        super.putAll(m);
        saveToDisk();
    }

    @Override
    public void clear() {
        super.clear();
        saveToDisk();
    }

    @Override
    public V putIfAbsent(K key, V value) {
        V result = super.putIfAbsent(key, value);
        if (result == null) {
            saveToDisk();
        }
        return result;
    }

    @Override
    public boolean remove(Object key, Object value) {
        boolean result = super.remove(key, value);
        if (result) {
            saveToDisk();
        }
        return result;
    }

    @Override
    public V replace(K key, V value) {
        V result = super.replace(key, value);
        if (result != null) {
            saveToDisk();
        }
        return result;
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        boolean result = super.replace(key, oldValue, newValue);
        if (result) {
            saveToDisk();
        }
        return result;
    }
}
