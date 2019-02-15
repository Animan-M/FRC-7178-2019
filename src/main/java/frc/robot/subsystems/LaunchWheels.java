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
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new LaunchBall());
  }

  public void LaunchSetUp() {
    _shootBack.follow(_shootFront);
  }

  public void Launch() {
    if(Robot.m_oi.m_Controller1.getRawAxis(3) < 0) {
      _shootFront.set(0.5);
    } if (Robot.m_oi.m_Controller1.getRawAxis(3) > 0) {
      _shootBack.set(-0.5);
    } else {
      _shootBack.set(0);
    }
  }
}
