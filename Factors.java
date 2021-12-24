public class Factors {
   public static boolean areFactors(int n, int[] iArray) {
       for (int i : iArray) {
           if (n % i != 0) {
               return false;
           }
       }
       return true;
   }
   
   public static void main(String args[]) {
       int[] arrayTest = {2, 4, 6, 8};
       System.out.println(areFactors(48, arrayTest));
       System.out.println(areFactors(3, arrayTest));
   }
}
