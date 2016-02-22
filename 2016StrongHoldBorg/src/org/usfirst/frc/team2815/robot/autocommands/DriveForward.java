package org.usfirst.frc.team2815.robot.autocommands;

import org.usfirst.frc.team2815.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {
	private boolean state;
	private final double STARTTIME;
	private final boolean FINISHED = true;
	private double drive_Time; // DRIVE_TIME is 2
	private double speed;
	public DriveForward(double time, double speed) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.driveTrain);
		drive_Time = time;
		STARTTIME = Timer.getMatchTime();
		this.speed = speed;
		// state = BOOTING;
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		this.setInterruptible(false);

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		// if(Timer.getMatchTime()<=(STARTTIME+drive_Time))
		// Robot.driveTrain.setMotors(-.25, -.25);
		// else{
		// Robot.driveTrain.setMotors(0, 0);
		// state = FINISHED;

		Robot.driveTrain.setMotors(speed, speed);
		Timer.delay(drive_Time);
		Robot.driveTrain.setMotors(0, 0);
		state = FINISHED;
		// }
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return (state);
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
