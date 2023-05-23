import java.util.*;

public class Graph {
    private Map<Integer, List<Edge>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge(int i, int j, int l) {
        List<Edge> list = adj.get(i);
        if (list == null) {
            list = new ArrayList<>();
            adj.put(i, list);
        }
        list.add(new Edge(i, j, l));
    }

    public List<Edge> getEdges(int vertex) {
        return adj.get(vertex);
    }

    public Set<Integer> vertexSet() {
        return adj.keySet();
    }

    public double getLength(int a, int b) {
        List<Edge> edges = adj.get(a);
        for (Edge edge : edges) {
            if (edge.b == b) {
                return edge.l;
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Graph L = new Graph();
        L.addEdge(0, 1, 20);
        L.addEdge(0, 2, 35);
        L.addEdge(1, 3, 55);
        L.addEdge(2, 4, 70);
        L.addEdge(3, 5, 60);
        L.addEdge(4, 6, 100);
        L.addEdge(5, 7, 80);
        L.addEdge(6, 7, 30);

        for (int vertex : L.vertexSet()) {
            List<Edge> edges = L.getEdges(vertex);
            for (Edge edge : edges) {
                System.out.println(edge.a + " -> " + edge.b + " (" + edge.l + ")");
            }
        }
        int n = 8; // Количество вершин графа

        /** Строим матрицу смежности графа и указываем длину всех дуг**/


        /** Wj = Wk + xk - lkj * g, где
         *  Wk - начальное количество топлива в баке в начале маршрута из точки k в точку j;
         *  xk - количество заправленного топлива в точке `k`
         *  lkj - длина участка (k, j) ∈ E;
         *  g – удельный расход топлива;
         *  Wj - количество полученного топлива в точке j.
         **/

        double Wj;
        int[] xk = new int[]{5, 1, 2, 5, 3, 10, 10, 0};
        double[] p = new double[]{55, 49.1, 61, 50, 49, 53, 52.5, 0};
        double[][] Wk = new double[10][10]; // Количество полученн
        double g = 0.01; // средний расход на 1 км, если 10л на 100км

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 1; j--) {
                if (L.getLength(i, j) > 0) {
                    if (i == 0) {
                        Wj = 0 + xk[i] - L.getLength(i, j) * g;
                        System.out.println(Wj + " = 0.0  + " + xk[i] + " - " + L.getLength(j, i) + " * " + g + " Из точки " + j + " в точку " + i + " с расстоянием " + L.getLength(i, j));
                        Wk[j][j] = Wj;
                    } else {
                        Wj = Wk[i][i] + xk[i] - L.getLength(i, j) * g;
                        System.out.println(Wj + " = " + Wk[i][i] + " + " + xk[i] + " - " + L.getLength(i, j) + " * " + g + " Из точки " + i + " в точку " + j + " с расстоянием " + L.getLength(i, j));
                        Wk[j][j] = Wj;
                    }

                }
            }
        }
    }
}