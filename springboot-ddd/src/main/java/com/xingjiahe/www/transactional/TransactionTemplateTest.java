package com.xingjiahe.www.transactional;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author haisongzhe
 * @date 2022/12/17
 */
@Slf4j
public class TransactionTemplateTest {


    public static void main(String[] args) {

    }

    public  void execute() {
        final ObjectHolder<String> orderCodeHolder = new ObjectHolder<>(null);
        TransactionTemplate tt = new TransactionTemplate();
        try {
            CreateOrderResponseDTO execute = tt.execute(new TransactionCallback<CreateOrderResponseDTO>() {
                @Override
                public CreateOrderResponseDTO doInTransaction(TransactionStatus transactionStatus) {
                    orderCodeHolder.set("调用订单中心成功");
                    return new CreateOrderResponseDTO();
                }
            });
            throw  new RuntimeException();
        }catch (Exception e){
            log.error("[TransactionTemplateTest][execute][param{}]",e, JSON.toJSONString(orderCodeHolder));
        }
    }
}
