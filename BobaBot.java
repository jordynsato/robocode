package sming_jmsato;

import robocode.*;
import java.awt.Color;
import robocode.util.Utils;

/**
 * BobaBot - an AdvancedRobot by Serena Ing and Jordyn Sato
 */
public class BobaBot extends AdvancedRobot
{
	private double distanceX, distanceY, direction;
	private boolean ifRobotThere; //if there is a robot there
	private int count;

	/**
	 * run: BobaBot's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		setBulletColor(Color.red);

		count = 0;
		distanceX = getBattleFieldWidth() - 50;
		distanceY = getBattleFieldHeight() - 50;
		ifRobotThere=false;
		turnLeft(getHeading() %90); // moving towards a wall
		ahead(distanceX);
		ifRobotThere=true;
		turnGunRight(90);
				
		// Robot main loop
		while(true) {
			ifRobotThere = true;
			direction = getHeading();
			
			if(count >= 2) {
				avoidWalls(10);
			}
			else {
				avoidWalls(0);
			}
			ifRobotThere = false;
			count++;
		}//end while
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		double rHeading = this.getHeading();
		double tBearing = e.getBearing();		
		double gunHeading = this.getGunHeading();
		
		double turnAngle = Utils.normalRelativeAngleDegrees(rHeading + tBearing - gunHeading);

		turnGunRight(turnAngle);
		
		setFire(2);
		
		if(ifRobotThere)
			scan();
	}

	public void onHitRobot(HitRobotEvent e) {
		if(e.getBearing() > -90 && e.getBearing() < 90) {
			back(100);
		}
		else {
			ahead(100);
		}
	}

	private void avoidWalls(double buffer) {
		if(getY() + distanceY >= distanceY || getX() + distanceX >= distanceX) {
			turnRight(90);
			if(direction == 180) {
				ahead(distanceX - 10);
			}
			else if(direction == 0) {
				ahead(distanceX - buffer);
			}
			else if(direction == 90) {
				ahead(distanceY - buffer);
			}
			else {
				ahead(distanceY - 10);
			}
		}
		else {
			turnRight(90);
			ahead(distanceX);
		}
	}
}
