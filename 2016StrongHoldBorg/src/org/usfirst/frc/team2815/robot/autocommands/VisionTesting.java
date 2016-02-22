package org.usfirst.frc.team2815.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.*;

/**
 *
 */
public class VisionTesting extends Command {
	
	NetworkTable table;
	double[] defa = {0,0};
	double[] areas = {0,0};
	public VisionTesting() {
		table = NetworkTable.getTable("GRIP/myContoursReport");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	areas = table.getNumberArray("area", defa);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
