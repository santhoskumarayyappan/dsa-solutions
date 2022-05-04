

//https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1/
class Solution
{
    
    static long inversionCount = 0;
    static void mergeHelper(long arr[], int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        
        long[] left = Arrays.copyOfRange(arr, l, mid + 1);
        long[] right = Arrays.copyOfRange(arr, mid + 1, r + 1);
        
        int i = 0;
        int j = 0;
        int k = l;
        
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                inversionCount += mid - (i + l) + 1;
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
        
        
    }
    static void merge(long arr[], int i, int j) {
        if (i < j) {
            int mid = i + (j - i) / 2;
            merge(arr, i, mid);
            merge(arr, mid + 1, j);
            mergeHelper(arr, i, mid, j);
        }
    }
    static long inversionCount(long arr[], long N)
    {
        inversionCount = 0;
        merge(arr, 0, arr.length - 1);
        return inversionCount;
    }
}
