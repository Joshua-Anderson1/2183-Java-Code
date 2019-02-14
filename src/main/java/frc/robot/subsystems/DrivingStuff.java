/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.commands.Drive;

/**
 * This is where the Drive motors get grouped
 */
public class DrivingStuff extends Subsystem {
  public static final Spark leftFrontMotor = new Spark(2);
  public static final Spark rightFrontMotor = new Spark(3);
  public static final Spark leftRearMotor = new Spark(0);
  public static final Spark rightRearMotor = new Spark(1);
 SpeedControllerGroup m_left = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
 SpeedControllerGroup m_right = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
 DifferentialDrive driveMotors = new DifferentialDrive(m_left, m_right);
 
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new Drive());
  }
}