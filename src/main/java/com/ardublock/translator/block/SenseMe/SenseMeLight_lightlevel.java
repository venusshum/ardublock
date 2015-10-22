package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeLight_lightlevel extends TranslatorBlock {

	public SenseMeLight_lightlevel (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("SenseMeLightSensor.h");
			translator.addSetupCommand("SenseMeLightSensor"+".begin();\n");
			ret = ret + "SenseMeLightSensor.lightLevel()";
		
			return ret;
		}
}
