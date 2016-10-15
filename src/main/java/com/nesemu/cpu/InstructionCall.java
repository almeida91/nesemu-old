package com.nesemu.cpu;


/**
 * Created by igor on 24/09/16.
 */
public class InstructionCall {
    private Instruction instruction;
    private AddressingMode mode;
    private CPU cpu;
    private int opcode;
    private int cycles;

    public InstructionCall(Instruction instruction, AddressingMode mode, CPU cpu, int opcode, int cycles) {
        this.instruction = instruction;
        this.mode = mode;
        this.cpu = cpu;
        this.opcode = opcode;
        this.cycles = cycles;
    }

    public int run() {
        int addr;

        switch (mode) {
            case ABSOLUTE:
                addr = absolute();
                break;
            case ABSOLUTE_X:
                addr = absoluteX();
                break;
            case ABSOLUTE_Y:
                addr = absoluteY();
                break;
            case IMMEDIATE:
                addr = immediate();
                break;
            case INDIRECT:
                addr = indirect();
                break;
            case INDIRECT_X:
                addr = indirectX();
                break;
            case INDIRECT_Y:
                addr = indirectY();
                break;
            case RELATIVE:
                addr = relative();
                break;
            case ZERO_PAGE:
                addr = zeroPage();
                break;
            case ZERO_PAGE_X:
                addr = zeroPageX();
                break;
            case ZERO_PAGE_Y:
                addr = zeroPageY();
                break;
            default:
                addr = 0;
        }

        instruction.run(opcode, addr);

        return cycles;
    }

    private int immediate() {
        return cpu.getNextPc();
    }

    private int zeroPage() {
        return cpu.readMemory();
    }

    private int zeroPageX() {
        return zeroPage() + cpu.getX();
    }

    private int zeroPageY() {
        return zeroPage() + cpu.getY();
    }

    private int absolute() {
        return cpu.readMemory16bit();
    }

    private int absoluteX() {
        return absolute() + cpu.getX();
    }

    private int absoluteY() {
        return absolute() + cpu.getY();
    }

    private int indirect() {
        int addr = cpu.readMemory16bit();
        return cpu.readMemory16bit(addr);
    }

    private int indirectX() {
        int addr = cpu.readMemory() + cpu.getX();
        addr = cpu.readMemory16bit(addr);
        return addr;
    }

    private int indirectY() {
        int addr = cpu.readMemory();
        addr = cpu.readMemory16bit(addr) + cpu.getY();
        return addr;
    }

    private int relative() {
        int addr = cpu.getPC();
        addr += cpu.readMemory();
        return addr;
    }
}
