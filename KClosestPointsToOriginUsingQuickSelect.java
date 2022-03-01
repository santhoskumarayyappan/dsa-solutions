//01-03-2022
//https://leetcode.com/problems/k-closest-points-to-origin/




// idea is to use Quick Select which returns K th smallest element, a[i] and also puts a[i] in its sorted position i.e a[0 ... i] <= a[i] and a[i] <= a[i + 1 ... n - 1]
// so we can return a[0 ... i]

class KClosestPointsToOriginUsingQuickSelect {
    public int getDistance(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
    
    public void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
    
    public int partition(int[][] points, int l, int r) {
        int pivotDistance = getDistance(points[r]);
        for (int i = l; i < r; i++) {
            if (getDistance(points[i]) <= pivotDistance) {
                swap(points, l, i);
                l++;
            }
        }
        swap(points, l, r);
        return l;
    }
    
    public int randomPartition(int[][] points, int l, int r) {
        int randomPivot = (int)(Math.random() * (r - l + 1));
        swap(points, r, l + randomPivot);
        return partition(points, l, r);
    }
    
    public void quickSelect(int[][] points, int k) {
        int l = 0, r = points.length - 1;
        while (l <= r) {
            int pivot = randomPartition(points, l, r);
            if (pivot == k) {
                return;
            } else if (pivot < k) {
                l = pivot + 1;
            } else {
                r = pivot - 1;
            }
        }
    }
    
    public int[][] kClosest(int[][] points, int k) {
       quickSelect(points, k - 1);
       return Arrays.copyOfRange(points, 0, k);
    }
}
