package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNameDuplicatedException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoMagnetometer_xyz extends TranslatorBlock {

	public EngduinoMagnetometer_xyz (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String varName="";
			String ret="";
			
			TranslatorBlock va = this.getTranslatorBlockAtSocket(0);
			
			translator.addHeaderFile("EngduinoMagnetometer_xyz.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("EngduinoMagnetometer_xyz"+".begin();\n");
			

			
			varName = va.toCode();
			
			
			ret = "\tEngduinoMagnetometer_xyz.xyz(" + varName + ");\n";
			return ret;
		}
}
