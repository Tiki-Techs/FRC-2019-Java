/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;



public class IntakeOpenClose extends Subsystem {
  DoubleSolenoid intakeOpenCloseSolenoid = new DoubleSolenoid(Robot.hardware.INTAKE_OPEN_CLOSE_SOLENOID_1, Robot.hardware.INTAKE_OPEN_CLOSE_SOLENOID_2);
  
 
  public static IntakeOpenClose instance;
  public static IntakeOpenClose getInstance() {

    if (instance == null){
    instance = new IntakeOpenClose();
    }
   return instance;
  }

   private IntakeOpenClose(){
     
  }

    
    
   public void setOpen(){
     intakeOpenCloseSolenoid.set(Value.kForward);
   }

   public void setClose(){
     intakeOpenCloseSolenoid.set(Value.kReverse);
   }

   public boolean isOpen(){
     if(intakeOpenCloseSolenoid.get().equals(Value.kForward)){
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
