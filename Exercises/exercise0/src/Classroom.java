import java.util.UUID;

public class Classroom {
    String classroomId;
    int capacity;
    boolean hasProjector;
    boolean hasWhiteboard;
    String building;
    int floor;
    boolean isOccupied;
    String teacher;

    public Classroom(int capacity, boolean hasProjector, boolean hasWhiteboard, String building, int floor) {
        this.classroomId = UUID.randomUUID().toString().substring(0, 8);
        this.capacity = capacity;
        this.hasProjector = hasProjector;
        this.hasWhiteboard = hasWhiteboard;
        this.building = building;
        this.floor = floor;
        this.isOccupied = false;
        this.teacher = null;
        System.out.println("Classroom instance created. Classroom ID: " + this.classroomId);
    }

    public void conductClass() {
        System.out.println("Class is in session in Classroom " + classroomId);
    }
    public void occupyClassroom() {
    }
    public void releaseClassroom() {
    }
}
