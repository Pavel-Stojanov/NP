package kol1.MojDDV17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MojDDV {
    private List<Receipt> receipts;

    public MojDDV() {
        receipts = new ArrayList<>();
    }

    public double getMin() {
        return receipts.stream().mapToDouble(Receipt::getTotalTax).min().getAsDouble();
    }

    public double getMax() {
        return receipts.stream().mapToDouble(Receipt::getTotalTax).max().getAsDouble();
    }

    public double getSum() {
        return receipts.stream().mapToDouble(Receipt::getTotalTax).sum();
    }

    public int getCount() {
        return receipts.size();
    }

    public double getAvg() {
        return receipts.stream().mapToDouble(Receipt::getTotalTax).average().getAsDouble();
    }

    void readRecords(InputStream inputStream) {

        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        br.lines().forEach(l -> {
            try {
                Receipt receipt = Receipt.create(l);
                receipts.add(receipt);
            } catch (AmountNotAllowedException e) {
                System.out.println(e.getMessage());
            }
        });
    }

    void printTaxReturns(OutputStream outputStream) {
        PrintWriter writer = new PrintWriter(outputStream);
        for (Receipt receipt : receipts) {
            writer.println(receipt);
        }
        writer.flush();
    }

    public void printStatistics(OutputStream out) {
        PrintWriter writer = new PrintWriter(out);
        writer.write(String.format("min:\t%-5.3f\n", getMin()));
        writer.write(String.format("max:\t%-5.3f\n", getMax()));
        writer.write(String.format("sum:\t%-5.3f\n", getSum()));
        writer.write(String.format("count:\t%-5d\n", getCount()));
        writer.write(String.format("avg:\t%-5.3f\n", getAvg()));
        writer.flush();
    }
}
