import { House } from "@element-plus/icons-vue";
import { h, reactive } from "vue";
import { createRouter, createWebHistory } from "vue-router";

// 创建路由文件
export const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      component: () => import("@/views/Login/index.vue"),
      beforeEnter: () => {
        document.title = "登录";
      },
    },
    {
      path: "/index",
      component: () => import("@/views/Home/index.vue"),
      children: [
        {
          path: "home",
          component: () => import("@/views/HomeSon/index.vue"),
          beforeEnter: () => {
            document.title = "主页";
          },
        },
        {
          path: "user",
          component: () => import("@/views/User/index.vue"),
          beforeEnter: () => {
            document.title = "用户管理";
          },
        },
        {
          path: "novel",
          component: () => import("@/views/Novel/index.vue"),
          beforeEnter: () => {
            document.title = "小说管理";
          },
        },
      ],
    },
  ],
});

export const CustomMenu = reactive([
  {
    key: "index",
    label: "主页",
    // icon: () => <House />,
  },
]);
