package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoLEDs_setLED_RGB extends TranslatorBlock {
	public EngduinoLEDs_setLED_RGB (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			TranslatorBlock num = this.getTranslatorBlockAtSocket(0);
			TranslatorBlock R = this.getTranslatorBlockAtSocket(1);
			TranslatorBlock G = this.getTranslatorBlockAtSocket(2);
			TranslatorBlock B = this.getTranslatorBlockAtSocket(3);
			
			translator.addHeaderFile("EngduinoLEDs.h");
			translator.addSetupCommand("EngduinoLEDs"+".begin();\n");
			ret = ret + "\tEngduinoLEDs.setLED(" + num.toCode() + ", "+ R.toCode() + ", " + G.toCode() + ", " + B.toCode() +");\n";
			return ret;
		}
}
