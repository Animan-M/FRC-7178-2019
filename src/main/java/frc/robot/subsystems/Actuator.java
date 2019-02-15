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
  public final static WPI_TalonSRX _liftFrontLeft = RobotMap._liftFrontLeft;
  public final static WPI_TalonSRX _liftBackLeft = RobotMap._liftBackLeft;
  public final static WPI_TalonSRX _liftFrontRight = RobotMap._liftFrontRight;
  public final static WPI_TalonSRX _liftBackRight = RobotMap._liftBackRight;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void ActuatorSetUp() {
    _liftBackLeft.follow(_liftFrontLeft);
    _liftFrontRight.follow(_liftFrontLeft);
    _liftBackRight.follow(_liftFrontLeft);
  }

  public void Down() {
    if(Robot.m_oi.m_Controller1.getRawButton(6) && Robot.m_oi.m_Joystick2.getRawButton(7) == true) {
      _liftFrontLeft.set(1);
    } else {
      _liftFrontLeft.set(0);
    }
  }
}
