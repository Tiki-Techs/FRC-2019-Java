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
import jaci.pathfinder.Pathfinder;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Waypoint;
import jaci.pathfinder.followers.EncoderFollower;
import jaci.pathfinder.modifiers.TankModifier;
/**
 * Default drive command
 */
public class ScoreHatch extends Command {
  public ScoreHatch() {
    requires(Robot.drive);
    requires(Robot.gyro);
    requires(Robot.limelight);
    requires(Robot.shiftSolenoid);
  }

  Trajectory.Config config;
  Trajectory trajectory;
  TankModifier modifier;
  EncoderFollower left;
  EncoderFollower right;
  double maxSpeed;
  double maxAccel;
  double maxJerk;
  double l;
  double r;
  double gyro_heading;
  double desired_heading;
  double angleDifference;
  double turn;
  double waypointY;
  double waypointX;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //waypoint values in meters
    double waypointY = (Robot.hardware.kTargetHeight - Robot.hardware.kLimelightHeight) / Math.tan(Robot.limelight.getAngleY());
    if(Robot.limelight.getAngleX() > 0){
      waypointX = waypointY * Math.sin(Robot.limelight.getAngleX());
    }
    else{
      waypointX = -(waypointY * Math.sin(Robot.limelight.getAngleX()));
    }
    double waypointX = waypointY * Math.sin(Robot.limelight.getAngleX());
    Waypoint[] goal = new Waypoint[]{
      new Waypoint(waypointX, waypointY, Robot.limelight.getAngleOffset())
    };
    
    if(Robot.shiftSolenoid.isInSpeed()){
      maxSpeed = Robot.hardware.kMaxSpeedHigh;
      maxAccel = Robot.hardware.kMaxAccelHigh;
      maxJerk = Robot.hardware.kMaxJerkHigh;
    }
    else{
      maxSpeed = Robot.hardware.kMaxSpeedLow;
      maxAccel = Robot.hardware.kMaxAccelLow;
      maxJerk = Robot.hardware.kMaxJerkHigh;
    }
    config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, .05, maxSpeed, maxAccel, maxJerk);

    trajectory = Pathfinder.generate(goal, config);

    modifier = new TankModifier(trajectory);

    modifier.modify(Robot.hardware.kWheelBaseWidth);

    left = new EncoderFollower(modifier.getLeftTrajectory());
    right = new EncoderFollower(modifier.getRightTrajectory());

    left.configureEncoder(Robot.drive.getLeftEncoderPos(), Robot.hardware.kDriveEncoderResolution, Robot.hardware.kWheelDiameter);
    right.configureEncoder(Robot.drive.getRightEncoderPos(), Robot.hardware.kDriveEncoderResolution, Robot.hardware.kWheelDiameter);

    left.configurePIDVA(1, 0, 0, 1 / maxSpeed, 0);
    right.configurePIDVA(1, 0, 0, 1 / maxSpeed, 0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  
    


    l = left.calculate(Robot.drive.getLeftEncoderPos());
    r = right.calculate(Robot.drive.getRightEncoderPos());

    gyro_heading = Robot.gyro.getAngleZ();
    desired_heading = Pathfinder.r2d(left.getHeading());  

    angleDifference = Pathfinder.boundHalfDegrees(desired_heading - gyro_heading);
    turn = 0.8 * (-1.0/80.0) * angleDifference;

    Robot.drive.setLeftRight(l + turn, r - turn);
    
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
