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
public class ClimbGrabbers extends Subsystem {
  DoubleSolenoid grabbers = new DoubleSolenoid(Robot.hardware.PCM_0, Robot.hardware.CLIMB_GRABBERS_SOLENOID_1, Robot.hardware.CLIMB_GRABBERS_SOLENOID_2);




  public static ClimbGrabbers instance;

  public static ClimbGrabbers getInstance() {
    if (instance == null){
    instance = new ClimbGrabbers();
    }
   return instance;
   }
    
    private ClimbGrabbers(){
      //hardware is isntance of robotmap
    }

   public void setGrab(){
     grabbers.set(Value.kForward);
   }
   public void setRelease(){
     grabbers.set(Value.kReverse);
   }

  
  @Override
  public void initDefaultCommand() {
  }
}
