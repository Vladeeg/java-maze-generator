import graph.MazeBaseField;
import graph.Vertex;

import java.util.ArrayList;

public class MazeGenerator {
    private MazeBaseField mazeBaseField;
    MazeGenerator(MazeBaseField mazeBaseField) {
        this.mazeBaseField = mazeBaseField;
    }

    public boolean[][] generate() {
        int width = mazeBaseField.getWidth() * 2 - 1;
        int height = mazeBaseField.getHeight() * 2 - 1;
        boolean[][] ret = new boolean[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                ret[j][i] = i % 2 == 0 && j % 2 == 0;
            }
        }
        ArrayList<Integer> vertices = new ArrayList<>(mazeBaseField.getWidth() * mazeBaseField.getHeight());
        int[] distances = new int[mazeBaseField.getWidth() * mazeBaseField.getHeight()];
        int[] pointers = new int[mazeBaseField.getWidth() * mazeBaseField.getHeight()];

        for (int i = 1; i < distances.length; i++) {
            Vertex s = mazeBaseField.getVertexByNumber(0);
            vertices.add(i);
            pointers[i] = 0;
            distances[i] = s.getDistanceTo(mazeBaseField.getVertexByNumber(i));
        }

        while (vertices.size() > 0) {
            int u = vertices.get(0);
            for (Integer v : vertices) {
                if (distances[v] < distances[u]) {
                    u = v;
                }
            }

            int uX = u % mazeBaseField.getWidth();
            int uY = (u - uX) / mazeBaseField.getWidth();
            uX = uX * 2;
            uY = uY * 2;

            vertices.remove(new Integer(u));
            if (u - pointers[u] == 1) {
                ret[uX - 1][uY] = true;
            } else if (u - pointers[u] == -1) {
                ret[uX + 1][uY] = true;
            } else if (u - pointers[u] < 0) {
                ret[uX][uY + 1] = true;
            } else {
                ret[uX][uY - 1] = true;
            }

            for (Integer v : vertices) {
                if (mazeBaseField.getVertexByNumber(u)
                        .getDistanceTo(mazeBaseField.getVertexByNumber(v)) < distances[v]) {
                    distances[v] = mazeBaseField.getVertexByNumber(u)
                            .getDistanceTo(mazeBaseField.getVertexByNumber(v));
                    pointers[v] = u;
                }
            }
        }

        return ret;
    }
}