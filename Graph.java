package Prolectclass;

import java.util.ArrayList;

class Graph {
    private final int rows;
    private final int cols;
    private final ArrayList<ArrayList<Integer>> List;

    public Graph(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.List = new ArrayList<>(rows * cols);
        for (int i = 0; i < rows * cols; i++) {
            this.List.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        List.get(u).add(v);
    }

    public ArrayList<Integer> getAdjList(int u) {
        return List.get(u);
    }
}

