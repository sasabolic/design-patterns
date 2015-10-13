package rs.symbolic.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * The type used to handle low priority bugs.
 */
public class LowPriorityBugHandler implements BugHandler {
    private static final Logger log = LoggerFactory.getLogger(LowPriorityBugHandler.class);

    private BugHandler next;

    @Override
    public void setNext(BugHandler handler) {
        this.next = Objects.requireNonNull(handler, "Handler cannot be null");
    }

    @Override
    public void handleRequest(BugRequest bug) {
        Objects.requireNonNull(bug, "Bug request must not be null");
        if (BugRequest.Type.LOW == bug.getType()) {
            log.debug("Bug '" + bug.getTitle() + "' of type '" + bug.getType() + "' handled by Junior Developer");
        } else if (this.next != null) {
            this.next.handleRequest(bug);
        }
    }


}
