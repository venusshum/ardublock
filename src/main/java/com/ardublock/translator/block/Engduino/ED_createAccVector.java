package com.ardublock.translator.block.Engduino;

import java.util.ResourceBundle;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.NumberBlock;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.VariableFakeBlock;
import com.ardublock.translator.block.exception.BlockException;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNameDuplicatedException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ED_createAccVector extends TranslatorBlock{
	
	private static ResourceBundle uiMessageBundle = ResourceBundle.getBundle("com/ardublock/block/ardublock");
	
	
	public ED_createAccVector(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}
	
	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		String varName="";
		TranslatorBlock name = this.getRequiredTranslatorBlockAtSocket(0);
		TranslatorBlock size = this.getRequiredTranslatorBlockAtSocket(1);
		if (!(name instanceof VariableFakeBlock)) {
			throw new BlockException(blockId, uiMessageBundle.getString("ardublock.error_msg.array_var_slot"));
		}
		if (!(size instanceof NumberBlock)) {
			throw new BlockException(blockId, uiMessageBundle.getString("ardublock.error_msg.array_size_slot"));
		}
		
		varName+=name.toCode();
		int foo = Integer.parseInt(size.toCode());
	
		translator.addDefinitionCommand("float " + varName +"["+foo+"];\n");
		//translator.addSetupCommand("\tfor (int i=0;i<"+foo+";i++) "+ varName+"i]=0;\n"   );
		return "";
	}
}
