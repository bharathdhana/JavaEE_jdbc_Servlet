public class Loan {
    private int offerId;
    private String offerName;
    private double rateOfInterest;
    private String terms;

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    // Getters and Setters
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public double getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(double rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }



    // Constructors
    public Loan(int offerId, String offerName, double rateOfInterest, String terms) {
        this.offerId = offerId;
        this.offerName = offerName;
        this.rateOfInterest = rateOfInterest;
        this.terms = terms;
    }

    public Loan() {}

    public Loan(String offerName, double rateOfInterest, String terms) {
        this.offerName = offerName;
        this.rateOfInterest = rateOfInterest;
        this.terms = terms;
    }
}
