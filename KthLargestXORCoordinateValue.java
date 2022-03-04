class KthLargestXORCoordinateValue {
    
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    int partition(int[] a, int l, int r) {
        if(l >= r) return l;
        int i = l - 1, j = r + 1, pivot = a[l];
        while(true) {
            while(a[++i] > pivot);
            while(a[--j] < pivot);
            if(i < j) {
                swap(a, i, j);
            }
            else return j;
        }
    }
    
    public int randomPartition(int[] a, int l, int r) {
         int pivot = (int) (Math.random() * (r - l + 1)) + l;
         swap(a, pivot, l);
         return partition(a, l, r);
    }
    
    public int helper(int[] a, int i, int j, int k) {
        while(i < j) {
            int pivot = partition(a, i, j);
            if(pivot < k) i = pivot + 1;
            else j = pivot;
        }
        return a[i];
    }
    
    public int[] computeXor(int[][] matrix) {
        int[] a = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 && j == 0) {
                    
                } else if (i == 0) {
                    matrix[i][j] ^= matrix[i][j - 1];
                } else if (j == 0) {
                    matrix[i][j] ^= matrix[i - 1][j];
                } else {
                    matrix[i][j] ^= matrix[i - 1][j] ^ matrix[i][j - 1] ^ matrix[i - 1][j - 1];
                }
                a[i * matrix[0].length + j] = matrix[i][j];
            }
        }
        return a;
    }
    
    public int kthLargestValue(int[][] matrix, int k) {
        int[] a = computeXor(matrix);
        int i = 0, j = a.length - 1;
        return helper(a, i, j, k - 1);     
    }
}
