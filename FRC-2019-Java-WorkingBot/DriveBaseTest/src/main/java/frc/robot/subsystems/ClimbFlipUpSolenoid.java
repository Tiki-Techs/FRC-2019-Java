/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;


/**
 * Drive Subsystem
 */
public class ClimbFlipUpSolenoid extends Subsystem {
  DoubleSolenoid climbFlipUp = new DoubleSolenoid(Robot.hardware.PCM_0, Robot.hardware.CLIMB_FLIP_UP_SOLENOID_1, Robot.hardware.CLIMB_FLIP_UP_SOLENOID_2);




  public static ClimbFlipUpSolenoid instance;

  public static ClimbFlipUpSolenoid getInstance() {
    if (instance == null){
    instance = new ClimbFlipUpSolenoid();
    }
   return instance;
   }
    
    private ClimbFlipUpSolenoid(){
      //hardware is isntance of robotmap
    }

   public void setUp(){
     climbFlipUp.set(Value.kForward);
   }
   public void setDown(){
     climbFlipUp.set(Value.kReverse);
   }
   public boolean isUp(){
     if(climbFlipUp.get().equals(Value.kForward)){
      return true;
    }
     else{
       return false;
     }
   }

  
  @Override
  public void initDefaultCommand() {
  }
}
