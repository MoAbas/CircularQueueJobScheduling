package circularQueueScheduling;

public class Job{

    String name;
    int entryTime, jobTime;

    public Job(String name, int entryTime, int jobTime) {
        this.name = name;
        this.entryTime = entryTime;
        this.jobTime = jobTime;
    }
}
