public class missingnumberxor {

  static int getMissingNo(int a[], int n) {
    int x1 = a[0];
    int x2 = a[0];
    System.out.println(x1 + "::" + x2);
		/* For xor of all the elements
		in array */
    for (int i = 1; i < n; i++) {
      // System.out.println(x1);
      x1 = x1 ^ a[i];
    }
    int t = x2 + 1;
    for (int i = t; i <= x2 + n; i++) {
      x2 = x2 ^ i;
    }
    return (x1 ^ x2);
  }

  /* program to test above function */
  public static void main(String args[]) {
    int a[] = { 5, 7, 8, 9, 10 };
    int miss = getMissingNo(a, 5);
    System.out.println(miss);
  }

}
