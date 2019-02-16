/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
// import edu.wpi.first.wpilibj.ADXL345_SPI;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.ActuatorDown;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;;
/**
 * Add your docs here.
 */
public class Actuator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public final static WPI_TalonSRX _liftFrontLeft = RobotMap._liftFrontLeft;
  public final static WPI_TalonSRX _liftBackLeft = RobotMap._liftBackLeft;
  public final static WPI_TalonSRX _liftFrontRight = RobotMap._liftFrontRight;
  public final static WPI_TalonSRX _liftBackRight = RobotMap._liftBackRight;

  // public final static ADXL345_SPI _gyro = RobotMap._gyro;

  public static double _lastCurrentFL;
  public static double _lastCurrentBL;
  public static double _lastCurrentFR;
  public static double _lastCurrentBR;
  public static double _thisCurrent;

  public static DigitalInput _fr_ul = new DigitalInput(0);
  public static DigitalInput _fr_ll = new DigitalInput(1);
  public static DigitalInput _br_ul = new DigitalInput(2);
  public static DigitalInput _br_ll = new DigitalInput(3);
  public static DigitalInput _bl_ul = new DigitalInput(4);
  public static DigitalInput _bl_ll = new DigitalInput(5);
  public static DigitalInput _fl_ul = new DigitalInput(6);
  public static DigitalInput _fl_ll = new DigitalInput(7);

  //upperlimits 0,2,4,6
  //lowerlimits 1,3,5,7
  //FR, BR, BL, FL

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
   setDefaultCommand(new ActuatorDown());
  }

  public void ActuatorSetUp() {
    // _gyro.reset();
    _lastCurrentFL = 0.0;
    _lastCurrentBL = 0.0;
    _lastCurrentFR = 0.0;
    _lastCurrentBR = 0.0;
    _liftBackLeft.setInverted(true);
    _liftFrontLeft.setNeutralMode(NeutralMode.Brake);
    _liftBackLeft.setNeutralMode(NeutralMode.Brake);
    _liftFrontRight.setNeutralMode(NeutralMode.Brake);
    _liftBackRight.setNeutralMode(NeutralMode.Brake);
  }

  public void Down() {

    //check the buttons measure the current.
    if((Robot.m_oi.m_Controller1.getRawButton(8) == true)) {
      if(_fr_ll.get() == false){
        _liftFrontRight.set(0.51);
        _lastCurrentFR = _liftFrontRight.getOutputCurrent();
      }else{
        _liftFrontRight.set(0);
      }
      if(_br_ll.get() == false){
        _liftBackRight.set(0.52);
        _lastCurrentBR = _liftBackRight.getOutputCurrent();
      }else{
        _liftBackRight.set(0);
      }
      if(_bl_ll.get() == false){
        _liftBackLeft.set(0.55);
      }else{
        _liftBackLeft.set(0.0);
        _lastCurrentBL = _liftBackLeft.getOutputCurrent();
      }
      if(_fl_ll.get() == false){
        _liftFrontLeft.set(0.55);
        _lastCurrentFL = _liftFrontLeft.getOutputCurrent();
      }else{
        _liftFrontLeft.set(0.0);
      }
    }else if((Robot.m_oi.m_Controller1.getRawButton(7) == true)) {
        _lastCurrentFL = _liftFrontLeft.getOutputCurrent();
        _lastCurrentBL = _liftBackLeft.getOutputCurrent();
        _lastCurrentFR = _liftFrontRight.getOutputCurrent();
        _lastCurrentBR = _liftBackRight.getOutputCurrent();
        if(_fr_ul.get() == false){
          _liftFrontRight.set(-0.21);
        }else{
          _liftFrontRight.set(0);
        }
        if(_br_ul.get() == false){
          _liftBackRight.set(-0.22);
        }else{
          _liftBackRight.set(0);
        }
        if(_bl_ul.get() == false){
          _liftBackLeft.set(-0.25);
        }else{
          _liftBackLeft.set(0.0);
        }
        if(_fl_ul.get() == false){
          _liftFrontLeft.set(-0.25);
        }else{
          _liftFrontLeft.set(0.0);
        }
    
    // } else if ((Robot.m_oi.m_Controller1.getRawButton(8) == false) && (Robot.m_oi.m_Joystick2.getRawButton(7) ==true) && (Robot.m_oi.m_Joystick2.getRawButton(8) == true)){
      // _liftFrontLeft.configPeakCurrentLimit((int)_lastCurrentFL +1);
      // _liftBackLeft.configPeakCurrentLimit((int)_lastCurrentBL +1);
      // _liftFrontRight.configPeakCurrentLimit((int)_lastCurrentFR +1);
      // _liftBackRight.configPeakCurrentLimit((int)_lastCurrentBR +1);
      // _liftFrontLeft.configContinuousCurrentLimit((int)_lastCurrentFL);
      // _liftBackLeft.configContinuousCurrentLimit((int)_lastCurrentFR);
      // _liftFrontRight.configContinuousCurrentLimit((int)_lastCurrentBL);
      // _liftBackRight.configContinuousCurrentLimit((int)_lastCurrentBR);
      // _liftFrontLeft.enableCurrentLimit(true);
      // _liftBackLeft.enableCurrentLimit(true);
      // _liftFrontRight.enableCurrentLimit(true);
      // _liftBackRight.enableCurrentLimit(true);
    } else if (Robot.m_oi.m_Controller1.getRawButton(3) == true) {
      if(_br_ul.get() == false){
        _liftBackRight.set(-0.22);
      }else{
        _liftBackRight.set(0);
      }
      if(_bl_ul.get() == false){
        _liftBackLeft.set(-0.25);
      }else{
        _liftBackLeft.set(0.0);
      }
      
    } else if (Robot.m_oi.m_Controller1.getRawButton(4) == true) {
      if(_fl_ul.get() == false){
        _liftFrontLeft.set(-0.25);
      }else{
        _liftFrontLeft.set(0.0);
      }
      if(_fr_ul.get() == false){
        _liftFrontRight.set(-0.21);
      }else{
        _liftFrontRight.set(0);
      }
     } else { _liftFrontLeft.set(0);
      _liftBackLeft.set(0);
      _liftFrontRight.set(0);
      _liftBackRight.set(0);
      // _lastCurrentFL = 0.0;
      // _lastCurrentBL = 0.0;
      // _lastCurrentFR = 0.0;
      // _lastCurrentBR = 0.0;
      _liftFrontLeft.enableCurrentLimit(false);
      _liftBackLeft.enableCurrentLimit(false);
      _liftFrontRight.enableCurrentLimit(false);
      _liftBackRight.enableCurrentLimit(false);
    }

    SmartDashboard.putBoolean("Limit FR UL", _fr_ul.get());
    SmartDashboard.putBoolean("Limit FR LL", _fr_ll.get());
    SmartDashboard.putBoolean("Limit BR UL", _br_ul.get());
    SmartDashboard.putBoolean("Limit BR LL", _br_ll.get());
    SmartDashboard.putBoolean("Limit BL UL", _bl_ul.get());
    SmartDashboard.putBoolean("Limit BL LL", _bl_ll.get());
    SmartDashboard.putBoolean("Limit FL UL", _fl_ul.get());
    SmartDashboard.putBoolean("Limit FL LL", _fl_ll.get());
    SmartDashboard.putNumber("FR LAST Current",_lastCurrentFR);
    SmartDashboard.putNumber("BR LAST Current",_lastCurrentBL);
    SmartDashboard.putNumber("BL LAST Current",_lastCurrentBR);
    SmartDashboard.putNumber("FL LAST Current",_lastCurrentFL);

    SmartDashboard.putNumber("FR Current",_liftFrontRight.getOutputCurrent());
    SmartDashboard.putNumber("BR Current",_liftBackRight.getOutputCurrent());
    SmartDashboard.putNumber("BL Current",_liftBackLeft.getOutputCurrent());
    SmartDashboard.putNumber("FL Current",_liftFrontLeft.getOutputCurrent());

    // SmartDashboard.putNumber("Gyro x", _gyro.)

  }

}
