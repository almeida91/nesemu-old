package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x08, cycles = 3)
public class PushProcessorStatus extends Instruction {
    public PushProcessorStatus(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().push(getCpu().getP());
    }

    @Override
    public String getMnemonic() {
        return "PHP";
    }

}
