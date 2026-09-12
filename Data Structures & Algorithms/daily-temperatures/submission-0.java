class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[]{};
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        // Initialize all with not possible result
        Arrays.fill(result, 0);

        int currentDay = 0;
        while (currentDay < temperatures.length) {
            int currentTemperature = temperatures[currentDay];
            // Keep checking past days for which we havent yet found warmer temperature.
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemperature) {
                int prevDay = stack.pop();
                result[prevDay] = currentDay - prevDay;
            }

            // Add current day
            stack.push(currentDay);
            currentDay++;
        }
        return result;
    }
}
