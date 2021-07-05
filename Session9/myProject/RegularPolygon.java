package myProject;

import java.util.Date;

/**
* This class defines function of regular polygon.
* 
* @author Aman Gautam
* 
*/
public class RegularPolygon implements Shape
{

    int noOfSides;
    double lengthOfSide;
    Date date;
    Point originPoint;
    
    public RegularPolygon(double noOfSides, double lengthOfSide, Date date, Point origin) {
        this.noOfSides = (int)noOfSides;
        this.lengthOfSide = lengthOfSide;
        this.originPoint = origin;
        this.date = date;
    }
    
    @Override
    public double getArea()
    {
        double apothem = lengthOfSide / (2 * Math.tan(Math.toRadians(180 / noOfSides)));
        
        return (getPerimeter() * apothem / 2);
    }

    @Override
    public double getPerimeter()
    {
        return noOfSides * lengthOfSide;
    }

    @Override
    public Point getOrigin()
    {
        return originPoint;
    }

    @Override
    public boolean isPointEnclosed(Point givenPoint)
    {
        return false;
    }

    @Override
    public Date getTimeStamp()
    {
        return date;
    }

    @Override
    public String getShapeType()
    {
        return "Regular Polygon";
    }

    @Override
    public double getOriginDistance()
    {
        return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) + (originPoint.y - 0) * (originPoint.y - 0));

    }

}