public class Wuerfelbecher {
    public int AnzahlDerWürfel;
    public Wuerfel wuerfels[];
    public Wuerfelbecher(int nAnzahlDerWürfel){
        AnzahlDerWürfel = nAnzahlDerWürfel;
        wuerfels = new Wuerfel[AnzahlDerWürfel];
        for (int i = 0; i < AnzahlDerWürfel; i++){
            wuerfels[i] = new Wuerfel(1, 6);
        }
    }
    public void Wuerfelhinzufügen(Wuerfel w){
        Wuerfel newWuerfels[] = new Wuerfel[AnzahlDerWürfel + 1];
        for (int i = 0; i < AnzahlDerWürfel; i++){
            newWuerfels[i] = wuerfels[i];
        }
        newWuerfels[AnzahlDerWürfel] = w;
        wuerfels = newWuerfels;
        AnzahlDerWürfel++;
    }
    public void Wuerfelentfernen() {
       if(AnzahlDerWürfel == 0) return;
        Wuerfel newWuerfels[] = new Wuerfel[AnzahlDerWürfel - 1];
        for (int i = 0; i < AnzahlDerWürfel - 1; i++) {
            newWuerfels[i] = wuerfels[i];
        }
        wuerfels = newWuerfels;
        AnzahlDerWürfel--;
    }
    public int summeZeigen(){
        int S = 0;
        for (int i = 0; i < AnzahlDerWürfel; i++){
            S = S + wuerfels[i].zieheZahl();
        }
        return S;
    }

}
