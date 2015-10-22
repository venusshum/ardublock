package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMePixel_setColor extends TranslatorBlock {

	public SenseMePixel_setColor (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	//@Override
		public String toCode() throws SocketNullException, SubroutineNotDeclaredException
		{
			String ret="";
			
			translator.addHeaderFile("SenseMeNeopixel.h");
			translator.addHeaderFile("Wire.h");
			translator.addSetupCommand("SenseMeNeopixel"+".begin();\n");
			
			
			TranslatorBlock va = this.getTranslatorBlockAtSocket(0);
			TranslatorBlock vb = this.getTranslatorBlockAtSocket(1);
			
			String c = va.toCode();
			String b = vb.toCode();
			
			ret += "\tSenseMeNeopixel.setColor(" + c + "," + b +");";
			return ret;
		}
}
