//08-04-2022
//https://leetcode.com/problems/next-permutation/



class Solution {
    public void nextPermutation(int[] a) {
        int i;
        for (i = a.length - 2; i >= 0; i--) {
            if (a[i] < a[i + 1]) {
                break;
            }
        }
        if (i >= 0) {
            int j = a.length - 1;
            while(a[i] >= a[j]) {
                j--;
            }
            swap(a, i, j);
        }
        reverse(a, i + 1);
        
    }
    
    public void reverse(int a[], int i) {
        int j = a.length - 1;
        while(i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }
    
    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}


// 1 2 3 2 4 
// 1 2 3 4 2
// 1 2 4 2 3
