package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeLEDM_drawPixel extends TranslatorBlock {

	public SenseMeLEDM_drawPixel (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
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
			
			
			TranslatorBlock V0 = this.getTranslatorBlockAtSocket(0);
			TranslatorBlock V1 = this.getTranslatorBlockAtSocket(1);
			String x = V0.toCode();
			String y = V1.toCode();
			
			ret += "\tSenseMeLEDMatrix.drawPixel(" + x + "," + y + ",1);";
			ret += "\tSenseMeLEDMatrix.writeDisplay();";
			
			return ret;
		}
}
