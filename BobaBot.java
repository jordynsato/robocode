package sming_jmsato;

import robocode.*;
import java.awt.Color;

/**
 * BobaBot - an AdvancedRobot by Serena Ing and Jordyn Sato
 */
public class BobaBot extends AdvancedRobot
{
	/**
	 * run: BobaBot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		setAdjustGunForRobotTurn(true);
		setAdjustRadarForRobotTurn(true);
		
		// Robot main loop
		while(true) {
			turnLeft(Math.cos(getX()));
			turnGunRight(360);
			//ahead(100);
			scan();
			//back(100);
			scan();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double x = this.getX();
		double y = this.getY();
		double rHeading = this.getHeadingRadians();
		double rVelocity = this.getVelocity();
		double tVelocity = e.getVelocity();
		double eHeading = e.getHeadingRadians();		
		double gunHeading = this.getGunHeadingRadians();
		//double bulletPower = this.getBulletPower();
		
		if(tVelocity == 0) {
			turnGunRight(eHeading - gunHeading);
		}
		else {	
			Targeting t = new Targeting(x, y, rHeading, rVelocity, e.getDistance(), e.getBearingRadians(), eHeading, tVelocity);
			t.calculateLinear();			
			turnGunRight(t.getFireHeading() - gunHeading);
			//turnGunRight(Utils.normalRelativeAngle(t.getFireHeading() - gunHeading));
			//turnGunRightRadians(getRelativeAngle(t.getFireHeading() - gunHeading));
		}
		setFire(2);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		//back(10);
		//turnGunRight(e.getHeading() - this.getGunHeading());
		//fire(2);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		//back(20);
	}
}
