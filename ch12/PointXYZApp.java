package gr.aueb.cf.ch12;

public class PointXYZApp {

    public static void main(String[] args) {
        PointXYZ p1 = new PointXYZ(1, 3, 5);
        PointXYZ p2 = new PointXYZ(12, 6, 8);
        PointXYZ p3 = new PointXYZ(5, 2, 51);

        System.out.println(p1.convertToString());
        System.out.println(p2.convertToString());
        System.out.println(p3.convertToString());
    }
}
