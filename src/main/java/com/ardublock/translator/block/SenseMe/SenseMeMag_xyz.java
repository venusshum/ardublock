package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNameDuplicatedException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeMag_xyz extends TranslatorBlock {

	public SenseMeMag_xyz (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String varName="";
			String ret="";
			
			TranslatorBlock va = this.getTranslatorBlockAtSocket(0);
			
			translator.addHeaderFile("SenseMeMagnetometer_xyz.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("SenseMeMagnetometer_xyz"+".begin();\n");
			

			
			varName = va.toCode();
			
			
			ret = "\tSenseMeMagnetometer_xyz.xyz(" + varName + ");\n";
			return ret;
		}
}
