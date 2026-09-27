import javax.swing.text.Position;
import dsaj.trees.TraversalExamples;
import net.datastructures.ArrayList;
import net.datastructures.LinkedBinaryTree;

public class TestTree01 {

	private static LinkedBinaryTree<String> mt;
	private static net.datastructures.Position<String> current, root;

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
		root = mt.addRoot("raiz");
		current = mt.addLeft(root, "Interno1");
		mt.addLeft(current, "folha_esquerda_Interno1");
		mt.addRight(current, "folha_direita_Interno1");
		current = mt.addRight(root, "Interno2");
		mt.addLeft(current, "folha_esquerda_Interno2");
		mt.addRight(current, "folha_direita_Interno2");
	}
	
	public static void printTree01() {
		//TaversalExamples.printPreorder(mt);
		//TraversalExamples.printPreorderIndent(mt, root, 1);

		System.out.println();
		System.out.println("Pre order:");
		TraversalExamples.printPreorderIndentSlow(mt);	

		System.out.println();
		System.out.println("Post order:");
		TraversalExamples.printPostorder(mt);	

		System.out.println();
		System.out.println("In order:");
		TraversalExamples.printInorder(mt);	
				
		System.out.println();
		System.out.println("Breadth First:");
		TraversalExamples.printBreadthfirst(mt);	
	}
	
	public TestTree01() {
		mt = new LinkedBinaryTree<String>();
		buildTree02();
		printTree01();
	}
	
}
