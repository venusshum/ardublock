package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoLEDs_setLED_brightness extends TranslatorBlock {
	public EngduinoLEDs_setLED_brightness (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			TranslatorBlock num = this.getTranslatorBlockAtSocket(0);
			TranslatorBlock co = this.getTranslatorBlockAtSocket(1);
			TranslatorBlock br = this.getTranslatorBlockAtSocket(2);
			
			translator.addHeaderFile("EngduinoLEDs.h");
			translator.addSetupCommand("EngduinoLEDs"+".begin();\n");
			ret = ret + "\tEngduinoLEDs.setLED(" + num.toCode() + ", " + co.toCode() + ", " + br.toCode() + ");\n";
			return ret;
		}
}
