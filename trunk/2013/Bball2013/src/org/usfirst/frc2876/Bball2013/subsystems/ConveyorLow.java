// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc2876.Bball2013.subsystems;
import org.usfirst.frc2876.Bball2013.RobotMap;
import org.usfirst.frc2876.Bball2013.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class ConveyorLow extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput lmLow = RobotMap.conveyorLowlmLow;
    Relay conveyorLowRelay = RobotMap.conveyorLowconveyorLowRelay;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    int counter;
    boolean previous;
    Relay.Value relay_val = Relay.Value.kOff;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        setDefaultCommand(new ConveyorLowOff());
    }
    public boolean hasBall() {
        return lmLow.get();
    }
    public boolean hasBallEntered() {
        boolean b = lmLow.get();
        if (b && !previous) {
            // ball just hit lim
            previous = true;
            return true;
        } else if (b) {
            // ball is hitting lim
            return true;
        }
        // ball hasn't hit lim switch
        return false;
    }
    public boolean hasBallExited() {
        boolean b = lmLow.get();
        if (!b && previous) {
            // ball was pressing lim and has gone past lim
            previous = false;
            return true;
        } else if (b) {
            // ball is still pressing lim
            return false;
        }
        // ball is still hitting lim switch or never entered?
        return false;
    }
    public void incrCounter() {
        counter++;
        if (counter > 3) {
            counter = 3;
        }
    }
    public void decrCounter() {
        counter--;
        if (counter < 0) {
            counter = 0;
        }
    }
    public int getCounter() {
        return counter;
    }
    public void idle() {
        relay_val = Relay.Value.kOff;
        //conveyorLowRelay.set(relay_val);
    }
    public void forward() {
        relay_val = Relay.Value.kForward;
        //conveyorLowRelay.set(relay_val);
    }
    public void reverse() {
        relay_val = Relay.Value.kReverse;
        //conveyorLowRelay.set(relay_val);
    }
}
