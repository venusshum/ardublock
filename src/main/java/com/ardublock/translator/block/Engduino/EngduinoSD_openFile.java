package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoSD_openFile extends TranslatorBlock{

	public EngduinoSD_openFile (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String ret="";
		TranslatorBlock readwrite = this.getTranslatorBlockAtSocket(1);
		TranslatorBlock filename = this.getTranslatorBlockAtSocket(0);
		
		translator.addHeaderFile("EngduinoSD.h");
		translator.addSetupCommand("EngduinoSD"+".begin(" + filename.toCode() + "," + readwrite.toCode()+ ");\n");
		//ret = ret + "\tEngduinoLEDs.setLED(" + num.toCode() + ", " + co.toCode() + ");\n";
		return ret;
	}
}
