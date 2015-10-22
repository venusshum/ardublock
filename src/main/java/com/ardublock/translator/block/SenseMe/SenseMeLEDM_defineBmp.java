package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeLEDM_defineBmp extends TranslatorBlock {

	public SenseMeLEDM_defineBmp (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("SenseMeLEDMatrix.h");
			translator.addHeaderFile("Wire.h");
			
			translator.addSetupCommand("SenseMeLEDMatrix"+".begin();\n");
			
			
			String varName = this.getTranslatorBlockAtSocket(0).toCode();
			String r0 = this.getTranslatorBlockAtSocket(1).toCode();
			String r1 = this.getTranslatorBlockAtSocket(2).toCode();
			String r2 = this.getTranslatorBlockAtSocket(3).toCode();
			String r3 = this.getTranslatorBlockAtSocket(4).toCode();
			String r4 = this.getTranslatorBlockAtSocket(5).toCode();
			String r5 = this.getTranslatorBlockAtSocket(6).toCode();
			String r6 = this.getTranslatorBlockAtSocket(7).toCode();
			String r7 = this.getTranslatorBlockAtSocket(8).toCode();
			
			String command="";
			command += "static const uint8_t PROGMEM ";
			command += varName + "[]=\n";
			command += "{B" + r0 + ",\n";
			command += " B" + r1 + ",\n";
			command += " B" + r2 + ",\n";
			command += " B" + r3 + ",\n";
			command += " B" + r4 + ",\n";
			command += " B" + r5 + ",\n";
			command += " B" + r6 + ",\n";
			command += " B" + r7 + "};\n";
			
			translator.addDefinitionCommand(command);
			return ret;
		}
}
