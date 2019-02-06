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



public class IntakeInOut extends Subsystem {
 DoubleSolenoid intakeInOutSolenoid = new DoubleSolenoid(Robot.hardware.INTAKE_IN_OUT_SOLENOID_1, Robot.hardware.INTAKE_IN_OUT_SOLENOID_2);
 
  public static IntakeInOut instance;
  public static IntakeInOut getInstance() {

    if (instance == null){
    instance = new IntakeInOut();
    }
   return instance;
   }

   private IntakeInOut(){
 
  }

    
    
  public void setOut(){
    intakeInOutSolenoid.set(Value.kForward);
  }

  public void setIn(){
    intakeInOutSolenoid.set(Value.kReverse);
  }
  
  
  @Override
  public void initDefaultCommand() {
  }
}
