public class Factors {
   public static boolean areFactors(int n, int[] iArray) {
       for (int i : iArray) {
           if (n % i != 0) {
               return false;
           }
       }
       return true;
   }
   
   public static boolean isPrime(int n) {
       if (n == 0 || n == 1) {
           return false;
       } else {
           for (int i = 2; i < n; i++) {
               if (n % i == 0) {
                   return false;
               }
           }
       }
       return true; 
   }


   public static boolean arePrimeFactors(int n, int[] iArray) {
       for (int i : iArray) {
           if (!(isPrime(i) && areFactors(n, iArray))) {
               return false;
           }
       }
       return true;
   }
   public static void main(String args[]) {
       int[] arrayTest = {2, 4, 6, 8};
       int[] arrayTest2 = {2, 3};
       System.out.println(areFactors(48, arrayTest));
       System.out.println(areFactors(3, arrayTest));
       System.out.println(isPrime(30));
       System.out.println(arePrimeFactors(60, arrayTest2));

   }
}
