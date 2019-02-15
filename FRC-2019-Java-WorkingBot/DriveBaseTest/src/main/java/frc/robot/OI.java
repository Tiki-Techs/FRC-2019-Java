/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.*;
import frc.robot.commands.Follow;
import frc.robot.commands.IntakeClose;
import frc.robot.commands.IntakeIn;
import frc.robot.commands.IntakeOpen;
import frc.robot.commands.IntakeOut;
import frc.robot.commands.IntakeToggleInOut;
import frc.robot.commands.IntakeToggleOpen;
import frc.robot.commands.ScoreHatch;
import frc.robot.commands.ShiftSpeed;
import frc.robot.commands.ShiftTorque;
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

  public OI(){
    
    button1.whileHeld(new Follow());

    button2.whenPressed(new ShiftTorque());
    button3.whenPressed(new ShiftSpeed());

    button4.whenPressed(new ScoreHatch());
    
    button5.whenPressed(new IntakeToggleInOut());
    button6.whenPressed(new IntakeToggleOpen());

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
