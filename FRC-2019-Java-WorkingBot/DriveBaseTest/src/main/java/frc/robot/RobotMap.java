/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {


  public int DRIVE_LEFT_FRONT_SPARK = 0;
  public int DRIVE_LEFT_BACK_SPARK = 1;
  public int DRIVE_RIGHT_BACK_SPARK = 2;
  public int DRIVE_RIGHT_FRONT_SPARK = 3;

  public int DRIVE_LEFT_ENCODER_1 = 0;
  public int DRIVE_LEFT_ENCODER_2 = 1;
  public int DRIVE_RIGHT_ENCODER_1 = 2;
  public int DRIVE_RIGHT_ENCODER_2 = 3;

  public int SHIFT_SOLENOID_1 = 0;
  public int SHIFT_SOLENOID_2 = 1;

  public int INTAKE_IN_OUT_SOLENOID_1 = 2;
  public int INTAKE_IN_OUT_SOLENOID_2 = 3;

  public int INTAKE_OPEN_CLOSE_SOLENOID_1 = 6;
  public int INTAKE_OPEN_CLOSE_SOLENOID_2 = 7;

  public int CLIMB_SOLENOID_1 = 6;
  public int CLIMB_SOLENOID_2 = 7;

  public int CLIMB_TALON_LEFT = 4;
  public int CLIMB_TALON_RIGHT = 5;




  //constants

  public double kLimelightHeight = 0.78105; // in meters
  public double kTargetHeight = 0.725775155; // in meters
  

  public double kMaxSpeedHigh = 15.5; // meters per second
  public double kMaxAccelHigh = 7.961504812;
  public double kMaxJerkHigh = 40;

  public double kMaxSpeedLow = 8; // meters per second
  public double kMaxAccelLow = 16.37795275;
  public double kMaxJarkLow = 20;

  public double kWheelBaseWidth = .6477; // in meters


  public int kDriveEncoderResolution = 2048;

  public double kWheelDiameter = .1524; // in meters


  
}
