/**
 * 配置编译环境和线上环境之间的切换
 * 
 * baseUrl: 域名地址
 * routerMode: 路由模式
 * baseImgPath: 图片存放地址
 * 
 */
let baseUrl = 'http://localhost:8090';
let routerMode = 'history';
let baseImgPath = 'http://images.cangdu.org/';

// if (process.env.NODE_ENV == 'development') {
// 	//baseUrl = 'http://localhost:8090/';
// }else{
// 	baseUrl = 'http://localhost:8090/';
// }

export {
	baseUrl,
	routerMode,
	baseImgPath
}