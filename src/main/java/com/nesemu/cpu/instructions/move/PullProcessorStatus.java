package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x28, cycles = 4)
public class PullProcessorStatus extends Instruction {
    public PullProcessorStatus(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setP(getCpu().pull());
    }

    @Override
    public String getMnemonic() {
        return "PLP";
    }

}
