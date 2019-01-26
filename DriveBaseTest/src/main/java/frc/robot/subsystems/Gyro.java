/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * Drive Subsystem
 */
public class Gyro extends Subsystem {
  public ADIS16448_IMU gyro;





  public static Gyro instance;
  public static Gyro getInstance() {

    if (instance == null) {
    instance = new Gyro();
    }
   return instance;
   }
    
    private Gyro(){
      gyro = new ADIS16448_IMU();
      gyro.reset();
    }
   
// Accessors for Angles
   public double getAngleX(){
     return gyro.getAngleX();
   }
   public double getAngleY(){
     return gyro.getAngleY();
   }
   public double getAngleZ(){
     return gyro.getAngleZ();
   }

// Accessors for accelerations
   public double getAccelX(){
     return gyro.getAccelX();
   }
   public double getAccelY(){
     return gyro.getAccelY();
   }
   public double getAccelZ(){
     return gyro.getAccelZ();
   }

// accessors for pitch, yaw, and roll
   public double getPitch(){
     return gyro.getPitch();
   }
   public double getRoll(){
     return gyro.getRoll();
   }
   public double getYaw(){
     return gyro.getYaw();
   }

  @Override
  public void initDefaultCommand() {
  }
}
