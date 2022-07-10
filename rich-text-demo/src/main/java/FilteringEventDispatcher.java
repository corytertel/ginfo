import java.util.Set;
import javafx.event.Event;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

public class FilteringEventDispatcher implements EventDispatcher {

    private final EventDispatcher delegate;
    private final Set<KeyCombination> blacklistedCombos;

    public FilteringEventDispatcher(EventDispatcher delegate, KeyCombination... blacklistedCombos) {
	this.delegate = delegate;
	this.blacklistedCombos = Set.of(blacklistedCombos);
    }

    @Override
    public Event dispatchEvent(Event event, EventDispatchChain tail) {
	if(!(event instanceof KeyEvent) || isPermitted((KeyEvent) event))
	    return delegate.dispatchEvent(event, tail); // forward event to TextArea
	else
	    return event;
    }

    private boolean isPermitted(KeyEvent event) {
	return blacklistedCombos.stream().noneMatch(combo -> combo.match(event));
    }
}
