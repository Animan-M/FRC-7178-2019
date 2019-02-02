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

import com.ctre.phoenix.motorcontrol.can.*;
/**
 * Add your docs here.
 */
public class LaunchWheels extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static WPI_TalonSRX _talon8 = RobotMap._talon8;
  public final static WPI_TalonSRX _talon9 = RobotMap._talon9;
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new LaunchBall());
  }

  public void LaunchSetUp() {
    _talon9.follow(_talon8);
  }

  public void Launch() {
    if(Robot.m_oi.m_Joystick2.getRawButton(4)) {
      _talon8.set(1);
    } else {
      _talon8.set(0);
    }
  }
}
