package io.sixhours.pattern;


/**
 * The interface of handler used in a chain.
 */
public interface BugHandler {
    /**
     * Sets next handler in the chain.
     *
     * @param handler the handler
     */
    void setNext(BugHandler handler);

    /**
     * Handles request.
     *
     * @param bug the bug
     */
    void handleRequest(BugRequest bug);
}
