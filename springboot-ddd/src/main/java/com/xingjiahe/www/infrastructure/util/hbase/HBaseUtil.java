//package com.xingjiahe.www.infrastructure.util.hbase;
//
//import com.alibaba.fastjson.JSONObject;
//import com.hellobike.constant.Consts;
//import com.hellobike.domain.model.PointInfo;
//import com.hellobike.hbase.core.mapper.HBaseHelper;
//import com.hellobike.hitchdriver.dto.PointInfoDTO;
//import com.hellobike.infrastructure.util.LogUtils;
//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.hadoop.hbase.Cell;
//import org.apache.hadoop.hbase.client.Put;
//import org.apache.hadoop.hbase.client.Result;
//import org.apache.hadoop.hbase.client.ResultScanner;
//import org.apache.hadoop.hbase.client.Scan;
//import org.apache.hadoop.hbase.filter.CompareFilter;
//import org.apache.hadoop.hbase.filter.Filter;
//import org.apache.hadoop.hbase.filter.RegexStringComparator;
//import org.apache.hadoop.hbase.filter.RowFilter;
//import org.apache.hadoop.hbase.util.Bytes;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class HBaseUtil {
//
//    /**
//     * 创建表
//     *
//     * @param tableName
//     * @param familyColumn
//     */
//    public static void createTable(String tableName, String familyColumn) {
//        try {
//            List<String> familyColumns = new ArrayList<>(1);
//            familyColumns.add(familyColumn);
//            HBaseHelper.getDao().createTable(tableName, familyColumns);
//        } catch (IOException e) {
//            e.printStackTrace();
//            LogUtils.ERROR.error("创建" + tableName + "表失败！", e);
//        }
//    }
//
//    /**
//     * @param tableName 表名
//     * @param put
//     * @return
//     */
//    public static boolean put(String tableName, Put put) {
//        try {
//            return HBaseHelper.getDao().put(tableName, put);
//        } catch (Exception e) {
//            LogUtils.ERROR.error("数据插入表名" + tableName + "失败！数据为:", e);
//            return false;
//        }
//    }
//
//
//    public static boolean put(String tableName, List<Put> puts) {
//        if (StringUtils.isBlank(tableName)) {
//            return false;
//        }
//        try {
//            return HBaseHelper.getDao().put(tableName, puts);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static List<Result> get(String tableName, String... rowkeys) {
//        List<Result> resultList = new ArrayList<>();
//        ArrayList<String> filterRowKey = new ArrayList<>();
//        for (String rowKey : rowkeys) {
//            if (StringUtils.isNotBlank(rowKey)) {
//                filterRowKey.add(rowKey);
//            }
//        }
//        if (CollectionUtils.isEmpty(filterRowKey)) {
//            return resultList;
//        }
//        String[] rowKeyArray = filterRowKey.toArray(new String[filterRowKey.size()]);
//        try {
//            return HBaseHelper.getDao().get(tableName, rowKeyArray);
//        } catch (Exception e) {
//            LogUtils.ERROR.error("hbase get error", e);
//            return resultList;
//        }
//    }
//
//    public static boolean isTableExist(String tableName) {
//        try {
//            return HBaseHelper.getDao().isTableExist(tableName);
//        } catch (Exception e) {
//            LogUtils.ERROR.error(e);
//        }
//        return false;
//    }
//
//    /**
//     * 分页正则查询
//     *
//     * @param tableName 表名字
//     * @param startRow  开始行
//     * @param stopRow   结束行
//     * @param regex     正则
//     * @return
//     * @throws IOException
//     */
//    public static ResultScanner getByRegex(String tableName, String startRow, String stopRow, String regex) throws IOException {
//        Scan scan = new Scan();
//        scan.setStartRow(Bytes.toBytes(startRow));
//        scan.setStopRow(Bytes.toBytes(stopRow));
//        Filter regexFilter = new RowFilter(CompareFilter.CompareOp.EQUAL, new RegexStringComparator(regex));
//        scan.setFilter(regexFilter);
//        return HBaseHelper.getDao().getByScan(tableName, scan);
//    }
//
//    public static List<PointInfoDTO> getPointInfoList(String startRow, String stopRow, String regex) {
//        ResultScanner scanner = null;
//        List list = new ArrayList();
//        try {
//            scanner = HBaseUtil.getByRegex(Consts.HBASE_POSITION_TABLE_NAME, startRow, stopRow, regex);
//        } catch (IOException e) {
//            LogUtils.ERROR.error("getPositionByJourneyList:{}", e);
//        }
//
//        for (Result result : scanner) {
//            PointInfoDTO pointInfoDTO = new PointInfoDTO();
//            for (Cell cell : result.rawCells()) {
//                String row = Bytes.toString(cell.getRowArray(), cell.getRowOffset(), cell.getRowLength());
//                if (org.apache.commons.lang.StringUtils.isBlank(row)) {
//                    continue;
//                }
//                pointInfoDTO.setTimeStamp(Long.valueOf(row.split(Consts.HBASE_POSITION_REGEX)[2]));
//                String qualifier = Bytes.toString(cell.getQualifierArray(), cell.getQualifierOffset(), cell.getQualifierLength());
//                switch (qualifier) {
//                    case Consts.HBASE_POSITION_ORDER_TYPE:
//                        int orderType = Bytes.toInt(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
//                        pointInfoDTO.setOrderType(orderType);
//                        break;
//                    case Consts.HBASE_POSITION_POINT:
//                        String position = Bytes.toString(cell.getValueArray(), cell.getValueOffset(), cell.getValueLength());
//                        PointInfo pointInfo = JSONObject.parseObject(position, PointInfo.class);
//                        pointInfoDTO.setLat(pointInfo.getLat());
//                        pointInfoDTO.setLon(pointInfo.getLon());
//                        break;
//                }
//            }
//            list.add(pointInfoDTO);
//        }
//        return list;
//    }
//
//
//}