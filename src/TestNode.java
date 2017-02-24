/**
 * Created by nero on 2017/2/24.
 */
public class TestNode implements Printable {
    int id;
    TestNode Lchild, Rchild;
    String content;

    public TestNode(int id, TestNode lchild, TestNode rchild, String content) {
        this.id = id;
        Lchild = lchild;
        Rchild = rchild;
        this.content = content;
    }

    public void setLchild(TestNode lchild) {
        Lchild = lchild;
    }

    public void setRchild(TestNode rchild) {
        Rchild = rchild;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Printable getLchild() {
        return Lchild;
    }

    @Override
    public Printable getRchild() {
        return Rchild;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public int getId() {
        return id;
    }
}
