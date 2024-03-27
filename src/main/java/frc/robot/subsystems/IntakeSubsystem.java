package frc.robot.subsystems;

import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase{
    private final VictorSPX m_intake;
    private final VictorSPX m_elevator;

    public IntakeSubsystem() {
        m_intake = new VictorSPX(Constants.CANID.shooterUpID);
        m_elevator = new VictorSPX(Constants.CANID.elevatorID);
    }

    public void intakeOn() {
        m_intake.set(VictorSPXControlMode.PercentOutput, Constants.kIntakeSpeed);
        m_elevator.set(VictorSPXControlMode.PercentOutput, 0.3);
    }

    public void intakeOff() {
        m_intake.set(VictorSPXControlMode.PercentOutput, 0);
        m_elevator.set(VictorSPXControlMode.PercentOutput, 0);
    }
    
    @Override
  public void periodic() {}
}

