// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.ClawSubsystem;
import edu.wpi.first.wpilibj.Timer;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ClawSubsystem _clawSubsystem = new ClawSubsystem();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    
    /** ⬇ CLAW SUBSYSTEM TEST CODE ⬇ */
    // open the claw slowly
    _clawSubsystem.openClaw();

    // let the claw open for 1 second
    Timer.delay(1);

    // stop opening the claw
    _clawSubsystem.stop();

  }


  // binds commands to joystick buttons
  private void configureBindings() {
    // NOTHING HERE YET
  }
}
