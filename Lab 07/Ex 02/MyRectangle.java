import java.awt.Color;
import java.awt.Graphics;

class MyRectangle implements MyShape {
    private int x;
    private int y;
    private Color color;

    public MyRectangle(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 50, 30);
    }
}