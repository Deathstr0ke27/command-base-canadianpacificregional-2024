package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;

public class DriveStraightBackwards extends Command {
    private final DriveSubsystem dtRight2, dtRight1, dtLeft2, dtLeft1;
    private final Timer timer;
    private final double tempo;

    public DriveStraightBackwards(DriveSubsystem dtRight2, DriveSubsystem dtRight1, DriveSubsystem dtLeft2, DriveSubsystem dtLeft1, double tempo) {
        this.dtRight2 = dtRight2;
        this.dtRight1 = dtRight1;
        this.dtLeft2 = dtLeft2;
        this.dtLeft1 = dtLeft1;
        this.timer = new Timer();
        this.tempo = tempo;

        addRequirements(dtRight2, dtRight1, dtLeft2, dtLeft1); // Requer o subsistema de drive
    }

    @Override
    public void initialize() {
        timer.reset(); // Reseta o timer
        timer.start(); // Inicia o timer
    }

    @Override
    public void execute() {
        dtRight2.setSpeed(0.25); // Move os motores para trás com 50% de velocidade
        dtRight1.setSpeed(0.25);
        dtLeft2.setSpeed(-0.25);
        dtLeft1.setSpeed(-0.25);
    }

    @Override
    public void end(boolean interrupted) {
        dtRight2.stop();
        dtRight1.stop();
        dtLeft2.stop();
        dtLeft1.stop(); // Para os motores quando o comando termina
    }

    @Override
    public boolean isFinished() {
        return timer.hasElapsed(tempo); // Tempo que o robo vai andar pra tras
    }
}