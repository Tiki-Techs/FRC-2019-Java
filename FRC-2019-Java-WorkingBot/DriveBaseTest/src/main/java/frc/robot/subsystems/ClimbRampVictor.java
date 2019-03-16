/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ClimbRampOIControl;

/**
 * Drive Subsystem
 */
public class ClimbRampVictor extends Subsystem {
  VictorSP rampMotor = new VictorSP(Robot.hardware.CLIMB_RAMP_VICTOR);



  public static ClimbRampVictor instance;
  public static ClimbRampVictor getInstance() {

    if (instance == null) {
    instance = new ClimbRampVictor();
    }
   return instance;
   }
    
   public ClimbRampVictor()
   {
     rampMotor.setInverted(true);
   }

 
  

   public void set(double speed){
     rampMotor.set(speed);
   }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ClimbRampOIControl());    
  }
}
