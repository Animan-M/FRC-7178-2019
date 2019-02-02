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
import frc.robot.commands.IntakeBack;

import com.ctre.phoenix.motorcontrol.can.*;
/**
 * Add your docs here.
 */
public class BackIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static WPI_TalonSRX _talon5 = RobotMap._talon5;
  public static WPI_TalonSRX _talon6 = RobotMap._talon6;
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new IntakeBack());
  }

  public void IntakeSetUp() {
    _talon5.follow(_talon6);
  }

  public void Intake() {
    if(Robot.m_oi.m_Controller1.getRawButton(1)) {
      _talon6.set(1);
    } else {
      _talon6.set(0);
    }
  }
}