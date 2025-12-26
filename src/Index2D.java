public class Index2D implements Pixel2D {
    private int x;
    private int y;
    public Index2D(int w, int h) {
        this.x = w;
        this.y = h;
    }
    public Index2D(Pixel2D other) {
        this.x = other.getX();
        this.y = other.getY();
    }
    @Override
    public int getX() {

        return this.x;
    }

    @Override
    public int getY() {

        return this.y;
    }

    @Override
    public double distance2D(Pixel2D p2) {

        return Math.sqrt(Math.pow(p2.getX() - this.x, 2) + Math.pow(p2.getY() - this.y, 2));
    }

    @Override
    public String toString() {
        String ans = "(" + this.x + "," + this.y + ")";

        return ans;
    }

    @Override
    public boolean equals(Object p) {
       if(p instanceof Index2D) {return ((Index2D) p).getX() == this.x && ((Index2D) p).getY() == this.y;}
       else {return false;}

    }
}
