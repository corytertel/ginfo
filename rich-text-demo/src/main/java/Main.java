//package richtextdemo;

import static javafx.scene.input.KeyCode.*;
import static javafx.scene.input.KeyCombination.*;
import static org.fxmisc.wellbehaved.event.EventPattern.*;
import java.util.regex.Pattern;
import org.fxmisc.flowless.VirtualizedScrollPane;
import org.fxmisc.richtext.CaretNode;
import org.fxmisc.wellbehaved.event.EventPattern;
import org.fxmisc.wellbehaved.event.InputMap;
import org.fxmisc.wellbehaved.event.Nodes;
import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.DoubleStringConverter;

public class Main extends Application {

    String lorem_ispum = "Lorem ipsum dolor sit amet. A alias ipsa aut numquam iusto ut quod corporis. Sit voluptatem nemo ut odit voluptates id vero qui accusamus ipsa sed voluptatem dolores ea obcaecati beatae. Est quia sapiente ad magni quam et aliquid exercitationem et voluptas soluta et consequatur ipsum. Qui enim sint sed ratione libero est iusto necessitatibus.\n\nAut rerum nostrum qui alias commodi aut esse maxime nam modi natus. Et recusandae autem At blanditiis blanditiis et consequuntur quam et omnis adipisci non sint molestiae.\n\nHic distinctio totam non debitis voluptatem et vero voluptatem qui nihil voluptas. Est eius ipsum aut totam voluptas ex dolor reiciendis et illo modi rem deleniti itaque sit quis excepturi. Et officiis provident est atque incidunt est dolor accusantium aut praesentium harum. Est quasi vel debitis unde aliquid galisum At minus reprehenderit sed laborum debitis non ratione fuga.\n\nQui possimus autem qui blanditiis galisum et perferendis accusantium minima perferendis ex fugit internos est itaque perferendis aut sint esse. Eos molestias sunt et Quis quisquam est facilis aperiam sed nobis dicta sed inventore aliquam rem velit repellendus. Vel animi itaque aut explicabo officiis ut fugit omnis ea illo beatae et maiores quae.\n\nAt sapiente maiores est voluptatem veniam aut recusandae veritatis eos libero voluptas est enim deserunt et doloremque quia. Vel autem eligendi est illo debitis ad voluptatem necessitatibus et vitae recusandae et voluptatem dolor? Et vitae commodi et maiores perspiciatis eos Quis officia qui voluptatem eum magnam velit ut odit eveniet.\n\nAut molestiae soluta ut quia suscipit eum esse facere qui nihil porro ea debitis ducimus. Id consequatur iste et similique dolores vel quis Quis quo iste voluptatibus est eius fugit.\n\nLorem ipsum dolor sit amet. A alias ipsa aut numquam iusto ut quod corporis. Sit voluptatem nemo ut odit voluptates id vero qui accusamus ipsa sed voluptatem dolores ea obcaecati beatae. Est quia sapiente ad magni quam et aliquid exercitationem et voluptas soluta et consequatur ipsum. Qui enim sint sed ratione libero est iusto necessitatibus.\n\nAut rerum nostrum qui alias commodi aut esse maxime nam modi natus. Et recusandae autem At blanditiis blanditiis et consequuntur quam et omnis adipisci non sint molestiae.\n\nHic distinctio totam non debitis voluptatem et vero voluptatem qui nihil voluptas. Est eius ipsum aut totam voluptas ex dolor reiciendis et illo modi rem deleniti itaque sit quis excepturi. Et officiis provident est atque incidunt est dolor accusantium aut praesentium harum. Est quasi vel debitis unde aliquid galisum At minus reprehenderit sed laborum debitis non ratione fuga.\n\nQui possimus autem qui blanditiis galisum et perferendis accusantium minima perferendis ex fugit internos est itaque perferendis aut sint esse. Eos molestias sunt et Quis quisquam est facilis aperiam sed nobis dicta sed inventore aliquam rem velit repellendus. Vel animi itaque aut explicabo officiis ut fugit omnis ea illo beatae et maiores quae.\n\nAt sapiente maiores est voluptatem veniam aut recusandae veritatis eos libero voluptas est enim deserunt et doloremque quia. Vel autem eligendi est illo debitis ad voluptatem necessitatibus et vitae recusandae et voluptatem dolor? Et vitae commodi et maiores perspiciatis eos Quis officia qui voluptatem eum magnam velit ut odit eveniet.\n\nAut molestiae soluta ut quia suscipit eum esse facere qui nihil porro ea debitis ducimus. Id consequatur iste et similique dolores vel quis Quis quo iste voluptatibus est eius fugit.\n\nLorem ipsum dolor sit amet. A alias ipsa aut numquam iusto ut quod corporis. Sit voluptatem nemo ut odit voluptates id vero qui accusamus ipsa sed voluptatem dolores ea obcaecati beatae. Est quia sapiente ad magni quam et aliquid exercitationem et voluptas soluta et consequatur ipsum. Qui enim sint sed ratione libero est iusto necessitatibus.\n\nAut rerum nostrum qui alias commodi aut esse maxime nam modi natus. Et recusandae autem At blanditiis blanditiis et consequuntur quam et omnis adipisci non sint molestiae.\n\nHic distinctio totam non debitis voluptatem et vero voluptatem qui nihil voluptas. Est eius ipsum aut totam voluptas ex dolor reiciendis et illo modi rem deleniti itaque sit quis excepturi. Et officiis provident est atque incidunt est dolor accusantium aut praesentium harum. Est quasi vel debitis unde aliquid galisum At minus reprehenderit sed laborum debitis non ratione fuga.\n\nQui possimus autem qui blanditiis galisum et perferendis accusantium minima perferendis ex fugit internos est itaque perferendis aut sint esse. Eos molestias sunt et Quis quisquam est facilis aperiam sed nobis dicta sed inventore aliquam rem velit repellendus. Vel animi itaque aut explicabo officiis ut fugit omnis ea illo beatae et maiores quae.\n\nAt sapiente maiores est voluptatem veniam aut recusandae veritatis eos libero voluptas est enim deserunt et doloremque quia. Vel autem eligendi est illo debitis ad voluptatem necessitatibus et vitae recusandae et voluptatem dolor? Et vitae commodi et maiores perspiciatis eos Quis officia qui voluptatem eum magnam velit ut odit eveniet.\n\nAut molestiae soluta ut quia suscipit eum esse facere qui nihil porro ea debitis ducimus. Id consequatur iste et similique dolores vel quis Quis quo iste voluptatibus est eius fugit.";


    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
	Stage window = primaryStage;
	VBox root = new VBox(0);
	Scene mainScene = new Scene(root, 600, 800);



	GinfoTextArea area = new GinfoTextArea(lorem_ispum);
	area.setWrapText(true);
	area.setStyle("-fx-font: normal 12pt \"OxygenMono Nerd Font\";");
	area.moveTo(0);


	// area.selectRange(3, 17);
	area.underlineRange(24, 40, "blue");

	EventPattern<Event, KeyEvent>[] events;

	InputMap<Event> preventTyping = InputMap.consume
	    (anyOf
	     (
	      // prevent selection via (CTRL + ) SHIFT + [LEFT, UP, DOWN]

	      // keyPressed(KeyCombination.valueOf("a"))

	      //keyPressed(LEFT,    SHIFT_DOWN, SHORTCUT_ANY),
	      // keyPressed(KP_LEFT, SHIFT_DOWN, SHORTCUT_ANY),
	      // keyPressed(UP,    SHIFT_DOWN, SHORTCUT_ANY),
	      // keyPressed(KP_UP, SHIFT_DOWN, SHORTCUT_ANY),
	      // keyPressed(DOWN,    SHIFT_DOWN, SHORTCUT_ANY),
	      // keyPressed(KP_DOWN, SHIFT_DOWN, SHORTCUT_ANY),

	      // // prevent selection via mouse eventsdf
	      // eventType(MouseEvent.MOUSE_DRAGGED),
	      // eventType(MouseEvent.DRAG_DETECTED),
	      // mousePressed().unless(e -> e.getClickCount() == 1 && !e.isShiftDown()),

	      // // prevent any right arrow movement, regardless of modifiers
	      // keyPressed(RIGHT,     SHORTCUT_ANY, SHIFT_ANY),
	      // keyPressed(KP_RIGHT,  SHORTCUT_ANY, SHIFT_ANY)
	      keyPressed(A,     SHORTCUT_ANY, SHIFT_ANY)
	      )
	     );
        Nodes.addInputMap(area, preventTyping);

	VirtualizedScrollPane<GinfoTextArea> scrollPane = new VirtualizedScrollPane<GinfoTextArea>(area);

	// ScrollPane scrollWrapper = new ScrollPane();
	// scrollWrapper.setContent(area);
	// scrollWrapper.setFitToWidth(true);
	// scrollWrapper.setHbarPolicy(ScrollBarPolicy.NEVER);
	// scrollWrapper.setVbarPolicy(ScrollBarPolicy.ALWAYS);

	GinfoMenuBar menuBar = new GinfoMenuBar(area);

	// root.getChildren().addAll(menuBar, scrollWrapper);
	root.getChildren().addAll(menuBar, scrollPane);
	// VBox.setVgrow(scrollWrapper, Priority.ALWAYS);

	window.setScene(mainScene);
	window.setTitle("ginfo-prototype");
	window.show();

	area.setPrefSize(window.getWidth(), window.getHeight() - menuBar.getHeight());
    }
}
