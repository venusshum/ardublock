package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeAcc_x extends TranslatorBlock {

	public SenseMeAcc_x (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("SenseMeAccelerometer.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("SenseMeAccelerometer"+".begin();\n");
			
			ret += "SenseMeAccelerometer.getX()";
			return ret;
		}
}
