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

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;

/**
 * Drive Subsystem
 */
public class ClimbTalons extends Subsystem {
  TalonSRX climbTalonLeft = new TalonSRX(Robot.hardware.CLIMB_TALON_LEFT);
  TalonSRX climbTalonRight = new TalonSRX(Robot.hardware.CLIMB_TALON_RIGHT);



  public static ClimbTalons instance;
  public static ClimbTalons getInstance() {

    if (instance == null) {
    instance = new ClimbTalons();
    }
   return instance;
   }
    
   public ClimbTalons()
   {
     //Right Talon runs a PID based on the position of the Left
     climbTalonLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
     climbTalonRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
   }

 
   public void set(double speed){
     climbTalonLeft.set(ControlMode.PercentOutput, speed);
     climbTalonRight.set(ControlMode.Position, climbTalonLeft.getSelectedSensorPosition());
   }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveStandard());    
  }
}
