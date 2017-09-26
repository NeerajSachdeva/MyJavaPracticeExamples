public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.maxSubArray());

	}

	public int maxSubArray() {
		int[] array = { 1, 2, 3, 4, -1, 2 };
		int max = array[0];

		int[] sum = new int[array.length];
		sum[0] = array[0];

		System.out.println("sum[0] : " + sum[0]);
		System.out.println("max before: " + max);

		for (int i = 1; i < array.length; i++) {
			System.out.println("array[i], sum[i - 1] + array[i]: " + array[i] + " " + sum[i - 1] + array[i]);
			sum[i] = Math.max(array[i], sum[i - 1] + array[i]);
			System.out.println("sum[i] : " + sum[i]);
			max = Math.max(max, sum[i]);
			System.out.println("max: " + max);
		}

		return max;
	}
}