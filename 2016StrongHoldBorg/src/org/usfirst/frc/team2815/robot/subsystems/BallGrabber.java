package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallGrabber extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Victor ballpicker;
	double setVal;
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public BallGrabber(){
    	ballpicker = new Victor(RobotMap.ballpick);
    	setVal = 0;
    }
    public void operateBallPicker(boolean lvalue, boolean rvalue){
		if(lvalue)
			setVal = .99;
		else if(rvalue)
			setVal = -.99;
		else
			setVal = 0;
		ballpicker.set(setVal);
	}
    
    public void autoBallPick(double val){
    	ballpicker.set(val);
    }
}

