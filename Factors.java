public class Factors {
   public static boolean areFactors(int n, int[] iArray) {
       for (int i : iArray) {
           if (i % n != 0) {
               return false;
           }
       }
       return true;
   }
   
   public static void main(String args[]) {
       int[] arrayTest = {2, 4, 6, 8};
       System.out.println(areFactors(2, arrayTest));
       System.out.println(areFactors(3, arrayTest));
   }
}
