/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.commands.Follow;
import frc.robot.commands.IntakeClose;
import frc.robot.commands.IntakeOpen;
/**
 * Default drive command
 */
public class AutoDriveTest extends Command {
  Timer timer;

  private double step0EndTime;
  private double step1EndTime;
  private double step2EndTime;
  private double step3EndTime;
  
  public AutoDriveTest() {
    requires(Robot.drive);
    requires(Robot.shiftSolenoid);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer = new Timer();
    timer.reset();
    timer.start();

    step0EndTime = 1;
    step1EndTime = 1;
    step2EndTime = 1;
    step3EndTime = 1;
  }

  private int phaseFor(double t){
    if (t < step0EndTime)
    {
        return 0;
    }
    if (t < step1EndTime)
    {
        return 1;
    }
    if (t < step2EndTime)
    {
        return 2;
    }
    return 3;
  }

  private void forwardInitial(double time){
    new IntakeOpen();
    new IntakeClose();
  }

  private void turnToTarget(double time){
    new Follow();
  }

  private void squareUp(double time){
    Robot.drive.set(.2, 0);
  }
  
  private void stop(double time){
    Robot.drive.set(0,0);
    Robot.intakePan.set(0);
  }
  
  

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double time = timer.get();
		int phase = phaseFor(time);
		// Call the behavior appropriate for the phase
		switch (phase) {
			case 0:
				forwardInitial(time);
				break;

			case 1:
				turnToTarget(time);
				break;
			case 2:
				squareUp(time);
				break;
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
