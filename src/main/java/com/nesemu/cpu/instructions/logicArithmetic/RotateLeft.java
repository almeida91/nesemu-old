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
            value = getCpu().getA() << 1;
            value &= getCpu().isCarryFlag() ? 1 : 0;
            getCpu().setA(value & 0xFF);
        } else {
            value = getCpu().readMemory(address) << 1;
            value &= getCpu().isCarryFlag() ? 1 : 0;
            getCpu().writeMemory(address, value);
        }

        setFlags(value, true, true, true, false);
    }

    @Override
    public String getMnemonic() {
        return "ROL";
    }
}
