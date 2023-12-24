// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;

public class OpenClawCommand extends CommandBase {
  private final ClawSubsystem _clawSubsystem;
  private final Timer _timer;

  /** Creates a new OpenClawCommand. */
  public OpenClawCommand(ClawSubsystem clawSubsystem) {
    _clawSubsystem = clawSubsystem;
    _timer = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(clawSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("OpenClawCommand has been scheduled.");

    _timer.start(); // start a "stopwatch" timer 
    _clawSubsystem.openClaw(); // open the claw slowly
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("1 second has passed, OpenClawCommand ended.");

    _clawSubsystem.stop(); // stop opening the claw
    _timer.stop(); // end the timer
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _timer.hasElapsed(1); // finish the command if 1 second has elasped in the timer
  }
}
