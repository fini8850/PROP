package prop.assignment0.parser;

import java.io.IOException;

import prop.assignment0.node.INode;
import prop.assignment0.token.TokenizerException;

public interface IParser {
	/**
	 * Opens a file for parsing.
	 */
	void open(String fileName) throws IOException, TokenizerException;
	
	/**
	 * Parses a program from file returning a parse tree (the root node of a parse tree).
	 */
	INode parse() throws IOException, TokenizerException, ParserException;

	/**
	 * Closes the file and releases any system resources associated with it.
	 */
	public void close() throws IOException ;
}