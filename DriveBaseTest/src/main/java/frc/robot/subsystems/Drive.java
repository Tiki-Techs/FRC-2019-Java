/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;

/**
 * Drive Subsystem
 */
public class Drive extends Subsystem {
  RobotMap hardware = new RobotMap();
  CANSparkMax driveLeftBack = new CANSparkMax(hardware.DRIVE_LEFT_BACK_SPARK, MotorType.kBrushless);
  CANSparkMax driveRightBack = new CANSparkMax(hardware.DRIVE_RIGHT_BACK_SPARK, MotorType.kBrushless);
  
  




  public static Drive instance;
  public static Drive getInstance() {

    if (instance == null) {
    instance = new Drive();
    }
   return instance;
   }
    
   public Drive()
   {
     driveRightBack.setInverted(true);
   }

  public void set(double speed, double turn) {
    driveLeftBack.set(speed + turn);
    driveRightBack.set(speed - turn);
  }

  //returns motor velocity for transmission NEOs
  public double getLeftNeoEncoder(){
      return driveLeftBack.getEncoder().getVelocity();
  }
  public double getRightNeoEncoder(){
    return driveRightBack.getEncoder().getVelocity();
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveStandard());    
  }
}
