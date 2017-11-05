package graph;

public class Graph {


    private int verticesCount;
    private boolean[][] adjacencyMatrix;

    public Graph(int count) {
        this.verticesCount = count;
        adjacencyMatrix = new boolean[count][count];
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Graph g = new Graph(5);
        g.addEdge(1, 4);
        g.addEdge(4, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 1);

        g.display();
    }

    public void addEdge(int i, int j) {
        if (i > 0 && verticesCount > i && j > 0 && verticesCount > j) {
            adjacencyMatrix[i][j] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (i > 0 && verticesCount > i && j > 0 && verticesCount > j) {
            adjacencyMatrix[i][j] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i > 0 && verticesCount > i && j > 0 && verticesCount > j) {
            return adjacencyMatrix[i][j];
        }
        return false;
    }

    public void display() {
        for (int i = 0; i < verticesCount; i++) {
            for (int j = 0; j < verticesCount; j++) {
                System.out.print(isEdge(i, j) + " ");
            }
            System.out.println();
        }

    }

}
