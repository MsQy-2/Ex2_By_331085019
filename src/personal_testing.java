public class personal_testing
{
    public static void main(String[] args)
    {
        Map m=new Map(10,10,0);
        Index2D start=new Index2D(1,2);
        Index2D end=new Index2D(9,7);
        Pixel2D[] path=m.shortestPath(start,end,1,false);
        for(int i=0;i<path.length;i++)
        {
            System.out.println(path[i].toString());
        }
    }
}
