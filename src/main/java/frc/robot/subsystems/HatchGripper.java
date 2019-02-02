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
import frc.robot.commands.Gripper;
import edu.wpi.first.wpilibj.Solenoid;
/**
 * Add your docs here.
 */
public class HatchGripper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static Solenoid _gripper1 = RobotMap._gripper1;
  public final static Solenoid _gripper2 = RobotMap._gripper2;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Gripper());
  }

  public void GripperSetUp() {
    _gripper1.set(false);
    _gripper2.set(false);
  }

  public void Gripper() {
    if(Robot.m_oi.m_Joystick2.getRawButton(2)) {
      _gripper1.set(true);
      _gripper2.set(true);
    } else {
      _gripper1.set(false);
      _gripper2.set(false);
    }
  }
}
