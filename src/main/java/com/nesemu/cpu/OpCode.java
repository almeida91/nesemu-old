package com.nesemu.cpu;

import java.lang.annotation.*;

/**
 * Created by igor on 24/09/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(OpCodes.class)
public @interface OpCode {
    int code();

    AddressingMode mode() default AddressingMode.IMPLIED;
}
