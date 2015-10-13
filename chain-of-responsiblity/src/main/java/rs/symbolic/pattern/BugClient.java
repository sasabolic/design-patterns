package rs.symbolic.pattern;

/**
 * The client used to invoke chain processing.
 */
public class BugClient {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        BugHandler handler = createFlow();

        handler.handleRequest(new BugRequest("Title-1", BugRequest.Type.HIGH));
        handler.handleRequest(new BugRequest("Title-2", BugRequest.Type.LOW));
        handler.handleRequest(new BugRequest("Title-3", BugRequest.Type.MEDIUM));
    }

    private static BugHandler createFlow() {
        BugHandler lowPriorityBugHandler = new LowPriorityBugHandler();
        BugHandler mediumPriorityBugHandler = new MediumPriorityBugHandler();
        BugHandler highPriorityBugHandler = new HighPriorityBugHandler();

        lowPriorityBugHandler.setNext(mediumPriorityBugHandler);
        mediumPriorityBugHandler.setNext(highPriorityBugHandler);

        return lowPriorityBugHandler;
    }

}
