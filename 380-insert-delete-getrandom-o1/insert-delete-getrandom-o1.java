class RandomizedSet {
    private final List<Integer> l;
    private final Map<Integer, Integer> m;
    public RandomizedSet() {
        l = new ArrayList<>();
        m = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(m.containsKey(val))
        {
            return false;
        }
        m.put(val, l.size());
        l.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!m.containsKey(val))
        {
            return false;
        }
        int index = m.get(val);
        int lastIndex = l.size()-1;
        int lastElement = l.get(lastIndex);
        if(index != lastIndex)
        {
            l.set(index, lastElement);
            m.put(lastElement, index);
        }
        l.remove(lastIndex);
        m.remove(val);
        return true;
    }
    
    public int getRandom() {
        int index = ThreadLocalRandom.current().nextInt(l.size());
        return l.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */