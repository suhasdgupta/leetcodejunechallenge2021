class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int m = horizontalCuts.length;
        int n = verticalCuts.length;
        int H = Math.max(horizontalCuts[0], h-horizontalCuts[m-1]);
        int V = Math.max(verticalCuts[0], w-verticalCuts[n-1]);
        
        for(int i =1;i<m;i++){
            H =Math.max(H, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        for(int i =1;i<n;i++){
            V =Math.max(V, verticalCuts[i]-verticalCuts[i-1]);
        }
        return (int)(H * 1L * V % 1_000_000_007);
    }
}
