public class Fraction {
    private int numerator;
    private int denominator;


    public Fraction(int num, int denom) {
        if (denom == 0)
            throw new IllegalArgumentException("Denominator cannot be 0!");

        else if (denom < 0) {
            numerator = -num;
            denominator = Math.abs(denom);
        } else {
            numerator = num;
            denominator = denom;
        }
    }

    public Fraction(int num){
      this(num,1);
    }

    public Fraction(){
        this(1,1);
    }

    public int getNumerator(){
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public String toString(){
        return(this.numerator + "/" + this.denominator);
    }

    public double toDouble(){
        return(this.numerator/this.denominator);
    }

    public Fraction add(Fraction other){
       Fraction added = new Fraction();
       if (this.denominator == other.denominator){
           added.numerator = this.numerator + other.numerator;
           added.denominator = this.denominator;
       }
       else{
           added.denominator = this.denominator*other.denominator;
           added.numerator = (this.numerator*other.denominator) + (other.numerator*this.denominator);
       }
       return added;
    }

    public Fraction subtract(Fraction other){
        Fraction subtracted = new Fraction();
        if (this.denominator == other.denominator){
            subtracted.numerator = this.numerator - other.numerator;
            subtracted.denominator = this.denominator;
        }
        else{
            subtracted.denominator = this.denominator*other.denominator;
            subtracted.numerator = (this.numerator*other.denominator) - (other.numerator*this.denominator);
        }
        return subtracted;
    }

    public Fraction multiply(Fraction other){
        Fraction multiplied = new Fraction();
        multiplied.numerator = this.numerator*other.numerator;
        multiplied.denominator = this.denominator*other.denominator;

        return multiplied;
    }

    public Fraction divide(Fraction other){
        try {

            if (other.numerator == 0) {
                throw new IllegalArgumentException("You cannot divide by 0!");
            }
        }catch(IllegalArgumentException iae){
            System.out.println("Don't try to divide by 0.");
        }
        Fraction divided = new Fraction();
        divided.numerator = this.numerator*other.denominator;
        divided.denominator = this.denominator*other.numerator;

        return divided;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            Fraction second = (Fraction) other;
            //come back here to add logic after implementing lowest terms.
            this.toLowestTerms();
            second.toLowestTerms();
            if (this.numerator == second.numerator && this.denominator == second.denominator)
                return true;
            else
                return false;

        } else {
            throw new IllegalArgumentException("Object passed to equals is not of type fraction, check object type.");

        }
    }

    public static int gcd(int a, int b){
        //System.out.println("A="+a);
        //System.out.println("B="+b);
        while ((a != 0) && (b != 0)) {
        int remainder = a%b;
        a = b;
        b = remainder;
        }
    //System.out.println("A = "+a);
    return a;
    }

    public void toLowestTerms(){
        int maxCommonDivisor = gcd(this.numerator,this.denominator);
        this.numerator /= maxCommonDivisor;
        this.denominator /= maxCommonDivisor;

    }


}
