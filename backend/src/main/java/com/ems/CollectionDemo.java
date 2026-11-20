import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Age: " + age;
    }
}

public class CollectionDemo {

    public static void main(String[] args) {

        // =================================
        // 1. ARRAYLIST TESTING
        // =================================

        System.out.println("\n===== ARRAYLIST TEST =====");

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(101, "Rahul", 25));
        students.add(new Student(102, "Moumita", 30));
        students.add(new Student(103, "Amit", 28));

        // Display all students
        for (Student s : students) {
            System.out.println(s);
        }

        // Access by index
        System.out.println("\nStudent at index 1:");
        System.out.println(students.get(1));

        // Update
        students.set(1, new Student(102, "Moumita Das", 31));

        // Delete
        students.remove(0);

        System.out.println("\nAfter update and delete:");

        for (Student s : students) {
            System.out.println(s);
        }


        // =================================
        // 2. LINKEDLIST TESTING
        // =================================

        System.out.println("\n===== LINKEDLIST TEST =====");

        LinkedList<String> names = new LinkedList<>();

        names.add("Rahul");
        names.add("Moumita");
        names.add("Amit");

        // Add at first position
        names.addFirst("Suman");

        // Add at last position
        names.addLast("Priya");

        System.out.println("All Names: " + names);

        // Access first and last
        System.out.println("First Name: " + names.getFirst());
        System.out.println("Last Name: " + names.getLast());

        // Remove first and last
        names.removeFirst();
        names.removeLast();

        System.out.println("After removing: " + names);


        // =================================
        // 3. HASHMAP TESTING
        // =================================

        System.out.println("\n===== HASHMAP TEST =====");

        HashMap<Integer, Student> studentMap = new HashMap<>();

        studentMap.put(101, new Student(101, "Rahul", 25));
        studentMap.put(102, new Student(102, "Moumita", 30));
        studentMap.put(103, new Student(103, "Amit", 28));

        // Search by ID
        Student found = studentMap.get(102);

        System.out.println("Search Student ID 102:");

        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Student not found");
        }

        // Update by ID
        studentMap.put(102, new Student(102, "Moumita Das", 31));

        // Delete by ID
        studentMap.remove(103);

        // Display all Map entries
        System.out.println("\nAll Students in HashMap:");

        for (Map.Entry<Integer, Student> entry : studentMap.entrySet()) {
            System.out.println(
                "Key: " + entry.getKey() +
                " | Value: " + entry.getValue()
            );
        }

        // Check key exists
        System.out.println("\nIs ID 101 exists? " +
                studentMap.containsKey(101));


        // =================================
        // 4. ARRAYLIST + HASHMAP TOGETHER
        // =================================

        System.out.println("\n===== ARRAYLIST + HASHMAP =====");

        ArrayList<Student> studentList = new ArrayList<>();

        HashMap<Integer, Student> studentLookup = new HashMap<>();

        Student s1 = new Student(201, "Ankit", 26);
        Student s2 = new Student(202, "Riya", 24);
        Student s3 = new Student(203, "Suman", 29);

        // Store same objects in both collections
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        studentLookup.put(s1.getId(), s1);
        studentLookup.put(s2.getId(), s2);
        studentLookup.put(s3.getId(), s3);

        // Display using ArrayList
        System.out.println("Student List:");

        for (Student s : studentList) {
            System.out.println(s);
        }

        // Fast lookup using HashMap
        System.out.println("\nFind Student ID 203:");

        Student result = studentLookup.get(203);

        System.out.println(result);
    }
}
