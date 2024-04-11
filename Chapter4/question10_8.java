public class question10_8 
{
    public static void main(String[] args)
    {
        int[][] brackets2001 = {{27050, 65550, 136750, 297350}, {45200, 109250, 166500, 297350}, {22600, 54625, 83250, 148675}, {36250, 93650, 151650, 297350} };

        double[] rates2001 = {0.15, 0.275, 0.305, 0.355, 0.391};

        int[][] brackets2009 = {{27050, 65550, 136750, 297350}, {45200, 109250, 166500, 297350}, {22600, 54625, 83250, 148675}, {36250, 93650, 151650, 297350}};

        double[] rates2009 = {0.15, 0.275, 0.305, 0.355, 0.391};

        for (int year = 2001; year <= 2009; year += 8) {
            System.out.println("Tax Table for Year " + year + "\n");
            for (int income = 50000; income <= 60000; income += 1000) {
                System.out.println("Taxable Income: $" + income);
                Tax taxSingle = new Tax(Tax.SINGLE_FILER, brackets2001, rates2001, income);
                Tax taxMarried = new Tax(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, brackets2001, rates2001, income);
                Tax taxSeparate = new Tax(Tax.MARRIED_SEPARATELY, brackets2001, rates2001, income);
                Tax taxHead = new Tax(Tax.HEAD_OF_HOUSEHOLD, brackets2001, rates2001, income);

                if (year == 2009) {
                    taxSingle = new Tax(Tax.SINGLE_FILER, brackets2009, rates2009, income);
                    taxMarried = new Tax(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW, brackets2009, rates2009, income);
                    taxSeparate = new Tax(Tax.MARRIED_SEPARATELY, brackets2009, rates2009, income);
                    taxHead = new Tax(Tax.HEAD_OF_HOUSEHOLD, brackets2009, rates2009, income);
                }

                System.out.println("Single filer: $" + taxSingle.getTax());
                System.out.println("Married filing jointly: $" + taxMarried.getTax());
                System.out.println("Married filing separately: $" + taxSeparate.getTax());
                System.out.println("Head of household: $" + taxHead.getTax());
                System.out.println("-----------------------");
            }
            System.out.println();
        }
    }
}

class Tax {
    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW = 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;
    
    private int filingStatus;
    private int[][] brackets;
    private double[] rates;
    private double taxableIncome;
    
    public Tax() {
    }
    
    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;
    }
    
    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        int[] bracket = brackets[filingStatus];
        double tax = 0;
        double remainingIncome = taxableIncome;
        for (int i = 0; i < bracket.length; i++) {
            if (remainingIncome > bracket[i]) {
                tax += bracket[i] * rates[i];
                remainingIncome -= bracket[i];
            } else {
                tax += remainingIncome * rates[i];
                break;
            }
        }
        return tax;
    }
}
