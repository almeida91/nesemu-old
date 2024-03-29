package com.nesemu.cpu.instructions;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 24/09/16.
 */
@OpCode(code = 0x00, cycles = 7)
public class Break extends Instruction {
    public Break(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().push16bits(getCpu().getPC());
        getCpu().push(getCpu().getP());
        getCpu().setInterruptFlag(true);
        getCpu().readMemory16bit(0xFFFE);
    }

    @Override
    public String getMnemonic() {
        return "BRK";
    }

}
