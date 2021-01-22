package Array._1013;

class Solution{
    public boolean canThreePartsEqualSum(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; ++i){
            sum += arr[i];
        }
        if( sum%3 == 0 ){
            //这里的条件不能写作sum!=0 && sum% = 0,否则会导致{1，-1，1，-1，1，-1，1，-1}用例失败
            int subSum = sum / 3;
            // 这里应该首先从arr[0]开始加，不然会导致{1，-1，1，-1}这个用例失败
            int subSum1 = arr[0];
            int subSum2 = arr[arr.length-1];
            int subSum3 =0;

            int i = 1;
            int j = arr.length -2;

            while (subSum1 != subSum && i < j){
                subSum1 += arr[i];
                i++;
            }
            i--;
            while (subSum2 != subSum && i < j){
                subSum2 +=arr[j];
                j--;
            }
            j++;
            if (i!=j-1){
                for (int mid = i+1; mid < j; mid++){
                    subSum3 += arr[mid];
                }
                if (subSum3 == subSum) return true;

            }
        }
        return false;
    }
}