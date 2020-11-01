//package com.xingjiahe.www.infrastructure.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.hellobike.constant.Consts;
//import com.hellobike.constant.MQConfig;
//import com.hellobike.soa.rpc.RpcClientHelper;
//
///**
// * create by zmm 弄死熊猫
// * <p>
// * on 2018/12/19
// */
//public class ClientMsgPushUtil {
//
//    /**
//     * tcp推送
//     * @param amqpTemplate
//     * @param userGuid
//     * @param notifyCode
//     * @param data
//     */
//    public static boolean pushToApp(String userGuid, String notifyCode, Object data) {
//        try {
//            // 触发TCP通知
//            JSONObject tcpNotifyParams = new JSONObject();
//            tcpNotifyParams.put("code", notifyCode);
//            tcpNotifyParams.put("timestamp", System.currentTimeMillis());
//            tcpNotifyParams.put("guid", userGuid);
//            tcpNotifyParams.put("data", data);
//
//            JSONObject transferData = new JSONObject();
//            transferData.put("type", Consts.Tcp.TCP_TYPE);
//            transferData.put("guid", userGuid);
//            transferData.put("data", tcpNotifyParams);
//
//            YunLogger.yun.metric("hitchDriver.tcpPush.params", 0.0, tcpNotifyParams);
//            com.hellobike.infrastructure.util.LogUtils.COMMON.debug("send msg to mq,exchange:{},body:{}", MQConfig.Exchanges.HITCH_DRIVER_TCP_NOTIFY, tcpNotifyParams.toJSONString());
//            com.hellobike.infrastructure.util.ThreadPools.getInstance().pushToTcpGWMqTask(() -> {
//                Object response = RpcClientHelper.invokeByName(Consts.Tcp.PUSH_IFACE, Consts.Tcp.PUSH_METHOD, String.class, transferData.toJSONString());
//                com.hellobike.infrastructure.util.LogUtils.COMMON.debug("userGuid {}, app.online.msg.push.Push response {}", userGuid, JSON.toJSONString(response));
//            });
//
//            return true;
//
//        } catch (Exception ex) {
//            com.hellobike.infrastructure.util.LogUtils.ERROR.error("127.0.0.1||0||{}||user tcpNotify error,data:{}", ex.getClass().getName(), data, ex);
//        }
//
//        return false;
//    }
//}
