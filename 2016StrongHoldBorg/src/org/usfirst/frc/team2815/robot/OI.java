package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

import org.usfirst.frc.team2815.robot.commands.ExampleCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick xbox = new Joystick(0);
	Joystick flight = new Joystick(1);
	
	public double getLeftYValue(){
		if(Math.abs(xbox.getRawAxis(1))>=.07){
			return (-.75*xbox.getRawAxis(1));
		}
		else
			return 0;
	}
	
	public double getRightYValue(){
		if(Math.abs(xbox.getRawAxis(5))>=.07){
			return (-.75*xbox.getRawAxis(5));
		}
		else
			return 0;
	}
	
	public double getRightXValue(){
		if(Math.abs(xbox.getRawAxis(4))>=.07){
			return (-1*xbox.getRawAxis(4));
		}
		else
			return 0;
	}
	public boolean getAButton(){
		return xbox.getRawButton(1);
	}
	public boolean getXButton(){
		return xbox.getRawButton(3);
	}
	
	public double getRightTrigger(){
		return xbox.getRawAxis(3);
	}
	public double getLeftTrigger(){
		return xbox.getRawAxis(2);
	}
	public int getThePOV(){
		return xbox.getPOV();
	}
	
	public boolean getFlight1(){
		return flight.getRawButton(1);
	}
	public boolean getFlight2(){
		return flight.getRawButton(2);
	}
	public boolean getFlight3(){
		return flight.getRawButton(3);
	}
	public boolean getFlight4(){
		return flight.getRawButton(4);
	}
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

