package org.usfirst.frc.team2815.robot.subsystems;

import org.usfirst.frc.team2815.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pnuematics extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	Solenoid solenoid1[] = new Solenoid[2];
	Solenoid solenoid2[] = new Solenoid[2];
	// boolean state1;
	// boolean state2;
	//
	public Pnuematics(){
	solenoid1[0] = new Solenoid(RobotMap.pnuSolenoid1[0]);
	solenoid1[1] = new Solenoid(RobotMap.pnuSolenoid1[1]);
	solenoid2[0] = new Solenoid(RobotMap.pnuSolenoid2[0]);
	solenoid2[1] = new Solenoid(RobotMap.pnuSolenoid2[1]);
	// state1 = false;
	// state2 = false;
	}

	public void operateSolenoid1(boolean fire) {
		/*
		 * if(changeState){ if(!state1){ while(changeState){
		 * solenoid1[0].set(true); solenoid1[1].set(false); } state1 = !state1;
		 * }else{ while(changeState){ solenoid1[0].set(false);
		 * solenoid1[1].set(true); } state1 = !state1; }
		 * 
		 * }
		 */
		if (!fire) {
			solenoid1[0].set(true);
			solenoid1[1].set(false);
		} else {
			solenoid1[0].set(false);
			solenoid1[1].set(true);
		}
	}

	public void operateSolenoid2(boolean fire) {
		/*
		 * if(changeState){ if(!state2){ while(changeState){
		 * solenoid2[0].set(true); solenoid2[1].set(false); } state2 = !state2;
		 * }else{ while(changeState){ solenoid2[0].set(false);
		 * solenoid2[1].set(true); } state2 = !state2; }
		 * 
		 * }
		 */
		if (!fire) {
			solenoid2[0].set(true);
			solenoid2[1].set(false);
		} else {
			solenoid2[0].set(false);
			solenoid2[1].set(true);
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
