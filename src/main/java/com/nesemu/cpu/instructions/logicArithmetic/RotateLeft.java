package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x2A)
@OpCode(code = 0x26, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x36, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x2E, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x3E, mode = AddressingMode.ABSOLUTE_X)
public class RotateLeft extends Instruction {
    public RotateLeft(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value;

        if (opcode == 0x0A) {
            int c = getCpu().isCarryFlag() ? 1 : 0;
            value = getCpu().getA();
            setFlags(value, false, false, true, false);
            value <<= 1;
            value &= c;
            getCpu().setA(value & 0xFF);
        } else {
            int c = getCpu().isCarryFlag() ? 1 : 0;
            value = getCpu().readMemory(address);
            setFlags(value, false, false, true, false);
            value <<= 1;
            value &= c;
            getCpu().writeMemory(address, value);
        }

        setFlags(value, true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "ROL";
    }
}
