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
import frc.robot.commands.StorageIn;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;;
/**
 * Add your docs here.
 */
public class Storage extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //public final static WPI_TalonSRX _talon7 = RobotMap._talon7;
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new StorageIn());
  }

  public void Holder() {
    // if(Robot.m_oi.m_Joystick2.getRawButton(3) == true) {
    //   _talon7.set(0.5);
    // } else {
    // s  _talon7.set(0);
    // }
  }
}
