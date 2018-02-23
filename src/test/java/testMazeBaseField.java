import graph.MazeBaseField;
import org.junit.Test;

public class testMazeBaseField {
    @Test
    public void testGenerate() {
        MazeBaseField field = new MazeBaseField(10, 5);
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                System.out.print("__");
            }
            System.out.println();
            for (int j = 0; j < field.getWidth(); j++) {
                System.out.print(field.getVertexByCoordinates(j, i).getRight() + " ");
            }
            System.out.println();
            for (int j = 0; j < field.getWidth(); j++) {
                System.out.print(field.getVertexByCoordinates(j, i).getBottom() + " ");
            }
            System.out.println();
        }
    }
}
