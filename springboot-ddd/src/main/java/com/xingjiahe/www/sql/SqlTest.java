package com.xingjiahe.www.sql;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
public class SqlTest {


    /** select 。。。 for update
     * 如果查询条件用了索引/主键 那么select  for update 就会加行锁 。
     * 如果索引失效还是会锁表
     * 如果是普通字段（没有索引/主键） 那么select for update 就会进行锁表
     * 未获取数据的时候 mysql 不进行加锁
     * @param args
     */


    /**
     * sql 查询过后应该对查询的数据的状态进行double check
     *
     * @param args
     */
    public static void main(String[] args) {
     String sql = "select id,gmt_create.gmt_modified  from conso_ticket_info + where deleted =0  and ticket_id in  <foreach collection ='ticketIdList'" +
             " open ='(' close=')'  separator =','>#{item} </foreach> + for update";
    }
}
