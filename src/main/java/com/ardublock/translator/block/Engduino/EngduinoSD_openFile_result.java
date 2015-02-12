package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoSD_openFile_result extends TranslatorBlock{

	public EngduinoSD_openFile_result (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
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
		translator.addHeaderFile("EngduinoLEDs.h");
		translator.addSetupCommand("EngduinoLEDs.begin()");
		//translator.addSetupCommand("EngduinoSD"+".begin(" + filename.toCode() + "," + readwrite.toCode()+ ");\n");
		
		ret += "if(!(char)EngduinoSD" + ".begin(" + filename.toCode() + "," + readwrite.toCode()+ "))";
		ret += "{";
		ret += "\tEngduinoLEDs.setAll(RED);";
		ret += "\tSerial.println(\"SD Card failed, or not present!\");";
		ret += "\tSerial.println(\"Sketch will terminates here...\");";
		ret += "\twhile(1){}";
		ret += "}";
		translator.addSetupCommand(ret);
		return "";
	}
		
}
