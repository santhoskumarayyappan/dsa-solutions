//18-05-2022
//https://leetcode.com/problems/reorganize-string/

class Solution {
      
    public String reorganizeString(String s) {
        int k = 2;
        int n = s.length();
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            charCountMap.merge(ch, 1, (a, b) -> a + b);
        }

        PriorityQueue<Character> q = new PriorityQueue<>(
          (a, b) -> {
            if (charCountMap.get(a) != charCountMap.get(b))
                return Integer.compare(charCountMap.get(b), charCountMap.get(a));
            else 
                return Character.compare(a, b);
          }
        );
        q.addAll(charCountMap.keySet());

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int d = Math.min(k, n);
            List<Character> tempQ = new LinkedList<>();
            for (int i = 0; i < d; i++) {
                if (q.isEmpty()) {
                    return "";
                }
                Character ch = q.poll();
                sb.append(ch);
                charCountMap.put(ch, charCountMap.get(ch) - 1);
                if (charCountMap.get(ch) > 0) {
                    tempQ.add(ch);
                } 
                n--;
            }
            for (Character ch : tempQ) {
                q.add(ch);
            }
        }

        return sb.toString();
    }
}
