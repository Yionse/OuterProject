import axios from "axios";

const httpInstance = axios.create({
  baseURL: "http://localhost:9081",
  timeout: 5000,
});

// 使用请求拦截器，增加token
httpInstance.interceptors.request.use(
  (config) => {
    config.headers["X-Token"] = localStorage.getItem("TOKEN") || "";
    return config;
  },
  (error) => {
    return new Promise.reject(error);
  }
);

// 使用响应拦截器，将data直接取出，返回
httpInstance.interceptors.response.use(
  (res) => res.data.data,
  (error) => {
    message.error("网络错误");
    return Promise.reject(error);
  }
);

export const post = (url, data) => {
  return httpInstance.post(url, data);
};

export const get = (url, data) => {
  return httpInstance.get(url, { params: data });
};
