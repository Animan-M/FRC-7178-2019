/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  
  //Chassis
  public static WPI_TalonSRX _talon0 = new WPI_TalonSRX(0);
  public static WPI_TalonSRX _talon1 = new WPI_TalonSRX(1);
  public static WPI_TalonSRX _talon2 = new WPI_TalonSRX(2);
  public static WPI_TalonSRX _talon3 = new WPI_TalonSRX(3);
  //Elevator
  public static WPI_TalonSRX _talon4 = new WPI_TalonSRX(4);
  //Back Cargo Intake
  public static WPI_TalonSRX _talon5 = new WPI_TalonSRX(5);
  public static WPI_TalonSRX _talon6 = new WPI_TalonSRX(6);
  //Storage
  public static WPI_TalonSRX _talon7 = new WPI_TalonSRX(7);
  //Launch Wheels
  public static WPI_TalonSRX _talon8 = new WPI_TalonSRX(8);
  public static WPI_TalonSRX _talon9 = new WPI_TalonSRX(9);
  //Actuator
  public static WPI_TalonSRX _talon10 = new WPI_TalonSRX(10);
  public static WPI_TalonSRX _talon11 = new WPI_TalonSRX(11);
  public static WPI_TalonSRX _talon12 = new WPI_TalonSRX(12);
  public static WPI_TalonSRX _talon13 = new WPI_TalonSRX(13);
  //Hatch Solenoids
  public static Solenoid _gripper1 = new Solenoid(14, 6);
  public static Solenoid _gripper2 = new Solenoid(14, 7);
  //Cargo Intake Solenoids
  public static Solenoid _cargo1 = new Solenoid(15, 6);
  public static Solenoid _cargo2 = new Solenoid(15, 7);

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
