package kol1.MojDDV16;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MojDDV {
    private List<Receipt> receipts;

    public MojDDV() {
        receipts = new ArrayList<>();
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
}
