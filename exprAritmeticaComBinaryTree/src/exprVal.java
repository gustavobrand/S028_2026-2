import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import dsaj.trees.TraversalExamples;
import net.datastructures.LinkedBinaryTree;
import net.datastructures.Position;
import dsaj.trees.TraversalExamples;
import net.datastructures.LinkedBinaryTree;

public class exprVal {

	//public Stack<Integer> valStk;
	public Stack<LinkedBinaryTree<String>> valStk;
	public Stack<String> opStk;	
	private static LinkedBinaryTree<String> mt;
	private static net.datastructures.Position<String> current, root;
	
	public exprVal() {
		valStk = new Stack<LinkedBinaryTree<String>>();
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
	
	public static void inorderPath(LinkedBinaryTree<String> t, Position<String> p, StringBuilder expr) {
		if (t.left(p) != null) {
			expr.append("(");
			//System.out.print("(");
			inorderPath(t , t.left(p), expr);
		}
		expr.append((p.getElement()));
		//System.out.print(p.getElement());
		if (t.right(p) != null) {
			inorderPath(t, t.right(p), expr);
			expr.append(")");
			//System.out.print(")");
		}
	}
	  
	public static String getExpr(LinkedBinaryTree<String> t) {
		Position<String> p = t.root();
		StringBuilder exprStr = new StringBuilder();
		inorderPath(t, p, exprStr);
		//System.out.println("\nExtracted expr from tree: " + exprStr.toString());
		return exprStr.toString();
	}
	
	public LinkedBinaryTree<String> evalExpr(String expr) {
		StringTokenizer exprTokens = new StringTokenizer(expr);
		valStk = new Stack<LinkedBinaryTree<String>>();
		opStk = new Stack<String>();
		while (exprTokens.hasMoreTokens()) {
			String token = exprTokens.nextToken();
			//System.out.println(token);
			if (isInteger(token)) {
				LinkedBinaryTree<String> temp = new LinkedBinaryTree<String>();
				temp.addRoot(token);
				valStk.push(temp);
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
		
		LinkedBinaryTree<String> x = new LinkedBinaryTree<String>();
		LinkedBinaryTree<String> y = new LinkedBinaryTree<String>();
		LinkedBinaryTree<String> rootop = new LinkedBinaryTree<String>();
		net.datastructures.Position<String> pRootOp;
		String op;
		x = valStk.pop();
		y = valStk.pop();
		op = opStk.pop();
		pRootOp = rootop.addRoot(op);
		rootop.attach(pRootOp, y, x);
		valStk.push(rootop);
/*		if (op.equals("-")) {
			//valStk.push(y - x);
			rootop.attach(pRootOp, y, x);
			valStk.push(rootop);
		} else if (op.equals("+")) {
			valStk.push(y + x);
		} else if (op.equals("*")) {
			valStk.push(y * x);
		} else if (op.equals("/")) {
			valStk.push(y / x);			
		}
*/
	}
	
	public static void printTree01() {
		//TaversalExamples.printPreorder(mt);
		//TraversalExamples.printPreorderIndent(mt, root, 1);

		System.out.println();
		System.out.println("Pre order:");
		TraversalExamples.printPreorderIndentSlow(mt);	

/*		System.out.println();
		System.out.println("Post order:");
		TraversalExamples.printPostorder(mt);	

		System.out.println();
		System.out.println("In order:");
		TraversalExamples.printInorder(mt);	
				
		System.out.println();
		System.out.println("Breadth First:");
		TraversalExamples.printBreadthfirst(mt);	
*/
	}
	
	public static void buildTree01() {
		root = mt.addRoot("eu");
		current = mt.addLeft(root, "quero");
		mt.addLeft(current, "ver");
		mt.addRight(current, "voce");
		current = mt.addRight(root, "imprimir");
		mt.addLeft(current, "isso");
		mt.addRight(current, "daqui");
	}

	public static void buildTree02() {
		LinkedBinaryTree<String> mt1 = new LinkedBinaryTree<String>();
		LinkedBinaryTree<String> mt2 = new LinkedBinaryTree<String>();
		LinkedBinaryTree<String> mt3 = new LinkedBinaryTree<String>();
		net.datastructures.Position<String> p1, p2, p3;

		p1 = mt1.addRoot("eu");
		p2 = mt2.addRoot("quero");
		p3 = mt3.addRoot("imprimir");
		mt1.addLeft(p2, "ver");
		mt1.addRight(p2, "voce");
		
		mt1.attach(p1, mt2, mt3);
		System.out.println();
		System.out.println("Pre order com attach:");
		TraversalExamples.printPreorderIndentSlow(mt1);	

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
			//System.out.println(expr + " = " + teste.evalExpr(expr));
			
			System.out.println();
			System.out.println("Pre order com attach:");
			LinkedBinaryTree<String> t1 = teste.evalExpr(expr);
			//TraversalExamples.printPreorderIndentSlow(teste.evalExpr(expr));	
			TraversalExamples.printPreorderIndentSlow(t1);	
			System.out.println("\nExtracted expr from tree: " + getExpr(t1));

		}
		
		//mt = new LinkedBinaryTree<String>();
		//buildTree01();
		//printTree01();		
		//buildTree02();
		
	}
	
}
