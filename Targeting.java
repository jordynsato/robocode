package sming_jmsato;

/**
 * MyClass - a class by (your name here)
 */
public class Targeting
{
	//Coordinates of robot, bullet, and target
	private double xr, yr, xb, yb, xt, yt;
	private double distance, heading, velocity;
	private double bulletHeading;
	
	public Targeting(double x, double y, double d, double h, double v) {
		xr = x;
		yr = y;
		distance = d;
		heading = h;
		velocity = v;
	}
	
	public static void calculate() {
		
	}
}
