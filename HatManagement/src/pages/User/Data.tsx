import { get, post } from "@/apis";
import {
  Button,
  DatePicker,
  Form,
  Input,
  Modal,
  Space,
  Table,
  message,
} from "antd";
import { useForm } from "antd/es/form/Form";
import dayjs from "dayjs";
import { useEffect, useRef, useState } from "react";
import customParseFormat from "dayjs/plugin/customParseFormat";

dayjs.extend(customParseFormat);
export default function Data() {
  const [data, setData] = useState([]);
  const [isShowModal, setIsShowModal] = useState(false);
  const [param, setParam] = useState({});
  const isAdd = useRef(true);
  const currentUser = useRef();
  const [form] = useForm();
  const [addForm] = useForm();
  const initData = async () => {
    const data = await post("/employee/selectList", param);
    setData(data as any);
  };
  useEffect(() => {
    initData();
  }, [param]);
  const columns: {}[] = [
    {
      dataIndex: "id",
      title: "员工编号",
    },
    {
      dataIndex: "name",
      title: "员工姓名",
    },
    {
      dataIndex: "createTime",
      title: "入职时间",
      render: (value: string) => dayjs(value).format("YYYY-MM-DD HH:mm:ss"),
    },
    {
      dataIndex: "railAddr",
      title: "工作场地",
    },
    {
      dataIndex: "phoneNumber",
      title: "联系方式",
    },
    {
      title: "操作",
      render: (record: any) => (
        <Space>
          <Button
            type="link"
            onClick={() => {
              setIsShowModal(true);
              isAdd.current = false;
              currentUser.current = record.id;
              addForm.setFieldsValue({
                ...record,
                createTime: dayjs(record?.createTime, "YYYY-MM-DD"),
              });
            }}
          >
            修改
          </Button>
          <Button
            type="link"
            style={{ color: "red" }}
            onClick={async () => {
              await post(`/employee/deleteById?id=${record?.id}`);
              message.warning("成功解雇该员工");
              await initData();
            }}
          >
            解雇
          </Button>
        </Space>
      ),
    },
  ];

  const queryHandle = async () => {
    const { id, name, startTime, endTime, railAddr } = form.getFieldsValue();
    setParam({
      id,
      name,
      startTime: startTime ? dayjs(startTime, "YYYY-MM-DD") : undefined,
      endTime: endTime ? dayjs(endTime, "YYYY-MM-DD") : undefined,
      railAddr,
    });
  };

  return (
    <>
      <Form form={form} layout="inline">
        <Form.Item label="员工编号：" name="id">
          <Input placeholder="员工编号" />
        </Form.Item>
        <Form.Item label="员工姓名：" name="name">
          <Input placeholder="员工姓名" />
        </Form.Item>
        <Form.Item dependencies={["endTime"]} noStyle>
          {({ getFieldValue }) => {
            return (
              <Form.Item label="入职开始时间：" name="startTime">
                <DatePicker
                  placeholder="选择入职开始时间"
                  style={{ width: "200px" }}
                  maxDate={
                    getFieldValue("endTime")
                      ? dayjs(getFieldValue("endTime"))
                      : (null as any)
                  }
                />
              </Form.Item>
            );
          }}
        </Form.Item>
        <Form.Item dependencies={["startTime"]} noStyle>
          {({ getFieldValue }) => {
            return (
              <Form.Item label="入职结束时间：" name="endTime">
                <DatePicker
                  placeholder="选择入职结束时间"
                  style={{ width: "200px" }}
                  minDate={
                    getFieldValue("startTime")
                      ? dayjs(getFieldValue("startTime"))
                      : (null as any)
                  }
                />
              </Form.Item>
            );
          }}
        </Form.Item>
        <Form.Item label="工作场地：" name="railAddr" className="my-4">
          <Input placeholder="工作场地" />
        </Form.Item>
      </Form>
      <Space className="my-2">
        <Button type="primary" onClick={queryHandle}>
          查询
        </Button>
        <Button
          onClick={() => {
            setIsShowModal(true);
            isAdd.current = true;
          }}
        >
          入职
        </Button>
        <Button
          onClick={() => {
            form.resetFields();
            setParam({});
          }}
        >
          重置
        </Button>
      </Space>
      <Table dataSource={data} columns={columns} />
      <Modal
        open={isShowModal}
        onCancel={() => {
          setIsShowModal(false);
          addForm.resetFields();
        }}
        title={`${isAdd.current ? "添加" : "修改"}员工信息`}
        footer={null}
      >
        <Form
          form={addForm}
          onFinish={async (e) => {
            const { name, railAddr, phoneNumber, createTime } = e;
            const param = {
              name,
              railAddr,
              phoneNumber,
              createTime: dayjs(createTime).format("YYYY-MM-DD"),
            };
            if (isAdd.current) {
              await post("/employee/save", param);
            } else {
              await post("/employee/updateById", {
                ...param,
                id: currentUser.current,
              });
              await initData();
            }
            message.success(`${isAdd.current ? "添加" : "编辑"}成功`);
            addForm.resetFields();
            setIsShowModal(false);
            await initData();
          }}
        >
          <Form.Item
            label="员工姓名："
            name={"name"}
            rules={[{ required: true, message: "请输入员工姓名" }]}
          >
            <Input placeholder="请输入员工姓名" />
          </Form.Item>
          <Form.Item
            label="入职时间："
            name={"createTime"}
            rules={[{ required: true, message: "请输入员工姓名" }]}
          >
            <DatePicker
              placeholder="请输入员工入职时间"
              style={{ width: "200px" }}
            />
          </Form.Item>
          <Form.Item
            label="工作场地："
            name={"railAddr"}
            rules={[{ required: true, message: "请输入工作场地" }]}
          >
            <Input placeholder="请输入工作场地" />
          </Form.Item>
          <Form.Item
            label="联系方式："
            name={"phoneNumber"}
            rules={[
              { required: true, message: "请输入联系方式" },
              {
                max: 11,
                message: "联系方式不合法",
              },
              {
                min: 11,
                message: "联系方式不合法",
              },
            ]}
          >
            <Input placeholder="请输入联系方式" type="number" />
          </Form.Item>
          <Form.Item label=" " colon={false}>
            <Space>
              <Button
                onClick={() => {
                  setIsShowModal(false);
                  addForm.resetFields();
                }}
              >
                取消
              </Button>
              <Button type="primary" htmlType="submit">
                {isAdd.current ? "添加" : "修改"}
              </Button>
            </Space>
          </Form.Item>
        </Form>
      </Modal>
    </>
  );
}
