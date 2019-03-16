/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.commands.ClimbGrab;
import frc.robot.commands.ClimbRampSolenoidToggle;
// import frc.robot.commands.ClimbNeosDown;
// import frc.robot.commands.ClimbNeosUp;
// import frc.robot.commands.ClimbRampDown;
import frc.robot.commands.ClimbRelease;
import frc.robot.commands.Follow;
import frc.robot.commands.IntakePanCenter;
import frc.robot.commands.IntakeToggleInOut;
import frc.robot.commands.IntakeToggleOpen;
import frc.robot.commands.ScoreHatch;
import frc.robot.commands.ShiftSpeed;
import frc.robot.commands.ShiftTorque;
import frc.robot.commands.TurnTo;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public Joystick joy1 = new Joystick(0);
  public Button button1 = new JoystickButton(joy1,1),
                button2 = new JoystickButton(joy1,2),
                button3 = new JoystickButton(joy1,3),
                button4 = new JoystickButton(joy1,4),
                button5 = new JoystickButton(joy1,5),
                button6 = new JoystickButton(joy1,6),
                button7 = new JoystickButton(joy1,7),
                button8 = new JoystickButton(joy1,8);

  public Joystick joy2 = new Joystick(1);
  public Button joy2button1 = new JoystickButton(joy2,1),
                joy2button2 = new JoystickButton(joy2,2),
                joy2button3 = new JoystickButton(joy2,3),
                joy2button4 = new JoystickButton(joy2,4),
                joy2button5 = new JoystickButton(joy2,5),
                joy2button6 = new JoystickButton(joy2,6),
                joy2button7 = new JoystickButton(joy2,7),
                joy2button8 = new JoystickButton(joy2,8);

  public OI(){
    
    //controller 1
    button1.whileHeld(new Follow());


    button2.whenPressed(new ShiftTorque());
    button3.whenPressed(new ShiftSpeed());

    // button4.whileHeld(new ScoreHatch());
    // button4.whenPressed(new TurnTo(90));

    button5.whenPressed(new IntakeToggleInOut());
    button6.whenPressed(new IntakeToggleOpen());

    // button7.whenPressed(new IntakePanCenter());


    //controller 2

    joy2button1.whenPressed(new ClimbGrab());
    joy2button2.whenPressed(new IntakeToggleInOut());
    joy2button3.whenPressed(new IntakeToggleOpen());
    joy2button4.whenPressed(new ClimbRelease());
    // joy2button5.whileHeld(new ClimbNeosUp());
    // joy2button6.whileHeld(new ClimbNeosDown());

    joy2button7.whenPressed(new ClimbRampSolenoidToggle());
    


  }




  public double getY(){
    if(Math.abs(joy1.getRawAxis(1)) < .05){
      return 0;
    }
    else{
      return joy1.getRawAxis(1);
    }
  }

  public double getX(){
    if(Math.abs(joy1.getRawAxis(4)) < .05){
      return 0;
    }
    else{
      return joy1.getRawAxis(4);
    }
  }

  public double getTriggerRight(){
    if(joy1.getRawAxis(3) < .05){
      return 0;
    }
    else{
      return joy1.getRawAxis(3);
    }
  }
  public double getTriggerLeft(){
    if(joy1.getRawAxis(2) < .05){
      return 0;
    }
    else{
      return joy1.getRawAxis(2);
    }
  }


    public double getJoy2TriggerRight(){
      if(joy2.getRawAxis(3) < .05){
        return 0;
      }
      else{
        return joy2.getRawAxis(3);
      }
    }
    public double getJoy2TriggerLeft(){
      if(joy2.getRawAxis(2) < .05){
        return 0;
      }
      else{
        return joy2.getRawAxis(2);
      }
  }
  public double getJoy2Y(){
    if(Math.abs(joy2.getRawAxis(1)) > 0.05){
      return joy2.getRawAxis(1);
    }
    else{
      return 0;
    }
  }


  
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
