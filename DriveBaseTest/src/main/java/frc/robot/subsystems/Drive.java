/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveStandard;

/**
 * Drive Subsystem
 */
public class Drive extends Subsystem {
  Talon driveLeftFront;
  Talon driveLeftBack;
  Talon driveRightFront;
  Talon driveRightBack;

  RobotMap hardware;


  public static Drive instance;
  public static Drive getInstance() {

    if (instance == null) {
    instance = new Drive();
    }
   return instance;
   }
    
   public Drive()
   {
     hardware = new RobotMap();
   }
  public void set(double speed, double turn) {
    driveLeftFront.set(speed + turn);
    driveLeftBack.set(speed + turn);
    driveRightFront.set(speed - turn);
    driveRightBack.set(speed - turn);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveStandard());    
  }
}
