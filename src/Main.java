import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;

public class Main {

    public static void main(String[] args) {



        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;


            try {

            /*имя класса драйвера . Чтобы виртуальная машина знала какие классы загружать.
        Класс с которым программа будет работать с БД*/

                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "munchen1987");

                preparedStatement = connection.prepareStatement("SELECT id_std, name_std, last_name FROM students WHERE id_std=?");
                preparedStatement.setInt(1, 1);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    System.out.println("id: " + resultSet.getInt("id_std") +
                            " \nName: " + resultSet.getString("name_std") +
                            "\nlastname: " + resultSet.getString("last_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {

                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }

                    if (connection != null) {
                        connection.close();
                    }

                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

    }
}
