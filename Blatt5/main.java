
public class main {


      public static void main(String[] args) {
          BinaererBaum baum = new BinaererBaum(10);
          //baum.insert(9);
          baum.insertIterative(9);
          baum.insertIterative(12);
          baum.insertIterative(11);
          baum.insertIterative(8);
          baum.insertIterative(22);
          System.out.println(baum.toString());
          System.out.println(baum.height());
      }
}
