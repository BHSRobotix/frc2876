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

import org.usfirst.frc2876.RecycleRush2876.RatePIDController;
import org.usfirst.frc2876.RecycleRush2876.RobotMap;
import org.usfirst.frc2876.RecycleRush2876.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
    
    
    // ====================================================================
    // STUFF I ADDED, DO NOT CHECK IN.
    
    // Stuff from RobotDrive class
    int kMaxNumberOfMotors = 4;
    double m_maxOutput = 1.0;
    int m_invertedMotors[] = {1,1,1,1};
    // End stuff from RobotDrive class


    PIDController frontLeftPID;
    PIDController rearLeftPID;
    PIDController frontRightPID;
    PIDController rearRightPID;

    // TODO need to tune rate PID constants.  These are defaults and not correct.
    final double Kp = 0.3;
    final double Ki = 0.0;
    final double Kd = 0.0;
    final double Kf = 0.0;

    public void createPIDControllers() {
    	
    	// TODO. To make rate PID work, we need to have it adjust the current motor speed based on error.
    	// By default, PID will drive motor speed to zero because it is trying to drive error to zero.
    	// There are supposedly two ways to do this:
    	//
    	//  1. use Kf, feed forward.  See chiefdelphi thread about choosing a Kf value.
    	//
    	//  2. define our own PID motor output class and have it adjust current motor speed based on error.
    	//
    	// All this info came from http://www.chiefdelphi.com/forums/showthread.php?t=127096
    	//
    	
    	// The following pid controller declaration assumes we are going to use Kf to make PID work
        frontLeftPID =  new PIDController(Kp, Ki, Kd, Kf, leftFrontEncoder, leftFrontMotor);
        rearLeftPID =  new PIDController(Kp, Ki, Kd, Kf, leftRearEncoder, leftRearMotor);
        frontRightPID =  new PIDController(Kp, Ki, Kd, Kf, rightFrontEncoder, rightFrontMotor);
        rearRightPID =  new PIDController(Kp, Ki, Kd, Kf, rightRearEncoder, rightRearMotor);

        // The following pid controller declarations assume we are going to use our own custom
        // motor output class.
//        frontLeftPID =  new PIDController(Kp, Ki, Kd, Kf, leftFrontEncoder, new RatePIDController(leftFrontMotor));
//        rearLeftPID =  new PIDController(Kp, Ki, Kd, Kf, leftRearEncoder, new RatePIDController(leftRearMotor));
//        frontRightPID =  new PIDController(Kp, Ki, Kd, Kf, rightFrontEncoder, new RatePIDController(rightFrontMotor));
//        rearRightPID =  new PIDController(Kp, Ki, Kd, Kf, rightRearEncoder, new RatePIDController(rightRearMotor));

        
        SmartDashboard.putData("frontLeft", frontLeftPID);
        SmartDashboard.putData("rearLeft", rearLeftPID);
        SmartDashboard.putData("frontRight", frontRightPID);
        SmartDashboard.putData("rearRight", rearRightPID);
    }

    public void initEncoders() {
        //leftFrontEncoder.start();
        leftFrontEncoder.reset();
        //rightFrontEncoder.start();
        rightFrontEncoder.reset();
        //leftRearEncoder.start();
        leftRearEncoder.reset();
        //rightRearEncoder.start();
        rightRearEncoder.reset();
        
    }

    /**
     * Rotate a vector in Cartesian space.
     * 
     * Copied from wpilib RobotDrive.java
     */
    private double[] rotateVector(double x, double y, double angle) {
        double cosA = Math.cos(angle * (3.14159 / 180.0));
        double sinA = Math.sin(angle * (3.14159 / 180.0));
        double out[] = new double[2];
        out[0] = x * cosA - y * sinA;
        out[1] = x * sinA + y * cosA;
        return out;
    }

    /**
     * Normalize all wheel speeds if the magnitude of any wheel is greater than 1.0.
     * 
     * Copied from wpilib RobotDrive.java
     */
    private void normalize(double wheelSpeeds[]) {
        double maxMagnitude = Math.abs(wheelSpeeds[0]);
        int i;
        for (i=1; i<kMaxNumberOfMotors; i++) {
            double temp = Math.abs(wheelSpeeds[i]);
            if (maxMagnitude < temp) maxMagnitude = temp;
        }
        if (maxMagnitude > 1.0) {
            for (i=0; i<kMaxNumberOfMotors; i++) {
                wheelSpeeds[i] = wheelSpeeds[i] / maxMagnitude;
            }
        }
    }


    /**
     * Drive method for Mecanum wheeled robots. Removed all references to CAN stuff
     * and changed motor output calls/sets to set pid setpoint instead.
     * 
     * Copied from wpilib RobotDrive.java
     */
    public void mecanumDrive_PID(double x, double y, double rotation, double gyroAngle) {
        double xIn = x;
        double yIn = y;
        // Negate y for the joystick.
        yIn = -yIn;
        // Compenstate for gyro angle.
        double rotated[] = rotateVector(xIn, yIn, gyroAngle);
        xIn = rotated[0];
        yIn = rotated[1];

        double wheelSpeeds[] = new double[kMaxNumberOfMotors];
        wheelSpeeds[RobotDrive.MotorType.kFrontLeft.value] = xIn + yIn + rotation;
        wheelSpeeds[MotorType.kFrontRight.value] = -xIn + yIn - rotation;
        wheelSpeeds[MotorType.kRearLeft.value] = -xIn + yIn + rotation;
        wheelSpeeds[MotorType.kRearRight.value] = xIn + yIn - rotation;

        normalize(wheelSpeeds);

        // We don't want to set absolute motor speeds here, instead we want to set PID setpoints to make sure wheels are all rotating at same rate. 
        //
//        frontLeftSpeedController.set(wheelSpeeds[MotorType.kFrontLeft.value] * m_invertedMotors[MotorType.kFrontLeft.value] * m_maxOutput);
//        frontRightSpeedController.set(wheelSpeeds[MotorType.kFrontRight.value] * m_invertedMotors[MotorType.kFrontRight.value] * m_maxOutput);
//        rearLeftSpeedController.set(wheelSpeeds[MotorType.kRearLeft.value] * m_invertedMotors[MotorType.kRearLeft.value] * m_maxOutput);
//        rearRightSpeedController.set(wheelSpeeds[MotorType.kRearRight.value] * m_invertedMotors[MotorType.kRearRight.value] * m_maxOutput);        

        frontLeftPID.setSetpoint(wheelSpeeds[MotorType.kFrontLeft.value] * m_invertedMotors[MotorType.kFrontLeft.value] * m_maxOutput);
        rearLeftPID.setSetpoint(wheelSpeeds[MotorType.kRearLeft.value] * m_invertedMotors[MotorType.kRearLeft.value] * m_maxOutput);
        frontRightPID.setSetpoint(wheelSpeeds[MotorType.kFrontRight.value] * m_invertedMotors[MotorType.kFrontRight.value] * m_maxOutput);
        rearRightPID.setSetpoint(wheelSpeeds[MotorType.kRearRight.value] * m_invertedMotors[MotorType.kRearRight.value] * m_maxOutput);        
    }

}

