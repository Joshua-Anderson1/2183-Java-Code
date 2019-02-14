/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Drive;
/**
 * The Controller ports are intialized and the X and Y for the Driver and Copilot are made
 */
public class Controllers extends Subsystem {
  protected Joystick driver = new Joystick(0);
  protected Joystick coPilot = new Joystick(1);
  protected double leftdriverX = driver.getRawAxis(0);
  protected double leftdriverY = driver.getRawAxis(1);
  protected double rightDriverX = driver.getRawAxis(4);
  protected double rightDriverY = driver.getRawAxis(5);
  protected double coPilotX = coPilot.getX();
  protected double coPilotY = coPilot.getY();

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
}
