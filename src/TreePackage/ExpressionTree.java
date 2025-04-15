package TreePackage;

public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface {
	
	public ExpressionTree() {
		
	}
	
	public double evaluate() {
		return evaluate(getRootNode());
	}
	
	private double evaluate(BinaryNode<String> rootNode) {
		double result;
		if (rootNode == null) {
			result = 0; 
		}
		else if (rootNode.isLeaf()) {
			String variable = rootNode.getData();
			result = getValueOf(variable);
		}
		else {
			double firstOperand = evaluate(rootNode.getLeftChild());
			double secondOperand = evaluate(rootNode.getRightChild());
			String operator = rootNode.getData();
			result = compute(operator, firstOperand, secondOperand);
		}
		
		return result;
	}
	
	private double getValueOf(String variable) {
		
	}
	
	private double coompute(String operator, double firstOperand, double secondOperand) {
		
	}

}
