package org.osate.xtext.aadl2.ui.editor.autoedit;

import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.ui.editor.autoedit.CompoundMultiLineTerminalsEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

public class Aadl2AutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Override
	protected void configure(IEditStrategyAcceptor acceptor) {
		configureIndentationEditStrategy(acceptor);
		configureStringLiteral(acceptor);
		configureParenthesis(acceptor);
		configureSquareBrackets(acceptor);
		configureAnnexBracesBlock(acceptor);
		configureCurlyBracesBlock(acceptor);
		configureMultilineComments(acceptor);
		configureCompoundBracesBlocks(acceptor);
		configureKeywordIndent(acceptor);
	}

	@Override
	protected void configureCompoundBracesBlocks(IEditStrategyAcceptor acceptor) {
		acceptor.accept(
				compoundMultiLineTerminals.newInstanceFor("{**", "**};").and("{ ", "}").and("[", "]").and("(", ")"),
				IDocument.DEFAULT_CONTENT_TYPE);
	}

	@Override
	protected void configureCurlyBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("{ ", "}"), IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureAnnexBracesBlock(IEditStrategyAcceptor acceptor) {
		acceptor.accept(singleLineTerminals.newInstance("{**", "**};"), IDocument.DEFAULT_CONTENT_TYPE);
	}

	protected void configureKeywordIndent(IEditStrategyAcceptor acceptor) {
		String[] keywords = { "public", "private", "abstract", "bus", "data", "device", "feature", "memory",
				"subprogram", "system", "thread", "process", "processor", "calls", "connections", "features", "flows",
				"modes", "properties", "prototypes", "subcomponents" };
		CompoundMultiLineTerminalsEditStrategy strategy = compoundMultiLineTerminals.newInstanceFor("is", ";");
		for (String keyword : keywords) {
			strategy = strategy.and(keyword, ";");
		}
		acceptor.accept(strategy, IDocument.DEFAULT_CONTENT_TYPE);
	}

}
