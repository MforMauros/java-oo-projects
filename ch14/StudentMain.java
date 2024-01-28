package gr.aueb.cf.ch14;

import java.lang.reflect.Constructor;

public class StudentMain {

    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("gr.aueb.cf.ch14.Student");
            Constructor<?> constructor = studentClass.getConstructor();
            Object studentInstance = constructor.newInstance();
            Student student = (Student) studentInstance;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
