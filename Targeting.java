package sming_jmsato;

/**
 * Targeting - a class by Jordyn Sato
 * 
 * This class takes in the input of the scanned robot and will predict
 * where the target will go next in order to hit them.
 */
public class Targeting
{
	//Coordinates of robot and target
	private double xr, yr, xt, yt, pXC, pYC;
	//From our robot
	private double rHeading, rVelocity;
	//From the targeted robot
	private double distance, bearing, heading, velocity;
	//Where our robot should fire
	private double fireHeading;
	//How fast and far the bullet is
	private double vBullet, bulletDistance;
	
	public Targeting(double x, double y, double rh, double rv, double d, double b, double h, double v) {
		xr = x;
		yr = y;
		rHeading = rh;
		rVelocity = rv;
		distance = d;
		bearing = b;
		heading = h;
		velocity = v;
		xt = xr + (distance * Math.cos(bearing));
		yt = yr + (distance * Math.sin(bearing));
	}
	
	public void calculateLinear() {
		double time = getImpactTime(10.0, 20.0, .01);
		xr += (rVelocity * Math.cos(rHeading) * time);
		yr += (rVelocity * Math.sin(rHeading) * time);
		pXC = xt + (velocity * Math.cos(heading) * time);
		pYC = yt + (velocity * Math.sin(heading) * time);
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
	
	private double f(double time) {
		double vb = 17;
		double dX = xt - xr;
		double dY = yt - yr;
		return Math.hypot(dX, dY) - vb * time;
	}

	private double getImpactTime(double t0, double t1, double accuracy) {
		double X = t1;
		double lastX = t0;
		int iterationCount = 0;
		double lastfX = f(lastX);

		while ((Math.abs(X - lastX) >= accuracy) && (iterationCount < 15)) {
			iterationCount++;
			double fX = f(X);
			if ((fX-lastfX) == 0.0)
				break;
			double nextX = X - fX*(X-lastX)/(fX-lastfX);
			lastX = X;
			X = nextX;
			lastfX = fX;
		}
	return X;
	}
}
