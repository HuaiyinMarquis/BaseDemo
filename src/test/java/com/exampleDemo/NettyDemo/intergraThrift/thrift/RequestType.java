/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.exampleDemo.NettyDemo.intergraThrift.thrift;


public enum RequestType implements org.apache.thrift.TEnum {
  QUERY(0),
  UPDATE(1);

  private final int value;

  private RequestType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static RequestType findByValue(int value) { 
    switch (value) {
      case 0:
        return QUERY;
      case 1:
        return UPDATE;
      default:
        return null;
    }
  }
}
