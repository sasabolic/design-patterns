package rs.symbolic.pattern;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.internal.matchers.Null;

import static org.mockito.Mockito.*;


/**
 * Test for Chain of Responsibility pattern.
 */
public class ChainOfResponsibilityTest {

    private BugHandler lowPriorityHandler;
    private BugHandler mediumPriorityHandler;
    private BugHandler highPriorityHandler;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    /**
     * Sets up the test.
     */
    @Before
    public void setUp() {
        lowPriorityHandler = spy(LowPriorityBugHandler.class);
        mediumPriorityHandler = spy(MediumPriorityBugHandler.class);
        highPriorityHandler = spy(HighPriorityBugHandler.class);


        lowPriorityHandler.setNext(mediumPriorityHandler);
        mediumPriorityHandler.setNext(highPriorityHandler);
    }

    /**
     * Tests processing of high priority bugs.
     */
    @Test
    public void testProcessHighHandler() {

        lowPriorityHandler.handleRequest(new BugRequest("Title", BugRequest.Type.HIGH));

        verify(lowPriorityHandler, times(1)).handleRequest(isA(BugRequest.class));
        verify(mediumPriorityHandler, times(1)).handleRequest(isA(BugRequest.class));
        verify(highPriorityHandler, times(1)).handleRequest(isA(BugRequest.class));
    }

    /**
     * Tests processing of medium priority bugs.
     */
    @Test
    public void testProcessMediumHandler() {

        lowPriorityHandler.handleRequest(new BugRequest("Title", BugRequest.Type.MEDIUM));

        verify(lowPriorityHandler, times(1)).handleRequest(isA(BugRequest.class));
        verify(mediumPriorityHandler, times(1)).handleRequest(isA(BugRequest.class));
        verify(highPriorityHandler, times(0)).handleRequest(isA(BugRequest.class));
    }

    /**
     * Tests processing of low priority bugs.
     */
    @Test
    public void testProcessLowHandler() {

        lowPriorityHandler.handleRequest(new BugRequest("Title", BugRequest.Type.LOW));

        verify(lowPriorityHandler, times(1)).handleRequest(isA(BugRequest.class));
        verify(mediumPriorityHandler, times(0)).handleRequest(isA(BugRequest.class));
        verify(highPriorityHandler, times(0)).handleRequest(isA(BugRequest.class));
    }

    /**
     * Tests case when bug request has null value.
     */
    @Test
    public void testBugRequestNull() {
        thrown.expect(NullPointerException.class);
        thrown.expectMessage("Bug request must not be null");

        lowPriorityHandler.handleRequest(null);

        verify(lowPriorityHandler, times(1)).handleRequest(isA(BugRequest.class));
        verify(mediumPriorityHandler, times(0)).handleRequest(isA(BugRequest.class));
        verify(highPriorityHandler, times(0)).handleRequest(isA(BugRequest.class));
    }
}
