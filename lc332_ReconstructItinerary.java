//Backtrack, Uber

/*
put the from and to cities in a hashmap, key as the from city, value as the list of to cities.

sort the to list to make sure the smallest lexical order when read as a single string.
Collections.sort()

Use backtrack to add res

if the to city not in the map keys, return false;

*/

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> res = new ArrayList<>();
        if (tickets == null || tickets.size() == 0) return res;
        
        HashMap<String, List<String>> fromTo = new HashMap<>();
        for (List<String>  ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            
            if (fromTo.containsKey(from)) {
                fromTo.get(from).add(to);
            } else {
                List<String> toList = new ArrayList<>();
                toList.add(to);
                fromTo.put(from, toList);
            }
        }
        
        for (Map.Entry<String, List<String>> entry : fromTo.entrySet()) {
            Collections.sort(entry.getValue());
        }
        
        res.add("JFK");
        dfs(fromTo, res, tickets.size() + 1);
        return res;
    }
    
    
    private boolean dfs(HashMap<String, List<String>> map, List<String> res, int size) {
        if (res.size() == size) return true;
        String to = res.get(res.size() - 1);
        if (!map.containsKey(to)) return false;
        
        List<String> toList = map.get(to);
        for (int i = 0; i < toList.size(); i++) {
            String dest = toList.get(i);
            res.add(dest);
            toList.remove(i);
            if (dfs(map, res, size)) return true;
            res.remove(res.size() - 1);
            toList.add(i, dest);
        }
        return false;
    }
}