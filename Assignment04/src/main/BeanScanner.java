package main;

import util.annotations.StructurePattern;

@StructurePattern("Bean Pattern")
public class BeanScanner implements BeanScannerInterface{

	private String input;
	private CommandInterface[] tokens;
	
	
	public BeanScanner(String s)
	{
		setInput(s);
	}
	
	public void setInput(String s)
	{
		input = s;
		CommandInterface[] storeTokens = new CommandInterface[s.length()];
		
		String temp = "";
		int counter = 0;
		for (int k = 1; k <= input.length(); k++)
		{
			if (Character.isLetter(input.charAt(k-1)))
			{
					temp += input.substring(k-1, k);
			}
			
			else if (Character.isDigit(input.charAt(k-1)))
			{
				if (input.charAt(k-1) != '0' && temp == "")
					temp += input.substring(k-1,  k);
			}
		
			else if (input.charAt(k-1) == '{')
			{
				temp += input.substring(k-1, k);
				Start startTok = new Start(temp);
				storeTokens[counter] = startTok;
				counter++;
				temp = "";
			}
			
			else if (input.charAt(k-1) == '}')
			{
				End endTok = new End(input.substring(k-1, k));
				storeTokens[counter] = endTok;
				counter++;
			}
			
			else if (input.charAt(k-1) == '"')
			{
				temp += input.substring(k-1, k);
				if (temp != "" && temp.length() > 1)
				{
					Quote quoteTok = new Quote(temp);
					storeTokens[counter] = quoteTok;
					counter++;
					temp = "";
				}
			}
			
			else if (temp != "" && temp.charAt(0) == '"')
			{
					temp += input.substring(k-1, k);
			}
			
			else if ((temp != "" && input.charAt(k-1) == ' '))
			{
				if (Character.isDigit(temp.charAt(0)))
				{
					Number numToken = new Number(temp);
					storeTokens[counter] = numToken;
					counter++;
					temp = "";
				}
				else{
					String tempTest = temp.toLowerCase();
					switch (tempTest){
						case "move": Move moveCom = new Move(temp);
							storeTokens[counter] = moveCom;
							counter++;
							temp = "";
							break;
						case "call": Call callCom = new Call(temp);
							storeTokens[counter] = callCom;
							counter++;
							temp = "";
							break;
						case "define": Define defineCom = new Define(temp);
							storeTokens[counter] = defineCom;
							counter++;
							temp = "";
							break;
						case "proceedall": ProceedAll proceedCom = new ProceedAll(temp);
							storeTokens[counter] = proceedCom;
							counter++;
							temp = "";
							break;
						case "redo": Redo redoCom = new Redo(temp);
							storeTokens[counter] = redoCom;
							counter++;
							temp = "";
							break;
						case "repeat": Repeat repeatCom = new Repeat(temp);
							storeTokens[counter] = repeatCom;
							counter++;
							temp = "";
							break;
						case "rotateleftarm": RotateLeftArm rotateLeftArmCom = new RotateLeftArm(temp);
							storeTokens[counter] = rotateLeftArmCom;
							counter++;
							temp = "";
							break;
						case "rotaterightarm": RotateRightArm rotateRightArmCom = new RotateRightArm(temp);
							storeTokens[counter] = rotateRightArmCom;
							counter++;
							temp = "";
							break;
						case "say": Say sayCom = new Say(temp);
							storeTokens[counter] = sayCom;
							counter++;
							temp = "";
							break;
						case "sleep": Sleep sleepCom = new Sleep(temp);
							storeTokens[counter] = sleepCom;
							counter++;
							temp = "";
							break;
						case "thread": Thread threadCom = new Thread(temp);
							storeTokens[counter] = threadCom;
							counter++;
							temp = "";
							break;
						case "undo": Undo undoCom = new Undo(temp);
							storeTokens[counter] = undoCom;
							counter++;
							temp = "";
							break;
						case "wait": Wait waitCom = new Wait(temp);
							storeTokens[counter] = waitCom;
							counter++;
							temp = "";
							break;
						case "approach": Approach approachCom = new Approach(temp);
							storeTokens[counter] = approachCom;
							counter++;
							temp = "";
						default:
							Word miscToken = new Word(temp);
							storeTokens[counter] = miscToken;
							counter++;
							temp = "";
						}	
					}
			}
				
		}
		tokens = new CommandInterface[counter];
		for (int i = 0; i < counter; i++)
		{
			tokens[i] = storeTokens[i];
		}
	}
	
	public String getInput()
	{
		return input;
	}

	public CommandInterface[] getTokens()
	{
		return tokens;
	}
}
