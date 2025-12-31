package lab9.XML;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

interface XMLComponent {
    void addAttribute(String key, String value);

    String toString(int indent);
}

abstract class XMLItem implements XMLComponent {

    protected String tag;
    protected Map<String, String> attributes;

    public XMLItem(String tag) {
        this.tag = tag;
        this.attributes = new LinkedHashMap<>();
    }

    @Override
    public void addAttribute(String key, String value) {
        attributes.put(key, value);
    }

    protected String attributesString() {
        if (attributes.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        attributes.forEach((k, v) -> sb.append(String.format(" %s=\"%s\"", k, v)));
        return sb.toString();
    }

    protected String indent(int indent) {
        return IntStream.range(0, indent)
                .mapToObj(i -> "    ")
                .collect(Collectors.joining(""));
    }


}

class XMLLeaf extends XMLItem {

    private String value;

    public XMLLeaf(String tag, String value) {
        super(tag);
        this.value = value;
    }

    @Override
    public String toString(int indent) {
        return String.format("%s<%s%s>%s</%s>", indent(indent), tag, attributesString(), value, tag);

    }
}

class XMLComposite extends XMLItem {

    private List<XMLComponent> children;

    public XMLComposite(String tag) {
        super(tag);
        this.children = new ArrayList<>();
    }

    public void addComponent(XMLComponent component) {
        children.add(component);
    }

    @Override
    public String toString(int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s<%s%s>\n",indent(indent),tag,attributesString()));

        for (XMLComponent child : children) {
            sb.append(child.toString(indent + 1)).append("\n");
        }

        sb.append(String.format("%s</%s>",indent(indent),tag));

        return sb.toString();

    }
}

public class XMLTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        XMLComponent component = new XMLLeaf("student", "Trajce Trajkovski");
        component.addAttribute("type", "redoven");
        component.addAttribute("program", "KNI");

        XMLComposite composite = new XMLComposite("name");
        composite.addComponent(new XMLLeaf("first-name", "trajce"));
        composite.addComponent(new XMLLeaf("last-name", "trajkovski"));
        composite.addAttribute("type", "redoven");
        component.addAttribute("program", "KNI");

        if (testCase == 1) {
            //TODO Print the component object
            System.out.println(component.toString(0));
        } else if (testCase == 2) {
            //TODO print the composite object
            System.out.println(composite.toString(0));
        } else if (testCase == 3) {
            XMLComposite main = new XMLComposite("level1");
            main.addAttribute("level", "1");
            XMLComposite lvl2 = new XMLComposite("level2");
            lvl2.addAttribute("level", "2");
            XMLComposite lvl3 = new XMLComposite("level3");
            lvl3.addAttribute("level", "3");
            lvl3.addComponent(component);
            lvl2.addComponent(lvl3);
            lvl2.addComponent(composite);
            lvl2.addComponent(new XMLLeaf("something", "blabla"));
            main.addComponent(lvl2);
            main.addComponent(new XMLLeaf("course", "napredno programiranje"));

            //TODO print the main object
            System.out.println(main.toString(0));
        }
    }
}
