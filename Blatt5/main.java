
public class main {


      public static void main(String[] args) {
          BinaererBaum baum = new BinaererBaum(10);
          baum.insert(9);
          baum.insertIterative(9);
          baum.insert(8);
          baum.insert(5);
          baum.insertIterative(3);
          System.out.println(baum.toString());
          System.out.println(baum.isDegenerate());
          baum.insertIterative(15);
          baum.insertIterative(17);
          baum.insert(16);
          System.out.println(baum.toString());
          System.out.println(baum.exist(17));
          System.out.println(baum.height());
          System.out.println(baum.min());
          System.out.println(baum.max());
          kleinerAlsZwanzig kaZ = (x)-> {if(x < 20) {
                                return true;
                            }
                            else {
                                return false;
                            }
                            };
          System.out.println(baum.alleKleinerAlsZwanzig(kaZ));
          baum.insert(20);
          System.out.println(baum.alleKleinerAlsZwanzig(kaZ));
          //int[] x = {5,4,6,3,7,1};
          //IntSet intSet = new IntSet(x);

      }
}
