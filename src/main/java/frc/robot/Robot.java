/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Drive;
import frc.robot.commands.BallIntake;
import frc.robot.commands.BallOuttake;
import frc.robot.commands.Elevator;
import frc.robot.commands.EndgameDriver;
import frc.robot.commands.EndgameElevation;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Hatch;
import frc.robot.commands.HatchIn;
import frc.robot.commands.HatchOut;
import frc.robot.subsystems.Controllers;
import frc.robot.subsystems.DrivingStuff;
import frc.robot.subsystems.Buttons;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.oi.F310;
import frc.robot.oi.OI;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;
  public static Subsystem buttons = new Buttons();
  public static Subsystem controllers = new Controllers();
  public static Subsystem drivingStuff = new DrivingStuff();
  protected Joystick driver = new Joystick(0);
  protected Joystick coPilot = new Joystick(1);
  protected JoystickButton Endgame = new JoystickButton(driver, F310.BUTTON_SHOULDER_RIGHT);
  protected JoystickButton SpoolIn = new JoystickButton(coPilot, F310.BUTTON_B);
  protected JoystickButton SpoolOut = new JoystickButton(coPilot, F310.BUTTON_A);
  protected JoystickButton BallIn = new JoystickButton(coPilot, F310.BUTTON_TRIGGER_RIGHT);
  protected JoystickButton BallOut = new JoystickButton(coPilot, F310.BUTTON_SHOULDER_RIGHT);
  protected JoystickButton HatchGrabber = new JoystickButton(coPilot, F310.BUTTON_TRIGGER_LEFT);
  
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    /* Error at frc.robot.commands.Drive.<clinit>(Drive.java:22): Unhandled exception: edu.wpi.first.hal.util.UncleanStatusException:  Code: -1029. HAL: Resource already allocated 
 	at edu.wpi.first.hal.PWMJNI.initializePWMPort(Native Method) 
 	at edu.wpi.first.wpilibj.PWM.<init>(PWM.java:63) 
 	at edu.wpi.first.wpilibj.PWMSpeedController.<init>(PWMSpeedController.java:25) 
 	at edu.wpi.first.wpilibj.Spark.<init>(Spark.java:47) 
 	at frc.robot.commands.Drive.<clinit>(Drive.java:22) 
 	at frc.robot.subsystems.Controllers.initDefaultCommand(Controllers.java:29) 
 	at edu.wpi.first.wpilibj.command.Subsystem.getDefaultCommand(Subsystem.java:111) 
 	at edu.wpi.first.wpilibj.command.Scheduler.run(Scheduler.java:241) 
 	at frc.robot.Robot.disabledPeriodic(Robot.java:100) 
 	at edu.wpi.first.wpilibj.IterativeRobotBase.loopFunc(IterativeRobotBase.java:212) 
 	at edu.wpi.first.wpilibj.TimedRobot.startCompetition(TimedRobot.java:81) 
 	at edu.wpi.first.wpilibj.RobotBase.startRobot(RobotBase.java:263) 
 	at frc.robot.Main.main(Main.java:28) 

    */
    controllers = new Controllers();
    buttons = new Buttons();
    drivingStuff = new DrivingStuff();
    m_oi = new OI();
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode. You
   * can use it to reset any subsystem information you want to clear when the
   * robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable chooser
   * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
   * remove all of the chooser code and uncomment the getString code to get the
   * auto name from the text box below the Gyro
   *
   * <p>
   * You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons to
   * the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
     * switch(autoSelected) { case "My Auto": autonomousCommand = new
     * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
     * ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  // This function is called periodically during autonomous.

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }
//Yeet 
  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic(){
    startCompetition();
    Scheduler.getInstance().run();
    new Drive();
    new Elevator();
    new EndgameDriver();
    Endgame.whileHeld(new EndgameElevation());
    HatchGrabber.whileHeld(new Hatch());
    BallIn.whileHeld(new BallIntake());
    BallOut.whileHeld(new BallOuttake());
    SpoolIn.whileHeld(new HatchIn());
    SpoolOut.whileHeld(new HatchOut());
  
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
