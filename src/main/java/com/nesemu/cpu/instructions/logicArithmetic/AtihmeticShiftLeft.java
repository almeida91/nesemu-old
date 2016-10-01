package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x0A)
@OpCode(code = 0x06, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x16, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x0E, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x1E, mode = AddressingMode.ABSOLUTE_X)
public class AtihmeticShiftLeft extends Instruction {
    public AtihmeticShiftLeft(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value;
        if (opcode == 0x0A) {
            value = getCpu().getA() << 1;
            getCpu().setA(value & 0xFF);
        }
        else {
            value = getCpu().readMemory(address) << 1;
            getCpu().writeMemory(address, value);
        }

        getCpu().setCarryFlag((value & 0x100) != 0);
    }

    @Override
    public String getMnemonic() {
        return "ASL";
    }
}
