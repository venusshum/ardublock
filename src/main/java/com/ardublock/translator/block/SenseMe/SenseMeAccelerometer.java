package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeAccelerometer extends TranslatorBlock {

	public SenseMeAccelerometer (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			TranslatorBlock accx = this.getTranslatorBlockAtSocket(0);
			
			translator.addHeaderFile("SenseMeAccelerometer.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("SenseMeAccelerometer"+".begin();\n");
			
			ret += "\tfloat tem_accx[3];\n";
			ret += "\tSenseMeAccelerometer.xyz(tem_accx);\n";
			ret += "\t"+accx.toCode() + "=tem_accx[0];\n";
			return ret;
		}
}
