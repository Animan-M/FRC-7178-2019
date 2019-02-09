/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;;
/**
 * Add your docs here.
 */
public class Actuator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static WPI_TalonSRX _talon10 = RobotMap._talon10;
  public final static WPI_TalonSRX _talon11 = RobotMap._talon11;
  public final static WPI_TalonSRX _talon12 = RobotMap._talon12;
  public final static WPI_TalonSRX _talon13 = RobotMap._talon13;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void ActuatorSetUp() {
    _talon11.follow(_talon10);
    _talon12.follow(_talon10);
    _talon13.follow(_talon10);
  }

  public void Down() {
    if(Robot.m_oi.m_Controller1.getRawButton(6) && Robot.m_oi.m_Joystick2.getRawButton(7) == true) {
      _talon10.set(1);
    } else {
      _talon10.set(0);
    }
  }
}
