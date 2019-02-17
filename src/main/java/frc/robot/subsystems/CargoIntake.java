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
import frc.robot.commands.CargoIntakeUp;
import edu.wpi.first.wpilibj.Solenoid;
/**
 * Add your docs here.
*/
public class CargoIntake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Solenoid _lowerIntakeLeft = RobotMap._lowerIntakeLeft;
  public static Solenoid _lowerIntakeRight = RobotMap._lowerIntakeRight;
  public static Solenoid _upperIntake = RobotMap._upperIntake;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new CargoIntakeUp());
  }

  public void CargoIntakeSetUp() {
    _lowerIntakeLeft.set(false);
    _lowerIntakeRight.set(false);
    _upperIntake.set(false);
  }

  public void Intake() {
    if(Robot.m_oi.m_Joystick2.getRawButton(3) == true) {
      _lowerIntakeLeft.set(true);
     // _lowerIntakeRight.set(true);
    } else if (Robot.m_oi.m_Joystick2.getRawButton(4) == true) {
     _lowerIntakeRight.set(true);
    } else if (Robot.m_oi.m_Joystick2.getRawButton(5) == true) {
    _upperIntake.set(true);
    _lowerIntakeRight.set(true);
    } else if (Robot.m_oi.m_Joystick2.getRawButton(5) == false) {
    _upperIntake.set(false);
    _lowerIntakeRight.set(false);
    } else { 
      _lowerIntakeLeft.set(false);
      _lowerIntakeRight.set(false);
    } 
  }
}
