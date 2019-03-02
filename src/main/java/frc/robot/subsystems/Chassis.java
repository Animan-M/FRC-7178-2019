
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
  public static DifferentialDrive m_driveType = new DifferentialDrive(RobotMap._motorFrontLeft, RobotMap._motorFrontRight);

  public static double forward;
  public static double backwards;
  public static double turn;
  public static double turnDif;
  public static double driveDif;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new teleopDrive());
  }

  public void driveSetUp() {
    _motorBackLeft.follow(_motorFrontLeft);
    _motorBackRight.follow(_motorFrontRight);
    turnDif = 0.75;
    driveDif = 0.85;
  }

  public void drive() {
    forward = driveDif*Robot.m_oi.m_Controller1.getRawAxis(3);
    backwards = -driveDif*Robot.m_oi.m_Controller1.getRawAxis(2);
    turn = turnDif*Robot.m_oi.m_Controller1.getRawAxis(0);

    double move = 0;

    if(forward > 0) {
      move = forward;
    } else if (backwards < 0) {
      move = backwards;
    } else {
      move = 0;
    }

    
    m_driveType.arcadeDrive(move, turn);
    
    // double leftMotor = Robot.m_oi.m_Controller1.getRawAxis(1);
    // double rightMotor = Robot.m_oi.m_Controller1.getRawAxis(5);
    // leftMotor = leftMotor * leftMotor*leftMotor;
    // rightMotor = rightMotor * rightMotor * rightMotor;
    // m_driveType.tankDrive(-leftMotor, -rightMotor);   
  }
}
