# Ex2_By_331085019
this is the secound assinment in Mavo leHishuv 
description of each function:

getPixel(int x, int y)
Returns the value at (x, y)

getPixel(Pixel2D p)
Same as above, using a Pixel2D

setPixel(int x, int y, int v)
Sets the pixel at (x, y) to value v

setPixel(Pixel2D p, int v)
Same as above using a Pixel2D

sameDimensions(Map2D p)
Checks if two maps have the same width and height

addMap2D(Map2D p)
Replaces each pixel with the value from map p

mul(double scalar)
Multiplies each pixel value by a scalar

rescale(double sx, double sy)
Resizes the map using scale factors
How
Computes new width/height
Copies old values where possible
Fills new cells with 0

drawCircle(Pixel2D center, double rad, int color)
Draws a filled circle.
How
by the formula of distens and less the the distans

drawRect(Pixel2D p1, Pixel2D p2, int color)
Draws a filled rectangle between two corners.
How
Iterates over min/max x and y and colors everything

fill(Pixel2D xy, int new_v, boolean cyclic)
Performs a flood fill starting at xy
how
by useing directions():
Recursive flood fill in 4 directions
How
Stops on boundary or different color
Recolors current pixel
Recursively spreads

shortestPath(Pixel2D p1, Pixel2D p2, int obsColor, boolean cyclic)
Finds the shortest path from p1 to p2 avoiding obstacles.
how
Breadth-First Search (BFS)
Uses queue, visited array, and parent tracking
Supports cyclic wrapping
Reconstructs path from parents
<img width="633" height="639" alt="צילום מסך 2025-12-28 152745" src="https://github.com/user-attachments/assets/7582528d-3843-4f13-9dcc-954a4b7efafa" />

