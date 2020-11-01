package com.xingjiahe.www.infrastructure.util;
/**
*<pre>
 * 
 *</pre>
* @author zhouqingchun E-mail:zhouqingchun@hellobike.com	
* @version 1.0.0
* @since 2018年11月8日 下午5:59:05
*/
public class VersionUtils {
	
	public static int getVersionNo(String version) {
        String[] vers = version.split("\\.");
        // 主版本
        int mainVersion = Integer.parseInt(vers[0]);
        // 次版本
        int minorVersion = Integer.parseInt(vers[1]);
        // 补丁
        int patchVersion = Integer.parseInt(vers[2]);
        return mainVersion * 10000 + minorVersion * 100 + patchVersion;
    }

}
