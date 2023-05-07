/*public class Graph1 {
    public static double calculatePhi(int k, int w, int[] p, int[][] links, int g, double[][] memo) {
        if (k == 0) {
            // если мы находимся в истоке, то значение phi = 0
            return 0;
        }
        if (memo[k][w] != -1) {
            // если значение phi уже вычислено, то возвращаем его
            return memo[k][w];
        }
        double minCost = Double.POSITIVE_INFINITY;
        for (int xk = 0; xk <= w; xk++) {
            double cost = xk * p[k];
            for (int j = 0; j < links[k].length; j++) {
                if (links[k][j] == 0) {
                    // если нет дуги ведущей к j, то пропускаем эту вершину
                    continue;
                }
                int capacity = w + xk - links[k][j] * g;
                double pathCost = calculatePhi(j, capacity, p, links, g, memo);
                cost += pathCost;
            }
            minCost = Math.min(minCost, cost);
        }
        memo[k][w] = minCost;
        return minCost;
    }
}*/