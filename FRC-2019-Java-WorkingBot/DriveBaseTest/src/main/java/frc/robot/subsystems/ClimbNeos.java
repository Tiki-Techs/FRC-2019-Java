/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;


/**
 * Drive Subsystem
 */
public class ClimbNeos extends Subsystem {
  CANSparkMax leftNeo = new CANSparkMax(Robot.hardware.CLIMB_NEO_LEFT, MotorType.kBrushless);
  CANSparkMax rightNeo = new CANSparkMax(Robot.hardware.CLIMB_NEO_RIGHT, MotorType.kBrushless);

  public static ClimbNeos instance;
  public static ClimbNeos getInstance() {

    if (instance == null) {
    instance = new ClimbNeos();
    }
   return instance;
   }
    
   public ClimbNeos()
   {
   }

 
   public void set(double speed){
     leftNeo.set(speed);
     rightNeo.set(speed);
   }
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new ClimbVictorsOIControl());
  }
}
