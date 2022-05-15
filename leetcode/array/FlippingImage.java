//04-03-2022
//https://leetcode.com/problems/flipping-an-image/



class Solution {
  
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
  
    public int[][] flipAndInvertImage(int[][] image) {
        int[] flip = {1, 0};
        for (int k = 0; k < image.length; k++) {
            int i = 0, j = image[0].length - 1;
            while (i <= j) {
                if (i == j) {
                    image[k][i] = flip[image[k][i]];
                } else {
                    swap(image[k], i, j);
                    image[k][i] = flip[image[k][i]];
                    image[k][j] = flip[image[k][j]];
                }
                i++;
                j--;
            }
        }
        return image;
    }
}
