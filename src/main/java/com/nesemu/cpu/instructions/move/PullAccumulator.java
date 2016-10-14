package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x68, cycles = 4)
public class PullAccumulator extends Instruction {
    public PullAccumulator(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setA(getCpu().pull());
        setFlags(getCpu().getA(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "PLA";
    }

}
