/**
 * Created with hzh.
 * Date: 2018/3/31
 * Time: 下午2:46
 */
import axios from 'axios/index';
import { Feedback } from '@icedesign/base';
import Constant from './Constant';

export default function callApi(url, data, method, needToken) {
  let getUrlData = '';
  if (data) {
    if (!(typeof data === 'string')) {
      let tmp = '';
      for (const k in data) {
        if (data.hasOwnProperty(k)) {
          tmp = `${k}=${data[k]}&${tmp}`;
        }
      }
      getUrlData = tmp;
    }
  }

  url = Constant.InterfaceUrl + url;

  if (!method) {
    method = 'POST';
  }

  if (data == null) {
    data = {};
  }

  if (method === 'GET') {
    url = `${url}?${getUrlData}`;
  }

  console.log(`data====${data}`);

  let config;
  if (needToken) {
    config = {
      url,
      method,
      headers: {
        // Authorization: '',
        // Accept: 'application/json',
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      data: JSON.stringify(data),
    };
  } else {
    config = {
      url,
      method,
      // headers: {
      //   // Authorization: 'odoshfsofohsa;fs9f0sufna;hf;osfosd',
      //   // Accept: 'application/json',
      'Content-Type': 'application/x-www-form-urlencoded',
      // 'Content-Type': 'application/json',
      // },
      data: JSON.stringify(data),
    };
  }


  if (method !== 'POST' || JSON.stringify(data) === '{}') {
    delete config.data;
  }

  console.log(`config===${config}`);

  return axios(config)
    .then((response) => {
      if (
        response.status === 200 &&
        response.data &&
        response.data.result === 'ok'
      ) {
        console.log(response.data.data);
        return response.data.data;
      }
      Feedback.toast.success(response.data.msg);
      console.log(response.data.msg);
    })
    .catch((error) => {
      Feedback.toast.error(error);
      console.log(error);
    });
}
