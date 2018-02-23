import graph.MazeBaseField;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        int width = Integer.parseInt(args[0]);
        int height = Integer.parseInt(args[1]);;
        MazeGenerator generator = new MazeGenerator(new MazeBaseField(width, height));
        boolean[][] maze = generator.generate();
        File f = new File("image.png");
        String format = "PNG";
        BufferedImage image = new BufferedImage(width * 2 - 1, height * 2 - 1, BufferedImage.TYPE_BYTE_BINARY);
        for (int i = 0; i < width * 2 - 1; i++) {
            for (int j = 0; j < height * 2 - 1; j++) {
                image.setRGB(i, j, 0);
            }
        }

        for (int i = 0; i < height * 2 - 1; i++) {
            for (int j = 0; j < width * 2 - 1; j++) {
                image.setRGB(j, i, (maze[j][i] ? 0xFFFFFF : 0));
            }
        }
        ImageIO.write(image, format, f);
    }
}
