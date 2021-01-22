package Array._0605;

class Solution{
    public boolean canPlaceFlowers(int[] flowerbed , int n ){
        int maxFlow = 0;
        int count = 0;
        if(flowerbed.length == 1 && flowerbed[0] ==0){
            maxFlow = 1;
        }else {
            if (flowerbed[0] == 0 && flowerbed[1] == 0) {
                flowerbed[0] = 1;
                maxFlow += 1;
            }
            for (int i = 0; i <= flowerbed.length - 1; i++) {
                if (flowerbed[i] == 1) {
                    maxFlow += maxFlower(count);
                    count = 0;
                }
                if (flowerbed[i] == 0) {
                    count++;
                }
            }
            if (flowerbed[flowerbed.length - 1] == 0)
                maxFlow += maxFlower(count + 1);
        }
        return maxFlow>=n;
    }

    public int maxFlower(int k){
        if(k <= 2) return 0;
        return (k-1)/2;
    }
}