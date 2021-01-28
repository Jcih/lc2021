class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        /*
        1. example
        2. data structure
        3. logic
        4. result
        5. analysis
        ===============
        parse to a map
        key: content, value: List of path
        out put the result of value
        ===============
        follow up: when the content gets very large, hwhat to do:
        use MD5 or SHA256 to hash them to a short string

        ===============
        
        **/
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : paths) {
            String[] split = s.split(" ");
            String folder = split[0];
            for (int i = 1; i < split.length; i++) {
                String file_content = split[i];
                //get file name and content
                String file = getFileName(file_content);
                String content = getContent(file_content);
                
                String filePath = folder + "/" + file;
                
                if (map.containsKey(content)) {
                    map.get(content).add(filePath);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(filePath);
                    map.put(content, list);
                }
            }  
        }
        
        for (Map.Entry<String,List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() >= 2)
                res.add(entry.getValue());
        }
        return res;
    }
    
    public String getFileName(String file_content) {
        for (int i = 0; i < file_content.length(); i++) {
            if (file_content.charAt(i) == '(') {
                return file_content.substring(0, i);
            }
        }
        return " ";
    } 
    public String getContent(String file_content) {
        int n = file_content.length();
        for (int i = 0; i < n; i++) {
            if (file_content.charAt(i) == '(') {
                return file_content.substring(i + 1, n - 1);
            }
        }
        return " ";
    } 
    
}