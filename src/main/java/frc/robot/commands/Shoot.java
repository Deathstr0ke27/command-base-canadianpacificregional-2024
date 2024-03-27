package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class Shoot extends Command{
    private final ShooterSubsystem shooterSubsystem;
    private final Timer timer;
    private boolean initialActivationComplete;

    public Shoot(ShooterSubsystem subsystem) {
        this.shooterSubsystem = subsystem;
        timer = new Timer();
        initialActivationComplete = false;

        addRequirements(shooterSubsystem);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
        initialActivationComplete = false;
    }

    @Override
    public void execute() {
        if (!initialActivationComplete) {
            shooterSubsystem.activateAuto(); // Ativa as duas primeiras VictorSPX
            initialActivationComplete = true;
            timer.reset(); // Reinicia o timer para ativar a terceira VictorSPX depois de 1 segundo
        } else if (timer.get() >= 2) {
            shooterSubsystem.activateElevatorAuto(); // Ativa a terceira VictorSPX após 1 segundo
        }
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= 5; // Retorna verdadeiro após 2 segundos para encerrar o comando
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.end(); // Desativa todos os motores do subsistema Shooter ao encerrar o comando
        timer.stop();
    }
}
