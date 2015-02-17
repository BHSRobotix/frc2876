// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.RecycleRush2876.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2876.RecycleRush2876.Robot;
import org.usfirst.frc2876.RecycleRush2876.RobotMap;
import org.usfirst.frc2876.RecycleRush2876.subsystems.Elevator;

/**
 *
 */
public class  ElevatorIdle extends Command {
	
	public ElevatorIdle() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
//		Robot.elevator.setSetpoint(RobotMap.elevatorpotentiometer.get());
//		Robot.elevator.setSetpoint(Elevator.BOTTOM);
		Robot.elevator.enablePID();

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SmartDashboard.putNumber("Potentiometer", Robot.elevator.getPosition());
		double leftTrigger = Robot.oi.getLeftTrigger();
		double rightTrigger = Robot.oi.getRightTrigger();
		Robot.elevator.updateDashboard();
		SmartDashboard.putNumber("Left Trigger", leftTrigger);
		SmartDashboard.putNumber("Right Trigger", rightTrigger);
		if (leftTrigger > .1 || rightTrigger > .1){
			Robot.elevator.disablePID();
//			Robot.elevator.getPIDController().reset();
			Robot.elevator.motorTrigger(rightTrigger, leftTrigger);
		}
		else if (!Robot.elevator.getPIDController().isEnable()){
			Robot.elevator.setSetpoint(RobotMap.elevatorpotentiometer.get());
//			Robot.elevator.setSetpoint(1500);
			Robot.elevator.enablePID();
		} 
		
		// This command will execute the trigger elevator commands if any of those controls are pressed
//		double leftTrigger = Robot.oi.getLeftTrigger();
//		double rightTrigger = Robot.oi.getRightTrigger();
//		if ( (!Robot.elevator.bottomMax())) {
//			Robot.elevator.motorLeftTrigger();
//		} else {
//			Robot.elevator.motorOff();
//		}
//		if ( (!Robot.elevator.topMax())) {
//			Robot.elevator.motorRightTrigger();
//		} else {
//			Robot.elevator.motorOff();
//		}

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
