public class SumOfDice {

	private final int numDice;
	private final int numSides;
	private final int sum;

	private final long[][] cache;

	public SumOfDice(int numDice, int numSides, int sum) {
		this.numDice = numDice;
		this.numSides = numSides;
		this.sum = sum;
		this.cache = new long[numDice][sum];
	}

	public long compute() {
		return sumOfDice(numDice, numSides, sum);
	}

	private long sumOfDice(int numDice, int numSides, int sum) {
		if (sum < numDice || sum > numSides * numDice) {
			return 0L;
		} else if (numDice == 1) {
			return 1L;
		}
		long cached = cache[numDice - 1][sum - 1];
		if (cached != 0) {
			return cached;
		}
		long res = 0L;
		for (int i = 1; i <= numSides; ++i) {
			res += sumOfDice(numDice - 1, numSides, sum - i);
		}
		cache[numDice - 1][sum - 1] = res;
		return res;
	}

	public static void main(String... argv) {
		int numDice = 4;
		int numSides = 6;
		int sum = 21;

		long res = new SumOfDice(numDice, numSides, sum).compute();
		System.out.printf("There are %d ways for %d dice with %d sides to sum to %d", res, numDice, numSides, sum);
	}
}
