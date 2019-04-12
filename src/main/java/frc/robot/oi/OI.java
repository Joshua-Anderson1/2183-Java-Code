/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.oi;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.subsystems.Controllers;
import frc.robot.Robot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
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
  public static JoystickButton SpoolIn = new JoystickButton(Robot.controllers.coPilot, F310.BUTTON_B);
  public static JoystickButton SpoolOut = new JoystickButton(Robot.controllers.coPilot, F310.BUTTON_A);
  public static JoystickButton BallIn = new JoystickButton(Robot.controllers.coPilot, F310.BUTTON_TRIGGER_RIGHT);
  public static JoystickButton BallOut = new JoystickButton(Robot.controllers.coPilot, F310.BUTTON_SHOULDER_RIGHT);
  public static JoystickButton Level1 = new JoystickButton(Robot.controllers.coPilot, F310.BUTTON_SHOULDER_LEFT);
  public static JoystickButton Level2 = new JoystickButton(Robot.controllers.coPilot, F310.BUTTON_X);
  public static JoystickButton Level3 = new JoystickButton(Robot.controllers.coPilot, F310.BUTTON_Y);
  public static JoystickButton HatchGrabber = new JoystickButton(Robot.controllers.coPilot, F310.BUTTON_TRIGGER_LEFT);
  //public static JoystickButton EndgameElevator = new JoystickButton(Robot.controllers.driver, F310.BUTTON_SHOULDER_RIGHT);
  
  
}
