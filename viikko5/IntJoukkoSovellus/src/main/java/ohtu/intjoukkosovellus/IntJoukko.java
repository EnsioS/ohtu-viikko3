package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5;  // luotava uusi taulukko on 
    // näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int alkioidenLkm;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        this.alkiot = new int[kapasiteetti];
        this.alkioidenLkm = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public IntJoukko() { // käytä muissa yleisintä konstruktoria
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) {
            return false;
        }
        alkiot[alkioidenLkm] = luku;
        alkioidenLkm++;
        if (alkioidenLkm != 0 && alkioidenLkm % alkiot.length == 0) { // taulukko täynnä
            kasvataTaulukkoa();
        }
        return true;

    }

    public void kasvataTaulukkoa() {
        int[] vanhaTaulukko = alkiot;
        alkiot = new int[alkioidenLkm + kasvatuskoko];
        kopioiTaulukko(vanhaTaulukko, alkiot);
    }

    public boolean kuuluu(int luku) {
        if (etsi(luku) == -1) {
            return false;
        }
        return true;
    }

    public int etsi(int luku) {
        for (int i = 0; i < alkioidenLkm; i++) {
            if (luku == alkiot[i]) {
                return i;
            }
        }

        return -1;
    }

    public boolean poista(int luku) { // käytä kuuluu metodia tähän ja kuuluu joka palauttaa indeksin tai -1
        int indeksi = etsi(luku);
        if (indeksi == -1) {
            return false;
        }

        alkioidenLkm--;

        for (int i = indeksi; i < alkioidenLkm; i++) {
            // siirretään loput alkiot oikealle paikalle, niin ettei taulukkoon jää tyhjää paikkaa
            alkiot[i] = alkiot[i + 1];
        }

        return true;
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }

    }

    public int mahtavuus() {
        return alkioidenLkm;
    }

    @Override
    public String toString() {
        if (alkioidenLkm == 0) {
            return "{}";
        } else {
            String tuotos = "{";
            for (int i = 0; i < alkioidenLkm - 1; i++) {
                tuotos += alkiot[i];
                tuotos += ", ";
            }
            tuotos += alkiot[alkioidenLkm - 1];
            tuotos += "}";
            return tuotos;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLkm];

        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = alkiot[i];
        }

        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko x = new IntJoukko();

        for (int luku : a.toIntArray()) { // tälläiset loopit parempia
            x.lisaa(luku);
        }

        for (int luku : b.toIntArray()) {
            x.lisaa(luku);
        }

        return x;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko y = new IntJoukko();

        for (int luku : a.toIntArray()) {
            if (b.kuuluu(luku)) {
                y.lisaa(luku);
            }
        }

        return y;
    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko z = new IntJoukko();

        for (int luku : a.toIntArray()) {
            if (!b.kuuluu(luku)) {
                z.lisaa(luku);
            }
        }

        return z;
    }

}
