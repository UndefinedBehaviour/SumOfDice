public class SumOfDice {
	
	private static long[][] cache;

	private static long sumOfDice(int numDice, int numSides, int sum) {
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
		
		cache = new long[numDice][sum];
		
		long res = sumOfDice(numDice, numSides, sum);
		System.out.printf("There are %d ways for %d dice with %d sides to sum to %d", res, numDice, numSides, sum);
	}
}

