joypackage frc.robot;

import java.io.IOException;
//import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.buttons.Button;
//import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.buttons.JoystickButton;

class Driver extends Buttons {
    //Things we want to do: get robot to move with controller, get drive base to work with code
    //This should make the robot go forward when joystick goes forward and backwards
    public Double Move(Double i){ 
            Double Speed = i;
            return Speed;
        }
    // When Both Triggers are pressed, speed is only half
    public void main (Double[] args, SpeedController rightMotor, SpeedController leftMotor) throws IOException {
        Joystick Joystick = new Joystick(0);
        DifferentialDrive differentialDrive = new DifferentialDrive(leftMotor, rightMotor);
        try {
        Double Speed = Joystick.getY();
        Double Rotate = Joystick.getX();
        Move(Speed);
        differentialDrive.arcadeDrive(Speed, Rotate, true);
        } finally {
            differentialDrive.close();
        }
    }
}