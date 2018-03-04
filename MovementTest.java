package smsi;
import robocode.*;
import robocode.util.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * MovementTest - a robot by (your name here)
 */
public class MovementTest extends AdvancedRobot
{
	/**
	 * run: MovementTest's default behavior
	 */
	int wallPadding = 50;
	
	public void run() {
		int moveDirection = 1;
		double centerX, centerY;
		double x, y;
		//move parts independently
		//setAdjustGunForRobotTurn(true);
		//setAdjustRadarForRobotTurn(true);
		
		// Robot main loop
		centerX = getBattleFieldWidth()/2;
		centerY = getBattleFieldHeight()/2; 
		
		while(true) {
		
		x = getX();
		y = getY();
		
		double distance = Math.hypot(centerY-y, centerX-x);
		
		turnRightRadians(Utils.normalRelativeAngle(Math.atan((centerX-x)/(centerY-y))));
		ahead(distance);
		//turnRight(-getHeading()+ Math.atan((centerX-x)/(centerY-y) ) );
		//ahead(Math.hypot(centerY-y, centerX-x));
		
		//this.setAhead(moveDirection*50.0);
		//turnLeft(moveDirection*180.0);
		
		//moveDirection*=-1;	 
		
		//if(getX() <= wallPadding || getX() >= getBattleFieldWidth()-wallPadding ||
		//getY() <=wallPadding||getY() >=getBattleFieldHeight() - wallPadding){
		//turnGunRight(360.0);
		//back(50);
		
		//			}
		}
		

	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		turnRight(getBearing()-90.0);
		ahead(10.0);
	}
	
	
}
