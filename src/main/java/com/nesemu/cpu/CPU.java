package com.nesemu.cpu;

import com.nesemu.Mapper;
import com.nesemu.ppu.PPU;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by igor on 15/09/16.
 */
public class CPU {
    private int A;
    private int X;
    private int Y;
    private int SP = 0x01FF;

    private int PC = 0x8000;

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

    private PPU ppu;

    private Map<Integer, InstructionCall> instructions;

    private void addClass(String packageName, File file) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (file.getName().endsWith(".class")) {
            Class<?> c = Class.forName(packageName + "." + file.getName().replace(".class", ""));

            OpCode[] opCodes;

            if (c.isAnnotationPresent(OpCodes.class)) {
                opCodes = ((OpCodes) c.getAnnotation(OpCodes.class)).value();
            } else if (c.isAnnotationPresent(OpCode.class)) {
                opCodes = new OpCode[]{(OpCode) c.getAnnotation(OpCode.class)};
            } else {
                return;
            }

            Constructor<?> constructor = c.getConstructor(CPU.class);
            Instruction instruction = (Instruction) constructor.newInstance(this);

            for (OpCode opCode : opCodes) {
                instructions.put(opCode.code(), new InstructionCall(instruction, opCode.mode(), this, opCode.code(), opCode.cycles(), opCode.crossBoundaryPenalty()));
            }
        } else {
            for (File innerFile : file.listFiles()) {
                addClass(packageName + "." + file.getName(), innerFile);
            }
        }
    }

    private void loadInstructions() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        instructions = new HashMap<>();

        String packageName = "com.nesemu.cpu.instructions";
        URL packageUrl = Thread.currentThread().getContextClassLoader().getResource(packageName.replace(".", "/"));
        File packageDir = new File(packageUrl.getFile());

        for (File file : packageDir.listFiles()) {
            addClass(packageName, file);
        }
    }

    public void initialize() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        loadInstructions();
    }

    public void cycle() {
        if (cycles == 0) {
            int opcode = readMemory();

            InstructionCall call = instructions.get(opcode);
            cycles = call.run();

        } else {
            cycles--;
        }
    }

    public void addCycles(int cycles) {
        this.cycles += cycles;
    }

    public int readMemory(int address) {
        if (address <= 0x07FF) {
            return ram[address];
        } else if (address <= 0x1FFF) {
            return ram[address & 0x7FFF];
        } else if (address < 0x3FFF) {
            return ppu.readMemory(address);
        } else if (address < 0x401F) {
            // TODO: IO registers / apu registers
            return 0;
        } else if (address <= 0xFFFF) {
            return mapper.read(address);
        } else {
            // TODO: exception?
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

        if (address <= 0x07FF) {
            ram[address] = value;
        } else if (address <= 0x1FFF) {
            ram[address & 0x7FFF] = value;
        } else if (address < 0x3FFF) {
            ppu.writeMemory(address, value);
        } else if (address < 0x401F) {
            // TODO: IO registers / apu registers
        } else if (address <= 0xFFFF) {
            mapper.write(address, value);
        }
    }

    /**
     * Return and increases the value of the program counter
     *
     * @return the old value to the PC register
     */
    public int getNextPc() {
        return PC++;
    }

    public void push(int value) {
        writeMemory(SP, value);
        SP--;
        // TODO: o SP tem que operar em mod 256
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
