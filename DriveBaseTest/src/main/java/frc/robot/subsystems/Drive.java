/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;

/**
 * Drive Subsystem
 */
public class Drive extends Subsystem {
  RobotMap hardware = new RobotMap();
  TalonSRX driveLeftFront = new TalonSRX(hardware.DRIVE_LEFT_FRONT_TALON);
  TalonSRX driveLeftBack = new TalonSRX(hardware.DRIVE_LEFT_BACK_TALON);
  TalonSRX driveRightFront = new TalonSRX(hardware.DRIVE_RIGHT_FRONT_TALON);
  TalonSRX driveRightBack = new TalonSRX(hardware.DRIVE_RIGHT_BACK_TALON);




  public static Drive instance;
  public static Drive getInstance() {

    if (instance == null) {
    instance = new Drive();
    }
   return instance;
   }
    
   public Drive()
   {
   }
  public void set(double speed, double turn) {
    driveLeftFront.set(ControlMode.PercentOutput, -(speed - turn));
    driveLeftBack.set(ControlMode.PercentOutput, -(speed - turn));
    driveRightFront.set(ControlMode.PercentOutput, speed + turn);
    driveRightBack.set(ControlMode.PercentOutput, speed + turn);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveStandard());    
  }
}
