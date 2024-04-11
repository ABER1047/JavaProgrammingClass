public class question9_2 
{
    public static void main(String[] args)
    {
        Stock st1 = new Stock("ORCL", "Oracle Corporation");
        st1.setPreviousClosingPrice(34.5);
        st1.setCurrentPrice(34.35);
        
        System.out.println("price-change percentage : "+st1.getChangePercent());
    }
}

class Stock
{
    private String symbol, name;
    private double previousClosingPrice, currentPrice;
    
    Stock(String symbol, String name)
    {
        this.symbol = symbol;
        this.name = name;
    }
    
    public void setCurrentPrice(double newCurrentPrice) 
    {
        currentPrice = newCurrentPrice;
    }
    
    public void setPreviousClosingPrice(double newPreviousClosingPrice) 
    {
        previousClosingPrice = newPreviousClosingPrice;
    }
    
    public double getChangePercent()
    {
        return (currentPrice/previousClosingPrice)*100;
    }
}
