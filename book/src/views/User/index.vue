<script setup>
import { ref, watchEffect, computed } from "vue";

// 初始数据
const data = ref([
  {
    id: 1,
    nickname: "王小明",
    phone: "15928774926",
    password: "123456789",
    img: "../../static/头像1.webp",
  },
  {
    id: 2,
    nickname: "薛敏",
    phone: "13010791955",
    password: "sintanim",
    img: "../../static/头像1.webp",
  },
  {
    id: 3,
    nickname: "姜涛",
    phone: "13681006669",
    password: "amet ea ",
    img: "../../static/头像1.webp",
  },
  {
    id: 4,
    nickname: "薛洋",
    phone: "16471002651",
    password: "aute labo",
    img: "../../static/头像1.webp",
  },
  {
    id: 5,
    nickname: "蔡刚",
    phone: "18063112528",
    password: "culpa qui",
    img: "../../static/头像1.webp",
  },
  {
    id: 1,
    nickname: "王小明",
    phone: "15928774926",
    password: "123456789",
    img: "../../static/头像1.webp",
  },
  {
    id: 2,
    nickname: "薛敏",
    phone: "13010791955",
    password: "sintanim",
    img: "../../static/头像1.webp",
  },
  {
    id: 1,
    nickname: "王小明",
    phone: "15928774926",
    password: "123456789",
    img: "../../static/头像1.webp",
  },
  {
    id: 2,
    nickname: "薛敏",
    phone: "13010791955",
    password: "sintanim",
    img: "../../static/头像1.webp",
  },
  {
    id: 1,
    nickname: "王小明",
    phone: "15928774926",
    password: "123456789",
    img: "../../static/头像1.webp",
  },
  {
    id: 2,
    nickname: "薛敏",
    phone: "13010791955",
    password: "sintanim",
    img: "../../static/头像1.webp",
  },
  {
    id: 1,
    nickname: "王小明",
    phone: "15928774926",
    password: "123456789",
    img: "../../static/头像1.webp",
  },
  {
    id: 2,
    nickname: "薛敏",
    phone: "13010791955",
    password: "sintanim",
    img: "../../static/头像1.webp",
  },
  {
    id: 1,
    nickname: "王小明",
    phone: "15928774926",
    password: "123456789",
    img: "../../static/头像1.webp",
  },
  {
    id: 2,
    nickname: "薛敏",
    phone: "13010791955",
    password: "sintanim",
    img: "../../static/头像1.webp",
  },
  {
    id: 1,
    nickname: "王小明",
    phone: "15928774926",
    password: "123456789",
    img: "../../static/头像1.webp",
  },
  {
    id: 2,
    nickname: "薛敏",
    phone: "13010791955",
    password: "sintanim",
    img: "../../static/头像1.webp",
  },
  {
    id: 1,
    nickname: "王小明",
    phone: "15928774926",
    password: "123456789",
    img: "../../static/头像1.webp",
  },
  {
    id: 2,
    nickname: "薛敏",
    phone: "13010791955",
    password: "sintanim",
    img: "../../static/头像1.webp",
  },
]);
// 数据copy一份
const copyData = ref(data.value);

// 搜索关键字
const key = ref("");

// 控制dialog
const dialogTableVisible = ref(false);
const currentUser = ref();
const updateData = ref({});

// 搜索回调
const searchHandle = () => {
  copyData.value = copyData.value.filter(
    (item) =>
      item.nickname.includes(key.value) || item.phone.includes(key.value)
  );
};

// 搜索回调
const deleteHandle = (id) => {
  copyData.value = copyData.value.filter((item) => id !== item.id);
};

const currentPage = ref(1);
const pageSize = ref(10);

const total = computed(() => copyData.value.length);

const pagedData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value;
  const end = start + pageSize.value;
  return copyData.value.slice(start, end);
});

const handleSizeChange = (val) => {
  pageSize.value = val;
  currentPage.value = 1; // 改变每页显示条数时，回到第一页
};

const handleCurrentChange = (val) => {
  currentPage.value = val;
};
</script>

<template>
  <el-space>
    <el-input v-model="key" />
    <el-button type="primary" @click="searchHandle">搜索</el-button>
    <el-button
      type="primary"
      @click="
        () => {
          copyData = data;
          key = '';
        }
      "
      >重置</el-button
    >
  </el-space>
  <el-table :data="pagedData">
    <el-table-column prop="id" label="序号" />
    <el-table-column prop="nickname" label="姓名" width="180" />
    <el-table-column prop="phone" label="手机号" width="180" />
    <el-table-column label="操作">
      <template #default="{ row }">
        <el-space>
          <el-button
            @click="
              () => {
                dialogTableVisible = true;
                currentUser = row.id;
                updateData = { ...row };
              }
            "
            >编辑</el-button
          >
          <el-button type="danger" @click="() => deleteHandle(row.id)"
            >删除</el-button
          >
        </el-space>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"
    :current-page="currentPage"
    :page-sizes="[10, 20, 30, 40]"
    :page-size="pageSize"
    layout="total, sizes, prev, pager, next, jumper"
    :total="total"
  >
  </el-pagination>
  <el-dialog
    v-model="dialogTableVisible"
    title="编辑信息"
    width="400"
    @close="dialogTableVisible = false"
  >
    <label class="item-label">
      <div>序号：</div>
      <el-input v-model="updateData.id" />
    </label>
    <label class="item-label">
      <div>姓名：</div>
      <el-input v-model="updateData.nickname" />
    </label>
    <label class="item-label">
      <div>手机号：</div>
      <el-input v-model="updateData.phone" />
    </label>
    <el-space>
      <el-button>取消</el-button>
      <el-button
        type="primary"
        @click="
          () => {
            copyData = copyData.map((item) => {
              if (item.id === currentUser) {
                item = { ...updateData };
              }
              return item;
            });
            dialogTableVisible = false;
          }
        "
        >确定</el-button
      >
    </el-space>
  </el-dialog>
</template>

<style lang="less">
.item-label {
  display: flex;
  flex-direction: row;
  align-items: center;
  margin: 20px 0;
  .el-input {
    flex: 1;
  }
  div {
    width: 80px;
  }
}
</style>
