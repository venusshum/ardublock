package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoSD_writeln_filename extends TranslatorBlock{

	public EngduinoSD_writeln_filename (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String setupString="";
		TranslatorBlock filename = this.getTranslatorBlockAtSocket(0);
		TranslatorBlock message = this.getTranslatorBlockAtSocket(1);
		TranslatorBlock appenStr = this.getTranslatorBlockAtSocket(2);
		
		translator.addHeaderFile("EngduinoSD.h");
		translator.addHeaderFile("EngduinoLEDs.h");
		//translator.addSetupCommand("EngduinoSD"+".begin(" + filename.toCode() + "," + readwrite.toCode()+ ");\n");
		
		setupString += "if(!EngduinoSD" + ".begin(" + filename.toCode() + ", FILE_WRITE)";
		setupString += "{";
		setupString += "\tEngduinoLEDs.setAll(RED);";
		setupString += "\tSerial.println(\"SD Card failed, or not present!\");";
		setupString += "\tSerial.println(\"Sketch will terminates here...\");";
		setupString += "\twhile(1){}";
		setupString += "}";
		translator.addSetupCommand(setupString);
		
		
		String ret = "";
		ret += "EngduinoSD.writeln(\"" + message.toCode();
		
		String test = appenStr.toCode();
		if(test.equals("true")){
		    ret+="\\n\");";
		}
		else {
			ret+="\");";
		}
		return ret;
	}
		
}
