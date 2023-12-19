// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.CANCoder;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();




    // create a new talon object in the code, passing in the motor's CAN ID
    // TalonFX wheelMotor = new TalonFX(10);
    TalonFX wheelMotor = new TalonFX(Constants.CAN.WHEEL_MOTOR_ID); // using the value from constants

    // tells the Talon that we'll be reading from its built-in INCREMENTAL encoder
    wheelMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    // sets the percent output of the Talon
    // (between -1.0 (full power reverse) and +1.0 (full power forward), with 0 being no motion)
    wheelMotor.set(TalonFXControlMode.PercentOutput, 0.5);

    // pause for 3 seconds (similar to python time.sleep), letting the motors spin at 0.5 percent output
    Timer.delay(3);

    // display in the console how many ticks the built-in encoder traveled
    System.out.println(wheelMotor.getSelectedSensorPosition());





    // create a new cancoder object in the code, passing in the encoder's CAN ID
    // CANCoder armEncoder = new CANCoder(3);
    CANCoder armEncoder = new CANCoder(Constants.CAN.ARM_ENC_ID); // using the value from constants

    // tells the CANCoder that we want the absolute position (angle) to be between 0 degrees and 360 degrees
    armEncoder.configAbsoluteSensorRange(AbsoluteSensorRange.Unsigned_0_to_360);

    // displays the absolute position (angle) of the encoder
    System.out.println(armEncoder.getAbsolutePosition());



    
    System.out.println("Robot turned on, I'm printed.");
    System.out.println();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run(); // gonna talk about this later

    System.out.println("I'm printed periodically, every 20ms.");
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
