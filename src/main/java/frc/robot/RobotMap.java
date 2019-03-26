/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Solenoid;
// import edu.wpi.first.wpilibj.ADXL345_SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  
  //Chassis Left
  public static WPI_TalonSRX _motorFrontLeft = new WPI_TalonSRX(7); //_talon0
  public static WPI_TalonSRX _motorBackLeft = new WPI_TalonSRX(3); //_talon1 
  //Chassis Right
  public static WPI_TalonSRX _motorFrontRight = new WPI_TalonSRX(4); //_talon2
  public static WPI_TalonSRX _motorBackRight = new WPI_TalonSRX(5); //_talon3
  //Elevator
  public static WPI_VictorSPX _elevatorLeft = new WPI_VictorSPX(6); //_talon4
  public static WPI_VictorSPX _elevatorRight = new WPI_VictorSPX(14); // new
  //Back Cargo Intake
  public static WPI_TalonSRX _intakeFront = new WPI_TalonSRX(12); //_talon5
  public static WPI_TalonSRX _intakeBack = new WPI_TalonSRX(13); //_talon6  
  //Launch Wheels
  public static WPI_TalonSRX _shootFront = new WPI_TalonSRX(10); //_talon8
  public static WPI_TalonSRX _shootBack = new WPI_TalonSRX(11); //_talon9
  //Actuator
  public static WPI_TalonSRX _liftFrontLeft = new WPI_TalonSRX(9); //_talon10
  public static WPI_TalonSRX _liftBackLeft = new WPI_TalonSRX(0); //_talon11
  public static WPI_TalonSRX _liftFrontRight = new WPI_TalonSRX(1); ///_talon12
  public static WPI_TalonSRX _liftBackRight = new WPI_TalonSRX(2); //_talon13
  //Hatch Solenoids
  public static Solenoid _gripper = new Solenoid(8, 0); //_gripper1
  //Lower Intake Left
  public static Solenoid _lowerIntakeLeft = new Solenoid(8, 2); //_gripper2
  //Lower Intake Right
  public static Solenoid _lowerIntakeRight = new Solenoid(8, 3); //_cargo1
  //UpperIntake
  public static Solenoid _upperIntake = new Solenoid(8, 1); //_cargo2
  // Gyro
  // public static ADXL345_SPI _gyro = new ADXL345_SPI(0);
  public static boolean _endGame = false;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
