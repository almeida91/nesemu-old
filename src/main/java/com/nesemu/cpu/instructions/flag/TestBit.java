package com.nesemu.cpu.instructions.flag;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x24, mode = AddressingMode.ZERO_PAGE, cycles = 3)
@OpCode(code = 0x2C, mode = AddressingMode.ABSOLUTE, cycles = 4)
public class TestBit extends Instruction {
    public TestBit(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        int value = getCpu().readMemory(address);

        getCpu().setZeroFlag((value & getCpu().getA()) == 0);
        getCpu().setNegativeFlag((value & 0x80) != 0);
        getCpu().setOverflowFlag((value & 0x40) != 0);
    }

    @Override
    public String getMnemonic() {
        return "BIT";
    }
}
