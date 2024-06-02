import { Empty } from "antd";

export default function Fence() {
  return (
    <>
      <div className="text-center font-bold text-4xl">高德API暂未接通</div>
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
