package prop.assignment0.node;

import java.io.IOException;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class AssignNode implements INode{

	private Lexeme id;
	private Lexeme assignOperator;
	private ExpressionNode expression;
	private Lexeme semicolon;
	
	public AssignNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		
		id = tokenizer.current();
		tokenizer.moveNext();
		
		assignOperator = tokenizer.current();
		tokenizer.moveNext();
		
		expression = new ExpressionNode(tokenizer);
		
		semicolon = tokenizer.current();
		tokenizer.moveNext();
	}
	
	public Lexeme getId() {
		return id;
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		return "" + id.value() + " " + assignOperator.value() + " " + expression.evaluate(null) + "\n";
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append("AssignmentNode\n");
		
		tabs++;
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}
		
		builder.append(id + "\n");
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}

		builder.append(assignOperator + "\n");
		
		expression.buildString(builder, tabs);
		
		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}

		builder.append(semicolon + "\n");
	}
}
