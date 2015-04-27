package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoIR_recv extends TranslatorBlock{

	public EngduinoIR_recv (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{

		TranslatorBlock bufname = this.getTranslatorBlockAtSocket(0);
		
		translator.addHeaderFile("EngduinoIR.h");
		translator.addDefinitionCommand("uint8_t "+ bufname.toCode() + "[IRBUFSZ];");
		translator.addSetupCommand("EngduinoIR"+".begin();\n");
		
		String ret = "";
		ret = "EngduinoIR.recv("+ bufname.toCode() + ", 1000);";
		return ret;
	}
		
}
