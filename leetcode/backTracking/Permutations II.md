
17-04-2022
[Question](https://leetcode.com/problems/permutations-ii)
```Java
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Map<Integer, Long> counter = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(e -> e, HashMap::new, Collectors.counting()));
        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(comb, nums.length, counter, results);
        return results;
    }

    protected void backtrack(LinkedList<Integer> comb, Integer N, Map<Integer, Long> counter, List<List<Integer>> results) {

        if (comb.size() == N) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }

        for (Map.Entry<Integer, Long> entry : counter.entrySet()) {
            Integer num = entry.getKey();
            Long count = entry.getValue();
            if (count == 0)
                continue;
            comb.addLast(num);
            counter.put(num, count - 1);

            backtrack(comb, N, counter, results);

            comb.removeLast();
            counter.put(num, count);
        }
    }
}
```
