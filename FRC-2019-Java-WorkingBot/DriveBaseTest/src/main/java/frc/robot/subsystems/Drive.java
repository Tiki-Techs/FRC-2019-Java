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
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;

/**
 * Drive Subsystem
 */
public class Drive extends Subsystem {
  CANSparkMax driveLeftBack = new CANSparkMax(Robot.hardware.DRIVE_LEFT_BACK_SPARK, MotorType.kBrushless);
  CANSparkMax driveRightBack = new CANSparkMax(Robot.hardware.DRIVE_RIGHT_BACK_SPARK, MotorType.kBrushless);
  





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
  
  // turn to target angle
  public void turnTo(double targetAngle){
    Robot.gyro.gyro.reset();
    double kPAngle = .5; //proportional control constant for turning
    double currentAngle = 0;

    while(Math.abs(targetAngle) - Math.abs(currentAngle) < 1){ // 1 degree error allowance
      currentAngle = Robot.gyro.getAngleZ();
      set(0, kPAngle * (1 - (Math.abs(currentAngle) / targetAngle)));
    }
  }
  // returns motor velocity for transmission NEOs
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
