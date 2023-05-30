import java.awt.Color;
import java.awt.Graphics;

class MyOval implements MyShape {
    private int x;
    private int y;
    private Color color;

    public MyOval(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, 30, 30);
    }
}