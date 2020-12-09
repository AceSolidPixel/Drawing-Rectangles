public class Rect
{
   int xPos;
   int yPos;
   int actualWidth;
   int actualHeight;
   public Rect(int x, int y, int width, int height)
   {
      xPos = x;
      yPos = y;
      actualWidth = width;
      actualHeight = height;
   }
   
   public int getX()
   {
      return xPos;
   }
   
   public int getY()
   {
      return yPos;
   }
   
   public int getWidth()
   {
      return actualWidth;
   }
      
   public int getHeight()
   {
      return actualHeight;
   }
}