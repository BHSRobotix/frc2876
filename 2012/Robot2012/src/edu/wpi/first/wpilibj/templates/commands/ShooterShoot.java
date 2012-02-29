/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 * @author User
 */
public class ShooterShoot extends CommandBase {

    double speed = 0.0;

    public ShooterShoot(double s) {
        // Use requires() here to declare subsystem dependencies
        requires(shooter);
        speed = s;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        shooter.set(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        SmartDashboard.putDouble("Count: " , shooter.getCount());

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