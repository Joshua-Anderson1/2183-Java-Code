/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.GenericHID;

/**
 * The command for the endgame elevator
 */
public class EndgameDriver extends Command {
  public final Spark endgameDrive = new Spark(4);
  protected Joystick driver = new Joystick(0);
  protected double leftdriverX = driver.getRawAxis(0);
  protected double rightDriverY = driver.getRawAxis(4);
  double motion = rightDriverY;
  public EndgameDriver() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.controllers);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    double motion = rightDriverY;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (motion > 1.0){
      motion = 1.0;
    } else if (motion < -1.0){
      motion = -1.0;
    } else {
      motion = rightDriverY;
    }

    endgameDrive.set(motion);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    endgameDrive.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
