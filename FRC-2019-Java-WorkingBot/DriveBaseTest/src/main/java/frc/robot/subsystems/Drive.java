/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.*;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;

/**
 * Drive Subsystem
 */
public class Drive extends Subsystem {
  CANSparkMax driveLeftFront = new CANSparkMax(Robot.hardware.DRIVE_LEFT_FRONT_SPARK, MotorType.kBrushless);
  CANSparkMax driveLeftBack = new CANSparkMax(Robot.hardware.DRIVE_LEFT_BACK_SPARK, MotorType.kBrushless);
  CANSparkMax driveRightBack = new CANSparkMax(Robot.hardware.DRIVE_RIGHT_BACK_SPARK, MotorType.kBrushless);
  CANSparkMax driveRightFront = new CANSparkMax(Robot.hardware.DRIVE_RIGHT_FRONT_SPARK, MotorType.kBrushless);

  Encoder driveLeftEncoder = new Encoder(Robot.hardware.DRIVE_LEFT_ENCODER_1, Robot.hardware.DRIVE_LEFT_ENCODER_2, false, EncodingType.k4X);
  Encoder driveRightEncoder = new Encoder(Robot.hardware.DRIVE_RIGHT_ENCODER_1, Robot.hardware.DRIVE_RIGHT_ENCODER_2, false, EncodingType.k4X);


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
     driveRightFront.setInverted(true);
    //  driveLeftEncoder.setDistancePerPulse(1);
    //  driveRightEncoder.setDistancePerPulse(1);
     driveLeftEncoder.setDistancePerPulse(.0002337787); // in meters
     driveRightEncoder.setDistancePerPulse(.0002337787); // in meters
    driveRightEncoder.setReverseDirection(true);
   }

  public void set(double speed, double turn) {
    driveLeftFront.set(speed + turn);
    driveLeftBack.set(speed + turn);
    driveRightFront.set(speed - turn);
    driveRightBack.set(speed - turn);
  }

  public void setLeftRight(double left, double right){
    driveLeftFront.set(left);
    driveLeftBack.set(left);
    driveRightFront.set(right);
    driveRightBack.set(right);
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

  public int getLeftEncoderPos(){
    return (int) driveLeftEncoder.getDistance();
  }
  public int getRightEncoderPos(){
    return (int) driveRightEncoder.getDistance();
  }

  public double getLeftEncoderDist(){
    return driveLeftEncoder.getDistance() * .0002337787;
  }
  public double getRightEncoderDist(){
    return driveRightEncoder.getDistance() * .0002337787;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveStandard());    
  }
}
