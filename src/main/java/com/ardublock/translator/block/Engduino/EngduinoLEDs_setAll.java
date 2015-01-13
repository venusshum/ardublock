package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoLEDs_setAll extends TranslatorBlock {

	public EngduinoLEDs_setAll (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			TranslatorBlock co = this.getTranslatorBlockAtSocket(0);
			
			translator.addHeaderFile("EngduinoLEDs.h");
			translator.addSetupCommand("EngduinoLEDs"+".begin();\n");
			ret = ret + "\tEngduinoLEDs.setAll(" + co.toCode() + ");\n";
			return ret;
		}
}
