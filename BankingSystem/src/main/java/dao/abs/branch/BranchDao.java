package main.java.dao.abs.branch;

import java.sql.ResultSet;
import java.util.List;

import main.java.dao.AbstractDao;
import main.java.model.Branch;

public abstract class BranchDao extends AbstractDao <Branch>{

	public abstract Branch findByName(String name);
	public abstract List<Branch> findByAddress(String address);
	public abstract Branch findByPhNumber(String phone_number);
	public abstract boolean isPhNumberExit(String phone_number);

	
}
