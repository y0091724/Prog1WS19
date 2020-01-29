
public class main {


      public static void main(String[] args) {
          BinaererBaum baum = new BinaererBaum(10);
          //baum.insert(9);

          baum.insertIterative(9);
          baum.insertIterative(8);
          baum.insertIterative(5);
          baum.insertIterative(3);
          baum.insertIterative(4);

          System.out.println(baum.toString());
          System.out.println(baum.height());
          System.out.println(baum.exist(23));
          System.out.println(baum.min());
          System.out.println(baum.max());
          System.out.println(baum.isDegenerate());

          //int[] x = {5,4,6,3,7,1};
          //IntSet intSet = new IntSet(x);

      }
}
