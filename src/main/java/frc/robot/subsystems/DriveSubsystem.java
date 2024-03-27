package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase {
    private VictorSPX motor;

    public DriveSubsystem(VictorSPX motor) {
        this.motor = motor;
    }
    
    public void setSpeed(double speed) {
        motor.set(ControlMode.PercentOutput, speed);
    }
    
    public void stop() {
        motor.set(ControlMode.PercentOutput, 0.0);
    }
}