//24-05-2022
//https://leetcode.com/problems/range-frequency-queries/

class RangeFreqQuery {

    Map<Integer, List<Integer>> valueToIndicesMap;
    
    public RangeFreqQuery(int[] arr) {
        valueToIndicesMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            List<Integer> indices = valueToIndicesMap.getOrDefault(arr[i], new ArrayList<>());
            indices.add(i);
            valueToIndicesMap.put(arr[i], indices);
        }
    }
    
    public int findFirstGreaterThan(List<Integer> indices, int i) {
        int low = 0, high = indices.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (indices.get(mid) > i) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    
    public int query(int left, int right, int value) {
        List<Integer> indices = valueToIndicesMap.getOrDefault(value, new ArrayList<>());
        int countOfValueTillLeftMinusOne = findFirstGreaterThan(indices, left - 1);
        int countOfValueTillRight = findFirstGreaterThan(indices, right);
        return countOfValueTillRight - countOfValueTillLeftMinusOne;        
    }
}

