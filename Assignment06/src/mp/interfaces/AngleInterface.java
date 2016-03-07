package mp.interfaces;

import mp.objects.Line;
import mp.objects.Point;

public interface AngleInterface {

	public void setInitialPoint(int x, int y);
	public void setX(int x);
	public void setY(int y);
	public int getX();
	public int getY();
	public Point getInitialPoint();
	public Line getLeftLine();
	public Line getRightLine();
	public void move(int x, int y);
	
}
