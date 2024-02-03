// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.OpenClawCommand;
import frc.robot.subsystems.ClawSubsystem;
import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ClawSubsystem _clawSubsystem = new ClawSubsystem();

  // create a new ps4 controller object, and use the ps4 controller connected to the DRIVER_CONTROLLER port 
  private final CommandPS4Controller _driverController = new CommandPS4Controller(Constants.ControllerPorts.DRIVER_CONTROLLER);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    MedianFilter filter = new MedianFilter(13);
    SmartDashboard.putNumber("OUT", 0);

    double[] values = {
      60,
      60,
      60,
      60,
      60, 
      60, 
      60,
      0,
      0,
      10,
      30,
      50,
      51,
      56,
      60,
      60,
      60,
      60,
      60,
      60,
      60,
      60,
      60
    };

    for (double value: values) {
      SmartDashboard.putNumber("OUT", filter.calculate(value));
      Timer.delay(0.55);
    }

    // Timer.delay(10);
    // out = filter.calculate(100);
    // SmartDashboard.putNumber("OUT", out);



    // bind ps4 controller buttons to Commands
    configureBindings();
  }

  /** Return the Command that gets scheduled once the robot is enabled in auton mode. */
  public Command getAutonCommand() {
    return new OpenClawCommand(_clawSubsystem);
  }

  // binds commands to joystick buttons
  private void configureBindings() {
    // once the square button on the ps4 controller is pressed, schedule the OpenClawCommand
    _driverController.square().onTrue(new OpenClawCommand(_clawSubsystem));
  }
}
