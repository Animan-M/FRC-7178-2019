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
import frc.robot.commands.ElevatorMove;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
/**
 * Add your docs here.
*/
public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static WPI_VictorSPX _elevatorLeft = RobotMap._elevatorLeft;
  public static final WPI_VictorSPX _elevatorRight = RobotMap._elevatorRight;
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ElevatorMove());
  }

  public void ElevatorSetUp() {
    _elevatorRight.follow(_elevatorLeft);
  }
  
  public void ElevatorShift() {
    if(Robot.m_oi.m_Joystick2.getRawButton(11)) {
      _elevatorLeft.set(0.2);
    } else if (Robot.m_oi.m_Joystick2.getRawButton(12)) {
      _elevatorLeft.set(-0.2);
    } else {
      _elevatorLeft.set(0);
    }
  }

}
