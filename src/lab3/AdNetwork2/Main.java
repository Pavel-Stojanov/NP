package lab3.AdNetwork2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class AdNetwork {
    private ArrayList<Ad> ads;

    public AdNetwork() {
        ads = new ArrayList<>();
    }

    public void readAds(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split("\\s+");
            String id = parts[0];
            String category = parts[1];
            double bidValue = Double.parseDouble(parts[2]);
            double ctr = Double.parseDouble(parts[3]);
            String content = Arrays.stream(parts, 4, parts.length)
                    .collect(Collectors.joining(" "));
            ads.add(new Ad(id, category, bidValue, ctr, content));
        }

    }

    public void placeAds(BufferedReader br, int k, PrintWriter pw) throws IOException {
        String line = br.readLine();
        String[] parts = line.split("\\s+");
        String id = parts[0];
        String category = parts[1];
        double floorBid = Double.parseDouble(parts[2]);
        String keywords = Arrays.stream(parts, 3, parts.length)
                .collect(Collectors.joining(" "));

        AdRequest req = new AdRequest(id, category, floorBid, keywords);
        final double x = 5.0;
        final double y = 100.0;

        List<Ad> bestAds = ads.stream().filter(a -> a.getBidValue() >= req.getFloorBid())
                .sorted(Comparator.comparingDouble(a -> {
                    double totalScore = relevanceScore(a, req) + x * a.getBidValue() + y * a.getCtr();
                    return -totalScore;
                })).limit(k).sorted()
                .collect(Collectors.toList());
        pw.printf("Top ads for request %s:\n", req.getId());
        bestAds.forEach(pw::println);
    }

    private int relevanceScore(Ad ad, AdRequest req) {
        int score = 0;
        if (ad.getCategory().equalsIgnoreCase(req.getCategory())) score += 10;
        String[] adWords = ad.getContent().toLowerCase().split("\\s+");
        String[] keywords = req.getKeywords().toLowerCase().split("\\s+");
        for (String kw : keywords) {
            for (String aw : adWords) {
                if (kw.equals(aw)) score++;
            }
        }
        return score;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        AdNetwork network = new AdNetwork();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine().trim());

        if (k == 0) {
            network.readAds(br);
            network.placeAds(br, 1, pw);
        } else if (k == 1) {
            network.readAds(br);
            network.placeAds(br, 3, pw);
        } else {
            network.readAds(br);
            network.placeAds(br, 8, pw);
        }

        pw.flush();
    }
}
