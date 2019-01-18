/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;

/**
 * Drive Subsystem
 */
public class Drive extends Subsystem {
  TalonSRX driveLeftFront;
  TalonSRX driveLeftBack;
  TalonSRX driveRightFront;
  TalonSRX driveRightBack;

  RobotMap hardware;


  public static Drive instance;
  public static Drive getInstance() {

    if (instance == null) {
    instance = new Drive();
    }
   return instance;
   }
    
   public Drive()
   {
     hardware = new RobotMap();
   }
  public void set(double speed, double turn) {
    driveLeftFront.set(ControlMode.PercentOutput, speed + turn);
    driveLeftBack.set(ControlMode.PercentOutput, speed + turn);
    driveRightFront.set(ControlMode.PercentOutput, speed + turn);
    driveRightBack.set(ControlMode.PercentOutput, speed + turn);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveStandard());    
  }
}
