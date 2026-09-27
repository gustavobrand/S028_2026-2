import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class exprVal {

	public Stack<Integer> valStk;
	public Stack<String> opStk;	
	
	public exprVal() {
		valStk = new Stack<Integer>();
		opStk = new Stack<String>();
	}

	public boolean isInteger( String input ) {  
	   try {  
	      Integer.parseInt( input );  
	      return true;  
	   }  
	   catch( Exception e ) {  
	      return false;  
	   }  
	}
	
	public int prec (String op) {
		if (op.equals("-") || op.equals("+")) {
			return 1;
		} else if (op.equals("*") || op.equals("/")) {
			return 2;
		} else if (op.equals("^")) {
			return 3;
		} else if (op.equals("$")) {
			return 0;
		}
		return 5;
	}
	
	public Integer evalExpr(String expr) {
		this.valStk = new Stack<Integer>();
		this.opStk = new Stack<String>();
		StringTokenizer exprTokens = new StringTokenizer(expr);
		while (exprTokens.hasMoreTokens()) {
			String token = exprTokens.nextToken();
			//System.out.println(token);
			if (isInteger(token)) {
				valStk.push(Integer.valueOf(token));
			} else {
				repeatOps(token);
				opStk.push(token);
			}
		}
		repeatOps("$");
		return valStk.peek();		
	}
	
	public void repeatOps(String op) {
		while ((valStk.size() > 1) && (prec(op) <= prec(opStk.peek()))) {
			doOp();
		}
	}
	
	public void doOp() {
		int x, y;
		String op;
		x = valStk.pop();
		y = valStk.pop();
		op = opStk.pop();
		if (op.equals("-")) {
			valStk.push(y - x);
		} else if (op.equals("+")) {
			valStk.push(y + x);
		} else if (op.equals("*")) {
			valStk.push(y * x);
		} else if (op.equals("/")) {
			valStk.push(y / x);			
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> exprs = new ArrayList<String>();
		exprs.add("15 / 3 - 2 * 4");
		exprs.add("15 / 3 + 2 * 4");
		exprs.add("15 / 3 * 2 + 4");
		exprs.add("15 / 3 * 2 * 4");
		exprs.add("15 - 3 * 2 + 4");
		
		exprVal teste = new exprVal();
		for (String expr : exprs) {
			System.out.println(expr + " = " + teste.evalExpr(expr));			
		}
		
		// TestTree01 tt = new TestTree01();
		
	}
	
}
