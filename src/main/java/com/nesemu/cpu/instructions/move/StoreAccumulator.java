package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x85, mode = AddressingMode.ZERO_PAGE, cycles = 3)
@OpCode(code = 0x95, mode = AddressingMode.ZERO_PAGE_X, cycles = 4)
@OpCode(code = 0x8D, mode = AddressingMode.ABSOLUTE, cycles = 4)
@OpCode(code = 0x9D, mode = AddressingMode.ABSOLUTE_X, cycles = 5)
@OpCode(code = 0x99, mode = AddressingMode.ABSOLUTE_Y, cycles = 5)
@OpCode(code = 0x81, mode = AddressingMode.INDIRECT_X, cycles = 6)
@OpCode(code = 0x91, mode = AddressingMode.INDIRECT_Y, cycles = 6)
public class StoreAccumulator extends Instruction {
    public StoreAccumulator(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().writeMemory(address, getCpu().getA());
    }

    @Override
    public String getMnemonic() {
        return "STA";
    }

}
