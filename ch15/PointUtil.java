package gr.aueb.cf.ch15;

public class PointUtil {

    public static double distanceFromOrigin(Point point) {
        if (point instanceof Point3D) {
            Point3D point3D = (Point3D) point;
            return point3D.getDistanceFromOrigin();
        }
        else if (point instanceof Point2D) {
            Point2D point2D = (Point2D) point;
            return point2D.getDistanceFromOrigin();
        }
        // If it's just a Point
        else {
            return point.getDistanceFromOrigin(); 
        }
    }
}
