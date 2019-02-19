/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;
import frc.robot.commands.IntakePanOIControl;

/**
 * Drive Subsystem
 */
public class IntakePan extends Subsystem {
  CANSparkMax panMotor = new CANSparkMax(Robot.hardware.INTAKE_PAN_SPARK, MotorType.kBrushed);
  DigitalInput limitSwitchLeft = new DigitalInput(Robot.hardware.INTAKE_PAN_LIMIT_LEFT);
  DigitalInput limitSwitchRight = new DigitalInput(Robot.hardware.INTAKE_PAN_LIMIT_RIGHT); 
  DigitalInput lineSensor = new DigitalInput(Robot.hardware.INTAKE_PAN_LINE_SENSOR);




  public static IntakePan instance;
  public static IntakePan getInstance() {

    if (instance == null) {
    instance = new IntakePan();
    }
   return instance;
   }
    
   public IntakePan()
   {
   }

 
   public boolean getLineSensor(){
     return lineSensor.get();
   }
   public boolean getLimitLeft(){
     return !limitSwitchLeft.get();
   }
   public boolean getLimitRight(){
     return !limitSwitchRight.get();
   }

   public double getEncoderPos(){
     return panMotor.getEncoder().getPosition();
   }
   public void setEncoderZero(){
     panMotor.getEncoder().setPosition(0);
   }
   // center is -11.819

   

   public void set(double speed){
     panMotor.set(speed);
   }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new IntakePanOIControl());    
  }
}
