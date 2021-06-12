class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if(startFuel>=target) return 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        int i=0, n=stations.length, maxDistance = startFuel;
        int stops=0;
        
        while(maxDistance<target){
            while(i<n && stations[i][0]<=maxDistance){
                queue.add(stations[i][1]);
                i++;
            }
            if(queue.isEmpty()) return -1;
            maxDistance+=queue.poll();
            stops++;
        }
        
        return stops;
    }
}
