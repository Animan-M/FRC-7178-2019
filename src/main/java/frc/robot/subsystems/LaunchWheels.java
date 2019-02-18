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
import frc.robot.commands.LaunchBall;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * Add your docs here.
 */
public class LaunchWheels extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static WPI_TalonSRX _shootFront = RobotMap._shootFront;
  public final static WPI_TalonSRX _shootBack = RobotMap._shootBack;
  public static WPI_TalonSRX _intakeFront = RobotMap._intakeFront; //Storage
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new LaunchBall());
  }

  public void LaunchSetUp() {
    _shootBack.follow(_shootFront);
  }

  public void Launch() {
    if(Robot.m_oi.m_Controller1.getRawAxis(2) > 0.1) {
      _shootBack.set(1);
      _intakeFront.set(-0.75);
    // } if (Robot.m_oi.m_Controller1.getRawButton(2) == true) {
    //   _shootBack.set(-1);
    //   _shootFront.set(-1);
    } else {
      _shootBack.set(0);
      _intakeFront.set(0);
    }
  }
}
