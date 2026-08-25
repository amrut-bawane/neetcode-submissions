class Solution {
    class Task {
        char id;
        int frequency;
        int lastExecutedInstant;

        Task(char id, int frequency) {
            this.id = id;
            this.frequency = frequency;
            this.lastExecutedInstant = 0;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        // Create Max heap with each entry as <task, frequency>
        // Pick task with max remaining count (root)
        // Task executes but cannot be retriggered till n cycles. Re-heap after n cycles
        // Next tick is free to pick item from the heap
        //

        if (tasks == null || tasks.length == 0) return 0;

        PriorityQueue<Task> taskHeap = new PriorityQueue<>((task1, task2) -> Integer.compare(task2.frequency, task1.frequency));
        Map<Character, Integer> taskMap = new HashMap<>();
        for (char task: tasks) {
            if (!taskMap.containsKey(task)) taskMap.put(task, 0);
            taskMap.put(task, taskMap.get(task) + 1);
        }

        for (char task: taskMap.keySet()) {
            taskHeap.offer(new Task(task, taskMap.get(task)));
        }
        Queue<Task> waitingTasks = new ArrayDeque<>();

        int remainingTasks = tasks.length;
        int currTime = 0;
        while (remainingTasks > 0) {
            // Reheap any waiting task who's eligible to be executed now.
            if (!waitingTasks.isEmpty()) {
                Task nextInQueue = waitingTasks.peek();
                if (currTime > nextInQueue.lastExecutedInstant + n) {
                    waitingTasks.poll();
                    taskHeap.offer(nextInQueue);
                }
            }
            
            // Pick task from current heap
            if (!taskHeap.isEmpty()) {
                Task next = taskHeap.poll();
                // Execute the task
                next.frequency--;
                next.lastExecutedInstant = currTime;
                remainingTasks--;
                if (next.frequency != 0) {
                    waitingTasks.offer(next);
                }
            }

            currTime++;
        }
        return currTime;
    }
}
