import { Empty, message } from "antd";
import { useEffect } from "react";

export default function Views() {
  useEffect(() => {
    message.warning("敬请期待");
  }, []);
  return (
    <>
      <div className="text-center font-bold text-4xl">
        当前高德地图API暂未接通，无法查看人员轨迹
      </div>
      <Empty
        image="https://img.js.design/assets/img/61035a1cbd36eb1fc96be3b0.png"
        description=""
        imageStyle={{
          width: "500px",
          height: "400px",
          margin: "auto",
        }}
      />
    </>
  );
}
