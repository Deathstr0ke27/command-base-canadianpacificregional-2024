package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class ClimbCommand extends Command {
    private final ClimbSubsystem climbSubsystem;
    private final double speed;

    public ClimbCommand(ClimbSubsystem subsystem, double speed) {
        this.climbSubsystem = subsystem;
        this.speed = speed;

        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        climbSubsystem.setSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        climbSubsystem.setSpeed(0);
    }
}
