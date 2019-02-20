/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Gripper;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
/**
 * Add your docs here.
 */
public class HatchGripper extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static Solenoid _gripper = RobotMap._gripper;

  public static DigitalInput _bottomHatch = new DigitalInput(8);
  public static DigitalInput _topHatch = new DigitalInput(9);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new Gripper());
  }

  public void GripperSetUp() {
    _gripper.set(true);
  }

  public void GripperThing() {
    // if(Robot.m_oi.m_Controller2.getRawButton(6) == true) {
    //   _gripper.set(true);
    // } else {
    //   _gripper.set(false);
    // }

    if ((_topHatch.get() == false && _bottomHatch.get() == false && Robot.m_oi.m_Controller2.getRawButton(6) == false) || Robot.m_oi.m_Controller2.getRawButton(7) == true) {
      _gripper.set(false);
    } else if (Robot.m_oi.m_Controller2.getRawButton(6) == true) {
      _gripper.set(true);
    }

    SmartDashboard.putBoolean("Bottom Hatch Grabber", _bottomHatch.get());
    SmartDashboard.putBoolean("Top Hatch Grabber", _topHatch.get());
  }
}
