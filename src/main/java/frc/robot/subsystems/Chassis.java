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
  public final static WPI_TalonSRX _talon0 = RobotMap._talon0;
  public final static WPI_TalonSRX _talon1 = RobotMap._talon1;
  public final static WPI_TalonSRX _talon2 = RobotMap._talon2;
  public final static WPI_TalonSRX _talon3 = RobotMap._talon3;

  public DifferentialDrive m_DifferentialDrive = new DifferentialDrive(RobotMap._talon0, RobotMap._talon2);

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
     setDefaultCommand(new teleopDrive());
  }

   public void drive() {
    m_DifferentialDrive.tankDrive(Robot.m_oi.m_Controller1.getRawAxis(1), Robot.m_oi.m_Controller1.getY()); 
    _talon1.follow(_talon0);
    _talon3.follow(_talon2);
   }
}
