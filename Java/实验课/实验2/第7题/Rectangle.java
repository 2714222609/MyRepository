package java_test2;

class Rectangle implements GetDuiJiaoXian {
    protected int length;
    protected int width;

    Rectangle(int x, int y) {
        length = x;
        width = y;
    }

    Rectangle() {
    }

    public double getDuiJiaoXian() {
        return Math.sqrt(length * length + width * width);
    }
}
