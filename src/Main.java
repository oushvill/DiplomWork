/*public class Main {
    public static void main(String[] args) {
        int N = 5;
        int W = 10;
        int[] p = new int[]{0, 5, 2, 3, 4, 0};
        int[][] links = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };
        int g = 2;
        double[][] memo = new double[N+1][W+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                memo[i][j] = -1;
            }
        }
        double minCost = Graph1.calculatePhi(N, W, p, links, g, memo);
        System.out.println("Minimum cost: " + minCost);
    }
}*/