package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeLEDM_print extends TranslatorBlock {

	public SenseMeLEDM_print (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
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
			
			
			TranslatorBlock va = this.getTranslatorBlockAtSocket(0);
			
			String varName = va.toCode();
			
			ret += "\tSenseMeLEDMatrix.setCursor(0,0);";
			ret += "\tSenseMeLEDMatrix.print(" + varName + ");";
			ret += "\tSenseMeLEDMatrix.writeDisplay();";
			return ret;
		}
}
