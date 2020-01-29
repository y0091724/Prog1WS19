
public class IntSet {

    private BinaererBaum baum;

    public IntSet(int[] elemente) {
        for(int x = 0; x < elemente.length; x++) {
            baum.insert(elemente[x]);
        }
    }

    public void insert(int nWert) {
        baum.insert(nWert);
    }

    public boolean contains(int nWert) {
        return baum.exist(nWert);
    }

    public IntSet union(IntSet andere) {
        int x;
        boolean boo = false;
        IntSet nSet = this;
        BinaererBaum baum = andere.getBaum();
        while (boo) {
            nSet.insert(baum.getWert());
            if(baum.getBaumL() != null) {
                baum = baum.getBaumL();
            }
            else {
                if(baum.getBaumR() != null) {
                    baum = baum.getBaumR();
                }
                else {
                    boo = true;
                }
            }
        }
        return nSet;
    }

    /*public IntSet intersection(Inset andere) {

    }
    */
    public BinaererBaum getBaum() {
        return baum;
    }

    public String toString() {
      return "a";
    }
}
