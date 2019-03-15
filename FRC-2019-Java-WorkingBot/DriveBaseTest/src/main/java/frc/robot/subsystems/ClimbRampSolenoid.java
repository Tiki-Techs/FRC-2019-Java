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
public class ClimbRampSolenoid extends Subsystem {
  DoubleSolenoid rampSolenoid = new DoubleSolenoid(Robot.hardware.PCM_1, Robot.hardware.CLIMB_RAMP_BACK_SOLENOID_1, Robot.hardware.CLIMB_RAMP_BACK_SOLENOID_2);




  public static ClimbRampSolenoid instance;

  public static ClimbRampSolenoid getInstance() {
    if (instance == null){
    instance = new ClimbRampSolenoid();
    }
   return instance;
   }
    
    private ClimbRampSolenoid(){
      //hardware is isntance of robotmap
    }

   public void setDown(){
     rampSolenoid.set(Value.kReverse);
   }
   public void setUp(){
    rampSolenoid.set(Value.kForward);
  }

  public void setOff(){
    rampSolenoid.set(Value.kOff);
  }

  public boolean isUp(){
    if(rampSolenoid.get().equals(Value.kForward)){
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