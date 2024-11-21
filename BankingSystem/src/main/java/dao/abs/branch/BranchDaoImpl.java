package main.java.dao.abs.branch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.model.Branch;

public class BranchDaoImpl extends BranchDao {

	@Override
	public String getTableName() {
		return "branches";
	}

	@Override
	public Branch converToObject(ResultSet resultset) {
		Branch branch = null;
		try {
			branch = new Branch();
			branch.setId(resultset.getInt("id"));
			branch.setName(resultset.getString("name"));
			branch.setAddress(resultset.getString("address"));
			branch.setPhone_number(resultset.getString("phone_number"));

		} catch (SQLException e) {
			System.out.println("Error for converToObject in branch dao is " + e.getMessage());
		}
		return branch;
	}

	@Override
	public String getInsertQuery() {
		return "insert into " + this.getTableName() + " (name,address,phone_number) values (?,?,?)";
	}

	@Override
	public String getUpdateQuery() {
		return "update " + this.getTableName() + " set name =?, address = ?, phone_number = ? where id = ?";
	}

	@Override
	public String getDeleteQuery() {
		return "delete from " + this.getTableName() + " where id = ?";
	}

	@Override
	public void prepareParams(PreparedStatement preparedStatement, Branch object) {
		try {
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getAddress());
			preparedStatement.setString(3, object.getPhone_number());
		} catch (SQLException e) {
			System.out.println("Error for parepareParams in Branch Dao " + e.getMessage());
		}

	}

	@Override
	public void prepareParamsForUpdate(PreparedStatement preparedStatement, Branch object) {
		try {
			preparedStatement.setString(1, object.getName());
			preparedStatement.setString(2, object.getAddress());
			preparedStatement.setString(3, object.getPhone_number());
			preparedStatement.setInt(4, object.getId());
		} catch (SQLException e) {
			System.out.println("Error for parepareParamsforupdate in Branch Dao " + e.getMessage());
		}

	}

	@Override
	public Branch findByName(String name) {
		Branch branch = null;
		try {
			String query = "Select id from " + this.getTableName() + " where name = ?";
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				branch = this.getById(id);
			}
		} catch (SQLException e) {
			System.out.println("Error for findByName id branch dao" + e.getMessage());
		} finally {
			this.connectionFactory.closeConnection();
		}
		return branch;
	}

	@Override
	public List<Branch> findByAddress(String address) {
		String query = "select id from " + this.getTableName() + " where address LIKE ?";
		List<Branch> branches = new ArrayList<>();
		try {
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, address);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				branches.add(this.converToObject(resultSet));
			}

		} catch (SQLException e) {
			System.out.println("Error for findByAddress in branchDao " + e.getMessage());
		} finally {
			this.connectionFactory.closeConnection();
		}
		return branches;
	}

	@Override
	public Branch findByPhNumber(String phone_number) {
		Branch branch = null;
		String query = "select id from " + this.getTableName() + " where phone_number LIKE ?";
		try {
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phone_number);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				branch = this.getById(id);
			}
		} catch (SQLException e) {
			System.out.println("Error for findByPhNumber in branchDao " + e.getMessage());
		} finally {
			this.connectionFactory.closeConnection();
		}
		return branch;
	}
	
	@Override
	public boolean isPhNumberExit(String phone_number) {
		boolean exit = false;
		String query = "select id from " + this.getTableName() + " where phone_number = ?";
		try {
			Connection connection = connectionFactory.createConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, phone_number);
			ResultSet resultSet = preparedStatement.executeQuery();
			exit = resultSet.next();
		} catch (SQLException e) {
			System.out.print("Error for isphNumberExit " + e.getMessage());
		} finally {
			this.connectionFactory.closeConnection();
		}
		return exit;
	}

}
