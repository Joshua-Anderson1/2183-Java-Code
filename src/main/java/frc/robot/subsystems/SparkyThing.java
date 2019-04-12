package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.NewThing;
import com.revrobotics.CANSparkMax;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class SparkyThing extends Subsystem {
  public void MotorPrint(Object x){
      System.out.println(x);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new NewThing());
  }
}
