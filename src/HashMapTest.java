import java.util.HashMap;
import java.util.HashSet;

class Student {
    private String name;
    private String ip;

    public Student(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
}

public class HashMapTest {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1,1);
        HashSet<Student> hashSet = new HashSet<Student>();
        Student student = new Student("yanglin", "111");
        hashSet.add(student);
        student.setName("kevin");
        for (Student i: hashSet) {
            System.out.println(i.getName());
        }

    }
}
