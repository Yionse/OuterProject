<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const phoneNumber = ref();
const code = ref();
const router = useRouter();
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
          <el-input placeholder="请输入您的手机号" v-model="phoneNumber" />
          <el-input
            placeholder="请输入验证码"
            style="margin: 20px 0"
            v-model="code"
          >
            <template #suffix>
              <span style="color: #fca64f">获取验证码</span>
            </template>
          </el-input>
          <div
            style="
              margin: 20px 0;
              text-align: right;
              text-decoration: underline;
              opacity: 0.6;
            "
          >
            忘记密码
          </div>
          <el-button
            style="background: #ff6e3d; color: white"
            @click="router.push('/index/home')"
            >登录</el-button
          >
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
