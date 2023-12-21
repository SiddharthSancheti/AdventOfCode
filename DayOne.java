public class DayOne {
    public static void main(String[] args) {
        int sum = 0;
        for (String arg : args) {
            String[] nums = arg.split("[a-zA-Z]");
            if (nums.length == 1) {
                sum += Integer.parseInt(nums[0]) * 10 + Integer.parseInt(nums[0]);
            } else {
                sum += Integer.parseInt(nums[0]) * 10 + Integer.parseInt(nums[nums.length - 1]);
            }

        }
        System.out.println(sum);
    }
}