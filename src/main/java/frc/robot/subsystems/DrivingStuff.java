/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.commands.Drive;
import frc.robot.RobotMap;
import frc.robot.subsystems.Controllers;
import frc.robot.Robot;
import frc.robot.oi.F310;
/**
 * This is where the Drive motors get grouped
 * 
 */
public class DrivingStuff extends Subsystem {
  public static SpeedControllerGroup m_left = new SpeedControllerGroup(RobotMap.leftFrontMotor, RobotMap.leftRearMotor);
  public static SpeedControllerGroup m_right = new SpeedControllerGroup(RobotMap.rightFrontMotor, RobotMap.rightRearMotor);
  public static SpeedControllerGroup driveMotors = new SpeedControllerGroup(m_left, m_right);
  
  public void arcadeDrive(double xSpeed, double zRotation, boolean squareInputs) {

    // Square the inputs (while preserving the sign) to increase fine control
    // while permitting full power.
    if (squareInputs) {
      xSpeed = Math.copySign(xSpeed * xSpeed, xSpeed);
      zRotation = Math.copySign(zRotation * zRotation, zRotation);
    }

    double leftMotorOutput;
    double rightMotorOutput;

    double maxInput;

    /*if(xSpeed < 0.01 && xSpeed > -0.01){
      xSpeed = 0.0;
    } else {
      xSpeed = xSpeed;
    }*/
  
  if(xSpeed >= -1.0){
    if (xSpeed > 1.0) {
      xSpeed = 1.0;
    } else if (xSpeed < -1.0) {
      xSpeed = -1.0;
    } else {
      xSpeed = xSpeed;
    }
  }

  if(zRotation >= -1.0){
    if (zRotation > 1.0) {
      zRotation = 1.0;
    } else if (zRotation < -1.0) {
      zRotation = -1.0;
    } else {
      zRotation = zRotation;
    }
  }
      if(xSpeed > 0.0){
      leftMotorOutput = 1.0;
      rightMotorOutput = -1.0;
    } else if (xSpeed < 0.0){
      leftMotorOutput = -1.0;
      rightMotorOutput = 1.0;
    } else {
      leftMotorOutput = 0.0;
      rightMotorOutput = 0.0;
    }
    /*if (xSpeed >= 0.0) {
      // First quadrant, else second quadrant
      if (zRotation >= 0.0) {
        leftMotorOutput = maxInput;
        rightMotorOutput = xSpeed - zRotation;
      } else {
        leftMotorOutput = xSpeed + zRotation;
        rightMotorOutput = maxInput;
      }
    } else {
      // Third quadrant, else fourth quadrant
      if (zRotation >= 0.0) {
        leftMotorOutput = xSpeed + zRotation;
        rightMotorOutput = maxInput;
      } else {
        leftMotorOutput = maxInput;
        rightMotorOutput = xSpeed - zRotation;
      }
    }
*/
    m_left.set(leftMotorOutput);
    m_right.set(rightMotorOutput);
    RobotMap.endgameElevator.set(1.0);

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
}