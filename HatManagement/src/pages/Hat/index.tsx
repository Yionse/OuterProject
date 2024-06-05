import { get, post } from "@/apis";
import {
  Button,
  DatePicker,
  Form,
  Input,
  Modal,
  Popconfirm,
  Select,
  Space,
  Table,
  message,
} from "antd";
import { useEffect, useRef, useState } from "react";
import dayjs from "dayjs";

export default function Hat() {
  const [data, setData] = useState([]);
  const [isSelectUser, setIsSelectUser] = useState([]);
  const [form] = Form.useForm();
  const [isShowModal, setIsShowModal] = useState(false);
  const [isShowBindModal, setIsShowBindModal] = useState(false);
  const [bindUser, setBindUser] = useState();
  const currentHat = useRef();
  const initData = async () => {
    const data = await get("/safetyHelmet/selectList");
    const isSelectUser = await get("/safetyHelmet/noSafeHelmetList");
    console.log(data);
    setData((data as any) || []);
    setIsSelectUser((isSelectUser as any) || []);
  };
  useEffect(() => {
    initData();
  }, []);
  const bindHat = async (id: any) => {
    await post("/safetyHelmet/updateById", {
      id,
      employeeId: bindUser,
    });
    initData();
  };
  const columns: {}[] = [
    {
      dataIndex: "number",
      title: "安全帽名字",
    },
    {
      dataIndex: "employeeName",
      title: "持有者名字",
      render: (value: any, record: any) =>
        record?.employeeId ? (
          value
        ) : (
          <span style={{ color: "red" }}>暂无持有者</span>
        ),
    },
    {
      dataIndex: "createTime",
      title: "采购时间",
    },
    {
      dataIndex: "updateTime",
      title: "检查时间",
    },
    {
      title: "操作",
      render: (record: any) => (
        <Space>
          <Button
            type="link"
            disabled={record?.employeeId}
            onClick={() => {
              (currentHat.current = record.id), setIsShowBindModal(true);
            }}
          >
            绑定
          </Button>
          <Button
            type="link"
            disabled={!record?.employeeId}
            onClick={async () => {
              await post("/safetyHelmet/notBind", {
                ...record,
                employeeId: null,
              });
              await initData();
            }}
          >
            解绑
          </Button>
          <Popconfirm
            title="确定要删除该安全帽？"
            onConfirm={async () => {
              await post(`/safetyHelmet/deleteById?id=${record.id}`);
              message.warning("已成功删除该安全帽！");
              initData();
            }}
          >
            <Button style={{ color: "red" }} type="link">
              删除
            </Button>
          </Popconfirm>
        </Space>
      ),
    },
  ];
  const saveHandle = async (e: any) => {
    const { number, name, createTime, updateTime } = form.getFieldsValue();
    await post("/safetyHelmet/save", {
      number,
      name,
      createTime: dayjs(createTime, "YYYY-MM-DD HH:mm:ss"),
      updateTime: dayjs(updateTime, "YYYY-MM-DD HH:mm:ss"),
    });
    await initData();
    message.success("成功添加安全帽！");
    closeModel();
  };
  const closeModel = () => {
    form.resetFields();
    setIsShowModal(false);
  };

  return (
    <>
      <Button type="primary" onClick={() => setIsShowModal(true)}>
        添加安全帽
      </Button>
      <Table dataSource={data} columns={columns} />
      <Modal
        title="添加安全帽"
        open={isShowModal}
        footer={null}
        onCancel={closeModel}
        onClose={closeModel}
      >
        <Form form={form} onFinish={saveHandle}>
          <Form.Item
            label="安全帽编号："
            name={"number"}
            rules={[{ required: true, message: "编号必须输入" }]}
          >
            <Input placeholder="请输入安全帽编号" />
          </Form.Item>
          <Form.Item label="持有者：" name={"name"}>
            <Select
              options={isSelectUser?.map((item: any) => ({
                label: item.name,
                value: item.id,
              }))}
            />
          </Form.Item>
          <Form.Item
            label="采购时间："
            name={"createTime"}
            rules={[{ required: true, message: "请选择时间" }]}
          >
            <DatePicker showTime placeholder="请选择采购时间" />
          </Form.Item>
          <Form.Item
            label="检查时间："
            name={"updateTime"}
            rules={[{ required: true, message: "请选择时间" }]}
          >
            <DatePicker showTime placeholder="请选择检查时间" />
          </Form.Item>
          <Form.Item>
            <Space>
              <Button onClick={closeModel}>取消</Button>
              <Button type="primary" htmlType="submit">
                添加
              </Button>
            </Space>
          </Form.Item>
        </Form>
      </Modal>
      <Modal
        title="安全帽绑定"
        open={isShowBindModal}
        onCancel={() => setIsShowBindModal(false)}
        onOk={async () => {
          await bindHat(currentHat.current);
          setIsShowBindModal(false);
        }}
      >
        <Select
          style={{ width: "200px" }}
          onChange={setBindUser}
          options={isSelectUser?.map((item: any) => ({
            label: item.name,
            value: item.id,
          }))}
        />
      </Modal>
    </>
  );
}
