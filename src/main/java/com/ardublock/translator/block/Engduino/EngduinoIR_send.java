package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoIR_send extends TranslatorBlock{

	public EngduinoIR_send (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{

		TranslatorBlock message = this.getTranslatorBlockAtSocket(0);
		
		translator.addHeaderFile("EngduinoIR.h");


		
		String ret = "";
		String msg = message.toCode();
		ret = "EngduinoIR.send(\"" + msg + "\", strlen(msg)+1)";
		return ret;
	}
		
}
