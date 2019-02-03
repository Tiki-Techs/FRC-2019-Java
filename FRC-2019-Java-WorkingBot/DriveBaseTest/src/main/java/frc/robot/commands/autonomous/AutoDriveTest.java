// /*----------------------------------------------------------------------------*/
// /* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
// /* Open Source Software - may be modified and shared by FRC teams. The code   */
// /* must be accompanied by the FIRST BSD license file in the root directory of */
// /* the project.                                                               */
// /*----------------------------------------------------------------------------*/

// package frc.robot.commands.autonomous;

// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.command.Command;
// import frc.robot.Robot;
// /**
//  * Default drive command
//  */
// public class AutoDriveTest extends Command {
//   Timer timer;

//   private double step0EndTime;
//   private double step1EndTime;
//   private double step2EndTime;
//   private double step3EndTime;
  
//   public AutoDriveTest() {
//     requires(Robot.drive);
//   }

//   // Called just before this Command runs the first time
//   @Override
//   protected void initialize() {
//     timer = new Timer();
//     timer.reset();
//     timer.start();

//     step0EndTime = 1;
//     step1EndTime = 2;
//     step2EndTime = 3;
//     step3EndTime = 4;
//   }

//   // Called repeatedly when this Command is scheduled to run
//   @Override
//   protected void execute() {
//     double speed = Robot.m_oi.getY();
//     double turn = Robot.m_oi.getX();
//   }

//   private int phaseFor(double t){
//     if(t < 
//   }

//   // Make this return true when this Command no longer needs to run execute()
//   @Override
//   protected boolean isFinished() {
//     return false;
//   }

//   // Called once after isFinished returns true
//   @Override
//   protected void end() {
//   }

//   // Called when another command which requires one or more of the same
//   // subsystems is scheduled to run
//   @Override
//   protected void interrupted() {
//   }
// }
