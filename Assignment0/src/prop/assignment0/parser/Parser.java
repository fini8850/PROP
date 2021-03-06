package prop.assignment0.parser;

import java.io.IOException;

import prop.assignment0.node.BlockNode;
import prop.assignment0.node.INode;
import prop.assignment0.token.Tokenizer;
import prop.assignment0.token.TokenizerException;

public class Parser implements IParser{

	private Tokenizer tokenizer = new Tokenizer();
	
	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		tokenizer.open(fileName);
		
	}

	@Override
	public INode parse() throws IOException, TokenizerException,
			ParserException {
		
		tokenizer.moveNext();
		tokenizer.moveNext();
		return new BlockNode(tokenizer);
	}

	@Override
	public void close() throws IOException {
		tokenizer.close();
	}

}
