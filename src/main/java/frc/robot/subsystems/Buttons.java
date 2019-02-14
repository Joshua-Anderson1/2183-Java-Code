package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.oi.F310;

/**
 * This is where all of the FightStick Buttons are made.
 */
public class Buttons extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  protected Joystick driver = new Joystick(0);
  protected Joystick coPilot = new Joystick(1);
  protected JoystickButton SpoolIn = new JoystickButton(coPilot, F310.BUTTON_B);
  protected JoystickButton SpoolOut = new JoystickButton(coPilot, F310.BUTTON_A);
  protected JoystickButton BallIn = new JoystickButton(coPilot, F310.BUTTON_TRIGGER_RIGHT);
  protected JoystickButton BallOut = new JoystickButton(coPilot, F310.BUTTON_SHOULDER_RIGHT);
  protected JoystickButton Level1 = new JoystickButton(coPilot, F310.BUTTON_SHOULDER_LEFT);
  protected JoystickButton Level2 = new JoystickButton(coPilot, F310.BUTTON_X);
  protected JoystickButton Level3 = new JoystickButton(coPilot, F310.BUTTON_Y);
  protected JoystickButton HatchGrabber = new JoystickButton(coPilot, F310.BUTTON_TRIGGER_LEFT);
  protected JoystickButton EndgameElevator = new JoystickButton(driver, F310.BUTTON_SHOULDER_RIGHT);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
