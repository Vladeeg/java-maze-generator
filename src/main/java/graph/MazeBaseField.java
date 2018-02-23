package graph;

public class MazeBaseField {
    private Vertex[] matrix;
    private int width, height;
    public MazeBaseField(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new Vertex[width * height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                matrix[i + j * width] = new Vertex(i + j * width);
            }
        }
        regenerate();
    }

    public void regenerate() {
        for (int i = 0; i < width - 1; i++) {
            for (int j = 0; j < height - 1; j++) {
                int length = (int) (Math.random() * (width + height));
                getVertexByCoordinates(i, j).setBottomD(length);
                getVertexByCoordinates(i, j).setBottom(getVertexByCoordinates(i, j + 1));

                getVertexByCoordinates(i, j + 1).setTopD(length);
                getVertexByCoordinates(i, j + 1).setTop(getVertexByCoordinates(i, j));

                length = (int) (Math.random() * (width + height));
                getVertexByCoordinates(i, j).setRightD(length);
                getVertexByCoordinates(i, j).setRight(getVertexByCoordinates(i + 1, j));

                getVertexByCoordinates(i + 1, j).setLeftD(length);
                getVertexByCoordinates(i, j).setLeft(getVertexByCoordinates(i, j));
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Vertex getVertexByCoordinates(int x, int y) {
        return matrix[x + y * width];
    }
    public Vertex getVertexByNumber(int x) {
        return matrix[x];
    }
}
