/**
 * com.urise.webapp.model.Resume class
 */
public class Resume {

    // Unique identifier
    String uuid;



    Resume(String uuid) {
        this.uuid = uuid;
    }

    Resume() {
    }

    String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return uuid;
    }
}
