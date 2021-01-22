package Array._0941;

class Solution{
    public static boolean validMountainArray(int[] arr){
        int maxIndex = 0;
        for(int i = 0; i < arr.length -1; i++){
            if(arr[i+1] == arr[i]) {
                return false;
            }
            if (arr[i + 1] < arr[i]) {
                maxIndex = i;
                break;
            }
        }
        if(maxIndex == 0 || maxIndex == arr.length-1 ) return  false;
        for (int i = maxIndex; i<arr.length-1; i++){
            if(arr[i] <= arr[i+1]) return false;
        }
        return true;
    }

    //简洁写法
    public boolean betterValidMountainArray(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
        }
}