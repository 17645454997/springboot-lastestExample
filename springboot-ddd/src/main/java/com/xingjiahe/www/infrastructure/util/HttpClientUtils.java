//package com.xingjiahe.www.infrastructure.util;
//
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.TypeReference;
//import com.alibaba.fastjson.util.ParameterizedTypeImpl;
//import com.hellobike.base.hellohttp.client.RestTemplateFactory;
//import com.hellobike.base.hellohttp.model.HttpClientConfig;
//import org.apache.http.conn.ConnectTimeoutException;
//import org.springframework.http.*;
//import org.springframework.util.CollectionUtils;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.ResourceAccessException;
//import org.springframework.web.client.RestTemplate;
//
//import java.lang.reflect.Type;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
//import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
//
///**
// * create by zmm 弄死熊猫
// * <p>
// * on 2018/8/27
// */
//public class HttpClientUtils {
//
//    public static String get(String path, Map<String, Object> params, HttpHeaders headers, int retryCount, String metricKey) {
//        int i = 1;
//        HttpEntity entity = new HttpEntity(headers);
//        if (!CollectionUtils.isEmpty(params)) {
//            path = extractMapToUrl(path, params);
//        }
//        ResponseEntity<String> responseEntity = null;
//        do {
//            long reqtime = System.currentTimeMillis();
//            try {
//                responseEntity = ClientConfig.getRestTemplate().exchange(path, HttpMethod.GET, entity, String.class);
//                return responseEntity.getBody();
//            } catch (ResourceAccessException e) {
//                if (i >= retryCount) {
//                    LogUtils.ERROR.error("第【{}】次执行重试任务【{}】时异常，不再重试！", i, path, e);
//                    throw e;
//                } else {
//                    LogUtils.ERROR.error("第【{}】次执行重试任务【{}】时异常，继续重试...", i, path, e);
//                }
//            } finally {
//                metrics(path, entity, responseEntity, reqtime, metricKey);
//            }
//        } while (i++ < retryCount);
//        return null == responseEntity ? null : responseEntity.getBody();
//    }
//
//    public static String get(String path, Map<String, Object> params, HttpHeaders headers, String metricKey) {
//        HttpEntity entity = new HttpEntity(headers);
//        if (!CollectionUtils.isEmpty(params)) {
//            path = extractMapToUrl(path, params);
//        }
//        ResponseEntity<String> responseEntity = null;
//        long reqtime = System.currentTimeMillis();
//        try {
//            responseEntity = ClientConfig.getRestTemplate().exchange(path, HttpMethod.GET, entity, String.class);
//        } finally {
//            metrics(path, entity, responseEntity, reqtime, metricKey);
//        }
//        return null == responseEntity ? null : responseEntity.getBody();
//    }
//
//    public static String postForFormdata(String path, MultiValueMap<String, String> params, String metricKey) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
//        // 请求entity
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
//        // 响应entity
//        ResponseEntity<String> responseEntity = null;
//        long reqtime = System.currentTimeMillis();
//        try {
//            responseEntity = ClientConfig.getRestTemplate().postForEntity(path, requestEntity, String.class);
//        } finally {
//            metrics(path, requestEntity, responseEntity, reqtime, metricKey);
//        }
//
//        return responseEntity == null ? null : responseEntity.getBody();
//    }
//
//    /**
//     * @param path   请求地址
//     * @param params 参数
//     * @return
//     */
//    public static String post(String path, Map<String, Object> params, String metricKey) {
//        MultiValueMap<String, String> postParams = new LinkedMultiValueMap<>();
//        postParams.add("sign", SignUtil.sign(params));
//        if (!CollectionUtils.isEmpty(params)) {
//            params.forEach((k, v) -> postParams.add(k, String.valueOf(v)));
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(CONTENT_TYPE, APPLICATION_FORM_URLENCODED_VALUE);
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(postParams, headers);
//        ResponseEntity<String> responseEntity = null;
//        long reqtime = System.currentTimeMillis();
//        try {
//            responseEntity = ClientConfig.getRestTemplate().exchange(path, HttpMethod.POST, entity, String.class);
//        } finally {
//            metrics(path, entity, responseEntity, reqtime, metricKey);
//        }
//        return null == responseEntity ? null : responseEntity.getBody();
//    }
//
//    public static String post(String url, String requestBody) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
//        ResponseEntity<String> response = ClientConfig.getRestTemplate().postForEntity(url, request, String.class);
//
//        return response != null && response.getStatusCodeValue() == 200 ? response.getBody() : null;
//    }
//
//    public static ResponseEntity<String> postForAxb(String url, String authorization, String requestBody) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", authorization);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//
//        ResponseEntity<String> response = ClientConfig.getRestTemplate().exchange(url, HttpMethod.POST, entity, String.class);
//
//        return response;
//    }
//
//    public static ResponseEntity<String> postForAxb(String url, String authorization, String requestBody, String metricKey, int retryCount) {
//        int i = 1;
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", authorization);
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
//        ResponseEntity<String> responseEntity = null;
//        do {
//            long reqtime = System.currentTimeMillis();
//            try {
//                responseEntity = ClientConfig.getRestTemplate().exchange(url, HttpMethod.POST, entity, String.class);
//                return responseEntity;
//            } catch (Exception e) {
//                if (i > retryCount) {
//                    LogUtils.ERROR.error("第【{}】次执行重试任务【{}】时异常，不再重试！params:{}", i, url, requestBody, e);
//                    throw e;
//                } else {
//                    LogUtils.ERROR.error("第【{}】次执行重试任务【{}】时异常，继续重试...params:{}", i, url, requestBody, e);
//                }
//            } finally {
//                metrics(url, entity, responseEntity, reqtime, metricKey);
//            }
//        } while (i++ < retryCount);
//
//        return responseEntity;
//    }
//
//    /**
//     * @param path   请求地址
//     * @param params 参数
//     * @return
//     */
//    public static String postWithRetry(String path, Map<String, Object> params, int retryCount, String metricKey) {
//        MultiValueMap<String, String> postParams = new LinkedMultiValueMap<>();
//        postParams.add("sign", SignUtil.sign(params));
//        if (!CollectionUtils.isEmpty(params)) {
//            params.forEach((k, v) -> postParams.add(k, String.valueOf(v)));
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(CONTENT_TYPE, APPLICATION_FORM_URLENCODED_VALUE);
//        int i = 1;
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(postParams, headers);
//        ResponseEntity<String> responseEntity = null;
//        do {
//            long reqtime = System.currentTimeMillis();
//            try {
//                responseEntity = ClientConfig.getRestTemplate().exchange(path, HttpMethod.POST, entity, String.class);
//                return responseEntity.getBody();
//            } catch (ResourceAccessException e) {
//                if (i > retryCount) {
//                    LogUtils.ERROR.error("第【{}】次执行重试任务【{}】时异常，不再重试！params:{}", i, path, params, e);
//                    throw e;
//                } else {
//                    LogUtils.ERROR.error("第【{}】次执行重试任务【{}】时异常，继续重试...params:{}", i, path, params, e);
//                }
//            } finally {
//                metrics(path, entity, responseEntity, reqtime, metricKey);
//            }
//        } while (i++ < retryCount);
//
//        return null == responseEntity ? null : responseEntity.getBody();
//    }
//
//    /**
//     * @param path   请求地址
//     * @param params 参数
//     * @return response
//     */
//    public static String postWithRetryWhenConnTimeout(String path, Map<String, Object> params, int retryCount) {
//        MultiValueMap<String, String> postParams = new LinkedMultiValueMap<>();
//        postParams.add("sign", SignUtil.sign(params));
//        if (!CollectionUtils.isEmpty(params)) {
//            params.forEach((k, v) -> postParams.add(k, String.valueOf(v)));
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(CONTENT_TYPE, APPLICATION_FORM_URLENCODED_VALUE);
//        int i = 1;
//        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(postParams, headers);
//        ResponseEntity<String> responseEntity = null;
//        do {
//            long reqtime = System.currentTimeMillis();
//            try {
//                responseEntity = ClientConfig.getRestTemplate().exchange(path, HttpMethod.POST, entity, String.class);
//                return responseEntity.getBody();
//            } catch (ResourceAccessException e) {
//                if (e.getCause() instanceof ConnectTimeoutException) {
//                    if (i > retryCount) {
//                        LogUtils.ERROR.error("第【{}】次执行重试任务【{}】时异常，不再重试！shouQiSubOrderId:{}", i, path, params.get("partnerOrderNo"), e);
//
//                        Map<String, Object> createMetrics = new HashMap<>();
//                        createMetrics.put("shouQiSubOrderId", params.get("partnerOrderNo"));
//                        createMetrics.put("helloOrderGuid", params.get("helloOrderGuid"));
//                        createMetrics.put("info", "call shouqi to create order connection timeout");
//                        YunLogger.yun.metric("shouqi.create.order.connectionTimeOut", 0.0, createMetrics);
//
//                        throw e;
//                    } else {
//                        LogUtils.ERROR.error("第【{}】次执行重试任务【{}】时异常，继续重试...shouQiSubOrderId:{}", i, path, params.get("partnerOrderNo"), e);
//                    }
//                } else {
//                    LogUtils.ERROR.error("called shouqi api to create order unknown exception,shouQiSubOrderId:{}, ex:{}", params.get("partnerOrderNo"), e);
//                    throw e;
//                }
//            } finally {
//                metrics(path, entity, responseEntity, reqtime, params.get("helloOrderGuid").toString());
//            }
//        } while (i++ < retryCount);
//
//        return (null == responseEntity) ? null : responseEntity.getBody();
//    }
//
//    /**
//     * @param path   请求地址
//     * @param params 参数
//     * @param clazz  返回的object类型class类
//     * @return
//     */
//    public static <T> Response<T> postForObjectResult(String path, Map<String, Object> params, Class<T> clazz, String metricKey) {
//        return parseObjectResult(post(path, params, metricKey), clazz);
//    }
//
//    /**
//     * @param path   请求地址
//     * @param params 参数
//     * @param clazz  返回的object类型class类
//     * @param path   请求地址
//     * @param params 参数
//     * @param clazz  返回的object类型class类
//     * @return
//     */
//    public static <T> Response<T> postForObjectResult(String path, Map<String, Object> params, Class<T> clazz,
//                                                      int retryCount, String metricKey) {
//        return parseObjectResult(postWithRetry(path, params, retryCount, metricKey), clazz);
//    }
//
//    /**
//     * @param path   请求地址
//     * @param params 参数
//     * @param clazz  返回的List类型class类
//     * @param path   请求地址
//     * @param params 参数
//     * @param clazz  返回的List类型class类
//     * @return
//     */
//    public static <T> Response<List<T>> postForListResult(String path, Map<String, Object> params, Class<T> clazz, String metricKey) {
//        return parseListResult(post(path, params, metricKey), clazz);
//    }
//
//    /**
//     * @param path   请求地址
//     * @param params 参数
//     * @param clazz  返回的List类型class类
//     * @param path   请求地址
//     * @param params 参数
//     * @param clazz  返回的List类型class类
//     * @return
//     */
//    public static <T> Response<List<T>> postForListResult(String path, Map<String, Object> params, Class<T> clazz,
//                                                          int retryCount, String metricKey) {
//        return parseListResult(postWithRetry(path, params, retryCount, metricKey), clazz);
//    }
//
//    private static <T> Response<T> parseObjectResult(String json, Class<T> clazz) {
//        return JSONObject.parseObject(json, new TypeReference<Response<T>>(clazz) {
//        });
//    }
//
//    private static <T> Response<List<T>> parseListResult(String json, Class<T> clazz) {
//        ParameterizedTypeImpl inner = new ParameterizedTypeImpl(new Type[]{clazz}, null, List.class);
//        ParameterizedTypeImpl outer = new ParameterizedTypeImpl(new Type[]{inner}, null, Response.class);
//        return JSONObject.parseObject(json, outer);
//    }
//
//    private static void metrics(String path, HttpEntity httpEntity, ResponseEntity responseEntity, long reqtime, String metricKey) {
//        Map<String, Object> shouqiReq = new HashMap<>();
//        shouqiReq.put("reqPath", path);
//        shouqiReq.put("reqEntity", httpEntity);
//        shouqiReq.put("resEntity", responseEntity);
//        shouqiReq.put("reqKey", metricKey);
//        shouqiReq.put("duration", System.currentTimeMillis() - reqtime);
//        YunLogger.yun.metric("shouqi.http.request", 0.0, shouqiReq);
//    }
//
//    /**
//     * 将map中的参数提取并拼接到url
//     *
//     * @param path
//     * @param params
//     * @return
//     */
//    private static String extractMapToUrl(String path, Map<String, Object> params) {
//        StringBuilder finalPath = new StringBuilder(path + "?");
//        for (Map.Entry<String, Object> paramEntry : params.entrySet()) {
//            finalPath.append(paramEntry.getKey() + "=" + paramEntry.getValue() + "&");
//        }
//        finalPath.deleteCharAt(finalPath.length() - 1);
//        return finalPath.toString();
//    }
//
//    static class ClientConfig {
//
//        private ClientConfig() {
//
//        }
//
//        private static class ClientConfigHolder {
//            private static final RestTemplate restTemplate = createRestTemplate();
//        }
//
//        public static RestTemplate getRestTemplate() {
//            return ClientConfigHolder.restTemplate;
//        }
//
//        private static RestTemplate createRestTemplate() {
////            File file = new File(Utils.getPath("configs/httpClientConfig.json"));
////            try {
////                return RestTemplateFactory.build(
////                        JacksonHelper.getMapper().readValue(Files.readAllBytes(file.toPath()), HttpClientConfig.class));
////            } catch (IOException e) {
////                return RestTemplateFactory.build(new HttpClientConfig());
////            }
//            return RestTemplateFactory.build(new HttpClientConfig());
//        }
//
//    }
//
//
//    /**
//     * 富数 - 获取token
//     *
//     * @param url
//     * @param applicationId
//     * @param applicationSecret
//     * @return
//     */
//    public static String fsPostGetToken(String url, String applicationId, String applicationSecret) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
//        body.add("application_id", applicationId);
//        body.add("application_secret", applicationSecret);
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(body, headers);
//        ResponseEntity<String> response = ClientConfig.getRestTemplate().postForEntity(url, request, String.class);
//
//        return response != null && response.getStatusCodeValue() == 200 ? response.getBody() : null;
//    }
//
//    /**
//     * 富数 - 身份验证
//     *
//     * @param url
//     * @param token
//     * @param requestBody
//     * @return
//     */
//    public static String fsPostBioIdentity(String url, String token, String requestBody) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("X-ACCESS-TOKEN", token);
//        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
//        ResponseEntity<String> response = ClientConfig.getRestTemplate().postForEntity(url, request, String.class);
//
//        return response != null && response.getStatusCodeValue() == 200 ? response.getBody() : null;
//    }
//
//    /**
//     * 富数 - 人像对比
//     *
//     * @param url
//     * @param token
//     * @param requestBody
//     * @return
//     */
//    public static String fsPostBioCheck(String url, String token, String requestBody) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.add("X-ACCESS-TOKEN", token);
//        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
//        ResponseEntity<String> response = ClientConfig.getRestTemplate().postForEntity(url, request, String.class);
//
//        return response != null && response.getStatusCodeValue() == 200 ? response.getBody() : null;
//    }
//}
