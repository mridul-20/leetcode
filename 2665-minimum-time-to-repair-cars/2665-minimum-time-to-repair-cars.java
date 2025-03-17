class Solution {
    public boolean CanRepaired(int[] ranks , long time , int cars){
        long totalCarsRepaired = 0;
        for(int rank: ranks){
            totalCarsRepaired += Math.sqrt(time/rank);
            if(totalCarsRepaired >= cars) return true;
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        long left = 1;
        long right = (long) Arrays.stream(ranks).min().getAsInt() * cars * cars;

        while(left < right){
            long mid = (left+right)/2;
            if(CanRepaired(ranks , mid , cars)){
                right = mid;
            }
            else{
                left = mid+1;
            }

        }
        return left;
    }
}