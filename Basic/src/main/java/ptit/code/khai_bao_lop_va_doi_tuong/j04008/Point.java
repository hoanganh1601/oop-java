package ptit.code.khai_bao_lop_va_doi_tuong.j04008;

public class Point {
    private double x;
    private double y;

    public Point() {
        x = 0.0;
        y = 0.0;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distance(Point secondPoint) {
        double disX = this.x - secondPoint.x;
        double disY = this.y - secondPoint.y;
        return Math.sqrt(disX * disX + disY * disY);
    }

    public double distance(Point p1, Point p2) {
        double disX = p1.x - p2.x;
        double disY = p1.y - p2.y;
        return Math.sqrt(disX * disX + disY * disY);
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
