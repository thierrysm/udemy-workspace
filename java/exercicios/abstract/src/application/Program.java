package application;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Shape> shapes = new ArrayList<>();

        System.out.print("Enter the number of shapes: ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            System.out.println("Shape #" + (1+i)  + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char type = sc.next().charAt(0);
            System.out.print("Color (BLACK/BLUE/RED): ");
            Color color = Color.valueOf(sc.next());

            if (type == 'r') {
                System.out.print("Width: ");
                double width = sc.nextDouble();
                System.out.print("Height: ");
                double height = sc.nextDouble();

                Rectangle rectangle = new Rectangle(color, width, height);
                shapes.add(rectangle);
            } else {
                System.out.print("Radius: ");
                double radius = sc.nextDouble();

                Circle circle = new Circle(color, radius);
                shapes.add(circle);
            }
        }

        System.out.println("SHAPE AREAS:");
        for (Shape shape : shapes) {
            System.out.println(String.format("%.2f", shape.area()));
        }
    }
}
