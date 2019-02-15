
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import frc.robot.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.teleopDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
 * Add your docs here.
 */
public class Chassis extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static WPI_TalonSRX _motorFrontLeft = RobotMap._motorFrontLeft;
  public final static WPI_TalonSRX _motorBackLeft = RobotMap._motorBackLeft;
  public final static WPI_TalonSRX _motorFrontRight = RobotMap._motorFrontRight;
  public final static WPI_TalonSRX _motorBackRight = RobotMap._motorBackRight;

  public DifferentialDrive m_DifferentialDrive = new DifferentialDrive(RobotMap._motorFrontLeft, RobotMap._motorFrontRight);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new teleopDrive());
  }

   public void driveSetUp() {
    _motorBackLeft.follow(_motorFrontLeft);
    _motorBackRight.follow(_motorFrontRight);
   }

   public void drive() {
    m_DifferentialDrive.tankDrive(Robot.m_oi.m_Controller1.getRawAxis(5), Robot.m_oi.m_Controller1.getRawAxis(1)); 
    
   }
}
