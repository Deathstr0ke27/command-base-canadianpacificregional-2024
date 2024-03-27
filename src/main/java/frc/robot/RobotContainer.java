// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.auto.AutoCenterLeft;
import frc.robot.commands.auto.AutoCenter;
import frc.robot.commands.auto.AutoLeftOne;
import frc.robot.commands.auto.AutoRightTwo;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.ShooterWithElevatorCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem dtRight2, dtRight1, dtLeft2, dtLeft1;
  private final ShooterSubsystem m_shooterSubsystem;
  private final IntakeSubsystem m_intakeSubsystem;
  private final ClimbSubsystem m_climbSubsystem;
  private final IntakeCommand m_intakeCommand;
  private final Joystick m_stickDrive;
  private final Joystick m_stickGame;

  private SendableChooser<Command> m_autoChooser = new SendableChooser<>();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_shooterSubsystem = new ShooterSubsystem(Constants.CANID.shooterDownID, Constants.CANID.shooterUpID, Constants.CANID.elevatorID); 
    m_intakeSubsystem = new IntakeSubsystem();
    m_climbSubsystem = new ClimbSubsystem(Constants.CANID.climbID);
    m_stickDrive = new Joystick(Constants.kDriveJoystick);
    m_stickGame = new Joystick(Constants.kGameJoystick);
    

    VictorSPX dtRight2Victor = new VictorSPX(Constants.CANID.dtRightID2);
    VictorSPX dtRight1Victor = new VictorSPX(Constants.CANID.dtRightID1);
    VictorSPX dtLeft2Victor = new VictorSPX(Constants.CANID.dtLeftID2);
    VictorSPX dtLeft1Victor = new VictorSPX(Constants.CANID.dtLeftID1);
        
    dtRight2 = new DriveSubsystem(dtRight2Victor);
    dtRight1 = new DriveSubsystem(dtRight1Victor);
    dtLeft2 = new DriveSubsystem(dtLeft2Victor);
    dtLeft1 = new DriveSubsystem(dtLeft1Victor);

    m_intakeCommand = new IntakeCommand(m_intakeSubsystem, m_stickGame, Constants.kIntakeButton);

    // Configure the trigger bindings
    configureBindings();

    CommandScheduler.getInstance().setDefaultCommand(dtRight2, new DriveCommand(m_stickDrive, dtRight2, dtRight1, dtLeft2, dtLeft1));

    m_autoChooser.setDefaultOption("1 - [AUTO C]", new AutoCenter(m_shooterSubsystem, dtRight2, dtRight1, dtLeft2, dtLeft1));
    m_autoChooser.addOption("2 - [AUTO 1]", new AutoLeftOne(m_shooterSubsystem, dtRight2, dtRight1, dtLeft2, dtLeft1));
    m_autoChooser.addOption("3 - [AUTO 2]", new AutoRightTwo(m_shooterSubsystem, dtRight2, dtRight1, dtLeft2, dtLeft1));
    m_autoChooser.addOption("4 - [AUTO C 2.0]", new AutoCenterLeft(m_shooterSubsystem, dtRight2, dtRight1, dtLeft2, dtLeft1));
    SmartDashboard.putData(m_autoChooser);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */

  private void configureBindings() {
    JoystickButton m_shooterButton = new JoystickButton(m_stickGame, Constants.kShootButton);
    JoystickButton m_elevatorButtonUp = new JoystickButton(m_stickGame, Constants.kElevatorUp);
    JoystickButton m_elevatorButtonDown = new JoystickButton(m_stickGame, Constants.kElevatorDown);
    
    m_shooterButton.whileTrue(new ShooterCommand(m_shooterSubsystem, Constants.kShootSpeed).withTimeout(2).andThen(new ShooterWithElevatorCommand(m_shooterSubsystem, Constants.kShootSpeed)));
    m_elevatorButtonUp.whileTrue(new ElevatorCommand(m_shooterSubsystem, Constants.kElevatorUpSpeed));
    m_elevatorButtonDown.whileTrue(new ElevatorCommand(m_shooterSubsystem, -0.6)); // TODO
    JoystickButton m_intakeButton = new JoystickButton(m_stickGame, Constants.kIntakeButton); //intake
        m_intakeButton.whileTrue(m_intakeCommand); //intake

        JoystickButton m_climbUpButton = new JoystickButton(m_stickGame, Constants.kClimbUp); // Botão 1 do joystick
        JoystickButton m_climbDownButton = new JoystickButton(m_stickGame, Constants.kClimbDown); // Botão 2 do joystick

        m_climbUpButton.whileTrue(new ClimbCommand(m_climbSubsystem, Constants.kClimbUpSpeed)); // Ativa o comando para girar o motor no sentido positivo
        m_climbDownButton.whileTrue(new ClimbCommand(m_climbSubsystem, Constants.kClimbDownSpeed)); // Ativa o comando para girar o motor no sentido negativo
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autoChooser.getSelected();
  }
}
