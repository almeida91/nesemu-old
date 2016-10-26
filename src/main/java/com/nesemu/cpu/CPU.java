package com.nesemu.cpu;

import com.nesemu.Mapper;
import com.nesemu.Util;

import java.util.Map;

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

    private Mapper mapper;

    private Map<Integer, InstructionCall> instructions;

    public void initialize() {

    }

    public void cycle() {
        if (cycles == 0) {
            int opcode = readMemory();

            InstructionCall call = instructions.get(opcode);
            cycles = call.run();

            PC++;
        }
        else {
            cycles--;
        }
    }

    public int readMemory(int address) {
        if (address < 2048) {
            return ram[address];
        } else if (address < 0x1FFF) {
            return ram[address & 0x7FFF];
        } else if (address > 0x4018) {
            return readMemory(address);
        }
        else {
            return 0;
        }
    }

    public int readMemory() {
        return readMemory(PC++);
    }

    public int readMemory16bit() {
        int value = readMemory();
        value |= readMemory() << 8;
        return value;
    }

    public int readMemory16bit(int address) {
        int value = readMemory(address);
        value |= readMemory(address + 1) << 8;
        return value;
    }

    public void writeMemory(int address, int value) {
        value &= 0xFF;
    }

    /**
     * Increases and return the value of the program counter
     * @return the new value to the PC register
     */
    public int getNextPc() {
        return PC++;
    }

    public void push(int value) {
        writeMemory(SP, value);
        SP--;
    }

    public int pull() {
        SP++;
        return readMemory(SP);
    }

    public void push16bits(int value) {
        push(value >> 8);
        push(value & 0xFF);
    }

    public int pull16bits() {
        int value = pull();
        return (pull() << 8) | value;
    }

    public int getP() {
        int p = carryFlag ? 1 : 0;

        p |= zeroFlag ? 0b10 : 0;
        p |= interruptFlag ? 0b100 : 0;
        p |= breakpointFlag ? 0b10000 : 0;
        p |= overflowFlag ? 0b1000000 : 0;
        p |= negativeFlag ? 0b10000000 : 0;

        return p;
    }

    public void setP(int p) {
        carryFlag = (p & 1) != 0;
        zeroFlag = (p & 0b10) != 0;
        interruptFlag = (p & 0b100) != 0;
        breakpointFlag = (p & 0b10000) != 0;
        overflowFlag = (p & 0b1000000) != 0;
        negativeFlag = (p & 0b10000000) != 0;
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

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getPC() {
        return PC;
    }

    public void setPC(int PC) {
        this.PC = PC;
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
