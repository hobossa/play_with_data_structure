import com.sun.jdi.IntegerValue;
import org.junit.Assert;
import org.junit.Test;

public class MyListTest {

    @Test
    public void test_get_ok() {
        MyList<Integer> l = new MyList<>();
        for (int i = 0; i < 10; i++) {
            l.append(i * 10);
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(Integer.valueOf(i * 10), l.get(i));
        }
    }

    @Test
    public void test_find_ok() {
        MyList<Integer> l = new MyList<>();
        for (int i = 0; i < 10; i++) {
            l.append(i * 10);
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertEquals(i, l.find(i * 10));
        }
    }

    @Test
    public void test_find_fail() {
        MyList<Integer> l = new MyList<>();
        for (int i = 0; i < 10; i++) {
            l.append(i * 10);
        }
        Assert.assertEquals(-1, l.find(404));
    }

    @Test
    public void test_size_ok() {
        MyList<Integer> l = new MyList<>();
        for (int i = 0; i < 10; i++) {
            l.append(i * 10);
        }
        Assert.assertEquals(10, l.size());
    }

    @Test
    public void test_insert_ok() {
        MyList<Integer> l = new MyList<>();
        for (int i = 0; i < 10; i++) {
            l.append(i * 10);
        }
        l.insert(0, 111);
        Assert.assertEquals(Integer.valueOf(111), l.get(0));
        Assert.assertEquals(11, l.size());
        l.insert(5, 555);
        Assert.assertEquals(Integer.valueOf(555), l.get(5));
        Assert.assertEquals(12, l.size());
        l.insert(12, 1212);
        Assert.assertEquals(Integer.valueOf(1212), l.get(12));
        Assert.assertEquals(13, l.size());
    }

    @Test
    public void test_delete_ok() {
        MyList<Integer> l = new MyList<>();
        for (int i = 0; i < 10; i++) {
            l.append(i * 10);
        }
        l.delete(0);
        Assert.assertEquals(9, l.size());
        Assert.assertEquals(Integer.valueOf(10), l.get(0));
        l.delete(8);
        Assert.assertEquals(8, l.size());
        l.delete(5);
        Assert.assertEquals(-1, l.find(60));
    }
}