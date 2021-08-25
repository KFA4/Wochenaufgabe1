
class Fraction {
    /* ********************************************************************
    /* attributes */
    /* ********************************************************************/
    private int num, denom;   // numerator and denominator of the fraction

  /* ********************************************************************
  /* constructors */
    /* ********************************************************************/

    /* create a fraction from two numbers
    /* denominator should be converted to a positive integer without changing
    /* the value of the fraction */
    public Fraction(int numerator, int denominator) {
        num   = numerator;
        denom = denominator;
        if (denom < 0) {
            denom = Math.abs(denom);
            num = -1*num;
        }

        // ...
    }
    /* create a fraction from String with a slash e.g. "3/4" */
    public Fraction(String fraction) {
        String numStr = fraction.substring(0, fraction.indexOf("/"));
        String denomStr = fraction.substring(fraction.indexOf("/") + 1);
        num = Integer.parseInt(numStr);
        denom = Integer.parseInt(denomStr);
    }

  /* ********************************************************************
  /* methods */
    /* ********************************************************************/

    /* get and set --------------------------------------------------------- */
    public int getNumerator()   { return num;  }
    public int getDenominator() { return denom;}

    /* type conversion ----------------------------------------------------- */
    /* returns a float representation of the fraction */
    public float toFloat ()     { return ((float) num/ (float) denom); }

    /* returns a String representation like "3/4" of the fraction */
    public String toString() {
        return num + "/" + denom;
    }


    /* operations ---------------------------------------------------------- */
    /* returns whether or not the fraction equals another fraction */
    /* does not change numerator or denominator of given fractions */
    public boolean equals(Fraction f) {
        f.reduce();
        int newNum = num;
        num = num / gcd(num, denom);
        denom = denom / gcd(newNum, denom);
        if(f.getNumerator() == num && f.getDenominator() == denom) return true;
        return false;
    }


    /* reduces the fraction */
    public void reduce() {
        int newNum = num;
        num = num / gcd(num, denom);
        denom = denom / gcd(newNum, denom);
    }

    /* adds a Fraction b to this Fraction */
    public void add(Fraction b) {
        b.reduce();
        int newNum = num;
        num = num / gcd(num, denom);
        denom = denom / gcd(newNum, denom);
        num = ((num*b.getDenominator()) + (b.getNumerator()*denom));
        denom = denom*b.getDenominator();
    }

    /* private ------------------------------------------------------------- */
    /* returns the greatest common divider of a and b*/
    private int gcd(int a, int b) {
        int min;
        if (a < b) min = a;
        else min = b;
        for (int i = min; i > 0; i--){
            if (a % i == 0 && b % i == 0) return i;
        }
        return 1;
    }

    /* returns the least common multiple of a and b */
    private int lcm(int a, int b) {
        return b/gcd(a,b)*a;
    }

    /* the main method is just for testing and should be removed later */
    public static void main(String[] args) {
        Fraction f1 = new Fraction("7/15");
        Fraction f2 = new Fraction(21,45);
        System.out.println("f1 = "+f1.toString()+" = "+f1.toFloat());
        System.out.println("f2 = "+f2.toString()+" = "+f2.toFloat());

        // Erwartet: f1 = f2
        if (f1.equals(f2)) {
            System.out.println("f1 = f2");
        } else {
            System.out.println("f1 != f2");
        }

        f2.reduce();
        // Erwartet: 7/15
        System.out.println(f2.toString());

        f1 = new Fraction(6,15);
        f2 = new Fraction(3,8);
        f1.add(f2);

        // Erwartet: 31/40
        System.out.println(f1.toString());
    }
} // end of class Fraction


