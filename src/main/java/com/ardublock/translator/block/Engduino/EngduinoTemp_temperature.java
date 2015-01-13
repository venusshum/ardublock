package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoTemp_temperature extends TranslatorBlock {

	public EngduinoTemp_temperature (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			TranslatorBlock UNIT = this.getTranslatorBlockAtSocket(0);
			
			translator.addHeaderFile("EngduinoThermistor.h");
			translator.addSetupCommand("EngduinoThermistor"+".begin();\n");
			ret = ret + "EngduinoThermistor.temperature("+ UNIT.toCode()+")";
			return ret;
		}
}
