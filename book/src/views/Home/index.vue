<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

// 获取Router示例
const router = useRouter();
// 当前的router
const current = ref("home");
const store = useStore();
onMounted(() => {
  // 当页面刷新时，联动菜单高亮
  current.value = location.pathname.replace("/index/", "");
});
</script>

<template>
  <el-card class="title-card">
    <div class="title">
      <div>
        <img
          class="avatar"
          src="https://img.js.design/assets/img/66499b7d9098e68db2ec5bec.png#bde108e7017a3c8ff201cda7b10a0432"
        />
        <span class="name">{{
          store.state?.currentUser?.userName || "未知"
        }}</span>
        <el-button @click="router.replace('/')">退出</el-button>
      </div>
    </div>
  </el-card>
  <div class="container">
    <div class="menu">
      <el-menu :default-active="current" class="el-menu-vertical-demo">
        <el-menu-item index="home" @click="router.replace('/index/home')">
          <el-icon><Grid /></el-icon>
          <span>首页</span>
        </el-menu-item>
        <el-menu-item index="user" @click="router.replace('/index/user')">
          <el-icon><Grid /></el-icon>
          <span>用户管理</span>
        </el-menu-item>
        <el-menu-item index="novel" @click="router.replace('/index/novel')">
          <el-icon><Grid /></el-icon>
          <span>小说管理</span>
        </el-menu-item>
      </el-menu>
    </div>
    <div class="content">
      <div
        class="content-son"
        style="
          background-color: white;
          height: 100%;
          box-sizing: border-box;
          padding: 20px;
          overflow-y: scroll;
        "
      >
        <router-view></router-view>
      </div>
    </div>
  </div>
</template>

<style lang="less">
.content-son::-webkit-scrollbar {
  display: none; /* Chrome Safari */
}

.title-card {
  background-color: #fca850;
}
.title {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  color: black;
  align-items: center;
  .avatar {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    vertical-align: middle;
  }
  .name {
    margin: 0 20px;
  }
}
.container {
  height: calc(100vh - 82px);
  display: flex;
  flex-direction: row;
  .menu {
    width: 15%;
    background-color: #fdb973;
  }
  .content {
    width: 85%;
    padding: 20px;
    background: #e5e5e5;
  }
}
</style>
