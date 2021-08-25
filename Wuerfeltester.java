class Wuerfeltester {
    public static void main(String args[]) {
        Wuerfelbecher a = new Wuerfelbecher(3);
        Wuerfel w1 = new Wuerfel(1,20);
        Wuerfel w2 = new Wuerfel(3,9);
        Wuerfel w3 = new Wuerfel(1,7);
        a.Wuerfelhinzufügen(w1);
        a.Wuerfelhinzufügen(w2);
        a.Wuerfelhinzufügen(w3);
        System.out.println("Die Summe ist " + a.summeZeigen());
        a.Wuerfelentfernen();
        System.out.println("Die Summe ist " + a.summeZeigen());

    }
}