/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.subsystems.Controllers;

/**
 * The command for the endgame elevator
 */
public class EndgameDriver extends Command {
  double motion;
  public EndgameDriver() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.controllers);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    double motion = Robot.controllers.rightDriverY;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    if (motion > 1.0){
      motion = 1.0;
    } else if (motion < -1.0){
      motion = -1.0;
    } else {
      motion = Robot.controllers.rightDriverY;
    }

    RobotMap.endgameDrive.set(motion);
  
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.endgameDrive.set(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

public void EndgameDriver() {
}
}
