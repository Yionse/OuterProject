<script setup>
import { onMounted } from "vue";
import * as echarts from "echarts";

const newUser = [
  {
    user: "榛子185",
    src: "https://img.js.design/assets/img/63d10f800045a3737cd7ee92.png#f047ce71ef76a4d8b44ff9342a8e70e6",
    address: "北京,北京",
  },
  {
    user: "茉莉亚f",
    src: "https://img.js.design/assets/img/63d10f80a29aea50d99c8dfe.png#e7c2f3292f602dfe38b97cac61f5b5e4",
    address: "广东,深圳",
  },
  {
    user: "粒粒378y72",
    src: "https://img.js.design/assets/img/63d10f80aa82d96de0fa5af0.png#b720f63e933d0cab619d4176982106ff",
    address: "天津,天津",
  },
];

onMounted(() => {
  // 记性echarts图表配置
  const chartDom = document.getElementById("two");
  const myChart = echarts.init(chartDom);
  const option = {
    title: {
      text: "用户",
    },
    xAxis: {
      type: "category",
      data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
    },
    yAxis: {
      type: "value",
    },
    series: [
      {
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: "line",
        smooth: true,
      },
    ],
  };
  myChart.setOption(option);

  const chartDomOne = document.getElementById("one");
  const myChartOne = echarts.init(chartDomOne);
  const optionOne = {
    title: {
      text: "流量来源",
    },
    xAxis: {
      max: "dataMax",
    },
    yAxis: {
      type: "category",
      data: ["A", "B", "C", "D", "E"],
      inverse: true,
      animationDuration: 300,
      animationDurationUpdate: 300,
      max: 2, // only the largest 3 bars will be displayed
    },
    series: [
      {
        realtimeSort: true,
        name: "X",
        type: "bar",
        data: [100, 99, 89],
        label: {
          show: true,
          position: "right",
          valueAnimation: true,
        },
      },
    ],
    legend: {
      show: false,
    },
    animationDuration: 0,
    animationDurationUpdate: 3000,
    animationEasing: "linear",
    animationEasingUpdate: "linear",
  };
  myChartOne.setOption(optionOne);

  const chartDomThree = document.getElementById("three");
  const myChartThree = echarts.init(chartDomThree);
  const optionThree = {
    title: {
      text: "新用户",
    },
    tooltip: {
      trigger: "item",
    },
    legend: {
      top: "5%",
      left: "center",
    },
    series: [
      {
        name: "Access From",
        type: "pie",
        radius: ["40%", "70%"],
        avoidLabelOverlap: false,
        itemStyle: {
          borderRadius: 10,
          borderColor: "#fff",
          borderWidth: 2,
        },
        label: {
          show: false,
          position: "center",
        },
        emphasis: {
          label: {
            show: true,
            fontSize: 40,
            fontWeight: "bold",
          },
        },
        labelLine: {
          show: false,
        },
        data: [
          { value: 1048, name: "男性" },
          { value: 735, name: "女性" },
          { value: 580, name: "未知" },
        ],
      },
    ],
  };
  myChartThree.setOption(optionThree);
});
</script>

<template>
  <div
    style="
      display: flex;
      flex-direction: row;
      justify-content: space-between;
      flex-wrap: wrap;
      align-items: center;
      height: 700px;
    "
  >
    <div
      style="
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        width: 65%;
      "
    >
      <el-card class="w-46 item-card">
        <div id="one" style="width: 100%; height: inherit"></div>
      </el-card>
      <el-card class="w-46 item-card">
        <div id="two" style="width: 100%; height: inherit"></div>
      </el-card>
    </div>
    <el-card class="w-30 item-card">
      <div id="three" style="width: 100%; height: inherit"></div>
    </el-card>
    <!-- <div
      style="
        display: flex;
        flex-direction: row;
        justify-content: space-between;
        width: 65%;
      "
    >
      <el-card class="item-card">
        <div id="one" style="width: 100%; height: inherit"></div>
      </el-card>
    </div> -->
    <el-card class="w-30 item-card">
      <div id="three" style="width: 100%; height: inherit">
        <h3>新用户</h3>
        <div
          v-for="user in newUser"
          :key="user.user"
          style="
            display: flex;
            flex-direction: row;
            flex-wrap: nowrap;
            align-items: center;
            width: 100%;
            margin: 15px 0;
          "
        >
          <img
            :src="user.src"
            style="width: 50px; height: 50px; border-radius: 50%"
          />
          <div style="flex: 1; margin-left: 20px">
            <div>{{ user.user }}</div>
            <div style="opacity: 0.6">{{ user.address }}</div>
          </div>
          <el-icon><ChatDotRound /></el-icon>
        </div>
      </div>
    </el-card>
  </div>
</template>

<style lang="less" scoped>
.w-46 {
  width: 46%;
}
.w-30 {
  width: 30%;
}

.item-card {
  height: 300px;
  border-radius: 50px;
  box-sizing: border-box;
  border: 2px solid black;
}
</style>
