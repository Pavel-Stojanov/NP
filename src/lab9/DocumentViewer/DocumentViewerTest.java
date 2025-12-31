package lab9.DocumentViewer;


import java.util.*;
import java.util.stream.Collectors;

interface IDocument {
    List<String> getLines();
}

class Document implements IDocument {
    private List<String> lines;

    public Document(String text) {
        this.lines = new ArrayList<>(Arrays.asList(text.split("\n")));
    }

    @Override
    public List<String> getLines() {
        return lines;
    }
}

class DocumentDecorator implements IDocument {
    protected IDocument document;

    public DocumentDecorator(IDocument document) {
        this.document = document;
    }

    @Override
    public List<String> getLines() {
        return document.getLines();
    }
}

class LineNumberDecorator extends DocumentDecorator {

    public LineNumberDecorator(IDocument document) {
        super(document);
    }

    @Override
    public List<String> getLines() {
        List<String> numbered = new ArrayList<>();
        for (int i = 0; i < super.getLines().size(); i++) {
            numbered.add((i + 1) + ": " + super.getLines().get(i));
        }
        return numbered;
    }
}

class WordCountDecorator extends DocumentDecorator {

    public WordCountDecorator(IDocument document) {
        super(document);
    }

    @Override
    public List<String> getLines() {
        List<String> lines = new ArrayList<>(super.getLines());

        long count = lines.stream().flatMap(s -> Arrays.stream(s.split("\\s+")))
                .filter(s -> !s.isEmpty())
                .count();

        lines.add("Words: " + count);

        return lines;
    }
}

class RedactionDecorator extends DocumentDecorator {
    private List<String> forbiddenWords;

    public RedactionDecorator(IDocument document, List<String> forbiddenWords) {
        super(document);
        this.forbiddenWords = forbiddenWords;
    }

    @Override
    public List<String> getLines() {
        List<String> lines = super.getLines();
        List<String> redacted = new ArrayList<>();

        for (String line : lines) {
            String temp = line;

            for (String forbidden : forbiddenWords) {

                temp = temp.replaceAll("(?i)\\b" + forbidden + "\\b", "*");

            }
            redacted.add(temp);
        }
        return redacted;
    }
}

class DocumentViewer {
    private Map<String, IDocument> documents;

    public DocumentViewer() {
        documents = new HashMap<>();
    }

    public void addDocument(String id, String text) {
        documents.put(id, new Document(text));
    }

    public void enableLineNumbers(String id) {
        documents.computeIfPresent(id, (k, doc) -> new LineNumberDecorator(doc));
    }

    public void enableWordCount(String id) {
        documents.computeIfPresent(id, (k, doc) -> new WordCountDecorator(doc));
    }

    public void enableRedaction(String id, List<String> forbiddenWords) {
        documents.computeIfPresent(id, (k, doc) -> new RedactionDecorator(doc, forbiddenWords));
    }

    public void display(String id) {
        System.out.println(String.format("=== Document %s ===", id));
        List<String> lines = documents.get(id).getLines();
        for (String line : lines) {
            System.out.println(line);
        }
    }
}

public class DocumentViewerTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DocumentViewer documentViewer = new DocumentViewer();

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String id = sc.nextLine();
            int numLines = sc.nextInt();
            sc.nextLine();

            StringBuilder sb = new StringBuilder();

            for (int i1 = 0; i1 < numLines; i1++) {
                sb.append(sc.nextLine()).append("\n");
            }
            documentViewer.addDocument(id, sb.toString());
        }

        while (sc.hasNext()) {
            String next = sc.next();
            if (next.equals("exit")) {
                break;
            } else if (next.equals("display")) {
                String id = sc.next();
                documentViewer.display(id);
            } else if (next.equals("enableLineNumbers")) {
                String id = sc.next();
                documentViewer.enableLineNumbers(id);
            } else if (next.equals("enableWordCount")) {
                String id = sc.next();
                documentViewer.enableWordCount(id);
            } else if (next.equals("enableRedaction")) {
                String id = sc.next();
                String line = sc.nextLine();
                List<String> forbidden = Arrays.stream(line.trim().split("\\s+")).collect(Collectors.toList());
                documentViewer.enableRedaction(id, forbidden);
            }
        }

    }
}
