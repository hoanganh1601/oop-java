package ptit.code.khai_bao_lop_va_doi_tuong.j04011;

public class Point3D {
    private int x;
    private int y;
    private int z;

    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Point3D vector(Point3D p1, Point3D p2) {
        int disX = p1.x - p2.x;
        int disY = p1.y - p2.y;
        int disZ = p1.z - p2.z;
        Point3D res = new Point3D(disX, disY, disZ);

        return res;
    }

    public static Point3D tichCoHuong(Point3D p1, Point3D p2) {
        int newX = p1.y * p2.z - p1.z * p2.y;
        int newY = p1.z * p2.x - p1.x * p2.z;
        int newZ = p1.x * p2.y - p1.y * p2.x;

        Point3D res = new Point3D(newX, newY, newZ);
        return res;
    }

    public static int tichVoHuong(Point3D p1, Point3D p2) {
        int res = p1.x * p2.x + p1.y * p2.y + p1.z * p2.z;
        return res;
    }

    public static boolean check(Point3D p1, Point3D p2, Point3D p3, Point3D p4) {
        Point3D p12 = vector(p1, p2);
        Point3D p13 = vector(p1, p3);
        Point3D p14 = vector(p1, p4);

        Point3D tmp = tichCoHuong(p12, p13);
        int res = tichVoHuong(tmp, p14);

        return res == 0;
    }
}
