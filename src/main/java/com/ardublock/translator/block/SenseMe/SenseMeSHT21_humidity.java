package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeSHT21_humidity extends TranslatorBlock {

	public SenseMeSHT21_humidity (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("SHT2x.h");
			translator.addHeaderFile("Wire.h");
			//translator.addSetupCommand("SHT2x"+".begin();\n");
			ret = ret + "SHT2x.GetHumidity()";
			return ret;
		}
}
