package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimbSubsystem extends SubsystemBase{
    private final VictorSPX m_climb;

    public ClimbSubsystem(int motorID) {
        m_climb = new VictorSPX(motorID);
    }

    public void setSpeed(double speed) {
        m_climb.set(ControlMode.PercentOutput, speed);
    }
}
