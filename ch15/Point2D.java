package gr.aueb.cf.ch15;

public class Point2D extends Point{
    private double y;

    public Point2D() {
                                //JVM gives it automatically
//        super();
//        y = 0.0;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point2D(double x, double y) {
        super(x);
        //setX(x);
        this.y = y;
    }
//    @Override
//    public String convertToString() {
//        return super.convertToString() + "(" + y + ")";
//    }
    @Override
    public String toString()  {
        return super.toString() + "(" + y + ")";
    }
    @Override
    public void movePlus10() {
        super.movePlus10();
        y += 10;
    }

    @Override
    protected void movePlusOne() {
        super.movePlusOne();
        y += 1;
    }

    @Override
    public double getDistanceFromOrigin() {
        double distanceX = super.getDistanceFromOrigin();
        double distanceY = getY();
        return Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2));
    }

}
