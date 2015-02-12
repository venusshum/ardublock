package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoSD_writeln extends TranslatorBlock{

	public EngduinoSD_writeln (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String setupString="";
		TranslatorBlock message = this.getTranslatorBlockAtSocket(0);
		TranslatorBlock appenStr = this.getTranslatorBlockAtSocket(1);
		
		translator.addHeaderFile("EngduinoSD.h");
		translator.addHeaderFile("EngduinoLEDs.h");
		
		//translator.addSetupCommand("EngduinoSD"+".begin(" + filename.toCode() + "," + readwrite.toCode()+ ");\n");
		
		//assume file is opened in another block
		
		
		String ret = "";
		
		
		String test = appenStr.toCode();
		if(test.equals("true")){
			ret += "EngduinoSD.writeln(\"" + message.toCode() + "\");";
		}
		else {
			ret += "EngduinoSD.write(\"" + message.toCode() + "\");";
		}
		return ret;
	}
		
}
