import java.util.Random;

class Wuerfel {
    //Erstellung der Atribute
    public Random rng;
    public int min, max;

    //Konstrukteure
    public Wuerfel() {
        rng = new Random();
    }

    public Wuerfel(int nMin, int nMax) {
        rng = new Random();
        min = nMin;
        max = nMax;
    }

    // Gibt den gerundeten random Wert zurück
    // Der Wert befindet sich zwischen min und max
    public int zieheZahl() {
        double z = rng.nextDouble()*(max-min+1)+min;
        System.out.println((int) z + " min = " + min + " max = " + max);
        return (int)z;

    }
}