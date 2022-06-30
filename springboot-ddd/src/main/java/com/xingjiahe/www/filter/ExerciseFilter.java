//package com.xingjiahe.www.filter;
//
//import com.xingjiahe.www.context.AccessContext;
//
///**
// * <p></p>
// *
// * @author hejiaxing
// * @version 1.0
// * @date 2021/12/16 上午10:34
// */
//public class ExerciseFilter implements AbstractAccessFilter<AccessContext>{
//
//    private static  final Long POLICE_CALL_ID = 110L;
//
//    @Override
//    public void filter(AccessContext context) {
//       if(context.getUserNewId().equals(POLICE_CALL_ID)){
//           System.out.println("过滤链已经报警了");
//       }
//    }
//
//}
