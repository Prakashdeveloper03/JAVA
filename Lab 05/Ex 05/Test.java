import javax.swing.JOptionPane;

abstract class Shape {
}

abstract class TwoDimensionalShape extends Shape {
	public abstract double getArea();
}

abstract class ThreeDimensionalShape extends Shape {
	public abstract double getArea();
	public abstract double getVolume();
}

class Triangle extends TwoDimensionalShape {
	private double base;
	private double height;

	public Triangle(double base, double height) {
		this.base = base;
		this.height = height;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return base * height / 2;
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f%n%s = %.2f", "Square", "base", getBase(), "height", getHeight());
	}
}

class Square extends TwoDimensionalShape {
	private double side;

	public Square(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double getArea() {
		return side * side;
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Square", "size", getSide());
	}
}

class Circle extends TwoDimensionalShape {
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Circle", "radius", getRadius());
	}
}


class Cube extends ThreeDimensionalShape {
	private double side;

	public Cube(double side) {
		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	@Override
	public double getArea() {
		return 6 * Math.pow(side, 2);
	}

	@Override
	public double getVolume() {
		return Math.pow(side, 3);
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Cube", "size", getSide());
	}
}

class Sphere extends ThreeDimensionalShape {
	private double radius;

	public Sphere(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return 4 * Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getVolume() {
		return 4 * Math.PI * Math.pow(radius, 3) / 3;
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Sphere", "radius", getRadius());
	}
}

class Tetrahedron extends ThreeDimensionalShape {
	private double edge;

	public Tetrahedron(double edge) {
		this.edge = edge;
	}

	public double getEdge() {
		return edge;
	}

	public void setEdge(double edge) {
		this.edge = edge;
	}

	@Override
	public double getArea() {
		return Math.pow(edge, 2) * Math.sqrt(3);
	}

	@Override
	public double getVolume() {
		return 1.0 / 12 * Math.sqrt(2) * Math.pow(edge, 3);
	}

	@Override
	public String toString() {
		return String.format("%s: %n%s = %.2f", "Tetrahedron", "edge", getEdge());
	}
}

public class Test {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[6];
		for (int i = 0; i < shapes.length; i++) {
			int shapeType = Integer.parseInt(JOptionPane.showInputDialog("Enter the type of shape (1 = Circle, 2 = Square, 3 = Triangle, 4 = Sphere, 5 = Cube, 6 = Tetrahedron)"));

			switch (shapeType) {
				case 1:
					double circleRadius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius of the circle"));
					shapes[i] = new Circle(circleRadius);
					break;
				case 2:
					double squareSide = Double.parseDouble(JOptionPane.showInputDialog("Enter the side length of the square"));
					shapes[i] = new Square(squareSide);
					break;
				case 3:
					double triangleBase = Double.parseDouble(JOptionPane.showInputDialog("Enter the base length of the triangle"));
					double triangleHeight = Double.parseDouble(JOptionPane.showInputDialog("Enter the height of the triangle"));
					shapes[i] = new Triangle(triangleBase, triangleHeight);
					break;
				case 4:
					double sphereRadius = Double.parseDouble(JOptionPane.showInputDialog("Enter the radius of the sphere"));
					shapes[i] = new Sphere(sphereRadius);
					break;
				case 5:
					double cubeSide = Double.parseDouble(JOptionPane.showInputDialog("Enter the side length of the cube"));
					shapes[i] = new Cube(cubeSide);
					break;
				case 6:
					double tetrahedronEdge = Double.parseDouble(JOptionPane.showInputDialog("Enter the edge length of the tetrahedron"));
					shapes[i] = new Tetrahedron(tetrahedronEdge);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid shape type. Please try again.");
					i--;
					break;
			}
		}

		for (Shape shape : shapes) {
			JOptionPane.showMessageDialog(null, shape.toString());
			if (shape instanceof TwoDimensionalShape) {
				TwoDimensionalShape twoDimensionalShape = (TwoDimensionalShape) shape;
				JOptionPane.showMessageDialog(null, "area = " + String.format("%.2f", twoDimensionalShape.getArea()));
			} else {
				ThreeDimensionalShape threeDimensionalShape = (ThreeDimensionalShape) shape;
				JOptionPane.showMessageDialog(null, "area = " + String.format("%.2f", threeDimensionalShape.getArea()) + "\nvolume = " + String.format("%.2f", threeDimensionalShape.getVolume()));
			}
		}
	}
}