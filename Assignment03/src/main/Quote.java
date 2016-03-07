package main;

import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Quote"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@PropertyNames({"Input", "Value"})
@EditablePropertyNames({"Input"})
public class Quote implements TokenInterface {

	private String input;
	
	public Quote(String s)
	{
		setInput(s);
		getInput();
	}
	
	public void setInput(String s)
	{
		input = s;
		System.out.println(input);
	}
	
	public String getInput()
	{
		return input;
	}
	
}
