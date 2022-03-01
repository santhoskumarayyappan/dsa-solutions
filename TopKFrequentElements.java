//01-03-2022
//https://leetcode.com/problems/top-k-frequent-elements/



// idea is to construct another List <Count of element i, i>  and Quickselect kth largest element which will be the element with Kth largest frequency
// also Quick select arranges this element in its sorted position so all the elements with Frequency larger than Kth largest Frequent element
// will be found before the Kth largest frequent element

class TopKFrequentElements {
   
    public int partition(List<Pair<Integer, Integer>> countValueList, int l, int r) {
        for (int i = l; i < r; i++) {
            if (countValueList.get(i).getKey() >= countValueList.get(r).getKey()) {
                Collections.swap(countValueList, i, l);
                l++;
            }
        }
        Collections.swap(countValueList, l, r);
        return l;
    }
    
    public int[] quickSelect(List<Pair<Integer, Integer>> countValueList, int k) {
        int l = 0, r = countValueList.size() - 1;
        while(l <= r) {
            int pivot = partition(countValueList, l, r);
            if (pivot == k) {
                break;
            } else if (pivot < k) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }
        return IntStream.range(0, k).map(i -> countValueList.get(i).getValue()).toArray();
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int a : nums) {
            countMap.put(a, countMap.getOrDefault(a, 0) + 1);
        }
        
        List<Pair<Integer, Integer>> countValueList = new ArrayList<>();
        countMap.forEach((value, count) -> {
            countValueList.add(new Pair<>(count, value));
        });      
        return quickSelect(countValueList, k);
    }
}
