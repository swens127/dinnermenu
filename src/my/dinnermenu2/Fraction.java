package my.dinnermenu2;

/**
 *
 * @author ajswe
 */

/* Fraction.java */
  
import java.math.BigInteger;

/** The Fraction class implements non-negative fractions, i.e., rational 
 * numbers.   
 */
class Fraction {
  /** Constructs a Fraction n/d. 
   *  @param n is the numerator, assumed non-negative.
   *  @param d is the denominator, assumed positive.
   */
  public Fraction(int n, int d) {
    numerator = n; 
    denominator = d;
  }

  /** Constructs a Fraction n/1. 
   *  @param n is the numerator, assumed non-negative.
   */
  public Fraction(int n) {
    this(n,1);
  }

  /** Constructs a Fraction 0/1. 
   */
  public Fraction() {
    numerator = 0;
    denominator = 1;
  }
  
  /** Constructs a Fraction from a string. 
   */
    public Fraction(String str_val) {
        if (str_val.contains(" ") && str_val.contains("/")) {
            String[] whole_frac = str_val.split("\\s+");
            int whole = Integer.parseInt(whole_frac[0]);
            String[] num_denom = whole_frac[1].split("/");
            denominator = Integer.parseInt(num_denom[1]);
            numerator = Integer.parseInt(num_denom[0]);
            numerator += (whole * denominator);
        } else if (str_val.contains("/")) {
            String[] num_denom = str_val.split("/");
            numerator = Integer.parseInt(num_denom[0]);
            denominator = Integer.parseInt(num_denom[1]);
        } else {
            numerator = Integer.parseInt(str_val);
            denominator = 1;
        }
    }

  /** Converts this fraction to a string format: "numerator/denominator." 
   *  Fractions are printed in reduced form (part of your assignment is 
   *  to make this statement true).  
   *  @return a String representation of this Fraction.
   */
  @Override
  public String toString()   {
    int thisGcd = gcd(numerator, denominator);
    int whole = numerator/denominator;
    int adjusted_numerator = numerator - (whole*denominator);
    if(whole != 0 && adjusted_numerator != 0) {
        return (whole + " " + adjusted_numerator/thisGcd + "/" + denominator/thisGcd);
    } else if(adjusted_numerator != 0) {
        return (adjusted_numerator/thisGcd + "/" + denominator/thisGcd);
    } else {
        return "" + whole;
    }
  }

  /** Calculates and returns the double floating point value of a fraction.
   *  @return a double floating point value for this Fraction.
   */
  public double evaluate()
    {
      double n = numerator;	// convert to double
      double d = denominator;	
      return (n/d);
    }

  /** Add f2 to this fraction and return the result. 
   * @param f2 is the fraction to be added.
   * @return the result of adding f2 to this Fraction.
   */
  public Fraction add (Fraction f2) {
    Fraction r = new Fraction((numerator * f2.denominator) + 
			      (f2.numerator * denominator),
			      (denominator * f2.denominator));    
    return r;
  }

  /** Computes the greatest common divisor (gcd) of the two inputs. 
   * @param x is assumed positive
   * @param y is assumed non-negative
   * @return the gcd of x and y
   */
  static private int gcd (int x, int y) {
    BigInteger b1 = BigInteger.valueOf(x);
    BigInteger b2 = BigInteger.valueOf(y);
    BigInteger gcd = b1.gcd(b2);
    return gcd.intValue();
  }
    
  /* private fields within a Fraction.           */ 
  private int numerator;
  private int denominator;
}
