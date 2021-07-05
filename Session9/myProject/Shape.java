package myProject;

import java.text.DecimalFormat;
import java.util.Date;

/**
* This interface declares function of various shape.
* @author Aman Gautam
* 
*/
public interface Shape
{
	DecimalFormat decimalFormat = new DecimalFormat(".###");
	
    double getArea();
    
    double getPerimeter();
    
    Point getOrigin();
    
    boolean isPointEnclosed(Point givenPoint);
    
    Date getTimeStamp();
    
    String getShapeType();
    
    double getOriginDistance();
    
    static enum ShapeType { SQUARE, RECTANGLE, CIRCLE, TRIANGLE, POLYGON }
}