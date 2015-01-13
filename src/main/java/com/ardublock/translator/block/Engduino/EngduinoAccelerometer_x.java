package com.ardublock.translator.block.Engduino;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class EngduinoAccelerometer_x extends TranslatorBlock {

	public EngduinoAccelerometer_x (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			TranslatorBlock accx = this.getTranslatorBlockAtSocket(0);
			
			translator.addHeaderFile("EngduinoAccelerometer.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("EngduinoAccelerometer"+".begin();\n");
			
			ret += "\tfloat tem_acc[3];\n";
			ret += "\tEngduinoAccelerometer.xyz(tem_acc);\n";
			ret += "\t"+accx.toCode() + "=tem_acc[0]\n";
			return ret;
		}
}
