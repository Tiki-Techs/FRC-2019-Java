/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class ClimbVictors extends Subsystem {
  VictorSP climb1 = new VictorSP(Robot.hardware.CLIMB_VICTOR_LEFT);
  VictorSP climb2 = new VictorSP(Robot.hardware.CLIMB_VICTOR_RIGHT);


 
  public static ClimbVictors instance;
  public static ClimbVictors getInstance() {

    if (instance == null){
    instance = new ClimbVictors();
    }
   return instance;
   }

   private ClimbVictors(){
    // test1.setInverted(true);
    // test2.setInverted(true);
  }

    
    
   public void set(double speed){
     climb1.set(speed);
    //  test2.set(speed);
   }
  @Override
  public void initDefaultCommand() {
  }
}
