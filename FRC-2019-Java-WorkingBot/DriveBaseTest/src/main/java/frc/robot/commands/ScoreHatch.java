/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

  EncoderFollower left;
  EncoderFollower right;
  double l;
  double r;
  double gyro_heading;
  double desired_heading;
  double angleDifference;
  double turn;
  double waypointY;
  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    SmartDashboard.putString("Pathfinding InitStart", "Working");
    //waypoint values in meters
    double waypointX = (Robot.hardware.kTargetHeight - Robot.hardware.kLimelightHeight) / Math.tan(Robot.limelight.getAngleY());
    double waypointY;

    SmartDashboard.putNumber("waypointX", waypointX);    
    if(Robot.limelight.getAngleX() > 0){
      waypointY = waypointX * Math.sin(Robot.limelight.getAngleX());
    }
    else{
      waypointY = -(waypointX * Math.sin(Robot.limelight.getAngleX()));
    }

    SmartDashboard.putNumber("waypointY", waypointY);
    SmartDashboard.putNumber("angle offset", Robot.limelight.getAngleOffset());

    Waypoint[] goal = new Waypoint[]{
      new Waypoint(waypointX, waypointY, Robot.limelight.getAngleOffset())
    };
    double maxSpeed;
    double maxAccel;
    double maxJerk;
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
    Trajectory.Config config = new Trajectory.Config(Trajectory.FitMethod.HERMITE_CUBIC, Trajectory.Config.SAMPLES_HIGH, .05, maxSpeed, maxAccel, maxJerk);

    Trajectory trajectory = Pathfinder.generate(goal, config);
    

    TankModifier modifier = new TankModifier(trajectory);

    modifier.modify(Robot.hardware.kWheelBaseWidth);

    left = new EncoderFollower(modifier.getLeftTrajectory());
    right = new EncoderFollower(modifier.getRightTrajectory());

    left.configureEncoder(Robot.drive.getLeftEncoderPos(), Robot.hardware.kDriveEncoderResolution, Robot.hardware.kWheelDiameter);
    right.configureEncoder(Robot.drive.getRightEncoderPos(), Robot.hardware.kDriveEncoderResolution, Robot.hardware.kWheelDiameter);

    left.configurePIDVA(1, 0, 0, 1 / maxSpeed, 0);
    right.configurePIDVA(1, 0, 0, 1 / maxSpeed, 0);

    SmartDashboard.putString("Pathfinding initEnd", "Working Now");

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
