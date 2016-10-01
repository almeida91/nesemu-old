package com.nesemu.cpu;


/**
 * Created by igor on 24/09/16.
 */
public class InstructionCall {
    private Instruction instruction;
    private AddressingMode mode;
    private CPU cpu;
    private int opcode;

    public InstructionCall(Instruction instruction, AddressingMode mode, CPU cpu, int opcode) {
        this.instruction = instruction;
        this.mode = mode;
        this.cpu = cpu;
        this.opcode = opcode;
    }

    public void run() {
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
    }

    private int immediate() {
        return 0;
    }

    private int zeroPage() {
        return 0;
    }

    private int zeroPageX() {
        return 0;
    }

    private int zeroPageY() {
        return 0;
    }

    private int absolute() {
        return 0;
    }

    private int absoluteX() {
        return 0;
    }

    private int absoluteY() {
        return 0;
    }

    private int indirect() {
        return 0;
    }

    private int indirectX() {
        return 0;
    }

    private int indirectY() {
        return 0;
    }

    private int relative() {
        return 0;
    }
}
