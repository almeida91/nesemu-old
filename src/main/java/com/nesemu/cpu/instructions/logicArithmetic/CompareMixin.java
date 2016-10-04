package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.CPU;

/**
 * Created by igor on 03/10/16.
 */
public interface CompareMixin {
    CPU getCpu();

    default void compare(int registerValue, int value) {

    }
}
