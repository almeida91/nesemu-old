package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x48, cycles = 3)
public class PushAccumulator extends Instruction {
    public PushAccumulator(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().push(getCpu().getA());
    }

    @Override
    public String getMnemonic() {
        return "PHA";
    }

}
