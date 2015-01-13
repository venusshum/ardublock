package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoLight_lightlevel extends TranslatorBlock {

	public EngduinoLight_lightlevel (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("EngduinoLight.h");
			translator.addSetupCommand("EngduinoLight"+".begin();\n");
			ret = ret + "EngduinoLight.lightLevel()";
		
			return ret;
		}
}
