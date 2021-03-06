package prop.assignment0.node;

import java.io.IOException;

import prop.assignment0.lexeme.Lexeme;
import prop.assignment0.token.Token;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class TermNode implements INode{

	private FactorNode factor;
	private Lexeme operator;
	private TermNode term;

	public TermNode(Tokenizer tokenizer) throws IOException, TokenizerException {

		factor = new FactorNode(tokenizer);
		Lexeme lexeme = tokenizer.current();
		if(lexeme.token().equals(Token.MULT_OP) || lexeme.token().equals(Token.DIV_OP)) {
			operator = lexeme;
			tokenizer.moveNext();
			term = new TermNode(tokenizer);
		}
	}

	@Override
	public Object evaluate(Object[] args) throws Exception {
		if(operator != null) {
			if(operator.token().equals(Token.MULT_OP)) {
				return (double)factor.evaluate(args) * (double)term.evaluate(args);
			} else if(operator.token().equals(Token.DIV_OP)) {
				return (double)factor.evaluate(args) / 
						((double)term.factor.evaluate(args) * 
						(double)term.factor.evaluate(args) / 
						(double)term.evaluate(args));
			} else {
				return null;
			}
		} else {
			return (double) factor.evaluate(args);
		}
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {

		for (int i = 0; i < tabs; i++) {
			builder.append("\t");
		}

		builder.append("TermNode\n");

		tabs++;

		factor.buildString(builder, tabs);

		if(operator != null) {
			for (int i = 0; i < tabs; i++) {
				builder.append("\t");
			}

			builder.append(operator + "\n");
			term.buildString(builder, tabs);
		}
	}

}
