package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor[] leftMotors = new Victor[2];
	Victor[] rightMotors = new Victor[2];
	static double lTarget;
	static double rTarget;
	static final double ACCL=.1;
	
	public DriveTrain(){
		leftMotors[0] = new Victor(RobotMap.leftMotors[0]);
		leftMotors[1] = new Victor(RobotMap.leftMotors[1]);
		rightMotors[0] = new Victor(RobotMap.rightMotors[0]);
		rightMotors[1] = new Victor(RobotMap.rightMotors[1]);
		rTarget = 0; 
		lTarget = 0;
	}
	public void setMotors(double LS, double RS){
		leftMotors[0].set(LS);
		leftMotors[1].set(LS);
		rightMotors[0].set(RS);
		rightMotors[1].set(RS);
		
	}
	public void tankDrive(double lSpeed, double rSpeed){
		if(lTarget != lSpeed){
			if(lTarget > lSpeed)
				lTarget-=ACCL;
			else if(lTarget < lSpeed)
				lTarget+=ACCL;
		}
		if(rTarget != rSpeed){
			if(rTarget > rSpeed)
				rTarget-=ACCL;
			else if(rTarget < rSpeed)
				rTarget+=ACCL;
		}
		setMotors(lTarget,rTarget);
	}
	public void arcadeDrive(double speed, double turnVal){
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

