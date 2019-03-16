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
import frc.robot.commands.TurnTo;
/**
 * Default drive command
 */
public class SecondLevelHabStart extends Command {
  Timer timer;

  private double step0EndTime;
  private double step1EndTime;
  private double step2EndTime;
  private double step3EndTime;
  private boolean isLeft;
  
  public SecondLevelHabStart(boolean left) {
    requires(Robot.drive);
    requires(Robot.shiftSolenoid);
    requires(Robot.limelight);
    requires(Robot.intakePan);
    requires(Robot.intakeInOut);
    requires(Robot.intakeOpenClose);
    isLeft = left;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    timer = new Timer();
    timer.reset();
    timer.start();

    step0EndTime = .05;
    step1EndTime = .05;
    step2EndTime = 1.05;
    step3EndTime = 1.05;
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

  private void shiftInitial(double time){
    Robot.shiftSolenoid.setSpeed();
  }
  private void forwardInitial(double time){
    Robot.drive.set(1,0);
  }

  private void turn90DegreesOne(double time){
    if(isLeft){
      TurnTo turnRight = new TurnTo(90);
    }
    else{
      TurnTo turnLeft = new TurnTo(-90);
    }
  }
  
  private void lateralOne(double time){
    Robot.drive.set(.3, 0);
  }

  private void turn90DegreesTwo(double time){
    if(isLeft){
      TurnTo turnLeft = new TurnTo(-100);
    }
    else{
      TurnTo turnRight = new TurnTo(100);
    }// slightly more than 90 to avoid mistargeting with vision
  }

  private void turnToTarget(double time){
    TurnTo turnToTarget = new TurnTo(Robot.limelight.getAngleX());
  }

  private void forward2(double time){
    Follow moveToTarget = new Follow();
  }
  
  private void releaseHatch(double time){
    Robot.intakeOpenClose.setOpen();
  }

  private void backUp(double time){
    Robot.drive.set(-.2, 0);
    Robot.intakeInOut.setIn();
  }

 

  private void score1(double time){
    Robot.intakeInOut.setOut();
    Robot.drive.set(.2, 0);
  }

  private void score2(double time){
    Robot.intakeOpenClose.setOpen();
    Robot.drive.set(-.1, 0);
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
				shiftInitial(time);
				break;
			case 1:
				forwardInitial(time);
				break;
			case 2:
				forward2(time);
        break;
      case 3:
        turn90DegreesOne(time);
        break;
      case 4:
        backUp(time);
        break;
      case 5:
        score1(time);
        break;
      case 6:
        score2(time);
        break;
      case 7:
        stop(time);
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
