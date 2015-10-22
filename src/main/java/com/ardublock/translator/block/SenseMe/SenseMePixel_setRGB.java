package com.ardublock.translator.block.SenseMe;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SenseMePixel_setRGB extends TranslatorBlock {

	public SenseMePixel_setRGB (Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
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
			TranslatorBlock vc = this.getTranslatorBlockAtSocket(2);
			TranslatorBlock vd = this.getTranslatorBlockAtSocket(3);
			
			String r = va.toCode();
			String g = vb.toCode();
			String b = vc.toCode();
			String br = vd.toCode();
			
			ret += "\tSenseMeNeopixel.setColor(" + r + "," + g + "," + b + "," + br+");";
			return ret;
		}
}
