package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xA8)
public class TransferAY extends Instruction {
    public TransferAY(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setY(getCpu().getA());
        setFlags(getCpu().getY(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "TAY";
    }
}
