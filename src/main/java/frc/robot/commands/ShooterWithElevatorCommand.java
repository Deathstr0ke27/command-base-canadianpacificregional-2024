package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterWithElevatorCommand extends Command {
    private final ShooterSubsystem shooterSubsystem;
    private final double speed;

    public ShooterWithElevatorCommand(ShooterSubsystem subsystem, double speed) {
        this.shooterSubsystem = subsystem;
        this.speed = speed;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        shooterSubsystem.setMotorShooter(speed);
        shooterSubsystem.setMotorElevator(0.6);
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.setMotorShooter(0);
        shooterSubsystem.setMotorElevator(0);
    }
}

