package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xA9, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0xA5, mode = AddressingMode.ZERO_PAGE, cycles = 3)
@OpCode(code = 0xB5, mode = AddressingMode.ZERO_PAGE_X, cycles = 4)
@OpCode(code = 0xAD, mode = AddressingMode.ABSOLUTE, cycles = 4)
@OpCode(code = 0xBD, mode = AddressingMode.ABSOLUTE_X, cycles = 4, crossBoundaryPenalty = true)
@OpCode(code = 0xB9, mode = AddressingMode.ABSOLUTE_Y, cycles = 4, crossBoundaryPenalty = true)
@OpCode(code = 0xA1, mode = AddressingMode.INDIRECT_X, cycles = 6)
@OpCode(code = 0xB1, mode = AddressingMode.INDIRECT_Y, cycles = 5, crossBoundaryPenalty = true)
public class LoadAccumulator extends Instruction {
    public LoadAccumulator(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setA(getCpu().readMemory(address));
        setFlags(getCpu().getA(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "LDA";
    }
}
