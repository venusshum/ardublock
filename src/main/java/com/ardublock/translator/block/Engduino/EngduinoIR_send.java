package com.ardublock.translator.block.Engduino;


import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoIR_send extends TranslatorBlock
{

	public EngduinoIR_send (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{

		//TranslatorBlock message = this.getTranslatorBlockAtSocket(0);
		
		translator.addHeaderFile("EngduinoIR.h");
		
		
		translator.addSetupCommand("EngduinoIR"+".begin();\n");
		
		//TranslatorBlock translatorBlock = this.getTranslatorBlockAtSocket(0, "Serial.print(", ");\n");
		//TranslatorBlock translatorBlock = this.getTranslatorBlockAtSocket(0, "EngduinoIR.send(", ", strlen(msg)+1);\n");
		//String ret = "";
		//if (translatorBlock != null) {
		//	ret = translatorBlock.toCode();
		//}
		String ret = "";
		TranslatorBlock message = this.getTranslatorBlockAtSocket(0);
		translator.addDefinitionCommand("char* "+ message.toCode() + "=\"\";");
		//String msg = message.toCode();
		//ret = "char *msg = \"" + message.toCode() + "\";\n";  
		//ret += "EngduinoIR.send(msg, strlen(msg)+1);";
		ret = "EngduinoIR.send(" + message.toCode() + ", strlen(msg)+1);\n";  
		return ret;
	}
		
}
