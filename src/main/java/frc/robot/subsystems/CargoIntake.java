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
  public static Solenoid _cargo1 = RobotMap._cargo1;
  public static Solenoid _cargo2 = RobotMap._cargo2;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new CargoIntakeUp());
  }

  public void CargoIntakeSetUp() {
    _cargo1.set(false);
    _cargo2.set(false);
  }

  public void Intake() {
    if(Robot.m_oi.m_Controller1.getRawButton(5) == true) {
      _cargo1.set(true);
      _cargo2.set(true);
    } else {
      _cargo1.set(false);
      _cargo2.set(false);
    }
  }
}
