// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import edu.wpi.first.wpilibj.SerialPort;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  private static final int A = 1;
  private static final int B = 2;
  private static final int X = 3;
  private static final int Y = 4;
  private static final int LB = 5;
  private static final int RB = 6;

  public static final int kDriveJoystick = 0;
  public static final int kGameJoystick = 1;

  public static final int kClimbUp = Y;
  public static final int kClimbDown = A;
  public static final int kIntakeButton = LB;
  public static final int kShootButton = RB;
  public static final int kElevatorUp = B;
  public static final int kElevatorDown = X;

  public static final int kLeftStickY = 1;
  public static final int kRightStickY = 5;
  public static final double kShootSpeed = 0.95;
  public static final double kElevatorUpSpeed = 0.5;
  public static final double kIntakeSpeed = 0.8;
  public static final double kElevatorDownSpeed = -0.2;
  public static final double kClimbUpSpeed = 0.35;
  public static final double kClimbDownSpeed = -1;

  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public class CANID {
    public static final int climbID = 1;
    public static final int shooterUpID = 2; //LEFT no PhoenixTunerX
    public static final int shooterDownID = 3; //RIGHT no PhoenixTunerX
    public static final int elevatorID = 4;
    public static final int dtRightID2 = 5;
    public static final int dtRightID1 = 6;
    public static final int dtLeftID2 = 7;
    public static final int dtLeftID1 = 8;
  }
}