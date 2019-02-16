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

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;

/**
 * Drive Subsystem
 */
public class ClimbVictors extends Subsystem {
  VictorSP climbVictorLeft = new VictorSP(Robot.hardware.CLIMB_VICTOR_LEFT);
  VictorSP climbVictorRight = new VictorSP(Robot.hardware.CLIMB_VICTOR_RIGHT);


  public static ClimbVictors instance;
  public static ClimbVictors getInstance() {

    if (instance == null) {
    instance = new ClimbVictors();
    }
   return instance;
   }
    
   public ClimbVictors()
   {
   }

 
   public void set(double speed){
    //  climbVictorLeft.set(speed);
     climbVictorRight.set(speed);
   }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveStandard());    
  }
}
