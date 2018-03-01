package sming_jmsato;

/**
 * Targeting - a class by Jordyn Sato
 * 
 * This class takes in the input of the scanned robot and will predict where the target will go next in order to hit them.
 */
public class Targeting
{
	//Coordinates of robot and target
	private double xr, yr, xt, yt;
	//From the targeted robot
	private double distance, bearing, heading, velocity;
	//Where our robot should fire
	private double fireHeading;
	//How fast and far the bullet is
	private double vBullet, bulletDistance;
	
	public Targeting(double x, double y, double d, double b, double h, double v) {
		xr = x;
		yr = y;
		distance = d;
		bearing = b;
		heading = h;
		velocity = v;
		xt = xr + (distance * Math.cos(bearing));
		yt = yr + (distance * Math.sin(bearing));
	}
	
	public void calculateLinear() {
		int time = 2;
		double pXC = xt + (velocity * Math.cos(heading) * time);
		double pYC = yt + (velocity * Math.sin(heading) * time);
		bulletDistance = Math.hypot(pXC, pYC);
		vBullet = bulletDistance/time;
		fireHeading = Math.atan(pYC/pXC);
	}
	
	public double getFireHeading() {
		return fireHeading;
	}
	
	public double getBulletDistance() {
		return bulletDistance;
	}
	
	public double getBulletVelocity() {
		return vBullet;
	}
}
