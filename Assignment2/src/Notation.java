
public class Notation {
	
	private static double operation(String first, String second,char op) {
		double result=0,fir,sec;
		switch(op) {
		case '+':
			fir=Double.parseDouble(first);
			sec=Double.parseDouble(second);
			result=fir+sec;
			break;
		
		case '-':
			fir=Double.parseDouble(first);
			sec=Double.parseDouble(second);
			result=fir-sec;
			break;
		
		case '*':
			fir=Double.parseDouble(first);
			sec=Double.parseDouble(second);
			result=fir*sec;
			break;
		
		case '/':
			fir=Double.parseDouble(first);
			sec=Double.parseDouble(second);
			result=fir/sec;
			break;
		
		default:
			System.out.println("Unknown operator");
		}	
		return result;
	}
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		String infix;
		String top;
		NotationStack<String> infixStack=new NotationStack<String>(10);
		char[] temp=postfix.toCharArray();
		
		try {
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==' ') {
					continue;
				}
				if(Character.isDigit(temp[i])) {
					infixStack.push(String.valueOf(temp[i]));
				}
				if(temp[i]=='+'||temp[i]=='-'||temp[i]=='/'||temp[i]=='*') {
					if(infixStack.size()<2) {
						throw new InvalidNotationFormatException();
					}
					else {
						top=infixStack.pop();
						infix="("+infixStack.pop()+temp[i]+top+")";
						infixStack.push(infix);
					}
				}
			}
			if(infixStack.size()>1) {
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackOverflowException d) {
			System.out.println(d.getMessage());
			d.printStackTrace();
		}
		catch(StackUnderflowException s) {
			System.out.println(s.getMessage());
			s.printStackTrace();
		}
		return infixStack.toString();
	}
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		
		NotationStack<String> postfixStack=new NotationStack<String>(10);
		NotationQueue<String> postfixQueue=new NotationQueue<String>(10);
		char[] temp=infix.toCharArray();
		
		try {
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==' ') {
					continue;
				}
				if(Character.isDigit(temp[i])) {
					postfixQueue.enqueue(String.valueOf(temp[i]));
				}
				if(temp[i]=='(') {
					
					postfixStack.push(String.valueOf(temp[i]));
				}
				if(temp[i]=='+'||temp[i]=='-'||temp[i]=='/'||temp[i]=='*') {
					if(temp[i]=='+'||temp[i]=='-') {
						while(postfixStack.top()=="*"||postfixStack.top()=="/"||postfixStack.top()=="+"||postfixStack.top()=="-") {
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
					else {
						while(postfixStack.top()=="*"||postfixStack.top()=="/") {
							postfixQueue.enqueue(postfixStack.pop());
						}
					}
				}
				if(!postfixStack.isEmpty()&&temp[i]==')') {
					while(postfixStack.top()!="(") {
						postfixQueue.enqueue(postfixStack.pop());
					}
					if(postfixStack.top()!="(") {
						throw new InvalidNotationFormatException();
					}
					
				}
			}
			while(postfixStack.top()=="+"||postfixStack.top()=="-"||postfixStack.top()=="*"||postfixStack.top()=="/") {
				postfixQueue.enqueue(postfixStack.pop());
			}
		}
		catch(QueueOverflowException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		catch(StackOverflowException d) {
			System.out.println(d.getMessage());
			d.printStackTrace();
		}
		catch(StackUnderflowException s) {
			System.out.println(s.getMessage());
			s.printStackTrace();
		}
		return postfixQueue.toString();
	}
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		String first, second;
		double result=0;
		NotationStack<String> postfixStack=new NotationStack<String>(10);
		char[] temp=postfixExpr.toCharArray();
		
		try {
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==' ') {
					continue;
				}
				if(Character.isDigit(temp[i])|| temp[i]=='(') {
					postfixStack.push(String.valueOf(temp[i]));
				}
				else {
					if(postfixStack.size()<2) {
						throw new InvalidNotationFormatException();
					}
					else {
						second=postfixStack.pop();
						first=postfixStack.pop();
						result=operation(first,second,temp[i]);
						postfixStack.push(Double.toString(result));
						
					}
				}
			}
			if(postfixStack.size()>1) {
				throw new InvalidNotationFormatException();
			}
		}
		catch(StackOverflowException d) {
			System.out.println(d.getMessage());
			d.printStackTrace();
		}
		catch(StackUnderflowException s) {
			System.out.println(s.getMessage());
			s.printStackTrace();
		}
		
					
		return result;
	}
	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException {
		double result=0;
		result=evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
		
		return result;
	}
}
