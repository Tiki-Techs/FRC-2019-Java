/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Drive Subsystem
 */
public class Limelight extends Subsystem {
  private NetworkTable limelightTable;





  public static Limelight instance;
  public static Limelight getInstance() {

    if (instance == null) {
    instance = new Limelight();
    }
   return instance;
   }
    
    private Limelight(){
      limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
    }
 

  public double getAngleX(){
    return limelightTable.getEntry("tx").getDouble(0);
  }
  public double getAngleY(){
    return limelightTable.getEntry("ty").getDouble(0);
  }

  public double getAngleOffset(){
    // angle offset to goal is equal to inverse sine of length of ratio of short side to long side returned by limelight
    // This has been both calculated and tested
    return Math.asin(limelightTable.getEntry("tshort").getDouble(0) / limelightTable.getEntry("tlong").getDouble(0));
  }

  
  @Override
  public void initDefaultCommand() {
  }
}
