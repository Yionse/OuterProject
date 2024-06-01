import { Button, Form, Input, message } from "antd";
import "./index.less";
import { LockOutlined, UserOutlined } from "@ant-design/icons";
import { useForm } from "antd/es/form/Form";
import { useNavigate } from "react-router-dom";

export default function Login() {
  const [form] = useForm();
  const navigate = useNavigate();
  document.title = "统一登录平台";
  return (
    <div className="box relative" style={{ width: "100vw", height: "100vh" }}>
      <div
        className="absolute top-1/2 left-1/2 h-72 w-96 bg-white p-8 rounded-xl"
        style={{ transform: "translate(-50%, -50%)" }}
      >
        <h1 className="text-center">个人博客</h1>
        <h3
          className="text-center font-normal text-base mt-4"
          style={{ color: "gray" }}
        >
          后台管理系统
        </h3>
        <Form
          className="mt-8"
          form={form}
          onFinish={() => {
            const { username, code } = form.getFieldsValue();
            if (username === "admin" && code === "admin") {
              navigate("/home/index");
            } else {
              message.error("密码错误，请重试");
            }
          }}
        >
          <Form.Item
            label="账号"
            name="username"
            rules={[{ required: true, message: "请输入账号" }]}
          >
            <Input
              type="text"
              prefix={<UserOutlined />}
              placeholder="请输入账号"
            />
          </Form.Item>
          <Form.Item
            label="密码"
            name="code"
            rules={[
              { required: true, max: 18, message: "最长为18位" },
              { required: true, message: "请输入密码" },
            ]}
          >
            <Input
              type="password"
              prefix={<LockOutlined />}
              placeholder="请输入密码"
              maxLength={18}
            />
          </Form.Item>
          <Form.Item>
            <Button
              htmlType="submit"
              className="w-full bg-red-600"
              style={{
                color: "white",
              }}
            >
              登录
            </Button>
          </Form.Item>
        </Form>
      </div>
    </div>
  );
}
