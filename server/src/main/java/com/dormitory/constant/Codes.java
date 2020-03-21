package com.dormitory.constant;

/**
 * @ClassName Codes
 * @Description 响应码
 * @Author CoderL
 * @Date 2020/2/28 17:19
 **/
public interface Codes {
    /** 未登录 */
    int UNAUTHEN = 4401;

    /** 未授权，拒绝访问 */
    int UNAUTHZ = 4403;

    /** session超时退出登录 */
    int SESSION_TIMEOUT = 4433;

    /** shiro相关的错误 */
    int SHIRO_ERR = 4444;

    /** 服务端异常 */
    int SERVER_ERR = 5500;
}
