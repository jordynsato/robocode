package smsi;
import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * SerenasRobot - a robot by (your name here)
 */
public class SerenasRobot extends AdvancedRobot
{
	/**
	 * run: SerenasRobot's default behavior
	 * trying to create oscillating movement behavior
	 */
	private double maxWidth, maxHeight;
	private double currentX, currentY;
	private int wallPadding = 50;

	public void run() {
		// Initialization of the robot should be put here
		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:
		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar
		// Robot main loop
		while(true) {
			/*			
			// Replace the next 4 lines with any behavior you would like
			ahead(100);
			turnGunRight(360);
			back(100);
			turnGunRight(360);
			*/
			
			addCustomEvent(new Condition ("avoidingWall") {
				public boolean test(){
					return (getX() <= wallPadding ||
					getX() >= getBattleFieldWidth()-wallPadding ||
					getY() <=wallPadding||
					getY()>=getBattleFieldHeight() - wallPadding
					);
				}
			});//end anonymous inner class
			
		
		}//end while
		//removeCustomEvent("avoidingWall");
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
	
	
}
