package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoSD_isAttached extends TranslatorBlock{

	public EngduinoSD_isAttached (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String setupString="";

		
		translator.addHeaderFile("EngduinoSD.h");
		
		//translator.addSetupCommand("EngduinoSD"+".begin(" + filename.toCode() + "," + readwrite.toCode()+ ");\n");
		
		//assume file is opened in another block
		
		String ret = "";
		
		ret = ret + "EngduinoSD.available()";
		return ret;
	}
		
}
