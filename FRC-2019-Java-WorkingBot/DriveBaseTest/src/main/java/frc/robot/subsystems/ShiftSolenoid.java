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
public class ShiftSolenoid extends Subsystem {
  DoubleSolenoid shift;




  public static ShiftSolenoid instance;

  public static ShiftSolenoid getInstance() {
    if (instance == null){
    instance = new ShiftSolenoid();
    }
   return instance;
   }
    
    private ShiftSolenoid(){
      //hardware is isntance of robotmap
      shift = new DoubleSolenoid(Robot.hardware.SHIFT_SOLENOID_1, Robot.hardware.SHIFT_SOLENOID_2);
    }

   public void setSpeed(){
     shift.set(Value.kForward);
   }
   public void setTorque(){
     shift.set(Value.kReverse);
   }

   public boolean isInSpeed(){
     if(shift.get().equals(Value.kForward)){
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
