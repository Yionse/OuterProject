import { Empty } from "antd";

export default function Index() {
  return (
    <>
      <div className="text-center font-bold text-4xl">
        欢迎使用安全帽管理系统
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
