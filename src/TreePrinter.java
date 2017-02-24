import java.io.*;

/**
 * Created by nero on 2017/2/24.
 */
public class TreePrinter {
    Printable root;
    File theGraphvizText;
    PrintWriter dos;

    public TreePrinter(Printable root, File theGraphvizText) {
        this.root = root;
        this.theGraphvizText = theGraphvizText;
        if (theGraphvizText.exists()) {
            theGraphvizText.delete();
        }
        try {
            theGraphvizText.createNewFile();
            dos = new PrintWriter(new FileWriter(theGraphvizText));
            dos.println("digraph g {");
            dos.println("node [shape = record,height=.1];");
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void createNode(Printable node) {
        if (node == null) {
            return;
        } else {
            try {
                dos.println("node"+node.getId()+"[label = \"<f0> |<f1> "+node.getContent()+"|<f2> \"];\n");
                dos.flush();
                createNode(node.getLchild());
                createNode(node.getRchild());
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void linkLRNode(Printable node) {
        if (node == null) {
            return;
        }
        if (node.getLchild() != null) {
            try {
                dos.println("\"node"+node.getId()+"\":f0 -> \"node"+node.getLchild().getId()+"\":f1;\n");
                dos.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (node.getRchild() != null) {
            try {
                dos.println("\"node" + node.getId() + "\":f2 -> \"node" + node.getRchild().getId() + "\":f1;\n");
                dos.flush();

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }

    private void createLink(Printable node) {
        if (node == null) {
            return;
        } else {
            linkLRNode(node);
            createLink(node.getLchild());
            createLink(node.getRchild());
            return;
        }
    }

    public void createBinaryTree() {
        createNode(root);
        createLink(root);
        dos.println("}");
        dos.close();
    }
}
