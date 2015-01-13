package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoButton_wasPressed extends TranslatorBlock {
	public EngduinoButton_wasPressed (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("EngduinoButton.h");
			translator.addSetupCommand("EngduinoButton"+".begin();\n");
			ret = ret + "\tEngduinoButton.wasPressed()";
			return ret;
		}
}
