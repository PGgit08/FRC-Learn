// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class ControllerPorts {
    public static final int DRIVER_CONTROLLER = 0;
  }

  // CAN IDs
  public static class CAN {
    public static final int WHEEL_MOTOR_ID = 10;
    public static final int CLAW_MOTOR_ID = 5;

    public static final int ARM_ENC_ID = 3;
  }
}
