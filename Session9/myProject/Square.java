package myProject;

import java.util.Date;

/**
* This class defines function of square.
* @author Aman Gautam
* 
*/
public class Square implements Shape
{
    double width;
    Date date;
    Point originPoint;
    Point maxSquarePoint;
    
    public Square(double width, Date date, Point originPoint)
    {
        this.width = width;
        this.date = date;
        this.originPoint = originPoint;
        this.maxSquarePoint = getMaxSquarePoint();
    }
    
	@Override
    public double getArea() {
        return Double.parseDouble(decimalFormat.format(width * width));
    }
    
	@Override
    public double getPerimeter() {
        return Double.parseDouble(decimalFormat.format(4 * width));
    }
    
	@Override
    public Date getTimeStamp() {
    	return date;
    }
    
	@Override
    public Point getOrigin() {
        return originPoint;
    }

	@Override
	public boolean isPointEnclosed(Point givenPoint) {
		if(givenPoint.x > originPoint.x && givenPoint.x < maxSquarePoint.x && givenPoint.y > originPoint.y && givenPoint.y < maxSquarePoint.y) {
			return true;
		}
		return false;
	}
	
	@Override
	public String getShapeType() {
		return "SQUARE";
	}

	@Override
	public double getOriginDistance() {
		
		return Math.sqrt((originPoint.x - 0) * (originPoint.x - 0) + (originPoint.y - 0) * (originPoint.y - 0));
	}
	
	/**
     * 
     * @return diagonally opposite points of square.
     */
    private Point getMaxSquarePoint() {
        return new Point(originPoint.x + width, originPoint.y + width);
    }
    
}
