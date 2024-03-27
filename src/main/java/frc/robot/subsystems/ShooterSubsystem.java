package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    private final VictorSPX m_shooterDown;
    private final VictorSPX m_shooterUp;
    private final VictorSPX m_elevator;

    public ShooterSubsystem(int m_shooterRightID, int m_shooterLeftID, int m_elevatorID) {
        m_shooterDown = new VictorSPX(m_shooterRightID);
        m_shooterUp = new VictorSPX(m_shooterLeftID);
        m_elevator = new VictorSPX(m_elevatorID);
    }

    public void setMotorShooter(double speed) {
        m_shooterDown.set(ControlMode.PercentOutput, -speed);
        m_shooterUp.set(ControlMode.PercentOutput, -speed);
    }

    public void setMotorElevator(double speed) {
        m_elevator.set(ControlMode.PercentOutput, -speed);
    }

    public void activate() {
        m_shooterDown.set(ControlMode.PercentOutput, 0.97);
        m_shooterUp.set(ControlMode.PercentOutput, 0.97);
    }

    public void activateAuto() {
        m_shooterDown.set(ControlMode.PercentOutput, -0.97);
        m_shooterUp.set(ControlMode.PercentOutput, -0.97);
    }

    public void activateElevator() {
        m_elevator.set(ControlMode.PercentOutput, 0.5);
    }

    public void activateElevatorAuto() {
        m_elevator.set(ControlMode.PercentOutput, -0.6);
    }

    public void end() {
        m_shooterDown.set(ControlMode.PercentOutput, 0);
        m_shooterUp.set(ControlMode.PercentOutput, 0);
        m_elevator.set(ControlMode.PercentOutput, 0);
    }
}

