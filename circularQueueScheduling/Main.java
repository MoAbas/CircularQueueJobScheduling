package circularQueueScheduling;

import java.util.ArrayList;

public class Main {

    static ArrayList<Job> jobs = new ArrayList<>();
    static int finishedJobs = 0;
            
    public static void main(String[] args) {
        
        Job job0 = new Job("job0",0,250);
        Job job1 = new Job("job1",50,170);
        Job job2 = new Job("job2",130,75);
        Job job3 = new Job("job3",190,100);
        Job job4 = new Job("job4",210,130);
        Job job5 = new Job("job5",350,50);
        
        jobs.add(job0);
        jobs.add(job1);
        jobs.add(job2);
        jobs.add(job3);
        jobs.add(job4);
        jobs.add(job5);
        
        CircularQueue<Integer> circularQueue = new CircularQueue(jobs.size());
        
        int quantomTime =100;
        
        for(int i=0;finishedJobs!=jobs.size();i++){
            for(int j=0;j<jobs.size();j++){
                if(jobs.get(j).entryTime==i){
                    circularQueue.enqueue(jobs.get(j));
                    System.out.println(i+"-"+circularQueue.toString()+"-"+jobs.get(j).name+" enters");
                }
            }
            if(!circularQueue.isEmpty()){
                Job frontJob = circularQueue.getFront();
                if(frontJob.jobTime==0){
                    circularQueue.dequeue();
                    finishedJobs++;
                    quantomTime=100;
                    System.out.println(i+"-"+circularQueue.toString()+"-"+frontJob.name+" is terminated");
                    if(!circularQueue.isEmpty()) frontJob = circularQueue.getFront();
                }
                else if(quantomTime==0){
                    circularQueue.dequeue();
                    circularQueue.enqueue(frontJob);
                    quantomTime=100;
                    System.out.println(i+"-"+circularQueue.toString()+"-"+frontJob.name+" time slot is expired but has remaining "+frontJob.jobTime+"ms");
                    frontJob = circularQueue.getFront();
                }
                frontJob.jobTime--;
                quantomTime--;
            }
        }
    }
    
}
