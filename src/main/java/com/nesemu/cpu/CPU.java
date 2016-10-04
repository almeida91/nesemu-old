package com.nesemu.cpu;

/**
 * Created by igor on 15/09/16.
 */
public class CPU {
    private int A;
    private int X;
    private int Y;
    private int SP;

    private int PC;

    private boolean carryFlag;
    private boolean zeroFlag;
    private boolean interruptFlag;
    private boolean decimalFlag;
    private boolean breakpointFlag;
    private boolean overflowFlag;
    private boolean negativeFlag;

    private int[] ram;

    private int cycles;

    public void cycle() {

    }

    public int readMemory(int address) {
        if (address < 2048) {
            return ram[address];
        } else if (address < 0x1FFF) {
            return ram[address & 0x7FFF];
        } else {
            return 0;
        }
    }

    public void writeMemory(int address, int value) {

    }

    public int getA() {
        return A;
    }

    public void setA(int a) {
        A = a & 0xFF;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x & 0xFF;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y & 0xFF;
    }

    public int getSP() {
        return SP;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
    }

    public int getP() {
        return 0;
    }

    public boolean isCarryFlag() {
        return carryFlag;
    }

    public void setCarryFlag(boolean carryFlag) {
        this.carryFlag = carryFlag;
    }

    public boolean isZeroFlag() {
        return zeroFlag;
    }

    public void setZeroFlag(boolean zeroFlag) {
        this.zeroFlag = zeroFlag;
    }

    public boolean isInterruptFlag() {
        return interruptFlag;
    }

    public void setInterruptFlag(boolean interruptFlag) {
        this.interruptFlag = interruptFlag;
    }

    public boolean isDecimalFlag() {
        return decimalFlag;
    }

    public void setDecimalFlag(boolean decimalFlag) {
        this.decimalFlag = decimalFlag;
    }

    public boolean isBreakpointFlag() {
        return breakpointFlag;
    }

    public void setBreakpointFlag(boolean breakpointFlag) {
        this.breakpointFlag = breakpointFlag;
    }

    public boolean isOverflowFlag() {
        return overflowFlag;
    }

    public void setOverflowFlag(boolean overflowFlag) {
        this.overflowFlag = overflowFlag;
    }

    public boolean isNegativeFlag() {
        return negativeFlag;
    }

    public void setNegativeFlag(boolean negativeFlag) {
        this.negativeFlag = negativeFlag;
    }
}
