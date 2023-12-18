package org.example;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.xml.transform.Result;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustoHistoryRepository {
    private BasicDataSource basicDataSource;

    public CustoHistoryRepository(String url, String userName, String password) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(password);
    }

    public List<CustoHistory> getCustoHistory(String customerId) {
        // stored procedure
        // call name of stored procedure
        // use callable statement over prepared statement

        String storedProCall = "{call CustOrderHist(?))}";

        List<CustoHistory>custoHistories = new ArrayList<>();

        try (Connection con = basicDataSource.getConnection();
             CallableStatement cs = con.prepareCall(storedProCall)) {

            cs.setString(1, customerId);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                String productName = rs.getString("ProductName");
                int total = rs.getInt("TOTAL");

                CustoHistory ch = new CustoHistory(productName, total);
                CustoHistory.add(ch);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

