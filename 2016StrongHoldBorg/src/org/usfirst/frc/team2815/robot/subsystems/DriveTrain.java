package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Talon[] leftMotors = new Talon[2];
	Talon[] rightMotors = new Talon[2];
	
	static double lTarget;
	static double rTarget;

	static double lActual;
	static double rActual;
	static final double ACCL=.05;
	//set false to tankDrive, true to arcadeDrive
	public static boolean driveTypeArcade;
	public static boolean driveTypeTank;
	
	public DriveTrain(){
		leftMotors[0] = new Talon(RobotMap.leftMotors[0]);
		leftMotors[1] = new Talon(RobotMap.leftMotors[1]);
		rightMotors[0] = new Talon(RobotMap.rightMotors[0]);
		rightMotors[1] = new Talon(RobotMap.rightMotors[1]);
		rTarget = 0; 
		lTarget = 0;
		lActual = 0;
		rActual = 0;
		driveTypeArcade = false;
		driveTypeTank = true;
	}
	public void setMotors(double LS, double RS){
		leftMotors[0].set(LS);
		leftMotors[1].set(LS);
		rightMotors[0].set(RS);
		rightMotors[1].set(RS);
		
	}
	public void tankDrive(double lSpeed, double rSpeed){
		if(lActual != lSpeed){
			if(lActual > lSpeed)
				lActual -= ACCL;
			else if(lActual < lSpeed)
				lActual += ACCL;
		}
		if(rActual != rSpeed){
			if(rActual > rSpeed)
				rActual -= ACCL;
			else if(rActual < rSpeed)
				rActual += ACCL;
		}
		setMotors(lActual,rActual);
	}
	public void arcadeDrive(double speed, double turnVal){
		
		lTarget = speed + turnVal;
		if(lTarget >= 1)
			lTarget = .99;
		rTarget = speed - turnVal;
		if(rTarget >= 1)
			rTarget = .99;
		if(lTarget != lActual){
			if(lActual > lTarget)
				lActual -= ACCL;
			if(lActual < lTarget)
				lActual += ACCL;
		}
		if(rTarget != rActual){
			if(rActual > rTarget)
				rActual -= ACCL;
			if(rActual < rTarget)
				rActual += ACCL;
		}
		setMotors(lActual,rActual);
	}
	public void driveToggle(boolean buttonA, boolean buttonX, double lSpeed, 
			double rSpeed, double turnValue){
		if(buttonA){
			driveTypeArcade = true;
			driveTypeTank = false;
		}
		if(buttonX){
			driveTypeArcade = false;
			driveTypeTank = true;
		}
		if(driveTypeTank){
			tankDrive(lSpeed, rSpeed);
		}
		if(driveTypeArcade){
			arcadeDrive(lSpeed, turnValue);
		}
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

