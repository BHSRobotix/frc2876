// RobotBuilder Version: 1.5
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2876.RecycleRush2876;


import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainLeftFrontMotor;
    public static SpeedController driveTrainLeftRearMotor;
    public static SpeedController driveTrainRightFrontMotor;
    public static SpeedController driveTrainRightRearMotor;
    public static RobotDrive driveTrainRobotDrive;
    public static Gyro driveTrainGyro;
    public static Encoder driveTrainRightFrontEncoder;
    public static Encoder driveTrainRightRearEncoder;
    public static Encoder driveTrainLeftFrontEncoder;
    public static Encoder driveTrainLeftRearEncoder;
    public static AnalogPotentiometer elevatorpotentiometer;
    public static SpeedController elevatorElevatorMotor;
    public static DigitalInput elevatorTopLimit;
    public static DigitalInput elevatorBottomLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainLeftFrontMotor = new Talon(4);
        LiveWindow.addActuator("DriveTrain", "LeftFrontMotor", (Talon) driveTrainLeftFrontMotor);
        
        driveTrainLeftRearMotor = new Talon(5);
        LiveWindow.addActuator("DriveTrain", "LeftRearMotor", (Talon) driveTrainLeftRearMotor);
        
        driveTrainRightFrontMotor = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "RightFrontMotor", (Talon) driveTrainRightFrontMotor);
        
        driveTrainRightRearMotor = new Talon(0);
        LiveWindow.addActuator("DriveTrain", "RightRearMotor", (Talon) driveTrainRightRearMotor);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainLeftFrontMotor, driveTrainLeftRearMotor,
              driveTrainRightFrontMotor, driveTrainRightRearMotor);
        
        driveTrainRobotDrive.setSafetyEnabled(false);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);

        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        driveTrainGyro = new Gyro(1);
        driveTrainGyro.initGyro();
        LiveWindow.addSensor("DriveTrain", "Gyro", driveTrainGyro);
        driveTrainGyro.setSensitivity(0.007);
        driveTrainRightFrontEncoder = new Encoder(2, 3, false, EncodingType.k2X);
        LiveWindow.addSensor("DriveTrain", "RightFront Encoder", driveTrainRightFrontEncoder);
        driveTrainRightFrontEncoder.setDistancePerPulse(1.0);
        driveTrainRightFrontEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainRightRearEncoder = new Encoder(0, 1, false, EncodingType.k2X);
        LiveWindow.addSensor("DriveTrain", "RightRear Encoder ", driveTrainRightRearEncoder);
        driveTrainRightRearEncoder.setDistancePerPulse(1.0);
        driveTrainRightRearEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainLeftFrontEncoder = new Encoder(4, 5, true, EncodingType.k2X);
        LiveWindow.addSensor("DriveTrain", "LeftFront Encoder", driveTrainLeftFrontEncoder);
        driveTrainLeftFrontEncoder.setDistancePerPulse(1.0);
        driveTrainLeftFrontEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveTrainLeftRearEncoder = new Encoder(6, 7, true, EncodingType.k2X);
        LiveWindow.addSensor("DriveTrain", "LeftRear Encoder", driveTrainLeftRearEncoder);
        driveTrainLeftRearEncoder.setDistancePerPulse(1.0);
        driveTrainLeftRearEncoder.setPIDSourceParameter(PIDSourceParameter.kRate);
        elevatorpotentiometer = new AnalogPotentiometer(0, 3600.0, 0.0);
        LiveWindow.addSensor("Elevator", "potentiometer", elevatorpotentiometer);
        
        elevatorElevatorMotor = new TalonSRX(7);
        LiveWindow.addActuator("Elevator", "Elevator Motor", (TalonSRX) elevatorElevatorMotor);
        
        elevatorTopLimit = new DigitalInput(8);
        LiveWindow.addSensor("Elevator", "TopLimit", elevatorTopLimit);
        
        elevatorBottomLimit = new DigitalInput(9);
        LiveWindow.addSensor("Elevator", "BottomLimit", elevatorBottomLimit);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        elevatorElevatorMotor = new CANTalon(1);
//        LiveWindow.addActuator("Elevator", "Elevator Motor",  elevatorElevatorMotor);
    }
}
