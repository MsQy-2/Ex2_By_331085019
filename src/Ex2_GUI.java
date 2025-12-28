import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Intro2CS_2026A
 * This class represents a Graphical User Interface (GUI) for Map2D.
 * The class has save and load functions, and a GUI draw function.
 * You should implement this class, it is recommender to use the StdDraw class, as in:
 * https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
 *
 *
 */
public class Ex2_GUI {
    public static void drawMap(Map2D map)
    {


        for(int y = 0; y < map.getHeight(); y++)
            for (int x = 0; x < map.getWidth(); x++)
            {

                StdDraw.square(1-x*0.2,1-y*0.2,0.2);
                if(map.getPixel(x,y) == '1')
                {
                    StdDraw.filledSquare(1-x*0.2,1-y*0.2,0.2);
                }


            }
    }

    /**
     * @param mapFileName
     * @return
     */
    public static Map2D loadMap(String mapFileName) {
        Map2D ans = null;
        try
        {
            FileReader fr = new FileReader(mapFileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            line = br.readLine();
            int x = Integer.parseInt(line.substring(6));
            line = br.readLine();
            int y = Integer.parseInt(line.substring(7));
            ans= new Map(x,y,0);
            line = br.readLine();
            int i=0;
            while(line != null)
            {

                for(int j=0;j<x;j++)
                {
                  ans.setPixel(j,i,line.charAt(j*2));

                }
                i++;
                line= br.readLine();

            }
            return ans;
        }
        catch (Exception e){throw new RuntimeException("Error loading Map");}




    }

    /**
     *
     * @param map
     * @param mapFileName
     */
    public static void saveMap(Map2D map, String mapFileName)
    {
        try
        {
            FileWriter fw = new FileWriter(mapFileName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("width=" + map.getWidth());
            pw.println("height=" + map.getHeight());

            for (int y = 0; y < map.getHeight(); y++)
            {
                for ( int x = 0; x < map.getWidth(); x++)
                {
                    pw.print(map.getPixel(x, y) + " ");
                }
                pw.println();
            }
            pw.println('x');
            pw.close();
            fw.close();
        }
        catch(Exception e)
        {
            System.out.println("Error: " + e);
        }


    }
    public static void main(String[] a) {
        String mapFile = "C:\\Users\\ranen\\Downloads\\Ex2_By_331085019\\src\\map.txt";
        Map2D map = loadMap(mapFile);
        drawMap(map);
    }
    /// ///////////// Private functions ///////////////
}
