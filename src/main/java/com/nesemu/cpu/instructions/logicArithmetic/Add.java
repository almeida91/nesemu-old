package com.nesemu.cpu.instructions.logicArithmetic;

import com.nesemu.cpu.AddressingMode;
import com.nesemu.cpu.CPU;
import com.nesemu.cpu.Instruction;
import com.nesemu.cpu.OpCode;

/**
 * Created by igor on 01/10/16.
 */
@OpCode(code = 0x69, mode = AddressingMode.IMMEDIATE)
@OpCode(code = 0x65, mode = AddressingMode.ZERO_PAGE)
@OpCode(code = 0x75, mode = AddressingMode.ZERO_PAGE_X)
@OpCode(code = 0x61, mode = AddressingMode.INDIRECT_X)
@OpCode(code = 0x71, mode = AddressingMode.INDIRECT_Y)
@OpCode(code = 0x6D, mode = AddressingMode.ABSOLUTE)
@OpCode(code = 0x7D, mode = AddressingMode.ABSOLUTE_X)
@OpCode(code = 0x79, mode = AddressingMode.ABSOLUTE_Y)
public class Add extends Instruction {
    public Add(CPU cpu) {
        super(cpu);
    }

    @Override
    public void run(int opcode, int address) {
        getCpu().setA(getCpu().getA() + getCpu().readMemory(address));

        // TODO: adc bit flags
    }

    @Override
    public String getMnemonic() {
        return "ADC";
    }
}
