
public class BinaererBaum {


    BinaererBaum baumL = null;
    BinaererBaum baumR = null;
    int wert;

    public BinaererBaum(int wert) {
        this.wert = wert;
    }

    public void insert(int nWert) {
        if(wert < nWert) {
            if(baumR == null) {
                baumR = new BinaererBaum(nWert);
            }
            else {
                baumR.insert(nWert);
            }
        }
        else {
            if(wert > nWert) {
                if(baumL == null) {
                    baumL = new BinaererBaum(nWert);
                }
                else {
                    baumL.insert(nWert);
                }
            }
            else {
                if(wert == nWert) {
                    //Was macht Sinn?
                }
            }
        }
    }

    //Rekursiv fiel uns leichter und ist eleganter

    public void insertIterative(int nWert) {
        BinaererBaum baum = this;
        boolean boo = false;
        while(boo == false) {
            if(baum.getWert() < nWert) {
                if(baum.getBaumR() == null) {
                    baum.setBaumR(new BinaererBaum(nWert));
                    boo = true;
                }
                else {
                    baum = baum.getBaumR();
                }
            }
            else {
                if(baum.getWert() > nWert) {
                    if(baum.getBaumL() == null) {
                        baum.setBaumL(new BinaererBaum(nWert));
                        boo = true;
                    }
                    else {
                        baum = baum.getBaumL();
                    }
                }
                else {
                    if(baum.getWert() == nWert) {
                      //Was macht Sinn?
                    }
                }
            }
        }
    }

    public int height() {
        int hoeheL;
        int hoeheR;
        if(isLeaf()) {
            return 1;
        }
        else {
            if(baumL != null) {
                hoeheL = baumL.height();
            }
            else {
              hoeheL = 0;
            }
            if(baumR != null) {
                hoeheR = baumR.height();
            }
            else {
                hoeheR = 0;
            }
            if(hoeheR <= hoeheL) {
                return 1 + hoeheL;
            }
            else {
                return 1 + hoeheR;
            }
        }
    }

    public boolean exist(int nWert) {
        boolean r;
        boolean l;
        if(wert == nWert) {
            return true;
        }
        if(isLeaf()) {
            return false;
        }
        if(baumR != null) {
            r = baumR.exist(nWert);
        }
        else {
            r = false;
        }
        if(baumL != null) {
            l = baumL.exist(nWert);
        }
        else {
            l = false;
        }
        if(l || r) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isDegenerate() {
        boolean ergebnis;
        if(isLeaf()) {
            return true;
        }
        if(baumL == null && baumR != null) {
            ergebnis = baumR.isDegenerate();
        }
        else {
            if(baumR == null && baumL != null) {
                ergebnis = baumL.isDegenerate();
            }
            else {
                ergebnis = false;
            }
        }
        return ergebnis;
    }

    public int max() {
      BinaererBaum baum = this;
      while(baum.getBaumR() != null) {
          baum = baum.getBaumR();
      }
      return baum.getWert();
    }

    public int min() {
        BinaererBaum baum = this;
        while(baum.getBaumL() != null) {
            baum = baum.getBaumL();
        }
        return baum.getWert();
    }

    public boolean isLeaf() {
        if(baumL == null && baumR == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        String links;
        String rechts;
        if(isLeaf()) {
            return "(" + Integer.toString(wert) + ")";
        }
        else {
            if(baumL != null) {
                links = baumL.toString();
            }
            else {
                links = "()";
            }
            if(baumR == null) {
                rechts = "()";
            }
            else {
                rechts = baumR.toString();
            }
        }
        return "( " + links + " "+ Integer.toString(wert) + " " + rechts + " )";
    }

    public BinaererBaum getBaumL() {
        return baumL;
    }

    public BinaererBaum getBaumR() {
        return baumR;
    }

    public void setBaumL(BinaererBaum l) {
        baumL = l;
    }

    public void setBaumR(BinaererBaum r) {
        baumR = r;
    }

    public Integer getWert() {
        return wert;
    }

    public void setWert(Integer nWert) {
        wert = nWert;
    }
}
