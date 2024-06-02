<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { ElMessage } from "element-plus";
import { useStore } from "vuex";

const isLogin = ref(true);
const phoneNumber = ref();
const code = ref();
const router = useRouter();
const store = useStore();
const clickHandle = () => {
  if (isLogin.value) {
    if (!phoneNumber.value || !code.value) {
      ElMessage({ type: "error", message: "输入不完整" });
      return;
    } else {
      store.commit("login", {
        userName: phoneNumber.value,
        password: code.value,
      });
      console.log(store.state.currentUser, "登录成功，有值了");
      if (store.state.currentUser?.userName) {
        ElMessage({ type: "success", message: "登录成功" });
        router.replace("/index/home");
      } else {
        ElMessage({ type: "error", message: "登录失败" });
        return;
      }
    }
  } else {
    if (!phoneNumber.value || !code.value) {
      ElMessage({ type: "error", message: "输入不完整" });
      return;
    } else {
      store.commit("register", {
        userName: phoneNumber.value,
        password: code.value,
      });
      console.log(store.state);
      ElMessage({ type: "success", message: "注册成功" });
    }
  }
};
</script>

<template>
  <div class="box">
    <div class="top"></div>
    <div class="container">
      <div class="back">
        <img
          src="https://img.js.design/assets/img/61035a1cbd36eb1fc96be3b0.png"
        />
      </div>
      <div class="login">
        <h2 style="text-align: center">欢迎登录</h2>
        <div style="display: flex; flex-direction: column; margin-top: 120px">
          <el-input placeholder="请输入您的账号" v-model="phoneNumber" />
          <el-input
            placeholder="请输入您的密码"
            style="margin: 20px 0"
            v-model="code"
            type="password"
          >
          </el-input>
          <div
            style="
              margin: 20px 0;
              text-align: right;
              text-decoration: underline;
              opacity: 0.6;
            "
            @click="
              () => {
                isLogin = !isLogin;
                phoneNumber = '';
                code = '';
              }
            "
          >
            {{ isLogin ? "注册" : "登录" }}
          </div>
          <el-button
            style="background: #ff6e3d; color: white"
            @click="clickHandle"
          >
            {{ isLogin ? "登录" : "注册" }}
          </el-button>
        </div>
      </div>
    </div>
    <div class="footer"></div>
  </div>
</template>

<style lang="less" scoped>
.box {
  display: flex;
  flex-direction: column;
  height: 100vh;
  .top {
    height: 10%;
    background: #fca64f;
  }
  .container {
    display: flex;
    box-sizing: border-box;
    flex-direction: row;
    padding: 0 20px;
    align-items: center;
    height: 80%;
    width: 100vw;
    flex: 1;
    background: white;
    border-radius: 40px;
    .back {
      width: 45%;
      img {
        width: 100%;
      }
    }
    .login {
      box-sizing: border-box;
      width: 30%;
      padding: 20px 50px;
      padding-bottom: 120px;
      margin-left: 200px;
      background: white;
      border: 1px solid rgba(245, 245, 245, 1);
      box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.1);
      .my-input {
        margin: 20px;
      }
    }
  }
  .footer {
    height: 10%;
    background: #ff703e;
  }
}
</style>
