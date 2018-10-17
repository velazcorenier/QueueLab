package testers;

import classes.Job;
import classes.SLLQueue;
import interfaces.Queue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProcessingSystem {
    public static void main(String[] args) {
        Queue<Job> inputQueue = new SLLQueue<>();
        String fileName = "input.txt";
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            String line = br.readLine();
            int i = 0;
            while (line != null) {
                String[] contentOfLine = line.split(", ");
                int arrivalTime = Integer.parseInt(contentOfLine[0]);
                int serviceTime = Integer.parseInt(contentOfLine[1]);
                inputQueue.enqueue(new Job(i++, arrivalTime, serviceTime));
                line = br.readLine();
            }
        }catch (Exception e) {
            System.out.println("File not found");
        }

        Queue<Job> processingQueue = new SLLQueue<>();
        ArrayList<Job> terminatedJobs = new ArrayList<>();
        int time = 0;

        while (!inputQueue.isEmpty() || !processingQueue.isEmpty()) {
            if (!processingQueue.isEmpty()) {
                processingQueue.first().isServed(1);
                if (processingQueue.first().getRemainingTime() == 0) {
                    processingQueue.first().setDepartureTime(time);
                    terminatedJobs.add(processingQueue.dequeue());
                } else
                    processingQueue.enqueue(processingQueue.dequeue());
            }
            if (!inputQueue.isEmpty()) {
                if (inputQueue.first().getArrivalTime() == time)
                    processingQueue.enqueue(inputQueue.dequeue());
            }
            time++;
        }

        double totalTime = 0;

        for (Job job : terminatedJobs) {
            totalTime += job.getDepartureTime() - job.getArrivalTime();
        }

        System.out.println("Average Time in System is: " + totalTime / terminatedJobs.size());


    }

}
