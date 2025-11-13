package kol1.BlockContainer38;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BlockContainer<T extends Comparable<T>> {
    List<List<T>> blocks;
    private int size;

    public BlockContainer(int n) {
        this.size = n;
        blocks = new ArrayList<>();
    }

    public void add(T a) {
        if (blocks.isEmpty()) {
            List<T> newBlock = new ArrayList<>();
            newBlock.add(a);
            blocks.add(newBlock);
        } else {
            List<T> lastBlock = blocks.get(blocks.size() - 1);
            if (lastBlock.size() < size) {
                lastBlock.add(a);
                Collections.sort(lastBlock);
            } else {
                List<T> newBlock = new ArrayList<>();
                newBlock.add(a);
                blocks.add(newBlock);
            }
        }
    }

    public boolean remove(T a) {
        if (blocks.isEmpty()) {
            return false;
        }
        List<T> lastBlock = blocks.get(blocks.size() - 1);
        boolean removed = lastBlock.remove(a);

        if (removed && lastBlock.isEmpty()) {
            blocks.remove(lastBlock);
        }
        return removed;
    }

    public void sort() {
        List<T> all = new ArrayList<>();
        for (List<T> block : blocks) {
            all.addAll(block);
        }
        Collections.sort(all);

        blocks.clear();

        for (T elem : all) {
            if (blocks.isEmpty() || blocks.get(blocks.size() - 1).size() == size) {
                blocks.add(new ArrayList<>());
            }
            blocks.get(blocks.size() - 1).add(elem);
        }
    }

    @Override
    public String toString() {
        if (blocks.isEmpty()) {
            return "";
        }
        return blocks.stream()
                .map(b -> b.stream().map(String::valueOf)
                        .collect(Collectors.joining(", ", "[", "]")))
                .collect(Collectors.joining(","));

    }
}
