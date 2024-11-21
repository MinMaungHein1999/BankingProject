package main.java.dao.abs.employee;

import main.java.model.Employee;

import java.sql.*;

public class EmployeeDaoImpl extends EmployeeDao {
    public EmployeeDaoImpl() {
    }

    @Override
    public String getTableName() {
        return "employees";
    }

    @Override
    public Employee converToObject(ResultSet resultset) {
        Employee employee = null;
        try {
           int id =  resultset.getInt("id");
           String username = resultset.getString("username");
           String email = resultset.getString("email");
           String password = resultset.getString("password");
           String phoneNumber = resultset.getString("phone_number");
           int status = resultset.getInt("status");
           String position = resultset.getString("position");
           String department = resultset.getString("department");
           Date confirmedAt = resultset.getDate("confirmed_at");
           int users_role_id =  resultset.getInt("users_role_id");
            resultset.getDate("branch_id");
            resultset.getDate("created_by");
            resultset.getDate("updated_by");


        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        return employee;
    }

    @Override
    public String getInsertQuery() {
        return "insert into "+this.getTableName()+" (username, email, password, phone_number, status, position, department, confirmed_at, users_role_id, branch_id, created_by, updated_by)" +
                " values (?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    public String getUpdateQuery() {
        return "update "+this.getTableName()+" set first_name = ?, last_name = ?, email = ?, phone_number = ?, employee_position = ?, salary = ?, branch_id = ? encrypt_password = ? where id = ?";
    }

    @Override
    public String getDeleteQuery() {
        return "delete from "+this.getTableName()+" where id = ?";
    }

    @Override
    public void prepareParams(PreparedStatement preparedStatement, Employee object) {
//        try {
//            preparedStatement.setString(1, object.getfirstName());
//            preparedStatement.setString(2, object.getlastName());
//            preparedStatement.setString(3, object.getEmail());
//            preparedStatement.setString(4, object.getPhoneNumber());
//            preparedStatement.setString(5, object.getPosition());
//            preparedStatement.setFloat(6, (float)object.getSalary());
//            preparedStatement.setInt(7, object.getBranch().getId());
//            preparedStatement.setString(8, object.getEncryptPassword());
//        }catch(SQLException e) {
//            System.out.print("SQL Exception for : "+e.getMessage());
//        }

    }

    @Override
    public void prepareParamsForUpdate(PreparedStatement preparedStatement, Employee object) {
//        try {
//            preparedStatement.setString(1, object.getfirstName());
//            preparedStatement.setString(2, object.getlastName());
//            preparedStatement.setString(3, object.getEmail());
//            preparedStatement.setString(4, object.getPhoneNumber());
//            preparedStatement.setString(5, object.getPosition());
//            preparedStatement.setFloat(6, (float)object.getSalary());
//            preparedStatement.setInt(7, object.getBranch().getId());
//            preparedStatement.setString(8, object.getEncryptPassword());
//            preparedStatement.setInt(9, object.getId());
//        }catch(SQLException e) {
//            System.out.print("SQL Exception for : "+e.getMessage());
//        }
    }


    @Override
    public Employee findByName(String name) {
        Employee employee = null;
        try {
            String query = "Select id from "+this.getTableName()+" where first_name like ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                int id = resultSet.getInt("id");
                employee = this.getById(id);
            }
        }catch(SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
        return employee;
    }


    @Override
    public boolean isEmailExists(String email) {
        boolean exists = false;
        try{
            String query = "SELECT id FROM "+this.getTableName()+" WHERE email = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            exists = resultSet.next();
        }catch (SQLException e) {
            System.out.print("SQL Exception for isEmailExists: " + e.getMessage());
        }
        return exists;
    }


    @Override
    public boolean isPhoneExists(String phoneNumber) {
        boolean exists = false;
        try {
            String query = "SELECT id FROM "+this.getTableName()+" WHERE phone_number = ?";
            Connection connection = connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, phoneNumber);
            ResultSet resultSet = preparedStatement.executeQuery();
            exists = resultSet.next();
        }catch(SQLException e) {
            System.out.print("SQL Exception for isPhoneNumberExists: "+e.getMessage());
        }
        return exists;
    }


    @Override
    public Employee validateEmployee(String email,String password) {

        return null;

    }


    @Override
    public void updateLoginToken(Employee employee) {

    }


    @Override
    public void validateLoginToken(Employee employee){

    }


    @Override
    public Employee getEmployeeByEmployeeEmail(String email) {
        Employee object = null;
        try {
            String query = "SELECT * FROM "+this.getTableName()+" WHERE email = ?";
            Connection connection = connectionFactory.createConnection() ;
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            prepareStatement.setString(1, email);
            ResultSet resultSet = prepareStatement.executeQuery();

            if(resultSet.next()) {
                object = this.converToObject(resultSet);
            }

        } catch (SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
        return object;
    }


    @Override
    public void setConfimedAt(Employee employee) {
        try {
            String query = "Update "+this.getTableName()+" set confirmed_at = ? WHERE id = ?";
            Connection connection = connectionFactory.createConnection() ;
            PreparedStatement prepareStatement = connection.prepareStatement(query);
            java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
            prepareStatement.setDate(1,sqlDate);
            prepareStatement.setInt(2, employee.getId());
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print("SQL Exception for : "+e.getMessage());
        }
        finally {
            this.connectionFactory.closeConnection();
        }
    }
}
