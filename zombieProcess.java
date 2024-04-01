import java.util.ArrayList;
import java.util.List;

public class zombieProcess {
    private static final int NUM_CHILD_PROCESSES = 10;

    public static void main(String[] args) {
        Thread parentThread = Thread.currentThread();
        System.out.println("Parent thread having id " + parentThread.getId());

        List<ChildProcess> childProcesses = new ArrayList<>();

        // Create and start child processes
        for (int i = 0; i < NUM_CHILD_PROCESSES; i++) {
            ChildProcess childProcess = new ChildProcess();
            childProcess.start();
            childProcesses.add(childProcess);
        }

        try {
            // Parent thread sleeps for a while (simulating doing some work)
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Parent thread is still running...");

        // Simulate not waiting for child processes to terminate
        // This would create "zombie" processes in a native environment

        System.out.println("Parent thread is exiting...");
    }

    private static class ChildProcess extends Thread {
        @Override
        public void run() {
            System.out.println("Child thread having id " + Thread.currentThread().getId() + " started");

            try {
                // Child process does some work and terminates
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Child thread having id " + Thread.currentThread().getId() + " terminated");
        }
    }
}