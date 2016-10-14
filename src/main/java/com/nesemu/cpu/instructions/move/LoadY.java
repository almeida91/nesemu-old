package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xA0, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xA4, mode = AddressingMode.ZERO_PAGE, cycles = 3)
@OpCode(code = 0xB4, mode = AddressingMode.ZERO_PAGE_X, cycles = 4)
@OpCode(code = 0xAC, mode = AddressingMode.ABSOLUTE, cycles = 4)
@OpCode(code = 0xBC, mode = AddressingMode.ABSOLUTE_X, cycles = 4, crossBoundaryPenalty = true)
public class LoadY extends Instruction {
    public LoadY(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setY(getCpu().readMemory(address));
        setFlags(getCpu().getY(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "LDY";
    }
}
