Welcome to Facebook!
 
This is just a simple shared plaintext pad, with no execution capabilities.
 
When you know what language you would like to use for your interview,
simply choose it from the dropdown in the top bar.
 
Enjoy your interview!
 
 
 
Description
Given a list of words, find all candidates that match the given pattern where every character 
in the pattern is uniquely mapped to a character in the words.
 
 
Question Statement
Examples:
 
Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pat = "mno"
Output: [abc xyz]
Explanation: 
abc and xyz have all distinct characters, similar to the pattern
 
Input:  
dict = ["abb", "abc", "xyz", "xyy"];
pattern = "aba"
Output: [] 
Explanation: 
Pattern has same character at index 0 and 2. 
No word in dictionary follows the pattern.
 
Input:   
dict = ["car", "cat", "book", "zoo"]; 
pat = "abb" 
Output: [zoo] 
Explanation: zoo has two two different characters and the pattern is similar to 'abb'
  
  
  /*
  abb
  mno
  
  map <a, m>
  map<b, n>
  b map.get(b)
  
  Map<word, pat>
  Map<pat, word>
  
  */
  
  /*
  pat = mno 
  word = abb
  
  map <m, a>
  map <n, b>
  map <o, b>
  
  
  abb
  [1, 2]
  
  word: zoo
  diff = 'z' -'a'
  'o' - 'a'
  [         1]
  [0]*26
  
  */
  
  class Solution {
      public List<String> findCandidatesMatchPattern(List<String> dict, String pattern) {
        
        List<String> res = new ArrayList<>();
        if (dict == null || dict.size() == 0) {
            return res;
        }
        
        layer1:
        for (String word: dict) {
          Map<Character, Character> wordToP = new HashMap<>();
          Map<Character, Character> patternToW = new HashMap<>();
          
          if (word.length() != pattern.length()) continue;
          if (word == null || pattern == null) continue;

          /*
          word: mno
          pat: abb
          
          len = 3
          w_c = m, p_c = a
          patternToW{a: m, b: n}
          wordToP{m: a, n: b,}
          
          word : zoo
          pat : abb
          
          patternToW{a: z, b: o}
          wordToP{z: a, o: b,}
          
          res : ["zoo"]
          
          Time Complexity : O(N*M) N is number of words, M length of pattern
          Space Complexity: T(M), M is length of Pattern
          
          
          **/
          int len = word.length();
          for (int i = 0; i < len; i++) {
              char w_c = word.charAt(i);
              char p_c = pattern.charAt(i);
            
              if (!patternToW.containsKey(p_c)) {
                  patternToW.put(p_c, w_c);
              } else {
                 if (patternToW.get(p_c) == w_c) {
                     continue;
                 } else {
                     continue layer1;
                 }
              
              }
            
              if (!wordToP.containsKey(w_c)) {
                  wordToP.put(w_c, p_c);
              } else {
                  if (wordToP.get(w_c) == p_c) {
                      continue;
                  } else {
                      continue layer1;
                  }
                
              }     
          }
          
          res.add(word);
        }
           
        return res;
        
      }
  
  }
