package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class TheClaw extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Victor claw1;
	Victor claw2;

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	public TheClaw() {
		claw1 = new Victor(RobotMap.clawVictor[0]);
		claw2 = new Victor(RobotMap.clawVictor[1]);
	}

	public void operateClaw(double value) {
		claw1.set(-1*value);
		claw2.set(value);
	}
}
