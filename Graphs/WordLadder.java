/**
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


**/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int counter = 0;
        Set<String> words = new HashSet<>(wordList);
        Queue <String> queue = new LinkedList<>();
        if (!words.contains(endWord))
            return 0;
        queue.offer(beginWord);
        int count = 0;
        while(!queue.isEmpty()){
            for (int k = queue.size(); k > 0; --k){
                String transformed = queue.poll();
                if(transformed.equals(endWord))
                    return count + 1;
                for(int i = 0 ; i < transformed.length() ; i++){
                    char [] charTrans = transformed.toCharArray();
                    for(char c = 'a'; c <='z'; c++){
                        charTrans[i] = c;
                        String newWord = new String(charTrans);
                        if(words.contains(newWord) && !transformed.equals(newWord)){
                            queue.offer(newWord);
                            words.remove(newWord);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}
