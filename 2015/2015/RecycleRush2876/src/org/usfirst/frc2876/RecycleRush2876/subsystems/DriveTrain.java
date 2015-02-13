// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.RecycleRush2876.subsystems;

import org.usfirst.frc2876.RecycleRush2876.RobotMap;
import org.usfirst.frc2876.RecycleRush2876.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveTrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController leftFrontMotor = RobotMap.driveTrainLeftFrontMotor;
    SpeedController leftRearMotor = RobotMap.driveTrainLeftRearMotor;
    SpeedController rightFrontMotor = RobotMap.driveTrainRightFrontMotor;
    SpeedController rightRearMotor = RobotMap.driveTrainRightRearMotor;
    RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;
    Gyro gyro = RobotMap.driveTrainGyro;
    Encoder rightFrontEncoder = RobotMap.driveTrainRightFrontEncoder;
    Encoder rightRearEncoder = RobotMap.driveTrainRightRearEncoder;
    Encoder leftFrontEncoder = RobotMap.driveTrainLeftFrontEncoder;
    Encoder leftRearEncoder = RobotMap.driveTrainLeftRearEncoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new DriveWithJoystick());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void drive(double x, double y, double rotation){
    	robotDrive.mecanumDrive_Cartesian(x, y, rotation, 0);
    	
    }
    
    public void fovDrive(double x, double y, double rotation, double gyroAngle){
    	robotDrive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
    }
    
    public double getGyroAngle(){
    	return gyro.getAngle();
    }
    
    public void resetGyro(){
    	gyro.reset();
    }
    
    private boolean isFOV = false;
    public void toggleIsFOV() {
    	this.isFOV = !this.isFOV;
    }
    public boolean getIsFOV() {
    	return isFOV;
    }
    
}

