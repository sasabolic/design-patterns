package rs.symbolic.pattern;


/**
 * The type Bug request.
 */
public class BugRequest {
    /**
     * The enum Type.
     */
    enum Type {
        /**
         * High type.
         */
        HIGH, /**
         * Medium type.
         */
        MEDIUM, /**
         * Low type.
         */
        LOW
    }

    private final String title;
    private final Type type;

    /**
     * Instantiates a new Bug request.
     *
     * @param title the title
     * @param type  the type
     */
    public BugRequest(String title, Type type) {
        this.title = title;
        this.type = type;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets bug type.
     *
     * @return the type
     */
    public Type getType() {
        return type;
    }
}
