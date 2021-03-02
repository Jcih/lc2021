/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    /*
    use recursive to add integer to queue
    
    */
    List<NestedInteger> nested;
    Queue<Integer> queue = new LinkedList<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        nested = nestedList;
        flat(nested);
    }
    
    private void flat(List<NestedInteger> nestedList) {
        
        for (NestedInteger cur : nestedList) {
            if (cur.isInteger()) {
                queue.offer(cur.getInteger());
            } else {
                List<NestedInteger> tmp = cur.getList();
                flat(tmp);
            }
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return queue.poll();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */