import java.util.*;

public class RecursiveTreePreview {
    static class Folder {
        String name;
        List<Object> contents;
        Folder(String name) {
            this.name = name;
            this.contents = new ArrayList<>();
        }
    }

    public static int countFiles(Object node) {
        if (node instanceof String) return 1;
        int count = 0;
        for (Object obj : ((Folder) node).contents)
            count += countFiles(obj);
        return count;
    }

    public static void printMenu(List<String> menu, int level) {
        for (String item : menu) {
            System.out.println("  ".repeat(level) + item);
            if (item.startsWith("-")) {
                List<String> sub = Arrays.asList("子項1", "子項2");
                printMenu(sub, level + 1);
            }
        }
    }

    public static void flattenList(List<Object> nested, List<Object> flat) {
        for (Object o : nested) {
            if (o instanceof List) flattenList((List<Object>) o, flat);
            else flat.add(o);
        }
    }

    public static int maxDepth(List<Object> list) {
        int max = 1;
        for (Object o : list) {
            if (o instanceof List) max = Math.max(max, 1 + maxDepth((List<Object>) o));
        }
        return max;
    }

    public static void main(String[] args) {
        Folder root = new Folder("root");
        root.contents.add("file1");
        Folder sub = new Folder("sub");
        sub.contents.add("file2");
        root.contents.add(sub);
        System.out.println(countFiles(root));

        List<String> menu = Arrays.asList("首頁", "-設定", "-幫助");
        printMenu(menu, 0);

        List<Object> nested = Arrays.asList(1, Arrays.asList(2, Arrays.asList(3, 4)), 5);
        List<Object> flat = new ArrayList<>();
        flattenList(nested, flat);
        System.out.println(flat);

        System.out.println(maxDepth(nested));
    }
}
