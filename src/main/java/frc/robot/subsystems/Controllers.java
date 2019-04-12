/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;
import frc.robot.oi.F310;
import frc.robot.oi.F3101;
/**
 * The Controller ports are intialized and the X and Y for the Driver and Copilot are made
 */
public class Controllers extends Subsystem {
  //public static F310 driver = new F310(0);
  public static Joystick driver = new Joystick(0);
  public static Joystick coPilot = new Joystick(1);
  public double leftdriverX = driver.getRawAxis(1);
  public double leftdriverY = driver.getRawAxis(0);
  public double rightDriverX = driver.getRawAxis(2);
  public double rightDriverY = driver.getRawAxis(3);
  public double coPilotX = coPilot.getX();
  public double coPilotY = coPilot.getY();

  /*public static GenericHID driver1 = new GenericHID(0);
  public static GenericHID coPilot1 = new GenericHID(1);
  public double leftdriverX1 = driver1.F3101.getAxis(F3101.LX);
  public double leftdriverY1 = driver1.F3101.getAxis(F3101.LY);
  public double rightdriverX1 = driver1.F3101.getAxis(F3101.RX);
  public double rightdriverY1 = driver1.F3101.getAxis(F3101.RY);
  public double coPilotX1 = coPilot1.getX();
  public double coPilotY1 = coPilot1.getY();
  */

  public void test(){
    System.out.println(leftdriverY);
  }
  public double limit(double Speed) {
    if (Speed > 1.0) {
      Speed = 1.0;
    } else if (Speed < -1.0) {
      Speed = -1.0;
    } else {
      Speed = Speed;
    }
    return Speed;
  }
  @Override
  public void initDefaultCommand() {
    
  }
}
