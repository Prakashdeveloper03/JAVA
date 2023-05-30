import java.awt.Graphics;
import java.io.Serializable;

interface MyShape extends Serializable {
    void draw(Graphics g);
}