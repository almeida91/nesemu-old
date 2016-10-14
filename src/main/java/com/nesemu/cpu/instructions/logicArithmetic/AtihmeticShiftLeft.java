package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x0A)
@OpCode(code = 0x06, mode = AddressingMode.ZERO_PAGE, cycles = 5)
@OpCode(code = 0x16, mode = AddressingMode.ZERO_PAGE_X, cycles = 6)
@OpCode(code = 0x0E, mode = AddressingMode.ABSOLUTE, cycles = 6)
@OpCode(code = 0x1E, mode = AddressingMode.ABSOLUTE_X, cycles = 7)
public class AtihmeticShiftLeft extends Instruction {
    public AtihmeticShiftLeft(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value;

        if (opcode == 0x0A) {
            getCpu().setCarryFlag(getCpu().getA() >> 7 == 1);
            value = getCpu().getA() << 1;
            getCpu().setA(value);
        } else {
            value = getCpu().readMemory(address);
            getCpu().setCarryFlag(value >> 7 == 1);
            value <<= 1;
            getCpu().writeMemory(address, value);
        }

        setFlags(value, true, true, true, false);
    }

    @Override
    public String getMnemonic() {
        return "ASL";
    }
}
