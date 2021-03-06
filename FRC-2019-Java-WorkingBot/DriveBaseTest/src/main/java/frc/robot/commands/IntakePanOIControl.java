/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
/**
 * Default drive command
 */
public class IntakePanOIControl extends Command {
  public IntakePanOIControl() {
    requires(Robot.intakePan);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_oi.getTriggerLeft() < .3 && Robot.m_oi.getTriggerRight() < .3)
    {
      if(!(Robot.intakePan.getLimitLeft() || Robot.intakePan.getLimitRight())){
       Robot.intakePan.set(Robot.m_oi.getJoy2TriggerRight() - Robot.m_oi.getJoy2TriggerLeft());
      }
      else if(Robot.intakePan.getLimitLeft()){
       Robot.intakePan.set(Robot.m_oi.getJoy2TriggerRight());
      }
      else{
        Robot.intakePan.set(-Robot.m_oi.getJoy2TriggerLeft());
      }
    }
    else{
      if(Robot.m_oi.getTriggerLeft() >= .3 && !Robot.intakePan.getLimitLeft() && !Robot.intakePan.getLineSensor()){
        Robot.intakePan.set(-1);
      }
      else if(Robot.m_oi.getTriggerRight() >= .3 && !Robot.intakePan.getLimitRight() && !Robot.intakePan.getLineSensor()){
        Robot.intakePan.set(1);
      }
      else{
        Robot.intakePan.set(0);
      }
    }

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
