package prop.seminar1.node;

import java.io.IOException;

import prop.seminar1.scanner.Scanner;
import prop.seminar1.token.Tokenizer;
import prop.seminar1.token.TokenizerException;

public class TextNode implements INode{

	private SentenceNode sentence;
	private TextNode text;
	
	public TextNode(Tokenizer tokenizer) throws IOException, TokenizerException {
		sentence = new SentenceNode(tokenizer);
		
		if(tokenizer.currentChar() != Scanner.EOF) {
			text = new TextNode(tokenizer);
		}
	}
	
	@Override
	public Object evaluate(Object[] args) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void buildString(StringBuilder builder, int tabs) {
		for(int i = 0; i < tabs ; i++) {
			builder.append("\t");
		}
		builder.append("TEXT\n");
		++tabs;
		sentence.buildString(builder, tabs);
		
		if(text != null) {
			text.buildString(builder, tabs);
		}
	}

	@Override
	public void translate(StringBuilder builder, int tabs) {
		for(int i = 0; i < tabs ; i++) {
			builder.append("\t");
		}
		builder.append("TEXT\n");
		++tabs;
		sentence.translate(builder, tabs);
		
		if(text != null) {
			text.translate(builder, tabs);
		}
	}
}
