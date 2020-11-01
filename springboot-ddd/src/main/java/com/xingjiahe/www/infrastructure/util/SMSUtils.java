//package com.xingjiahe.www.infrastructure.util;
//
//import com.carkey.message.base.resp.ReqResult;
//import com.carkey.message.service.ISendMsgService;
//import com.hellobike.constant.Consts;
//import com.hellobike.enums.SmsType;
//import com.hellobike.soa.rpc.RpcClientHelper;
//
//public class SMSUtils {
//    /**
//     * 发送短信
//     *
//     * @param mobile
//     * @param content
//     * @param smsType
//     * @return
//     */
//    public static boolean sendSms(String mobile, String content, SmsType smsType) {
//        ISendMsgService client = RpcClientHelper.getClient(ISendMsgService.class, null);
//
//        // 使用线程发送，防止阻塞主业务
//        ThreadPools.getInstance().submitSMSTask(() -> {
//            ReqResult reqResult = client.sendMsgWithSign(mobile, content, com.hellobike.infrastructure.util.ApolloConfigUtil.getProperty(Consts.MSG_SIGN, ""), smsType.channel);
//        });
//
//        return true;
//    }
//}
