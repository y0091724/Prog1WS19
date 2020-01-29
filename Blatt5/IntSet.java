
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
        /*
        IntSet nSet = this;
        if(andere.getBaum() != null) {
            return nSet;
        }
        else {
            boolean boo = false;
            BinaererBaum nBaum = andere.getBaum();
            while(boo) {
                baum.insert(andere.getBaum());
                if(andere.getBaum().getBaumL() != null) {
                    nBaum = andere.getBaum().getBaumL();
                }

            }
        }

        IntSet nSet = this;
        BinaererBaum =
        if(andere.getBaum().isLeaf()) {
            nSet.insert(andere.getBaum().getWert());
        }
        if(andere.getBaum().getBaumL() != null) {

        }
        */

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
        String ausgabe = baum.toString();
        ausgabe.replace("(",",");
        return "a";
    }
}
