import fetch from '../config/fetch'



/**
 * 获取用户列表
 */

export const getUserList = () => fetch('/user/queryUserList');



