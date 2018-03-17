import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {


        /*класс который описывает другой класса, из этого объекта можно получить данные другого класса*/
        Class<Student> studentClass = Student.class;

        System.out.println(studentClass.getCanonicalName()); // получение имени класса

        Field[] declaredFields = studentClass.getDeclaredFields(); //получаем поля класса

        for (Field declaredField: declaredFields){
            System.out.println(" Fileds: " + declaredField);

        }


        Object student = studentClass.newInstance();
        /*В случае если изветсно только имя метода */
        Method method = studentClass.getMethod("setName", String.class); // описание метода

        Object res = method.invoke(student, "Jango");//метод Invoke возвращает Object

        Student std= (Student) student;

        System.out.println(std.getName());

        

    }
}
