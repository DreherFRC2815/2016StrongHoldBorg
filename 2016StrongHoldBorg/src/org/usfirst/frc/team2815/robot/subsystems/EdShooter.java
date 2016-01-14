package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class EdShooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	static double motorSpeed;
	static Victor[] shootVictors = new Victor[2];
	
	public EdShooter(){
		motorSpeed = 0;
		shootVictors[0] = new Victor(RobotMap.shooterMotors[0]);
		shootVictors[1] = new Victor(RobotMap.shooterMotors[1]);
	}
	
	public void shoot(double inSpeed, double outSpeed){
		if(outSpeed > inSpeed){
			shootVictors[0].set(outSpeed);
			shootVictors[1].set(-1*outSpeed);
		}
		if(outSpeed < inSpeed){
			shootVictors[0].set(-1*inSpeed);
			shootVictors[1].set(inSpeed);
		}
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

