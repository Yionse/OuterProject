<script setup>
import { ref, computed } from "vue";
// mock数据
const data = ref(
  [
    {
      fictionId: "52dbfc92-23b4-3fc7-a7d5-afa88048f1b1",
      title: "玄幻帝",
      author: "墨二黑",
      fictionType: "玄幻魔法",
      descs:
        "在绝对实力面前，一切都是虚妄。　　于是，他与天斗，与人斗，奋斗中强大自己。　　前面有危险，冲过去。　　有魔王拦路，杀过去。　　再多的艰难也吓不退勇敢的心。　　为了自己和亲人的安全，他重整这个美丽而又混乱的帝国，与各种隐藏的势力斗智斗勇。　　然而，结局却让所有人大吃一惊……",
      cover: "../static/recommend/玄幻帝.jpg",
      updateTime: "2015-06-15",
      score: "4.9分",
    },
    {
      fictionId: "5895c250-a1f8-3397-8b26-065b9b59f12d",
      title: "执掌玄幻",
      author: "念千灵",
      fictionType: "玄幻小说",
      descs:
        "天地不仁肆凌轩，浴火重生屠满仙。弹指一挥万界撼，执掌玄幻我为天！穿越异界成为苦命赘婿，还好获得了神级职业管理员。游戏管理员管的是游戏。我管的却是整片玄！幻！大！陆！禁言，封号，改名，修改速度，设立安全区，扣除装备，时间暂停....“叮咚：管理员开启了全员禁言。”于是乎，整个大陆都安静了........",
      cover: "../static/recommend/执掌玄幻.jpg",
      updateTime: "2017-11-09",
      score: "4.9分",
    },
    {
      fictionId: "199fdd5e-75fc-33ae-b1ae-237508ad7e81",
      title: "玄幻模拟器",
      author: "咸鱼洁南",
      fictionType: "武侠仙侠",
      descs:
        "　　见狂澜之树，挽大厦之将倾.......灵气复苏，万界争霸.....武道修仙异能，谁可纵横？一切，从一个小小的模拟器开始。巫师世界，仙侠世界，猎魔世界，诸神世界........-20-1762",
      cover: "../static/recommend/玄幻模拟器.jpg",
      updateTime: "2022-05-28",
      score: "4.8分",
    },
    {
      fictionId: "46f8cbb3-d2b2-3a65-ba08-d853f0e2bcd3",
      title: "超现实玄幻",
      author: "鱼穹",
      fictionType: "都市言情",
      descs:
        "他，前世是苦逼程序猿，　　由于一次意外身亡，　　重生一个平行的异世界。　　他，不想再过平淡的生活，　　这世界便让他精彩一生。",
      cover: "../static/recommend/超现实玄幻.jpg",
      updateTime: "2017-03-12",
      score: "4.8分",
    },
    {
      fictionId: "8e5a79c8-fa62-3b72-ba20-ce72bf2865c5",
      title: "修仙别看戏",
      author: "踏歌行人未停",
      fictionType: "武侠修真",
      descs:
        "宁夏想破脑袋也想不明白千载难逢的穿越机会怎么会落到她这个平凡的工薪族身上，她还有三十五年的房贷没有还啊啊啊。她看着这个修仙人满天飞，普通人活得还不如狗的世界泪流满面。为什么还要被分配到一个有女主的世界，这可是一位心狠手辣的现实派女主，别瞅着我，鄙人只是个路人甲。且看既不平凡也不惊艳的路人甲如何在修仙世界走出一条康庄大道。",
      cover: "../static/recommend/修仙别看戏.jpg",
      updateTime: "2023-11-21",
      score: "4.7分",
    },
    {
      fictionId: "f132331a-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
    {
      fictionId: "f132331a-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
    {
      fictionId: "f132331a-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
    {
      fictionId: "f132331a-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
    {
      fictionId: "f132331a-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
    {
      fictionId: "f132331a-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
    {
      fictionId: "f1323asds-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
    {
      fictionId: "f132adsaa-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
    {
      fictionId: "f132hss1a-41b6-395e-9fec-9dcca4d07fc7",
      title: "开局女魔头负了我",
      author: "怕辣的红椒",
      fictionType: "武侠修真",
      descs:
        "江浩穿越普通人家，被迫卖入魔门，成为魔门弟子。本想安心修炼一点点变强，好在修真界生存下去，可却被一位女魔头“百般羞辱”。实力相差悬殊，他只能忍辱偷生，希望不要再遇到对方。没有靠山的他得到了魔门掌教的青睐，得以安心修炼，当他成为首席弟子面见掌教时，却愣在原地。望着对方绝美的脸庞，他有些笑不出来，这不是当初那个女魔头吗？",
      cover: "../static/recommend/开局女魔头负了我.jpg",
      updateTime: "2023-11-12",
      score: "4.7分",
    },
  ].map((item, index) => ({ ...item, id: index + 1 }))
);
// 复制一份
const copyData = ref(data.value);
// 搜索参数
const key = ref("");

// 控制弹窗开启关闭
const dialogTableVisible = ref(false);
// 存储当前的id
const currentUser = ref();
// 添加或更改数据的存储载体
const updateData = ref({});
// 编辑添加公用一个空间，需要判断是否是添加
const isAdd = ref(false);

// 单击搜索回调
const searchHandle = () => {
  copyData.value = copyData.value.filter(
    (item) =>
      item?.title?.includes(key.value) ||
      item?.author?.includes(key.value) ||
      item?.descs?.includes(key.value) ||
      item?.fictionType?.includes(key.value)
  );
};

// 删除回调
const deleteHandle = (id) => {
  copyData.value = copyData.value.filter((item) => id !== item.fictionId);
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
  <el-button
    type="primary"
    @click="
      () => {
        isAdd = true;
        dialogTableVisible = true;
      }
    "
    >添加</el-button
  >
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
    <el-table-column prop="id" label="序号" width="140" />
    <el-table-column prop="title" label="书名" width="80" />
    <el-table-column prop="author" label="作者" width="80" />
    <el-table-column prop="fictionType" label="类型" width="80" />
    <el-table-column prop="descs" label="简介" />
    <el-table-column prop="updateTime" label="更新时间" width="180" />
    <el-table-column label="操作" width="180">
      <template #default="{ row }">
        <el-space>
          <el-button
            @click="
              () => {
                dialogTableVisible = true;
                currentUser = row.fictionId;
                updateData = { ...row };
                isAdd = false;
              }
            "
            >编辑</el-button
          >
          <el-button type="danger" @click="() => deleteHandle(row.fictionId)"
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
  />
  <el-dialog
    v-model="dialogTableVisible"
    title="编辑信息"
    width="400"
    @close="dialogTableVisible = false"
  >
    <label class="item-label">
      <div>序号：</div>
      <el-input v-model="updateData.fictionId" />
    </label>
    <label class="item-label">
      <div>书名：</div>
      <el-input v-model="updateData.title" />
    </label>
    <label class="item-label">
      <div>作者：</div>
      <el-input v-model="updateData.author" />
    </label>
    <label class="item-label">
      <div>类型：</div>
      <el-input v-model="updateData.fictionType" />
    </label>
    <label class="item-label">
      <div>简介：</div>
      <el-input v-model="updateData.descs" />
    </label>
    <label class="item-label">
      <div>更新时间：</div>
      <el-input v-model="updateData.updateTime" />
    </label>
    <el-space>
      <el-button>取消</el-button>
      <el-button
        type="primary"
        @click="
          () => {
            if (!isAdd) {
              copyData = copyData.map((item) => {
                if (item.fictionId === currentUser) {
                  item = { ...updateData };
                }
                return item;
              });
            } else {
              copyData.push({
                ...updateData,
                id: copyData[copyData.length - 1].id + 1,
              });
            }
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
