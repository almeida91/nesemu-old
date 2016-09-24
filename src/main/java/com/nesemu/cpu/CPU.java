package com.nesemu.cpu;

/**
 * Created by igor on 15/09/16.
 */
public class CPU {
    private byte A;
    private byte X;
    private byte Y;
    private byte SP;

    private short PC;

    private boolean carryFlag;
    private boolean zeroFlag;
    private boolean interruptFlag;
    private boolean decimalFlag;
    private boolean breakpointFlag;
    private boolean overflowFlag;
    private boolean negativeFlag;

    private RAM ram;

    public void cycle() {

    }

}
