import java.io.Serializable;
import java.util.Arrays;

/**
 * This class represents a 2D map (int[w][h]) as a "screen" or a raster matrix or maze over integers.
 * This is the main class needed to be implemented.
 *
 * @author boaz.benmoshe
 *
 */
public class Map implements Map2D, Serializable{


    private int[][] _map;
    // edit this class below
	/**
	 * Constructs a w*h 2D raster map with an init value v.
	 * @param w
	 * @param h
	 * @param v
	 */
	public Map(int w, int h, int v)
    {init(w, h, v);
    int[][] map = new int[h][w];
    for (int x = 0; x < w; x++)
    {
        Arrays.fill(map[x],v);
    }
    this._map = map;
    }

	/**
	 * Constructs a square map (size*size).
	 * @param size
	 */
	public Map(int size)
    {
        this(size,size, 0);
        this._map = new int[size][size];
        for (int x = 0; x < size; x++){Arrays.fill(this._map[x],0);}
    }
	
	/**
	 * Constructs a map from a given 2D array.
	 * @param data
	 */
	public Map(int[][] data)
    {
        init(data);
        int length = data[0].length;
        for (int x = 0; x < data.length; x++)
        {
           if(data[x].length != length)
           {throw new RuntimeException("not valid map");}
        }
        if(data==null ){throw new RuntimeException("not valid map");}
        this._map = data;
	}
	@Override
	public void init(int w, int h, int v) {

	}
	@Override
	public void init(int[][] arr) {

	}
	@Override
	public int[][] getMap() {
		int[][] ans = this._map;

		return ans;
	}
	@Override
	public int getWidth() {
        int ans = this._map[0].length;

        return ans;
    }
	@Override
	public int getHeight() {
        int ans = this._map.length;

        return ans;
    }
	@Override
	public int getPixel(int x, int y) {
        int ans = this._map[x][y];

        return ans;
    }
	@Override
	public int getPixel(Pixel2D p) {
        int ans = this._map[p.getX()][p.getY()];

        return ans;
	}
	@Override
	public void setPixel(int x, int y, int v) {
        this._map[y][x] = v;

    }
	@Override
	public void setPixel(Pixel2D p, int v) {
        this._map[p.getX()][p.getY()] = v;

	}

    @Override
    public boolean isInside(Pixel2D p) {
        int maxX = this._map[0].length;
        int maxY = this._map.length;
        if(maxX > p.getX() || maxY > p.getY() ){return false;}
        return true;
    }

    @Override
    public boolean sameDimensions(Map2D p) {
        return this.getWidth() == p.getWidth() && this.getHeight() == p.getHeight();
    }

    @Override
    public void addMap2D(Map2D p) {
        if(sameDimensions(p))
        {
            for(int y = 0; y < this.getHeight(); y++){for(int x = 0; x < this.getWidth(); x++){this.setPixel(x, y, p.getPixel(x, y));}}
        }

    }

    @Override
    public void mul(double scalar) {
        for(int y = 0; y < this.getHeight(); y++){for(int x = 0; x < this.getWidth(); x++){this._map[y][x] *= scalar;}}

    }

    @Override
    public void rescale(double sx, double sy)
    {
        int X = (int) (this._map[0].length*sx);
        int Y = (int) (this._map.length*sy);
        int[][] new_map = new int[Y][X];
        for(int y = 0; y < this.getHeight(); y++){for(int x = 0; x < this.getWidth(); x++)
        {
            if(isInside(new Index2D(x, y))){new_map[y][x] = this._map[y][x];}
            else{new_map[y][x] = 0;}
        }}
        this._map = new_map;

    }

    @Override
    public void drawCircle(Pixel2D center, double rad, int color)
    {for (int y = 0; y < this.getHeight(); y++){for (int x = 0; x < this.getWidth(); x++)
    {
        if(Math.pow(this.getWidth()- center.getX(),2)+Math.pow(this.getHeight()-center.getY(),2)<=Math.pow(rad,2)){this.setPixel(x,y,color);}
    }}

    }

    @Override
    public void drawLine(Pixel2D p1, Pixel2D p2, int color)
    {
        int bigX = Math.max(p1.getX(), p2.getX());
        int bigY = Math.max(p1.getY(), p2.getY());
        int smallX = Math.min(p1.getX(), p2.getX());
        int smallY = Math.min(p1.getY(), p2.getY());
        for(int y = smallY; y <= bigY; y++){for(int x = smallX; x <= bigX; x++)
        {
            if(Math.abs(y-(((p1.getY()-p2.getY())/(p1.getX()- p2.getX()))*(x- p1.getX())+ p1.getY()))<1){
                this.setPixel(x,y,color);
            }
        }}

    }

    @Override
    public void drawRect(Pixel2D p1, Pixel2D p2, int color)
    {
        int bigX = Math.max(p1.getX(), p2.getX());
        int bigY = Math.max(p1.getY(), p2.getY());
        int smallX = Math.min(p1.getX(), p2.getX());
        int smallY = Math.min(p1.getY(), p2.getY());
        for(int y = smallY; y <= bigY; y++){for(int x = smallX; x <= bigX; x++){
            this.setPixel(x,y,color);
        }}

    }

    @Override
    public boolean equals(Object ob) {
        if(ob instanceof Map)
        {if(this.sameDimensions((Map)ob))
        {
            for (int y = 0; y < this.getHeight(); y++){
                for (int x = 0; x < this.getWidth(); x++){
                    if(this.getPixel(x, y) != ((Map)ob).getPixel(x, y))return false;
                }
            }
            return true;
        }

        }
        return false;
    }
	@Override
	/** 
	 * Fills this map with the new color (new_v) starting from p.
	 * https://en.wikipedia.org/wiki/Flood_fill
	 */
	public int fill(Pixel2D xy, int new_v,  boolean cyclic) {
		int ans = -1;

		return ans;
	}

	@Override
	/**
	 * BFS like shortest the computation based on iterative raster implementation of BFS, see:
	 * https://en.wikipedia.org/wiki/Breadth-first_search
	 */
	public Pixel2D[] shortestPath(Pixel2D p1, Pixel2D p2, int obsColor, boolean cyclic) {
		Pixel2D[] ans = null;  // the result.

		return ans;
	}
    @Override
    public Map2D allDistance(Pixel2D start, int obsColor, boolean cyclic) {
        Map2D ans = null;  // the result.

        return ans;
    }
	////////////////////// Private Methods ///////////////////////

}
