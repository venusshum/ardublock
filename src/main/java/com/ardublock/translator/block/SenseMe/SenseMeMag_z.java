package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeMag_z extends TranslatorBlock {

	public SenseMeMag_z (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("SenseMeMagnetometer.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("SenseMeMagnetometer"+".begin();\n");
			
			ret += "SenseMeMagnetometer.getZ()";
			return ret;
		}
}
