package vezbi.Discounts25;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Discounts {
    private List<Store> stores;

    public Discounts() {
        stores = new ArrayList<>();
    }

    public int readStores(InputStream inputStream) {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        stores = br.lines().map(Store::new).collect(Collectors.toList());
        return stores.size();

    }

    public List<Store> byAverageDiscount() {
        return stores.stream().sorted(Comparator.comparing(Store::avgDiscount).reversed().thenComparing(Store::getName)).limit(3).collect(Collectors.toList());
    }

    public List<Store> byTotalDiscount() {
        return stores.stream().sorted(Comparator.comparing(Store::getTotalDiscount).thenComparing(Store::getName)).limit(3).collect(Collectors.toList());
    }
}
