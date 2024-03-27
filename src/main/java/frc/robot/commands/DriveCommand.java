package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.Joystick;

public class DriveCommand extends Command{
    private Joystick joystick;
    private DriveSubsystem dtRight2, dtRight1, dtLeft2, dtLeft1;

    private double leftStickY;
    private double rightStickY;
    
    public DriveCommand(Joystick joystick, DriveSubsystem dtRight2, DriveSubsystem dtRight1, DriveSubsystem dtLeft2, DriveSubsystem dtLeft1) {
        this.joystick = joystick;
        this.dtRight2 = dtRight2;
        this.dtRight1 = dtRight1;
        this.dtLeft2 = dtLeft2;
        this.dtLeft1 = dtLeft1;
        
        addRequirements(dtRight2, dtRight1, dtLeft2, dtLeft1);
    }
    
    @Override
    public void execute() {
        leftStickY = joystick.getRawAxis(Constants.kLeftStickY);
        rightStickY = joystick.getRawAxis(Constants.kRightStickY);

        dtRight2.setSpeed(rightStickY);
        dtRight1.setSpeed(rightStickY);
        dtLeft2.setSpeed(-leftStickY);
        dtLeft1.setSpeed(-leftStickY);
    }

    @Override
    public void end(boolean interrupted) {
        dtRight2.stop();
        dtRight1.stop();
        dtLeft2.stop();
        dtLeft1.stop();
    }
}
