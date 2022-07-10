import static org.fxmisc.richtext.model.TwoDimensional.Bias.*;

import org.fxmisc.flowless.Cell;
import org.fxmisc.richtext.CharacterHit;
import org.fxmisc.richtext.InlineCssTextArea;
import org.fxmisc.richtext.model.Paragraph;
import org.fxmisc.richtext.model.TwoDimensional;

public class GinfoTextArea extends InlineCssTextArea {

    public GinfoTextArea(String string) {
	super(string);
    }

    public void underlineRange(int from, int to, String color) {
	String underline = "-rtfx-underline-color: " + color + "; " +
	    "-rtfx-underline-width: 2.0;";
	this.setStyle(from, to, underline);
    }

    public void boldRange(int from, int to, String color) {
	String bold = "-rtfx-bold-color: " + color + ";";
	this.setStyle(from, to, bold);
    }


    @Override
    public void replaceText(int start, int end, String text) {
	// String current = getText();
	// // only insert if no new lines after insert position:
	// if (! current.substring(start).contains("\n")) {
	//     super.replaceText(start, end, text);
	// }
	return;
    }

    @Override
    public void replaceSelection(String text) {
	// String current = getText();
	// int selectionStart = getSelection().getStart();
	// if (! current.substring(selectionStart).contains("\n")) {
	//     super.replaceSelection(text);
	// }
	return;
    }

    public void skipToPrevWord(SelectionPolicy selectionPolicy) {
        int caretPos = getCaretPosition();

        // if (0 == caretPos), do nothing as can't move to the left anyway
        if (1 <= caretPos ) {
            boolean prevCharIsWhiteSpace = Character.isWhitespace(getText(caretPos - 1, caretPos).charAt(0));
            wordBreaksBackwards(prevCharIsWhiteSpace ? 2 : 1, selectionPolicy);
        }
    }

    public void skipToNextWord(SelectionPolicy selectionPolicy) {
        int caretPos = getCaretPosition();
        int length = getLength();

        // if (caretPos == length), do nothing as can't move to the right anyway
        if (caretPos <= length - 1) {
            boolean nextCharIsWhiteSpace = Character.isWhitespace(getText(caretPos, caretPos + 1).charAt(0));
            wordBreaksForwards(nextCharIsWhiteSpace ? 2 : 1, selectionPolicy);
        }
    }
}
