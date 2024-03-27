package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends Command {
    private final IntakeSubsystem m_intakeSubsystem;
    private final Joystick m_joystick;
    private final int m_button;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, Joystick joystick, int button) {
        m_intakeSubsystem = intakeSubsystem;
        m_joystick = joystick;
        m_button = button;
        
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute() {
        if (m_joystick.getRawButton(m_button)) {
            m_intakeSubsystem.intakeOn();
        } else {
            m_intakeSubsystem.intakeOff();
        }
    }

    @Override
    public void end(boolean interrupted) {
        m_intakeSubsystem.intakeOff();
    }
}
