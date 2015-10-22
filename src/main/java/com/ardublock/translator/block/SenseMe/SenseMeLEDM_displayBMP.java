package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMeLEDM_displayBMP extends TranslatorBlock {

	public SenseMeLEDM_displayBMP (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("SenseMeLEDMatrix.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("SenseMeLEDMatrix"+".begin();");
			//translator.addSetupCommand("SenseMeLEDMatrix"+".clear();");
			//translator.addSetupCommand("SenseMeLEDMatrix"+".writeDisplay();\n");
			
			TranslatorBlock va = this.getTranslatorBlockAtSocket(0);
			
			String varName = va.toCode();
			
			ret += "\tSenseMeLEDMatrix.clear();\n";
			ret += "\tSenseMeLEDMatrix.drawBitmap(0, 0, " + varName + ", 8, 8, LED_ON);\n";
			ret += "\tSenseMeLEDMatrix.writeDisplay();\n";
			return ret;
		}
}
