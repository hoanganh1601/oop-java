package ptit.code.khai_bao_lop_va_doi_tuong.j04002;

public class Rectange {
    private double width;
    private double height;
    private String color;

    public Rectange(){
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectange(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double findArea() {
        return width * height;
    }

    public double findPerimeter() {
        return 2 * (width + height);
    }

    public void normalizeColor(){
        this.color = this.color.substring(0, 1).toUpperCase() + this.color.substring(1).toLowerCase();
    }

    @Override
    public String toString() {
        return (int)findPerimeter() + " " + (int)findArea() + " " + color;
    }
}
