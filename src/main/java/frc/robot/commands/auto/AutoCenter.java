package frc.robot.commands.auto;

import frc.robot.commands.DriveStraightBackwards;
import frc.robot.commands.Shoot;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoCenter extends SequentialCommandGroup {
    public AutoCenter(ShooterSubsystem shooterSubsystem, DriveSubsystem dtRight2, DriveSubsystem dtRight1, DriveSubsystem dtLeft2, DriveSubsystem dtLeft1) {
        addCommands(
        new Shoot(shooterSubsystem)
        );
    }
}

