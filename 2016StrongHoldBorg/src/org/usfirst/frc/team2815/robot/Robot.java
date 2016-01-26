
package org.usfirst.frc.team2815.robot;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2815.robot.autocommands.LowBarDrive;
import org.usfirst.frc.team2815.robot.commands.DriveWithArcadeOrTank;
import org.usfirst.frc.team2815.robot.commands.ExampleCommand;
import org.usfirst.frc.team2815.robot.commands.OperateSolenoids;
import org.usfirst.frc.team2815.robot.commands.ShootEdward;
import org.usfirst.frc.team2815.robot.commands.TankDriveWithJoystick;
import org.usfirst.frc.team2815.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2815.robot.subsystems.EdShooter;
import org.usfirst.frc.team2815.robot.subsystems.ExampleSubsystem;
import org.usfirst.frc.team2815.robot.subsystems.Pnuematics;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	//subsystem declaration
	public static DriveTrain driveTrain;
	public static EdShooter shoot;
	public static Pnuematics pnuem;
	//command declaration
    Command autonomousCommand;
    //Command tankDrive;
    Command togDrive;
    Command fire;
    Command pistons;
    //Miscellaneous
    public static Accelerometer accel;
    SendableChooser chooser;
    //SendableChooser toggDriveChooser;
    CameraServer server;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		//subsystem instantiation
		driveTrain = new DriveTrain();
		shoot = new EdShooter();
		pnuem = new Pnuematics();
		//command instantiation
		//tankDrive = new TankDriveWithJoystick();
		togDrive = new DriveWithArcadeOrTank();
		fire = new ShootEdward();
		autonomousCommand = new LowBarDrive();
		
		accel = new BuiltInAccelerometer(Accelerometer.Range.k4G);
		
		pistons = new OperateSolenoids();
		//chooser = new SendableChooser();
        //chooser.addDefault("Default Auto", new LowBarDrive());
		//chooser.addObject("My Auto", new MyAutoCommand());
        //SmartDashboard.putData("Auto mode", chooser);
		
        //server = CameraServer.getInstance();
        //server.setQuality(30);
        //the camera name (ex "cam0") can be found through the roborio web interface
        //server.startAutomaticCapture("cam0");
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        //autonomousCommand = new LowBarDrive();
        
		/*String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new LowBarDrive();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new LowBarDrive();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
    	
    	//tankDrive.start();
    	
    	//togDrive.start();
    	pistons.start();
    	if (autonomousCommand != null) autonomousCommand.cancel();
    	//fire.start();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
