package com.xingjiahe.www.annotation;

import org.springframework.stereotype.Repository;

/**
 * <p></p>
 *
 * @author hejiaxing
 * @version 1.0
 * @date 2022/7/7 7:46 PM
 */
@Repository
public class UserDao {
    private  String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
