package main;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"say"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class Say implements CommandInterface, ValueInterface{

	private String input;
	private String value;
	
	public Say(String s)
	{
		setInput(s);
		getInput();
		getValue();
	}
	
	public void setInput(String s)
	{
		input = s;
		value = s.toLowerCase();
	}
	
	public String getInput()
	{
		return input;
	}
	
	public String getValue()
	{
		return value;
	}
}
