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


  public int SHIFT_SOLENOID_1 = 0;
  public int SHIFT_SOLENOID_2 = 1;

  public int INTAKE_IN_OUT_SOLENOID_1 = 2;
  public int INTAKE_IN_OUT_SOLENOID_2 = 3;

  public int INTAKE_OPEN_CLOSE_SOLENOID_1 = 6;
  public int INTAKE_OPEN_CLOSE_SOLENOID_2 = 7;

  public int CLIMB_SOLENOID_1 = 6;
  public int CLIMB_SOLENOID_2 = 7;

  public int CLIMB_VICTOR_RIGHT = 0;
  public int CLIMB_VICTOR_LEFT = 1;


  
}
