// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClawSubsystem extends SubsystemBase {
  private final TalonFX _clawMotor;

  /** Creates a new Claw. */
  public ClawSubsystem() {
    _clawMotor = new TalonFX(Constants.CAN.CLAW_MOTOR_ID); // CAN ID in Constants
  }

  /** Slowly opens the claw. */
  public void openClaw() {
    _clawMotor.set(TalonFXControlMode.PercentOutput, 0.3);
    System.out.println("Claw is opening.");
  }

  /** Slowly closes the claw. */
  public void closeClaw() {
    _clawMotor.set(TalonFXControlMode.PercentOutput, -0.3);
    System.out.println("Claw is closing");
  }

  /** Stops opening/closing claw. */
  public void stop() {
    _clawMotor.set(TalonFXControlMode.PercentOutput, 0);
    System.out.println("Claw has stopped.");
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println("Periodic from Claw Subsystem!");
  }
}
