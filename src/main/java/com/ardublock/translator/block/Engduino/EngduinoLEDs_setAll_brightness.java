package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoLEDs_setAll_brightness extends TranslatorBlock {
	public EngduinoLEDs_setAll_brightness (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			TranslatorBlock co = this.getTranslatorBlockAtSocket(0);
			TranslatorBlock br = this.getTranslatorBlockAtSocket(1);
			
			translator.addHeaderFile("EngduinoLEDs.h");
			translator.addSetupCommand("EngduinoLEDs"+".begin();\n");
			ret = ret + "\tEngduinoLEDs.setAll(" + co.toCode() + ", " + br.toCode() +");\n";
			return ret;
		}
}
