<script setup>
import { onMounted } from "vue";
import * as echarts from "echarts";

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
