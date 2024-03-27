package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ElevatorCommand extends Command {
    private final ShooterSubsystem shooterSubsystem;
    private final double speed;

    public ElevatorCommand(ShooterSubsystem subsystem, double speed) {
        this.shooterSubsystem = subsystem;
        this.speed = speed;

        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        shooterSubsystem.setMotorElevator(speed);
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.setMotorElevator(0);
    }
}