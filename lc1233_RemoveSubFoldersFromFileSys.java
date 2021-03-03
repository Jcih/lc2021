class Solution {
    public List<String> removeSubfolders(String[] folder) {
        
        /*
        /a
        /a/b
        /a/b/c
        /b
        /b/c
        /b/d
        
        string start with "/a/" can be ignored.
        **/
        List<String> res = new ArrayList<>();
        if (folder == null || folder.length == 0) return res;
        Arrays.sort(folder);
        
        for (String s : folder) {
            if (res.isEmpty() || !s.startsWith(res.get(res.size() - 1) + "/")) {
                res.add(s);
            }
        }
        return res;
    }
}