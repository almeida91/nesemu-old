package com.nesemu.cpu.instructions.move;

import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0xAA)
public class TransferAX extends Instruction {
    public TransferAX(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setX(getCpu().getA());
        setFlags(getCpu().getX(), true, true, false, false);
    }

    @Override
    public String getMnemonic() {
        return "TAX";
    }
}
