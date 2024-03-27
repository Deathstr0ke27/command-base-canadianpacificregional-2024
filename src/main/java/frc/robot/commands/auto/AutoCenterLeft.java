package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveStraightBackwards;
import frc.robot.commands.Shoot;
import frc.robot.commands.TurnLeft;
import frc.robot.commands.TurnRight;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class AutoCenterLeft extends SequentialCommandGroup{
    public AutoCenterLeft(ShooterSubsystem shooterSubsystem, DriveSubsystem dtRight2, DriveSubsystem dtRight1, DriveSubsystem dtLeft2, DriveSubsystem dtLeft1) {
        addCommands(
        new Shoot(shooterSubsystem),
        new TurnLeft(dtRight2, dtRight1, dtLeft2, dtLeft1, 0.4),
        new DriveStraightBackwards(dtRight2, dtRight1, dtLeft2, dtLeft1, 6),
        new TurnRight(dtRight2, dtRight1, dtLeft2, dtLeft1, 1.3));
    }
}
