import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.skin.TextAreaSkin;
import javafx.scene.control.skin.TextInputControlSkin.Direction;
import javafx.scene.control.skin.TextInputControlSkin.TextUnit;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.HitInfo;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.web.HTMLEditor;

/*
 * Prototype features:
 * Have a search box to search for info manuals
 * Display text that dynamically resizes when the window resizes
 * Have a menu bar (file, edit, view, etc) that has clicable options
 * Have keybindings that you can configure. There are preset options
 such as Emacs, CUA, Vim, and Kakuone, but you can easily make more
 , but clicking "create custom keybinding"
 * Able to change colors through options
 * Have links and searched for text be colors by default
 * Can set font through options
 * Has a config file
 * Able to support multiple different keyboards
 */


public class Main extends Application {

    String lorem_ispum = "Lorem ipsum dolor sit amet. A alias ipsa aut numquam iusto ut quod corporis. Sit voluptatem nemo ut odit voluptates id vero qui accusamus ipsa sed voluptatem dolores ea obcaecati beatae. Est quia sapiente ad magni quam et aliquid exercitationem et voluptas soluta et consequatur ipsum. Qui enim sint sed ratione libero est iusto necessitatibus.\n\nAut rerum nostrum qui alias commodi aut esse maxime nam modi natus. Et recusandae autem At blanditiis blanditiis et consequuntur quam et omnis adipisci non sint molestiae.\n\nHic distinctio totam non debitis voluptatem et vero voluptatem qui nihil voluptas. Est eius ipsum aut totam voluptas ex dolor reiciendis et illo modi rem deleniti itaque sit quis excepturi. Et officiis provident est atque incidunt est dolor accusantium aut praesentium harum. Est quasi vel debitis unde aliquid galisum At minus reprehenderit sed laborum debitis non ratione fuga.\n\nQui possimus autem qui blanditiis galisum et perferendis accusantium minima perferendis ex fugit internos est itaque perferendis aut sint esse. Eos molestias sunt et Quis quisquam est facilis aperiam sed nobis dicta sed inventore aliquam rem velit repellendus. Vel animi itaque aut explicabo officiis ut fugit omnis ea illo beatae et maiores quae.\n\nAt sapiente maiores est voluptatem veniam aut recusandae veritatis eos libero voluptas est enim deserunt et doloremque quia. Vel autem eligendi est illo debitis ad voluptatem necessitatibus et vitae recusandae et voluptatem dolor? Et vitae commodi et maiores perspiciatis eos Quis officia qui voluptatem eum magnam velit ut odit eveniet.\n\nAut molestiae soluta ut quia suscipit eum esse facere qui nihil porro ea debitis ducimus. Id consequatur iste et similique dolores vel quis Quis quo iste voluptatibus est eius fugit.\n\nLorem ipsum dolor sit amet. A alias ipsa aut numquam iusto ut quod corporis. Sit voluptatem nemo ut odit voluptates id vero qui accusamus ipsa sed voluptatem dolores ea obcaecati beatae. Est quia sapiente ad magni quam et aliquid exercitationem et voluptas soluta et consequatur ipsum. Qui enim sint sed ratione libero est iusto necessitatibus.\n\nAut rerum nostrum qui alias commodi aut esse maxime nam modi natus. Et recusandae autem At blanditiis blanditiis et consequuntur quam et omnis adipisci non sint molestiae.\n\nHic distinctio totam non debitis voluptatem et vero voluptatem qui nihil voluptas. Est eius ipsum aut totam voluptas ex dolor reiciendis et illo modi rem deleniti itaque sit quis excepturi. Et officiis provident est atque incidunt est dolor accusantium aut praesentium harum. Est quasi vel debitis unde aliquid galisum At minus reprehenderit sed laborum debitis non ratione fuga.\n\nQui possimus autem qui blanditiis galisum et perferendis accusantium minima perferendis ex fugit internos est itaque perferendis aut sint esse. Eos molestias sunt et Quis quisquam est facilis aperiam sed nobis dicta sed inventore aliquam rem velit repellendus. Vel animi itaque aut explicabo officiis ut fugit omnis ea illo beatae et maiores quae.\n\nAt sapiente maiores est voluptatem veniam aut recusandae veritatis eos libero voluptas est enim deserunt et doloremque quia. Vel autem eligendi est illo debitis ad voluptatem necessitatibus et vitae recusandae et voluptatem dolor? Et vitae commodi et maiores perspiciatis eos Quis officia qui voluptatem eum magnam velit ut odit eveniet.\n\nAut molestiae soluta ut quia suscipit eum esse facere qui nihil porro ea debitis ducimus. Id consequatur iste et similique dolores vel quis Quis quo iste voluptatibus est eius fugit.\n\nLorem ipsum dolor sit amet. A alias ipsa aut numquam iusto ut quod corporis. Sit voluptatem nemo ut odit voluptates id vero qui accusamus ipsa sed voluptatem dolores ea obcaecati beatae. Est quia sapiente ad magni quam et aliquid exercitationem et voluptas soluta et consequatur ipsum. Qui enim sint sed ratione libero est iusto necessitatibus.\n\nAut rerum nostrum qui alias commodi aut esse maxime nam modi natus. Et recusandae autem At blanditiis blanditiis et consequuntur quam et omnis adipisci non sint molestiae.\n\nHic distinctio totam non debitis voluptatem et vero voluptatem qui nihil voluptas. Est eius ipsum aut totam voluptas ex dolor reiciendis et illo modi rem deleniti itaque sit quis excepturi. Et officiis provident est atque incidunt est dolor accusantium aut praesentium harum. Est quasi vel debitis unde aliquid galisum At minus reprehenderit sed laborum debitis non ratione fuga.\n\nQui possimus autem qui blanditiis galisum et perferendis accusantium minima perferendis ex fugit internos est itaque perferendis aut sint esse. Eos molestias sunt et Quis quisquam est facilis aperiam sed nobis dicta sed inventore aliquam rem velit repellendus. Vel animi itaque aut explicabo officiis ut fugit omnis ea illo beatae et maiores quae.\n\nAt sapiente maiores est voluptatem veniam aut recusandae veritatis eos libero voluptas est enim deserunt et doloremque quia. Vel autem eligendi est illo debitis ad voluptatem necessitatibus et vitae recusandae et voluptatem dolor? Et vitae commodi et maiores perspiciatis eos Quis officia qui voluptatem eum magnam velit ut odit eveniet.\n\nAut molestiae soluta ut quia suscipit eum esse facere qui nihil porro ea debitis ducimus. Id consequatur iste et similique dolores vel quis Quis quo iste voluptatibus est eius fugit.";

    int markSet = -1;
    int cursorIndex = 0;
    boolean cursorOn = true;
    TextFlow flow;
    double charHeight = 0.0;
    double charWidth = 0.0;
    double posX = 0.0;
    double posY = 0.0;

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	Stage window = primaryStage;
	VBox root = new VBox(0);
	Scene mainScene = new Scene(root, 600, 800);

	Font font = Font.font("VictorMono Nerd Font", FontWeight.NORMAL, 14);

	ScrollPane scrollWrapper = new ScrollPane();
	scrollWrapper.setContent(displayString(lorem_ispum, cursorIndex, font));
	scrollWrapper.setFitToWidth(true);
	scrollWrapper.setHbarPolicy(ScrollBarPolicy.NEVER);
	scrollWrapper.setVbarPolicy(ScrollBarPolicy.ALWAYS);

	KeyFrame blink = new KeyFrame(Duration.seconds(0.5), e -> {
		cursorOn = !cursorOn;
		scrollWrapper.setContent(displayString(lorem_ispum, cursorIndex, font));
	});
	Timeline timeline = new Timeline(blink);
	timeline.setCycleCount(Animation.INDEFINITE); // loop forever
	timeline.play();

	Menu menuFile = new Menu("File");
	Menu menuEdit = new Menu("Edit");
	Menu menuView = new Menu("View");
	Menu menuOptions = new Menu("Options");
	Menu menuHelp = new Menu("Help");

	MenuItem saveItem = new MenuItem("Save");
	menuFile.getItems().add(saveItem);

	// "C-a"
	// MenuItem beginningItem = new MenuItem("Beginning of Line");
	// beginningItem.setAccelerator(KeyCombination.valueOf("ctrl+a"));
	// beginningItem.setOnAction(e -> {
	// 	int pos = textArea.getCaretPosition();
	// 	while(pos != 0 && textArea.getText().charAt(pos - 1) != '\n') {
	// 	    pos--;
	// 	    if(markSet < 0)
	// 		textArea.backward();
	// 	    else
	// 		textArea.selectBackward();
	// 	}
	//     });

	// menuEdit.getItems().addAll(beginningItem, pageUpItem, pageDownItem);
	menuEdit.getItems().addAll
	    (
	     createKeybind("Page Up", "alt+v", e -> {
		    scrollWrapper.setVvalue
			(scrollWrapper.getVvalue() - scrollWrapper.getHeight());
		}),
	     createKeybind("Page Down", "ctrl+v", e -> {
		     scrollWrapper.setVvalue
			 (scrollWrapper.getVvalue() + scrollWrapper.getHeight());
		 }),
	     createKeybind("Forward Character", "ctrl+f", e -> {
		     cursorIndex++;
		     posX += charWidth;
		     scrollWrapper.setContent(displayString(lorem_ispum, cursorIndex, font));
		 }),
	     createKeybind("Backward Character", "ctrl+b", e -> {
		     cursorIndex--;
		     posX -= charWidth;
		     scrollWrapper.setContent(displayString(lorem_ispum, cursorIndex, font));
		 }),
	     createKeybind("Up Character", "ctrl+p", e-> {
		     int foundIndex;
		     do {
			 posY -= charHeight;
			 foundIndex = flow.hitTest(new Point2D(posX, posY)).getCharIndex();
		     } while(foundIndex == cursorIndex);
		     cursorIndex = foundIndex;
		     scrollWrapper.setContent(displayString(lorem_ispum, cursorIndex, font));
		 }),
	     createKeybind("Down Character", "ctrl+n", e-> {
		     int foundIndex;
		     do {
			 posY += charHeight;
			 foundIndex = flow.hitTest(new Point2D(posX, posY)).getCharIndex();
		     } while(foundIndex == cursorIndex);
		     cursorIndex = foundIndex;
		     scrollWrapper.setContent(displayString(lorem_ispum, cursorIndex, font));
		 })
	     );

	MenuBar menuBar = new MenuBar();
	menuBar.setUseSystemMenuBar(true);
	menuBar.getMenus().addAll(menuFile, menuEdit, menuView, menuOptions, menuHelp);

	// // textArea.setEventDispatcher
	// //     (new FilteringEventDispatcher
	// //      (textArea.getEventDispatcher(),
	// //       // cutItem.getAccelerator(),
	// //       // copyItem.getAccelerator(),
	// //       // pasteItem.getAccelerator(),
	// //       beginningItem.getAccelerator(),
	// //       pageUpItem.getAccelerator(),
	// //       pageDownItem.getAccelerator()));

	// textArea.setOnKeyPressed(e -> {
	// 	// if(e.getCode() == KeyCode.ENTER) {
	// 	//     var caretPos = textArea.getCaretPosition();
	// 	//     textArea.setText(lorem_ispum);
	// 	//     textArea.positionCaret(caretPos - 2);
	// 	// }

	// 	// else if(e.getCode() == KeyCode.SPACE) {
	// 	//     textArea.undo();
	// 	//     textArea.forward();
	// 	//     e.consume();
	// 	// }

	// 	// else if(e.getCode() == KeyCode.BACK_SPACE || e.getCode() == KeyCode.DELETE) {
	// 	//     textArea.undo();
	// 	//     textArea.backward();
	// 	// }

	// 	//
	// 	// Movement
	// 	//

	// 	// "C-n"
	// 	if(e.getCode() == KeyCode.N && e.isControlDown()) {
	// 	    TextAreaSkin skin = (TextAreaSkin) textArea.getSkin();
	// 	    if(markSet < 0)
	// 		skin.moveCaret(TextUnit.LINE, Direction.DOWN, false);
	// 	    else
	// 		skin.moveCaret(TextUnit.LINE, Direction.DOWN, true);
	// 	}

	// 	// "C-p"
	// 	else if(e.getCode() == KeyCode.P && e.isControlDown()) {
	// 	    TextAreaSkin skin = (TextAreaSkin) textArea.getSkin();
	// 	    if(markSet < 0)
	// 		skin.moveCaret(TextUnit.LINE, Direction.UP, false);
	// 	    else
	// 		skin.moveCaret(TextUnit.LINE, Direction.UP, true);
	// 	}

	// 	// "C-f"
	// 	else if(e.getCode() == KeyCode.F && e.isControlDown()) {
	// 	    if(markSet < 0)
	// 		textArea.forward();
	// 	    else
	// 		textArea.selectForward();
	// 	}

	// 	// "C-b"
	// 	else if(e.getCode() == KeyCode.B && e.isControlDown()) {
	// 	    if(markSet < 0)
	// 		textArea.backward();
	// 	    else
	// 		textArea.selectBackward();
	// 	}

	// 	// "M-f "
	// 	else if(e.getCode() == KeyCode.F && e.isAltDown()) {
	// 	    if(markSet < 0)
	// 		textArea.endOfNextWord();
	// 	    else
	// 		textArea.selectEndOfNextWord();
	// 	}

	// 	// "M-b"
	// 	else if(e.getCode() == KeyCode.B && e.isAltDown()) {
	// 	    if(markSet < 0)
	// 		textArea.previousWord();
	// 	    else
	// 		textArea.selectPreviousWord();
	// 	}

	// 	// "C-a"
	// 	// Built-in keybinding and must be handled differently

	// 	// "C-e "
	// 	else if (e.getCode() == KeyCode.E && e.isControlDown()) {
	// 	    int pos = textArea.getCaretPosition();
	// 	    while(textArea.getText().charAt(pos) != '\n'
	// 		  && pos != textArea.getText().length()) {
	// 		pos++;
	// 		if(markSet < 0)
	// 		    textArea.forward();
	// 		else
	// 		    textArea.selectForward();
	// 	    }
	// 	}

	// 	// "M-<"
	// 	else if(e.getCode() == KeyCode.COMMA && e.isShiftDown() && e.isAltDown()) {
	// 	    textArea.setScrollTop(0);
	// 	    if(markSet < 0)
	// 		textArea.home();
	// 	    else
	// 		textArea.selectHome();
	// 	}

	// 	// "M->"
	// 	else if(e.getCode() == KeyCode.PERIOD && e.isShiftDown() && e.isAltDown()) {
	// 	    textArea.setScrollTop(Integer.MAX_VALUE);
	// 	    if(markSet < 0)
	// 		textArea.end();
	// 	    else
	// 		textArea.selectEnd();
	// 	}

	// 	//
	// 	// Misc
	// 	//

	// 	// "C-SPC"
	// 	else if(e.getCode() == KeyCode.SPACE && e.isControlDown()) {
	// 	    if(markSet < 0)
	// 		markSet = textArea.getCaretPosition();
	// 	    else if(markSet == textArea.getCaretPosition()) {
	// 		textArea.deselect();
	// 		markSet = -1;
	// 	    }
	// 	    else {
	// 		textArea.deselect();
	// 		markSet = textArea.getCaretPosition();
	// 	    }
	// 	}


	// 	else if(e.getCode() == KeyCode.G && e.isControlDown()) {
	// 	    if(markSet >= 0) {
	// 		textArea.deselect();
	// 		markSet = -1;
	// 	    }
	// 	}


	// 	// Undo what has been done to the text
	// 	else if(!e.isControlDown() && !e.isAltDown()){
	// 	    System.out.println(e.getCode());
	// 	    var caretPos = textArea.getCaretPosition();
	// 	    textArea.setText(lorem_ispum);
	// 	    textArea.positionCaret(caretPos - 1);
	// 	}
	// });


	// cursor.setBackground
	//     (new Background(new BackgroundFill
	// 		    (Color.BLACK,
	// 		     CornerRadii.EMPTY,
	// 		     Insets.EMPTY)));

	root.getChildren().addAll(menuBar, scrollWrapper);
	VBox.setVgrow(scrollWrapper, Priority.ALWAYS);

	window.setScene(mainScene);
	window.setTitle("ginfo-prototype");
	window.show();

	while(flow.hitTest(new Point2D(0.0, charHeight)).getCharIndex() == 0) {
	    charHeight += 0.01;
	}
	System.out.println("charHeight: " + charHeight);

	while(flow.hitTest(new Point2D(charWidth, 0.0)).getCharIndex() == 0) {
	    charWidth += 0.01;
	}
	System.out.println("charWidth: " + charWidth);

    }

    // private TextFlow displayString(String string, int cursorIndex, Font font) {
    // 	if(cursorIndex < 0)
    // 	    cursorIndex = 0;
    // 	TextFlow flow = new TextFlow();
    // 	var flowChildren = flow.getChildren();
    // 	for(int i = 0; i < string.length(); i++) {
    // 	    Text text = new Text(Character.toString(string.charAt(i)));
    // 	    text.setFont(font);
    // 	    VBox wrapper = new VBox(text);
    // 	    if(i == cursorIndex)
    // 		wrapper.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    // 	    flowChildren.add(wrapper);
    // 	}
    // 	return flow;
    // }

    private TextFlow displayString(String string, int cursorIndex, Font font) {
	if(cursorIndex < 0)
	    cursorIndex = 0;

	flow = new TextFlow();

	Text startText = new Text(string.substring(0, cursorIndex));
	startText.setFont(font);

	Text cursorText;
	if(cursorOn)
	    cursorText = new Text("█");
	else
	    cursorText = new Text(string.substring(cursorIndex, cursorIndex + 1));
	cursorText.setFont(font);
	// VBox wrapper = new VBox(cursorText);
	// wrapper.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
	cursorText.setFill(Color.RED);

	Text endText = new Text(string.substring(cursorIndex + 1));
	endText.setFont(font);

	flow.getChildren().addAll(startText, cursorText, endText);

	return flow;
    }

private double getCharPixelWidth(Font font) {
	Text text = new Text(Character.toString('a'));
	text.setFont(font);
	VBox wrapper = new VBox(text);
	return wrapper.getWidth();
    }

    private MenuItem createKeybind(String name, String keyCombo, EventHandler<ActionEvent> action) {
	MenuItem item = new MenuItem(name);
	item.setAccelerator(KeyCombination.valueOf(keyCombo));
	item.setOnAction(action);
	return item;
    }

    // private void setBackgroundColors(Scene scene, FlowPane flow) {
    // 	final List<Integer> indices = Arrays.asList(0);
    // 	final Bounds out = flow.getBoundsInLocal();
    // 	final StringBuilder sbColors = new StringBuilder();
    // 	final StringBuilder sbInsets = new StringBuilder();
    // 	AtomicInteger cont = new AtomicInteger();
    // 	flow.getChildrenUnmodifiable().forEach(n->{
    // 		sbColors.append("hsb(")
    // 		    .append((double)indices.get(cont.get())/(double)(indices.get(flow.getChildren().size()-1)+1)*360d)
    // 		    .append(", 60%, 90%)");
    // 		Bounds b = ((Text)n).getBoundsInParent();
    // 		sbInsets.append(b.getMinY()).append(" ");
    // 		sbInsets.append(Math.min(scene.getWidth(),out.getMaxX())-b.getMaxX()-1).append(" ");
    // 		sbInsets.append(Math.min(scene.getHeight(),out.getMaxY())-b.getMaxY()).append(" ");
    // 		sbInsets.append(b.getMinX());
    // 		if(cont.getAndIncrement()<flow.getChildren().size()-1){
    // 		    sbColors.append(", ");
    // 		    sbInsets.append(", ");
    // 		}
    // 	    });
    // 	flow.setStyle("-fx-background-color: "+sbColors.toString()+"; -fx-background-insets: "+sbInsets.toString()+";");
    // }
}
