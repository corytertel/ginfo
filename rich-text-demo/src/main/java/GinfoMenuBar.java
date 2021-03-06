import org.fxmisc.richtext.NavigationActions.SelectionPolicy;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.skin.TextAreaSkin;
import javafx.scene.input.KeyCombination;

public class GinfoMenuBar extends MenuBar {

    private MenuItem beginningOfLine;
    private MenuItem endOfLine;
    private MenuItem forwardChar;
    private MenuItem backwardChar;
    private MenuItem forwardWord;
    private MenuItem backwardWord;
    private MenuItem nextLine;
    private MenuItem previousLine;
    private MenuItem beginningOfFile;
    private MenuItem endOfFile;
    private MenuItem pageUp;
    private MenuItem pageDown;
    private MenuItem setMark;
    private MenuItem globalCancel;

    private int markSet;
    private boolean verticalMovement;

    public GinfoMenuBar(GinfoTextArea area) throws Exception {
	markSet = -1;
	verticalMovement = false;

	Menu menuFile = new Menu("File");
	MenuItem saveItem = new MenuItem("Save");
	menuFile.getItems().add(saveItem);

	Menu menuEdit = new Menu("Edit");

	beginningOfLine = createKeybind("Beginning of Line", "ctrl+a", e -> {
		verticalMovement = false;
		int caretPos = area.getCaretPosition();
		int iniCaretPos = caretPos;
		double iniPosX = area.getCaretBounds().orElseThrow().getMinX();
		double movePosX = iniPosX;

		while(caretPos != 0) {
		    area.moveTo(caretPos - 1);
		    movePosX = area.getCaretBounds().orElseThrow().getMinX();

		    if(movePosX >= iniPosX) {
			area.moveTo(caretPos);
			if(markSet >= 0)
			    area.selectRange(iniCaretPos, caretPos);
			break;
		    }
		    else
			caretPos--;
		}
	    });

	endOfLine = createKeybind("End of Line", "ctrl+e", e -> {
		verticalMovement = false;
		int caretPos = area.getCaretPosition();
		int iniCaretPos = caretPos;
		double iniPosX = area.getCaretBounds().orElseThrow().getMaxX();
		double movePosX = iniPosX;

		while(caretPos != area.getText().length()) {
		    area.moveTo(caretPos + 1);
		    movePosX = area.getCaretBounds().orElseThrow().getMaxX();

		    if(movePosX <= iniPosX) {
			area.moveTo(caretPos);
			if(markSet >= 0)
			    area.selectRange(iniCaretPos, caretPos);
			break;
		    }
		    else
			caretPos++;
		}
	    });

	nextLine = createKeybind("Next Line", "ctrl+n", e -> {
		verticalMovement = true;
		if(markSet < 0) {
		    area.nextLine(SelectionPolicy.CLEAR);

		    int pos = area.getCaretPosition();
		    area.prevLine(SelectionPolicy.CLEAR);
		    area.moveTo(pos, SelectionPolicy.CLEAR);
		}
		else {
		    area.nextLine(SelectionPolicy.ADJUST);
		    int pos = area.getCaretPosition();
		    area.prevLine(SelectionPolicy.ADJUST);
		    area.moveTo(pos, SelectionPolicy.ADJUST);
		}
		area.requestFollowCaret();
	    });

	previousLine = createKeybind("Previous Line", "ctrl+p", e -> {
		verticalMovement = true;
		if(markSet < 0) {
		    area.prevLine(SelectionPolicy.CLEAR);
		    int pos = area.getCaretPosition();
		    area.nextLine(SelectionPolicy.CLEAR);
		    area.moveTo(pos, SelectionPolicy.CLEAR);
		}
		else {
		    area.prevLine(SelectionPolicy.ADJUST);
		    int pos = area.getCaretPosition();
		    area.nextLine(SelectionPolicy.ADJUST);
		    area.moveTo(pos, SelectionPolicy.ADJUST);
		}
		area.requestFollowCaret();
	    });

	forwardChar = createKeybind("Forward Character", "ctrl+f", e -> {
		verticalMovement = false;
		if(markSet < 0)
		    area.nextChar(SelectionPolicy.CLEAR);
		else
		    area.nextChar(SelectionPolicy.ADJUST);
		area.requestFollowCaret();
	    });

	backwardChar = createKeybind("Backward Character", "ctrl+b", e -> {
		verticalMovement = false;
		if(markSet < 0)
		    area.previousChar(SelectionPolicy.CLEAR);
		else
		    area.previousChar(SelectionPolicy.ADJUST);
		area.requestFollowCaret();
	    });

	forwardWord = createKeybind("Forward Word", "alt+f", e -> {
		verticalMovement = false;
		if(markSet < 0)
		    area.skipToNextWord(SelectionPolicy.CLEAR);
		else
		    area.skipToNextWord(SelectionPolicy.ADJUST);
		area.requestFollowCaret();
	    });

	backwardWord = createKeybind("Backward Word", "alt+b", e -> {
		verticalMovement = false;
		if(markSet < 0)
		    area.skipToPrevWord(SelectionPolicy.CLEAR);
		else
		    area.skipToPrevWord(SelectionPolicy.ADJUST);
		area.requestFollowCaret();
	    });

	beginningOfFile = createKeybind("Beginning of File", "alt+shift+comma", e -> {
		verticalMovement = false;
		if(markSet < 0)
		    area.moveTo(0, SelectionPolicy.CLEAR);
		else
		    area.moveTo(0, SelectionPolicy.ADJUST);
		area.requestFollowCaret();
	    });

	endOfFile = createKeybind("End of File", "alt+shift+period", e -> {
		verticalMovement = false;
		if(markSet < 0)
		    area.moveTo(area.getText().length(), SelectionPolicy.CLEAR);
		else
		    area.moveTo(area.getText().length(), SelectionPolicy.ADJUST);
		area.requestFollowCaret();
	    });

	pageUp = createKeybind("Page Up", "alt+v", e -> {
		verticalMovement = false;
		if(markSet < 0)
		    area.prevPage(SelectionPolicy.CLEAR);
		else
		    area.prevPage(SelectionPolicy.ADJUST);
		area.requestFollowCaret();
	    });

	pageDown = createKeybind("Page Down", "ctrl+v", e -> {
		verticalMovement = false;
		if(markSet < 0)
		    area.nextPage(SelectionPolicy.CLEAR);
		else
		    area.nextPage(SelectionPolicy.ADJUST);
		area.requestFollowCaret();
	    });

	setMark = createKeybind("Set Mark", "ctrl+space", e -> {
		if(markSet < 0)
		    markSet = area.getCaretPosition();
		else if(markSet == area.getCaretPosition()) {
		    area.deselect();
		    markSet = -1;
		}
		else {
		    area.deselect();
		    markSet = area.getCaretPosition();
		}
	    });

	globalCancel = createKeybind("Global Cancel", "ctrl+g", e -> {
		if(markSet >= 0) {
		    area.deselect();
		    markSet = -1;
		}
	    });

	menuEdit.getItems().addAll
	    (beginningOfLine,
	     endOfLine,
	     forwardChar,
	     backwardChar,
	     forwardWord,
	     backwardWord,
	     nextLine,
	     previousLine,
	     beginningOfFile,
	     endOfFile,
	     pageUp,
	     pageDown,
	     setMark,
	     globalCancel
	     );

	Menu menuView = new Menu("View");

	Menu menuOptions = new Menu("Options");

	Menu menuHelp = new Menu("Help");

	this.setUseSystemMenuBar(true);
	this.getMenus().addAll(menuFile, menuEdit, menuView, menuOptions, menuHelp);

	area.setEventDispatcher
	    (new FilteringEventDispatcher
	     (area.getEventDispatcher(),
	      beginningOfLine.getAccelerator(),
	      endOfLine.getAccelerator(),
	      forwardChar.getAccelerator(),
	      backwardChar.getAccelerator(),
	      forwardWord.getAccelerator(),
	      backwardWord.getAccelerator(),
	      nextLine.getAccelerator(),
	      previousLine.getAccelerator(),
	      beginningOfFile.getAccelerator(),
	      endOfFile.getAccelerator(),
	      pageUp.getAccelerator(),
	      pageDown.getAccelerator(),
	      setMark.getAccelerator(),
	      globalCancel.getAccelerator()
	      ));
    }

    private MenuItem createKeybind(String name, String keyCombo, EventHandler<ActionEvent> action) {
	MenuItem item = new MenuItem(name);
	item.setAccelerator(KeyCombination.valueOf(keyCombo));
	item.setOnAction(action);
	return item;
    }
}
