import { get } from "@/apis";
import { Table } from "antd";
import { useEffect, useState } from "react";

export default function Location() {
  const [data, setData] = useState([]);
  const initData = async () => {
    const data = await get("/locationInfo/selectList");
    setData(data);
  };
  useEffect(() => {
    initData();
  }, []);

  const columns = [
    {
      dataIndex: "employeeId",
      title: "用户编号",
    },
    {
      dataIndex: "employeName",
      title: "用户名",
      render: (value: any) => <span>{value ? value : "暂无"}</span>,
    },
    {
      dataIndex: "name",
      title: "安全帽名字",
      render: (value: any) => <span>{value ? value : "暂无"}</span>,
    },
    {
      dataIndex: "lat",
      title: "精度",
    },
    {
      dataIndex: "lon",
      title: "维度",
    },
    {
      dataIndex: "createTime",
      title: "时间",
    },
  ];
  return <Table dataSource={data} columns={columns} />;
}
