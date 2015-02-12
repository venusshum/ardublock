package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoMagnetometer_z extends TranslatorBlock {

	public EngduinoMagnetometer_z (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			TranslatorBlock mag = this.getTranslatorBlockAtSocket(0);
			
			translator.addHeaderFile("EngduinoMagnetometer.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("EngduinoMagnetometer"+".begin();\n");
			
			ret += "\tfloat tem_magz[3];\n";
			ret += "\tEngduinoMagnetometer.xyz(tem_magz);\n";
			ret += "\t"+mag.toCode() + "=tem_magz[2];\n";
			return ret;
		}
}
