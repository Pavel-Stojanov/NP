package lab3.AdNetwork2;

public class Ad implements Comparable<Ad>{
    private String id;
    private String category;
    private double bidValue;
    private double ctr;
    private String content;

    public Ad(String id, String category, double bidValue, double ctr, String content) {
        this.id = id;
        this.category = category;
        this.bidValue = bidValue;
        this.ctr = ctr;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public double getBidValue() {
        return bidValue;
    }

    public double getCtr() {
        return ctr;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return String.format("%s %s (bid=%.2f, ctr=%.2f%%) %s", id, category, bidValue, ctr*100, content);
    }

    @Override
    public int compareTo(Ad o) {
        int bidCompare = Double.compare(o.bidValue,this.bidValue);
        if (bidCompare!=0){
            return bidCompare;
        }
        return id.compareTo(o.id);
    }
}
