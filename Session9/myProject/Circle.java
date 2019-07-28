package myProject;

import java.util.Date;

/**
* This class defines function of circle.
* @author Aman Gautam
* 
*/
public class Circle implements Shape
{
   
    double radius;
    Date date;
    Point originPoint;
    Point center;

    public Circle(double radius, Date date,Point originPoint)
    {
        this.radius = radius;
        this.date = date;
        this.originPoint = originPoint;
        this.center = getCenterCoordinates();
        //System.out.println("circle created at " + date.toString());
    }
    
    @Override
    public double getArea() {
        return Double.parseDouble(decimalFormat.format(Math.PI * radius* radius));
    }
    
    @Override
    public double getPerimeter() {
        return Double.parseDouble(decimalFormat.format(2 * Math.PI * radius));
    }
    
    @Override
    public Point getOrigin() {
        return originPoint;
    }
    
    @Override
    public boolean isPointEnclosed(Point givenPoint) {
        //Point center = getCenterCoordinates();
        //System.out.println("center x: " + center.x + " center y: " + center.y);
        if(getDistance(center, givenPoint) < radius) {
        	return true;
        }
        return false;
    }
    
    @Override
    public Date getTimeStamp() {
    	return date;
    }
    
    @Override
    public String getShapeType() {
    	return "CIRCLE";
    }
    
    @Override
    public double getOriginDistance() {
        
        return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) + (originPoint.y - 0) * (originPoint.y - 0));
    }
    
    /**
     * 
     * @param center
     * @param givenPoint
     * @return distance between center and given point
     */
    private double getDistance(Point center, Point givenPoint) {
    	//distance = square root of ((x2-x1)^2 + (y2-y1)^2)
    	return Math.sqrt((center.x - givenPoint.x) * (center.x - givenPoint.x) + (center.y - givenPoint.y) * (center.y - givenPoint.y));
    }
    
    /**
     * 
     * @return coordinates of center
     */
    private Point getCenterCoordinates() {
    	double xAxis, yAxis;
    	//tan inverse of slope
    	double theta = Math.atan(originPoint.y / originPoint.x);			
    	xAxis = radius * Math.sin(theta);
    	yAxis = radius * Math.cos(theta);
    	
    	return new Point(originPoint.x + xAxis, originPoint.y + yAxis);   	
    }

}
