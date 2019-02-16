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
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * Add your docs here.
 */
public class BackIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static WPI_TalonSRX _intakeBack = RobotMap._intakeBack;
  public static WPI_TalonSRX _intakeFront = RobotMap._intakeFront;
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new IntakeBack());
    }

  public void IntakeSetUp() {
    _intakeFront.follow(_intakeBack);
  }

  public void Intake() {
    if(Robot.m_oi.m_Controller1.getRawButton(5)) {
      _intakeBack.set(-0.5);
    } else {
      _intakeBack.set(0);
    }
  }
}