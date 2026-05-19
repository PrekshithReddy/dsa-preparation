class LRUCache {
    int cap;
    int size = 0;

    int[] keys;
    int[] values;

    public LRUCache(int capacity) {
        cap = capacity;
        keys = new int[cap];
        values = new int[cap];
    }

    public int get(int k) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == k) {
                int val = values[i];
                int tempKey = keys[i];
                int tempVal = values[i];

                // Shift everything left
                for (int j = i; j < size - 1; j++) {
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }

                // Put accessed item at the end
                keys[size - 1] = tempKey;
                values[size - 1] = tempVal;

                return val;
            }
        }
        return -1;
    }

    public void put(int k, int v) {
        for (int i = 0; i < size; i++) {
            if (keys[i] == k) {
                values[i] = v;
                get(k); // move to end
                return;
            }
        }

        if (size < cap) {
            keys[size] = k;
            values[size] = v;
            size++;
        } else {
            // Remove least recently used (shift left)
            for (int i = 0; i < cap - 1; i++) {
                keys[i] = keys[i + 1];
                values[i] = values[i + 1];
            }
            keys[cap - 1] = k;
            values[cap - 1] = v;
        }
    }
}
