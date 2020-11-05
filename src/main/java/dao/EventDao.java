package dao;

import file.Event;

import java.sql.*;

public class EventDao {

    private String db = "jdbc:hsqldb:file:eventsDb";
    private String user = "SA";
    private String password = "";
    private Connection connection;


    public EventDao() {

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection(db, user, password);
            dropTable(connection);
            createTable(connection);

        } catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void createTable(Connection connection) throws SQLException {

        final String createSql = "create table event( \n"+
                " id varchar(20) not null,\n" +
                " duration int not null, \n" +
                " type varchar(15), \n" +
                " host varchar(15), \n" +
                " alert boolean \n" +
                ")";

        PreparedStatement preparedStatement = connection.prepareStatement(createSql);
        preparedStatement.execute();
    }

    public void dropTable(Connection connection) throws SQLException {

        final String dropSql = "DROP TABLE IF EXISTS event";

        PreparedStatement preparedStatement = connection.prepareStatement(dropSql);
        preparedStatement.execute();
    }

    public void insertData(Event event){

        final String insertSql = "insert into event(id,duration,type,host,alert) values (?,?,?,?,?)";

        try(PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {

            preparedStatement.setString(1, event.getId());
            preparedStatement.setInt(2, event.getDuration());
            preparedStatement.setString(3, event.getType());
            preparedStatement.setString(4, event.getHost());
            preparedStatement.setBoolean(5, event.isAlert());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
