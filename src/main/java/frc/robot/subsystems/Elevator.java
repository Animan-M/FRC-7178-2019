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
import frc.robot.commands.ElevatorMove;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


import com.ctre.phoenix.motorcontrol.NeutralMode;
import edu.wpi.first.wpilibj.AnalogInput;
/**
 * Add your docs here.
 */

 public class Elevator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static WPI_VictorSPX _elevatorLeft = RobotMap._elevatorLeft;
  public final static WPI_VictorSPX _elevatorRight = RobotMap._elevatorRight;

  public static AnalogInput _ai = new AnalogInput(0);

  public static final double _lowHatch = 1;
  public static final double _midHatch = 2;
  public static final double _highHatch = 3;
  
  public static final double _lowShoot = 1.0 ;
  public static final double _midShoot = 1.5;
  public static final double _highShoot = 3.5;

  public static final double _base = 0.5;

  public static final double _threshold = 0.05;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new ElevatorMove());
  }

    public void ElevatorSetUp() {
    _elevatorRight.follow(_elevatorLeft);
    _elevatorLeft.setNeutralMode(NeutralMode.Brake);
    _elevatorRight.setNeutralMode(NeutralMode.Brake);
    
  }
  
  public void ElevatorShift() {
    if(Robot.m_oi.m_Controller2.getRawAxis(2) > 0.1) {
      _elevatorLeft.set(0.2);
      _elevatorRight.set(0.2);
    } else if (Robot.m_oi.m_Controller2.getRawButton(5) == true) {
      _elevatorLeft.set(-0.2);
      _elevatorRight.set(-0.2);
    } else {
      _elevatorLeft.set(0);
      _elevatorRight.set(0);
    }

    if(Robot.m_oi.m_Controller2.getRawButton(2) == true) {
      if(_ai.getAverageVoltage() > _lowHatch + _threshold) {
        _elevatorLeft.set(-0.2);
        _elevatorRight.set(-0.2);
      } else if (_ai.getAverageVoltage() < _lowHatch - _threshold) {
        _elevatorLeft.set(0.2);
        _elevatorRight.set(0.2);
      } else {
        _elevatorLeft.set(0);
        _elevatorRight.set(0);
      }
    }

    if(Robot.m_oi.m_Controller2.getRawButton(4) == true) {
      if(_ai.getAverageVoltage() > _midHatch + _threshold) {
        _elevatorLeft.set(-0.2);
        _elevatorRight.set(-0.2);
      } else if (_ai.getAverageVoltage() < _midHatch - _threshold) {
        _elevatorLeft.set(0.2);
        _elevatorRight.set(0.2);
      } else {
        _elevatorLeft.set(0);
        _elevatorRight.set(0);
      }
    }

    if(Robot.m_oi.m_Controller2.getRawButton(2) == true) {
      if(_ai.getAverageVoltage() > _highHatch + _threshold) {
        _elevatorLeft.set(-0.2);
        _elevatorRight.set(-0.2);
      } else if (_ai.getAverageVoltage() < _highHatch - _threshold) {
        _elevatorLeft.set(0.2);
        _elevatorRight.set(0.2);
      } else {
        _elevatorLeft.set(0);
        _elevatorRight.set(0);
      }
    }

    if(Robot.m_oi.m_Controller2.getRawButton(7) == true) {
        if(_ai.getAverageVoltage() > _midShoot + _threshold) {
          _elevatorLeft.set(-0.2);
          _elevatorRight.set(-0.2);
        } else if (_ai.getAverageVoltage() < _midShoot - _threshold) {
          _elevatorLeft.set(0.2);
          _elevatorRight.set(0.2);
        } else {
          _elevatorLeft.set(0);
          _elevatorRight.set(0);
        }
    }

      





    SmartDashboard.putNumber("Accumulator Value", _ai.getAverageVoltage());
  
  }
}
