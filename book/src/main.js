import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";
import { router } from "./router";

// 引入ElementPlus
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import * as ElementPlusIconsVue from "@element-plus/icons-vue";
import store from "./store";

// 在Vue中引入相关资源
const app = createApp(App);

// 注册图标资源
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component);
}

app.use(store);
app.use(router);
app.use(ElementPlus);
app.mount("#app");
