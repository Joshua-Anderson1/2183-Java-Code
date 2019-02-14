/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.MotorSafety;

/**
 * This command lets the Robot drive whenever the F310 gamepad is being used
 */
public class Drive extends Command {
  public static final Spark leftFrontMotor = new Spark(2);
  public static final Spark rightFrontMotor = new Spark(3);
  public static final Spark leftRearMotor = new Spark(0);
  public static final Spark rightRearMotor = new Spark(1);
  SpeedControllerGroup m_left = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
  SpeedControllerGroup m_right = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
  DifferentialDrive driveMotors = new DifferentialDrive(m_left, m_right);
  protected Joystick driver = new Joystick(0);
  protected double leftdriverX = driver.getRawAxis(0);
  protected double leftdriverY = driver.getRawAxis(1);
  double Speed = leftdriverY;
  double Rotate = leftdriverX;
  
  public Drive() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.drivingStuff);
    requires(Robot.controllers);
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    double Speed = leftdriverY;
    double Rotate = leftdriverX;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
public void execute() {

    driveMotors.arcadeDrive(Speed, Rotate, true);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    driveMotors.arcadeDrive(0.0, 0.0, false);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
