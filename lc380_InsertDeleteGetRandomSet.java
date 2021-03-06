class RandomizedSet {
    List<Integer> list;
    Map<Integer, Integer> map;// key: value, value: index in list
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        //if not the last element, swap with the last element
        if (index != list.size() - 1) {
            int lastValue = list.get(list.size() - 1);
            list.set(index, lastValue);
            map.put(lastValue, index);
        }
        
        //remove last element in the list
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */