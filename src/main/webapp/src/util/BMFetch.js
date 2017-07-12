/**
 * @author gcy[of1518]
 * @date
 * @description 请求工具类
 * @require whatwg-fetch
 */
import 'whatwg-fetch';
import { Message } from 'element-ui';
// import * as auth from './BMAuth';
// import BMConst from './BMConst';

let baseUrl = 'http://localhost:8090';

/**
 * 公共请求类
 * @param {Object} param 
 */
let BMFetch = (param) => {
  let {host = "", url, timeout = 10, quiet = true} = param;
  url = baseUrl + url;
  let option = packParam(param);
  return new Promise((resolve, reject) => {
    //请求超时处理
    const timeoutCall = setTimeout(() => {
      Message.warning('网络不给力');
      resolve({ data: {}, Message: '网络不给力', err: new Error('timeout') });
    }, timeout * 1000);
    fetch(url, option)
      .then((res) => {

        clearTimeout(timeoutCall);

        res.json().then((res) => {
          // if (!!res.token) {
          //   auth.load(res.token);
          // }
          if (res.result=="ok") {
            resolve(res);
          } else {
            reject(res);
          }
        })

      })
      .catch((err) => {
        clearTimeout(timeoutCall);
        Message.warning('请求发生错误，请检查您的网络，稍后重试!');
        reject({ res: {}, err: err });
      })
  });
};

/**
 * pack param
 * @param {*} param
 */
function packParam(param) {
  delete param['url'];
  delete param['host'];
  delete param['timeout'];
  // let { Platform, SystemId } = BMConst.get('project') || {};
  //获取票据
  // const Authorization = auth.right();
  //default
  let req = {
    method: "GET",
    credentials: 'include',
    mode: 'cors',
    headers: {
      // 'Platform': Platform,
      // 'systemId': SystemId,
      'Accept': 'application/json',
      'Content-Type': 'application/json',
      // 'Authorization': `Bearer ${Authorization}`
    }
  };
  if (param && param['body'] && typeof param['body'] == 'object') {
    param['body'] = unescape(JSON.stringify(param['body']).replace(/\\u/g, '%u'));
  }
  return Object.assign(req, param)
}

export default BMFetch;